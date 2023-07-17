package com.springboot.catchmind.dto;

import lombok.Data;

@Data
public class PageDto {
    private final String page;
    private final String serviceName;
    private final String mid;

    private int startCount;
    private int endCount;
    private int dbCount;
    private int pageSize;
    private int pageCount;
    private int regPage;
}
