package com.dyx.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatClientController
{
    private final ChatClient dashScopechatClient;

    /**
     * 使用自动配置的 ChatClient.Builder
     * @param dashscopeChatModel
     */
    public ChatClientController(ChatModel dashscopeChatModel)
    {
        this.dashScopechatClient = ChatClient.builder(dashscopeChatModel).build();
    }

    /**
     * http://localhost:8003/chatclient/dochat
     * @param msg
     * @return
     */
    @GetMapping("/chatclient/dochat")
    public String doChat(@RequestParam(name = "msg",defaultValue = "2加4等于几") String msg)
    {
        String result = dashScopechatClient.prompt().user(msg).call().content();
        System.out.println("响应：" + result);
        return result;
    }
}
 