package com.dyx.controller;

import com.dyx.records.StudentRecord;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;

/**
 * @Description TODO
 */
@RestController
public class StructuredOutputController
{
    @Resource(name = "qwenChatClient")
    private ChatClient qwenChatClient;

    /**
     * http://localhost:8007/structuredoutput/chat?sname=李四&email=zzyybs@126.com
     * @param sname
     * @return
     */
    @GetMapping("/structuredoutput/chat")
    public StudentRecord chat(String sname, String email)
    {
        return qwenChatClient.prompt()
                .user(new Consumer<ChatClient.PromptUserSpec>() {
            @Override
            public void accept(ChatClient.PromptUserSpec promptUserSpec)
            {
                promptUserSpec.text("学号1001,我叫{sname},大学专业是计算机科学与技术,邮箱{email}")
                        .param("sname",sname)
                        .param("email",email);
            }
        }).call().entity(StudentRecord.class);
    }

    /**
     * http://localhost:8007/structuredoutput/chat2?sname=孙伟&email=zzyybs@126.com
     * @param sname
     * @return
     */
    @GetMapping("/structuredoutput/chat2")
    public StudentRecord chat2(@RequestParam(name = "sname") String sname,
                               @RequestParam(name = "email") String email)
    {
        String stringTemplate = """
                学号1002,我叫{sname},大学专业是软件工程,邮箱{email}
                """;

        return qwenChatClient.prompt()
                .user(promptUserSpec -> promptUserSpec.text(stringTemplate)
                        .param("sname",sname)
                        .param("email",email))
                .call()
                .entity(StudentRecord.class);
    }
}
