package com.example.warehouse.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DetailDto {
    private String t_no;
    private String p_code;
    private String p_name;
    private String t_type;
    private int t_cnt;
    private String c_code;
    private String c_name;
    private String t_date;
}
