package com.l2t.lcj.enumsandarrays;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    private String name;
    private String teamName;
    private String teamLabel;
    private double amount;
}
