package com.example.warehouse.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDto {
    private String p_code;
    private String p_name;
    private int p_size;
    private int p_incost;
    private int p_outcost;

}
