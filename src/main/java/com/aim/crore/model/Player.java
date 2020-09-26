package com.aim.crore.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Player {
    private Integer playerNo;
    private String name;
    private Double credits;
    private Boolean isDreamPlayer;
    private PlayerTypeEnum type;
    private TeamEnum team;
    private int weightedPoint;
    private int bonusPoint;
}
