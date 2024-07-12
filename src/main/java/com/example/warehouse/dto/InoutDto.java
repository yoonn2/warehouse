package com.example.warehouse.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InoutDto {
    private String t_no;
    private String p_code;
    private String t_type;
    private int t_cnt;
    private int t_date;
    private String c_code;
}
