package com.aim.crore.model;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum CombinationEnum {
    WK(0, 1, 4),
    BAT(1, 3, 6),
    ALL(2, 1, 4),
    BALL(3, 3, 6);


    private int min;
    private int max;
    private int index;

    private static final Map<Integer, CombinationEnum> lookup = new HashMap<>();

    static {
        for (CombinationEnum d : CombinationEnum.values()) {
            lookup.put(d.getIndex(), d);
        }
    }

    CombinationEnum(int index, int min, int max) {
        this.index = index;
        this.max = max;
        this.min = min;
    }

    public static boolean isValidCombination(String combination) {
        for (int i = 0; i < combination.length(); i++) {
            CombinationEnum combinationEnum = lookup.get(i);
            int digit = Integer.parseInt(String.valueOf(combination.charAt(i)));
            if(digit < combinationEnum.getMin() ||  digit > combinationEnum.getMax())
                return false;
        }

        return true;
    }

}
