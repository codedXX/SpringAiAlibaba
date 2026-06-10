package com.dyx.config;

import com.alibaba.cloud.ai.dashscope.api.DashScopeApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaaLLMConfig
{
    /*方式1

    1.1
    yml文件配置：spring.ai.dashscope.api-key=${aliQwen-api}

    1.2
    @Value("${spring.ai.dashscope.api-key}")
    private String apiKey;、

    1.3
    @Bean
    public DashScopeApi dashScopeApi()
    {
        return DashScopeApi.builder().apiKey(apiKey).build();
    }
    */

    /**
     * 方式2
     * yml文件配置：spring.ai.dashscope.api-key=${aliQwen-api}
     * @return
     */
    @Bean
    public DashScopeApi dashScopeApi()
    {
        return DashScopeApi.builder()
                    .apiKey("sk-255506ca196b48f38e686b3e82efac58")
                .build();
    }
}