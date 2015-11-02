package com.example.administrator.word4;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Administrator on 2015/10/31.
 */
public class MyDB extends SQLiteOpenHelper {
    private static String DB_NAME="My_DB.db";
    private static int DB_VERSION = 2;
    private SQLiteDatabase db;
    //①构造函数
    public MyDB(Context context){
        super(context,DB_NAME,null,DB_VERSION);
        db=getWritableDatabase();

    }
    //②打开SQLite数据库连接
    public SQLiteDatabase openConnection(){
        db=getWritableDatabase();
        return db;
    }

    //③关闭SQLite数据库连接操作
    public void closeConnection(){
        db.close();
    }
    //④创建表
    public boolean createTable(String createTableSql){
        try{
            openConnection();
            db.execSQL(createTableSql)
        ;}
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        finally {
            closeConnection();
        }
        return true;
    }
    //⑤添加数据
    public boolean save(String tableName,ContentValues values){
        try{
            openConnection();
            db.insert(tableName, null, values);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        finally {
            closeConnection();
        }
        return true;
    }
    //⑥修改数据
    public boolean update(String table,ContentValues values,String whereClause,String []whereArgs){
        try{
            openConnection();
            db.update(table, values, whereClause, whereArgs);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        finally {
            closeConnection();
        }
        return  true;
    }
    //⑦删除数据
    public  boolean delete(String table,String deleteSql,String obj[]){
        try{
            openConnection();
            db.delete(table, deleteSql, obj);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        finally {
            closeConnection();
        }
        return true;

    }
    //⑧查询操作
    public Cursor find(String findSql,String obj[]){

            try {
                openConnection();
                Cursor cursor = db.rawQuery(findSql, obj);
                return cursor;
            }
            catch (Exception e) {
                ;e.printStackTrace();
                return null;

            }
    }
    //⑨判断表是否存在
    public boolean isTableExits(String tableNmae){
        try{
            openConnection();
            String str = "select count(*)xcount from "+tableNmae;
            db.rawQuery(str,null).close();
        }catch (Exception e){
            return false;
        }
        finally {
            closeConnection();
        }
        return true;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
