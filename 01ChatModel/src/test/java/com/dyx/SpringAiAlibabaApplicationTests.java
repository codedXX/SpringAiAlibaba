package com.dyx;

import com.alibaba.cloud.ai.dashscope.api.DashScopeApi;
import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatModel;
import com.alibaba.cloud.ai.graph.agent.ReactAgent;
import com.alibaba.cloud.ai.graph.exception.GraphRunnerException;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringAiAlibabaApplicationTests {

    @Test
    void contextLoads() {
//        // 创建模型实例
//        DashScopeApi dashScopeApi = DashScopeApi.builder()
//                .apiKey("sk-255506ca196b48f38e686b3e82efac58")
//                .build();
//        ChatModel chatModel = DashScopeChatModel.builder()
//                .dashScopeApi(dashScopeApi)
//                .build();
//
//        // 创建 Agent
//        ReactAgent agent = ReactAgent.builder()
//                .name("weather_agent")
//                .model(chatModel)
//                .instruction("You are a helpful weather forecast assistant.")
//                .build();
//
//        // 运行 Agent
//        try {
//            agent.call("what is the weather in Hangzhou?");
//        } catch (GraphRunnerException e) {
//            throw new RuntimeException(e);
//        }
    }

}
