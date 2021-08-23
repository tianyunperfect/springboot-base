package com.alvin.controller;

import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestArrayList {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> test = new CopyOnWriteArrayList<>();
        test.add("456");
        test.add("123");
        test.add("123");
        Collections.sort(test);
        System.out.println(test);

    }
}
