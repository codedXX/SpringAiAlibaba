package com.dyx.utils;

import org.springframework.ai.tool.annotation.Tool;

import java.time.LocalDateTime;

public class DateTimeTools
{
    /**
     * 1.定义 function call（tool call）
     * 2. returnDirect
     *    true = tool直接返回不走大模型，直接给客户
     *    false = 拿到tool返回的结果，给大模型，最后由大模型回复
     */
    @Tool(description = "获取当前时间", returnDirect = false)
    public String getCurrentTime()
    {
        return LocalDateTime.now().toString();
    }
}