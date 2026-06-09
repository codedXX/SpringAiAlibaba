package com.dyx.config;

import org.springframework.context.annotation.Bean;

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
                    .apiKey(System.getenv("aliQwen-api"))
                .build();
    }
}