package com.mockserver.entity;

public class MatchMeta {
    private String name;
    private String broadcast_time;
    private double komi;
    private int handicap;
    private String pb;
    private String pw;
    private String url;
    private int id;
    private int po;


    public MatchMeta(String name, String broadcast_time,
                     double komi, int handicap, String pb,
                     String pw, String url, int id, int po) {
        this.name = name;
        this.broadcast_time = broadcast_time;
        this.komi = komi;
        this.handicap = handicap;
        this.pb = pb;
        this.pw = pw;
        this.url = url;
        this.id = id;
        this.po = po;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBroadcast_time() {
        return broadcast_time;
    }

    public void setBroadcast_time(String broadcast_time) {
        this.broadcast_time = broadcast_time;
    }

    public double getKomi() {
        return komi;
    }

    public void setKomi(double komi) {
        this.komi = komi;
    }

    public int getHandicap() {
        return handicap;
    }

    public void setHandicap(int handicap) {
        this.handicap = handicap;
    }

    public String getPb() {
        return pb;
    }

    public void setPb(String pb) {
        this.pb = pb;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPo() {
        return po;
    }

    public void setPo(int po) {
        this.po = po;
    }
}
