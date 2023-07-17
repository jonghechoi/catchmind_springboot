package com.springboot.catchmind.dto;

import lombok.Data;

@Data
public class TabletypeDto {
    String sid;
    int rooftop, terrace, bar, dininghall, windowseat, privateroom, rental;
}
