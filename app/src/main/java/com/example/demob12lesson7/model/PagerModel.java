package com.example.demob12lesson7.model;

public class PagerModel {
    int circle1;
    int circle2;
    int circle3;
    String start;
    String login;

    public PagerModel(int circle1, int circle2, int circle3, String start, String login) {
        this.circle1 = circle1;
        this.circle2 = circle2;
        this.circle3 = circle3;
        this.start = start;
        this.login = login;
    }

    public int getCircle1() {
        return circle1;
    }

    public int getCircle2() {
        return circle2;
    }

    public int getCircle3() {
        return circle3;
    }

    public String getStart() {
        return start;
    }

    public String getLogin() {
        return login;
    }
}
