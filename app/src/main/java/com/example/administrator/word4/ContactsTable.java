package com.example.administrator.word4;

import android.content.ContentValues;
import android.content.Context;

/**
 * 创建用于封装联系人表中数据的操作，例如将界面上的数据保存到数据库中
 * Created by Administrator on 2015/10/31.
 */
public class ContactsTable {
    private  final static String TABLENAME="contactsTable";
    private MyDB db;
    public ContactsTable(Context content){
        db=new MyDB(content);
        if(!db.isTableExits(TABLENAME)){
            String createTableSql="CREATE TABLE IF NOT EXISTS "+
                    TABLENAME +"(id_DB integer  "+
                    "primary key AUTOINCREMENT ,"+
                    User.NAME +"VARCHAR ,"+
                    User.MOBLIE + "VARCHAR ,"+
                    User.QQ + "VARCHAR ,"+
                    User.DANWEI + "VARCHAR,"+
                    User.ADDRESS +"VARCHAR )";
            //创建表
            db.createTable(createTableSql);
        }
    }
    public boolean addData(User user){
        ContentValues values=new ContentValues();
        values.put(User.NAME,user.getName());
        values.put(User.MOBLIE,user.getMoblie());
        values.put(User.DANWEI,user.getDanwei());
        values.put(User.QQ,user.getQq());
        values.put(User.ADDRESS,user.getAddress());
        return db.save(TABLENAME,values);
    }
}
