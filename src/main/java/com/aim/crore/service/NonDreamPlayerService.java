package com.aim.crore.service;

import com.aim.crore.model.Player;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NonDreamPlayerService {

    //Player[] = list of 11 non d team, maxCombination = 8
    //gives best 8(participant) combination
    List<Player[]> getNonDreamCombination(Player[] players, int maxCombination) {
        BestTeamCombination nonDreamCombination = new BestTeamCombination();
        Map<Double,Player[]> combination = nonDreamCombination.getCombination(players, 2);
        return combination.values().stream().limit(maxCombination).collect(Collectors.toList());
    }
}
