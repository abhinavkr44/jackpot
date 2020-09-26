package com.aim.crore.service;

import com.aim.crore.model.CombinationEnum;
import com.aim.crore.model.Player;
import com.aim.crore.model.PlayerTypeEnum;
import com.aim.crore.model.TeamEnum;

import java.util.List;


//from selected 11 team
public class ContraintCheck {


    boolean isValidCombination(List<Player> players) {
        int wkCount = 0;
        int batsmenCount = 0;
        int allCount = 0;
        int bowlCount = 0;

        for (Player player : players) {
            if (player.getType() == PlayerTypeEnum.WK) wkCount++;
            if (player.getType() == PlayerTypeEnum.BAT) batsmenCount++;
            if (player.getType() == PlayerTypeEnum.ALL) allCount++;
            if (player.getType() == PlayerTypeEnum.BOWL) bowlCount++;
        }
        return CombinationEnum.isValidCombination(wkCount + "" + batsmenCount + "" + allCount + "" + bowlCount);
    }

    boolean checkMinMaxPlayersTeamCriteria(List<Player> players, TeamEnum team1Enum, TeamEnum team2Enum) {
        int team1 = 0;
        int team2 = 0;

        for (Player player : players) {
            if (player.getTeam() == team1Enum) team1++;
            if (player.getTeam() == team2Enum) team2++;
        }
        return !(team1 > 7 || team1 < 4 || team2 > 7 || team2 < 4);
    }

    boolean checkMaxTeamPointsCriteria(List<Player> players) {
        int totalCredit = 0;
        for (Player player : players) {
            totalCredit += player.getCredits();
        }
        return totalCredit <= 100;
    }
}
