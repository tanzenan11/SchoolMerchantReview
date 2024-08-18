package com.cmr.utils;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RedisData {
    private LocalDateTime expireTime;  //逻辑过期的过期时间
    private Object data;   //存放数据
}
