package com.example.administrator.word4;

/**
 * Created by Administrator on 2015/10/31.
 */
public class User {
    public static final String NAME ="name" ;
    public static final String MOBLIE ="moblie" ;
    public static final String QQ ="qq" ;
    public static final String DANWEI ="danwei" ;
    public static final String ADDRESS ="address" ;
    private String name;;
    private String  moblie;
    private String  danwei  ;
    private String  qq  ;
    private String   address ;
    private int   id_DB =-1 ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoblie() {
        return moblie;
    }

    public void setMoblie(String moblie) {
        this.moblie = moblie;
    }

    public String getDanwei() {
        return danwei;
    }

    public void setDanwei(String danwei) {
        this.danwei = danwei;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId_DB() {
        return id_DB;
    }

    public void setId_DB(int id_DB) {
        this.id_DB = id_DB;
    }
}
