package com.dyx.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ChatModelController
{
    @Resource //阿里云百炼
    private ChatModel dashScopeChatModel;

    /**
     * http://localhost:8001/chatmodel/dochat
     * @param msg
     * @return
     */
    @GetMapping("/chatmodel/dochat")
    public String doChat(@RequestParam(name = "msg",defaultValue = "你是谁") String msg)
    {
        String result = dashScopeChatModel.call(msg);
        System.out.println("响应：" + result);
        return result;
    }

    /**
     *  http://localhost:8001/hello/streamchat
     * @param msg
     * @return
     */
    @GetMapping("/hello/streamchat")
    public Flux<String> streamChat(@RequestParam(name = "msg",defaultValue = "你是谁") String msg)
    {
        return dashScopeChatModel.stream(msg);
    }
}