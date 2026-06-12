package com.dyx.config;

import com.alibaba.cloud.ai.dashscope.api.DashScopeApi;
import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatModel;
import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatOptions;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 多模型共存
 */
@Configuration
public class SaaLLMConfig {
    // 模型名称常量定义
    private final String DEEPSEEK_MODEL = "deepseek-v4-flash";
    private final String QWEN_MODEL = "qwen3-max";
    @Value("${spring.ai.dashscope.api-key}")
    private String apiKey;

    @Bean(name = "deepseek")
    public ChatModel deepSeek() {
        return DashScopeChatModel.builder()
                .dashScopeApi(DashScopeApi.builder()
                        .apiKey(apiKey)
                        .build())
                .defaultOptions(
                        DashScopeChatOptions.builder().withModel(DEEPSEEK_MODEL).build()
                )
                .build();
    }

    @Bean(name = "qwen")
    public ChatModel qwen() {
        return DashScopeChatModel.builder().dashScopeApi(DashScopeApi.builder()
                        .apiKey(apiKey)
                        .build())
                .defaultOptions(
                        DashScopeChatOptions.builder()
                                .withModel(QWEN_MODEL)
                                .build()
                )
                .build();
    }

    /**
     @Qualifier("deepseek") 是什么意思?
     它的作用是:当按类型注入会遇到多个候选 Bean 时,用名字精确指定要注入哪一个。
     */
    @Bean(name = "deepseekChatClient")
    public ChatClient deepseekChatClient(@Qualifier("deepseek") ChatModel deepSeek) {
        return ChatClient.builder(deepSeek)
                .defaultOptions(ChatOptions.builder()
                        .model(DEEPSEEK_MODEL)
                        .build())
                .build();
    }

    @Bean(name = "qwenChatClient")
    public ChatClient qwenChatClient(@Qualifier("qwen") ChatModel qwen) {
        return ChatClient.builder(qwen)
                .defaultOptions(ChatOptions.builder()
                        .model(QWEN_MODEL)
                        .build())
                .build();
    }
}