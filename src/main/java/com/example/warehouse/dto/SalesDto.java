package com.example.warehouse.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SalesDto {
    private String p_code;
    private String p_name;
    private int t_cnt;
    private int p_outcost;
}
