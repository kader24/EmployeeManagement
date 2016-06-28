package com.cse24gmail.jakir.employeemanagement;

import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by HP on 6/18/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    private final static String DB_NAME="employee";
    private final static int DB_VERSION=1;

    public static final String ID_FIELD="_id";

    public static final String NAME_FIELD="name";
    public static final String DESIGNATION_FIELD="designation";
    public static final String ADDRESS_FIELD="address";
    public static final String EMAIL_FIELD="email";
    public static final String PHONE_FIELD="phone";

    public static final String TABLE_EMPLOYEE="employee";

    SQLiteDatabase database=getWritableDatabase();


    private static String SQL_EMPLOYEE="create table "+TABLE_EMPLOYEE+" ( "+ID_FIELD+" INTEGER primary key, "
            +NAME_FIELD+" TEXT, "+DESIGNATION_FIELD+" TEXT, "+EMAIL_FIELD+" TEXT, "+PHONE_FIELD+" TEXT, "+ADDRESS_FIELD+" TEXT );";
    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_EMPLOYEE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long addEmployee(String name,String designation,String email,String phone,String address){

        ContentValues v=new ContentValues();
        v.put(NAME_FIELD,name);
        v.put(DESIGNATION_FIELD,designation);
        v.put(EMAIL_FIELD,email);
        v.put(PHONE_FIELD,phone);
        v.put(ADDRESS_FIELD,address);

        long isInsert=database.insert(TABLE_EMPLOYEE,null,v);

        return isInsert;
    }

    public ArrayList<Employee> getEmployee(){

        ArrayList<Employee> list=new ArrayList<>();
        Cursor cursor=database.query(TABLE_EMPLOYEE,null,null,null,null,null,null);

        if(cursor!=null){

            cursor.moveToFirst();
            for(int i=0;i<cursor.getCount();i++){
                int id=cursor.getInt(cursor.getColumnIndex(ID_FIELD));
                String name=cursor.getString(cursor.getColumnIndex(NAME_FIELD));
                String email=cursor.getString(cursor.getColumnIndex(EMAIL_FIELD));
                String des=cursor.getString(cursor.getColumnIndex(DESIGNATION_FIELD));
                String addrs=cursor.getString(cursor.getColumnIndex(ADDRESS_FIELD));
                String phone=cursor.getString(cursor.getColumnIndex(PHONE_FIELD));

                Employee abc=new Employee(id,name,des,email,phone,addrs);
                list.add(abc);
                cursor.moveToNext();
            }

        }
       return list;

    }

    public ArrayList<Employee> getEmployeeInfoById(int empId){
        ArrayList<Employee> employees=new ArrayList<Employee>();

        String queryy="select * from "+TABLE_EMPLOYEE+
                " where "+TABLE_EMPLOYEE+"."+ID_FIELD+" = "
                +empId;

        Cursor cursor=database.rawQuery(queryy,null);
        if(cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
            for(int i=0;i<cursor.getCount();i++){
                String name=cursor.getString(cursor.getColumnIndex(DBHelper.NAME_FIELD));
                int id=Integer.parseInt(cursor.getString(cursor.getColumnIndex(DBHelper.ID_FIELD)));
                String email=cursor.getString(cursor.getColumnIndex(DBHelper.EMAIL_FIELD));
                String designation=cursor.getString(cursor.getColumnIndex(DBHelper.DESIGNATION_FIELD));
                String address=cursor.getString(cursor.getColumnIndex(DBHelper.ADDRESS_FIELD));
                String phone=cursor.getString(cursor.getColumnIndex(DBHelper.PHONE_FIELD));

                Employee employee=new Employee(id,name,designation,email,phone,address);
                employees.add(employee);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return employees;
    }
}
