package com.xp.prompt;

import com.xp.strategy.Dp;

import java.util.concurrent.Callable;

public class CharMatching implements Callable<String> {

    private String inputString;
    private String dicString;

    public CharMatching(String inputString, String dicString) {
        this.inputString = inputString;
        this.dicString = dicString;
    }

    public String call() throws Exception {
        String match = Dp.match(inputString, dicString);
        return match;

    }
}
