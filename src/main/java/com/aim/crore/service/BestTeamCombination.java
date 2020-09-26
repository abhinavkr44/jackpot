package com.aim.crore.service;

import com.aim.crore.model.Player;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

//gives best team combination excluding criteria in ascending order of weighted score
public class BestTeamCombination {
    private static Map<Double,Player[]> map = new TreeMap<>(Collections.reverseOrder());

    static void combinationUtil(Player dSquad[], Player team[], int start,
                                int end, int index, int maxPlayer) {
        // Current combination is ready to be printed, print it
        if (index == maxPlayer) {
            Player[] myPlayingEleven = new Player[maxPlayer];
            double totalPoint = 0;
            for (int j = 0; j < maxPlayer; j++) {
                totalPoint += team[j].getWeightedPoint() + team[j].getBonusPoint();
                myPlayingEleven[j] = team[j];
                System.out.print(team[j] + " ");
            }
            System.out.println(" ");
            while (map.containsKey(totalPoint))
                totalPoint = totalPoint + 0.1;
            map.put(totalPoint, myPlayingEleven);
            return;
        }

        for (int i = start; i <= end && end - i + 1 >= maxPlayer - index; i++) {
            team[index] = dSquad[i];
            combinationUtil(dSquad, team, i + 1, end, index + 1, maxPlayer);
        }
    }

    //dSquad is total of 13/11 player including dream team, maxplayer has to be 11/2 in a team
    public Map getCombination(Player dSquad[], int maxPlayer) {
        // A temporary array to store all combination one by one
        Player team[] = new Player[maxPlayer];

        //Print all combination using temprary array 'data[]'
        combinationUtil(dSquad, team, 0, dSquad.length - 1, 0, maxPlayer);
        return map;
    }
}
