package com.aim.crore.service;

import com.aim.crore.model.CombinationEnum;
import com.aim.crore.model.Player;
import com.aim.crore.model.PlayerTypeEnum;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        player1.setType(PlayerTypeEnum.BAT);
        player2.setType(PlayerTypeEnum.BAT);
        player3.setType(PlayerTypeEnum.BOWL);

        List<Player> players = Arrays.asList(player1,player2,player3);

        long emptyCount = players.stream()
                .filter(player -> player.getType() == PlayerTypeEnum.BAT)
                .count();
        long emptyCount1 = players.stream()
                .filter(player -> player.getType() == PlayerTypeEnum.BOWL)
                .count();
        System.out.println(emptyCount+" "+emptyCount1);

        /*CombinationEnum.isValidCombination("2414");*/

        /*int n = 3;
        int sum = 5;
        findCount(n, sum);*/

    }

    private static void findCount(int n, int sum) {

        //in case n = 2 start is 10 and end is (100-1) = 99
        int start = (int) Math.pow(10, n - 1);
        int end = (int) Math.pow(10, n) - 1;

        int count = 0;
        int i = start;

        while (i < end) {
            if (String.valueOf(i).contains("0"))
                i++;
            else {
                int cur = 0;
                int temp = i;

                while (temp != 0) {
                    cur += temp % 10;
                    temp = temp / 10;
                }

                if (cur == sum) {
                    count++;
                    i += 9;
                } else
                    i++;
            }
        }
        System.out.println(count);
    }
}
