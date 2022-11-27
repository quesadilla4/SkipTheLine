package com.example.skiptheline.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String CUSTOMER_TABLE = "CUSTOMER_TABLE";
    public static final String DISH_TABLE = "DISH_TABLE";
    public static final String ORDER_TABLE = "ORDER_TABLE";

    public static final String COLUMN_CUSTOMER_NAME = "CUSTOMER_NAME";
    public static final String COLUMN_CUSTOMER_EMAIL = "CUSTOMER_EMAIL";
    //public static final String COLUMN_ACTIVE_CUSTOMER = "ACTIVE_CUSTOMER";
    public static final String COLUMN_CUSTOMER_ID = "CUSTOMER_ID";
    public static final String COLUMN_DATE_ADDED = "DATE_ADDED";
    public static final String COLUMN_IS_ACTIVE = "IS_ACTIVE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_PASSWORD = "COLUMN_PASSWORD";
    public static final String COLUMN_IS_VENDOR = "IS_VENDOR";

    public static final String COLUMN_DISH_NAME = "DISH_NAME";
    public static final String COLUMN_VENDOR_NAME = "VENDOR_NAME";
    public static final String COLUMN_PRICE = "PRICE";
    public static final String COLUMN_CATEGORY = "CATEGORY";
    public static final String COLUMN_DISH_ID = "DISH_ID";

    public static final String COLUMN_ORDER_STATUS = "ORDER_STATUS";
    public static final String COLUMN_NUMBER_OF_DISHES = "NUMBER_OF_DISHES";
    public static final String COLUMN_PLACING_DATE = "PLACING_DATE";
    public static final String COLUMN_PLACING_TIME = "PLACING_TIME";
    public static final String COLUMN_ACCEPTANCE_DATE = "ACCEPTANCE_DATE";
    public static final String COLUMN_ACCEPTANCE_TIME = "ACCEPTANCE_TIME";
    public static final String COLUMN_CANCELLATION_DATE = "CANCELLATION_DATE";
    public static final String COLUMN_CANCELLATION_TIME = "CANCELLATION_TIME";
    public static final String COLUMN_READY_DATE = "READY_DATE";
    public static final String COLUMN_READY_TIME = "READY_TIME";
    public static final String COLUMN_COMPLETED_DATE = "COMPLETED_DATE";
    public static final String COLUMN_COMPLETED_TIME = "COMPLETED_TIME";






    public DataBaseHelper(@Nullable Context context) {
        super(context, "customer.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Creating the customer table
        String createTableStatement;
        createTableStatement = "CREATE TABLE " + CUSTOMER_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CUSTOMER_NAME + " TEXT, " +
                COLUMN_PASSWORD + " TEXT, " +
                COLUMN_IS_VENDOR + " BOOL, " +
                COLUMN_CUSTOMER_EMAIL + " TEXT, " +
                COLUMN_DATE_ADDED + " TEXT, " +
                COLUMN_IS_ACTIVE + " BOOL)";
        sqLiteDatabase.execSQL(createTableStatement);
        //Creating the dishes table
        createTableStatement = "CREATE TABLE " + DISH_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_DISH_NAME + " TEXT, " +
                COLUMN_VENDOR_NAME + " TEXT, " +
                COLUMN_PRICE + " REAL, " +
                COLUMN_CATEGORY + " TEXT, " +
                COLUMN_IS_ACTIVE + " BOOL)";
        sqLiteDatabase.execSQL(createTableStatement);
        //Creating the order table
        createTableStatement = "CREATE TABLE " + ORDER_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CUSTOMER_ID + " INTEGER, " +
                COLUMN_DISH_ID + " INTEGER, " +
                COLUMN_ORDER_STATUS + " INTEGER, " +
                COLUMN_PLACING_DATE + " TEXT, " +
                COLUMN_PLACING_TIME + " TEXT, " +
                COLUMN_ACCEPTANCE_DATE + " TEXT, " +
                COLUMN_ACCEPTANCE_TIME + " TEXT, "+
                COLUMN_CANCELLATION_DATE + " TEXT, " +
                COLUMN_CANCELLATION_TIME + " TEXT, "+
                COLUMN_READY_DATE + " TEXT, " +
                COLUMN_READY_TIME+ " TEXT, "+
                COLUMN_COMPLETED_DATE + " TEXT, " +
                COLUMN_COMPLETED_TIME + " TEXT)";
        sqLiteDatabase.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

   /* public boolean addOne(customerModel customerModel1){

        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(COLUMN_CUSTOMER_NAME,customerModel1.getName());
//        cv.put(COLUMN_CUSTOMER_AGE,customerModel1.getAge());
//        cv.put(COLUMN_ACTIVE_CUSTOMER,customerModel1.isActive());

        long insert = db.insert(CUSTOMER_TABLE, null, cv);
        if (insert==-1){
            return false;
        }
        else{
            return true;
        }
    }*/

    public boolean addCustomer(CustomerClass customerClass){

        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(COLUMN_CUSTOMER_NAME,customerClass.getName());
        cv.put(COLUMN_CUSTOMER_EMAIL,customerClass.getEmail());
        cv.put(COLUMN_PASSWORD,customerClass.getPassword());
        cv.put(COLUMN_DATE_ADDED,customerClass.getDateAdded());
        cv.put(COLUMN_IS_ACTIVE,customerClass.isActive());
        cv.put(COLUMN_IS_VENDOR,customerClass.isVendor());

        long insert = db.insert(CUSTOMER_TABLE, null, cv);
        if (insert==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean addDish(DishClass dishClass){

        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(COLUMN_DISH_NAME,dishClass.getName());
        cv.put(COLUMN_VENDOR_NAME,dishClass.getVendorName());
        cv.put(COLUMN_PRICE,dishClass.getPrice());
        cv.put(COLUMN_DATE_ADDED,dishClass.getDateAdded());
        cv.put(COLUMN_IS_ACTIVE,dishClass.isActive());

        long insert = db.insert(DISH_TABLE, null, cv);
        if (insert==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean addOrder(OrderClass orderClass){

        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(COLUMN_DISH_ID,orderClass.getDishId());
        cv.put(COLUMN_CUSTOMER_ID,orderClass.getCustomerId());
        cv.put(COLUMN_ORDER_STATUS,orderClass.getStatus());
        cv.put(COLUMN_PLACING_DATE,orderClass.getPlacingDate());
        cv.put(COLUMN_PLACING_TIME,orderClass.getPlacingTime());
        cv.put(COLUMN_ACCEPTANCE_DATE,orderClass.getAcceptanceDate());
        cv.put(COLUMN_ACCEPTANCE_TIME,orderClass.getAcceptanceTime());
        cv.put(COLUMN_CANCELLATION_DATE,orderClass.getCancellationDate());
        cv.put(COLUMN_CANCELLATION_TIME,orderClass.getCancellationTime());
        cv.put(COLUMN_READY_DATE,orderClass.getReadyDate());
        cv.put(COLUMN_READY_TIME,orderClass.getReadyTime());
        cv.put(COLUMN_COMPLETED_DATE,orderClass.getCompletedDate());
        cv.put(COLUMN_COMPLETED_TIME,orderClass.getCompletedTime());


        long insert = db.insert(ORDER_TABLE, null, cv);
        if (insert==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean updateOrderStatus(OrderClass orderClass,int newStatus){

        SQLiteDatabase db= this.getWritableDatabase();
        String queryString = "SELECT FROM " + ORDER_TABLE + " WHERE " + COLUMN_ID + " = " + orderClass.getId();
        Cursor cursor = db.rawQuery(queryString, null);

        ContentValues cv= new ContentValues();
        cv.put(COLUMN_DISH_ID,orderClass.getDishId());
        cv.put(COLUMN_CUSTOMER_ID,orderClass.getCustomerId());
        cv.put(COLUMN_ORDER_STATUS,newStatus);
        cv.put(COLUMN_PLACING_DATE,orderClass.getPlacingDate());
        cv.put(COLUMN_PLACING_TIME,orderClass.getPlacingTime());
        cv.put(COLUMN_ACCEPTANCE_DATE,orderClass.getAcceptanceDate());
        cv.put(COLUMN_ACCEPTANCE_TIME,orderClass.getAcceptanceTime());
        cv.put(COLUMN_CANCELLATION_DATE,orderClass.getCancellationDate());
        cv.put(COLUMN_CANCELLATION_TIME,orderClass.getCancellationTime());
        cv.put(COLUMN_READY_DATE,orderClass.getReadyDate());
        cv.put(COLUMN_READY_TIME,orderClass.getReadyTime());
        cv.put(COLUMN_COMPLETED_DATE,orderClass.getCompletedDate());
        cv.put(COLUMN_COMPLETED_TIME,orderClass.getCompletedTime());

        long insert = db.insert(ORDER_TABLE, null, cv);
        if (insert==-1){
            return false;
        }
        else{
            return true;
        }
    }

   /* public boolean deleteOne(customerModel customer_model){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + CUSTOMER_TABLE + " WHERE " + COLUMN_ID + " = " + customer_model.getId();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()){
            return true;
        }
        else{
            return false;
        }

    }
    public List<customerModel> getEveryone(){

        List<customerModel> returnList = new ArrayList<>();
        return returnList;
    }*/
    public List<CustomerClass> getEveryCustomer(){

        List<CustomerClass> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + CUSTOMER_TABLE;
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);

        if (cursor.moveToFirst()){
            do {
                int customerId = cursor.getInt(0);
                String customerName=cursor.getString(1);
                String customerPassword=cursor.getString(2);
                boolean isVendor=cursor.getInt(3) == 1 ? true: false;
                String customerEmail=cursor.getString(4);
                String dateAdded=cursor.getString(5);
                boolean isActive=cursor.getInt(6) == 1 ? true: false;

                CustomerClass order = new CustomerClass(customerId,customerName, customerEmail, customerPassword,
                         dateAdded, isVendor,isActive);
                returnList.add(order);

            }while(cursor.moveToNext());
        }
        else{

        }
        cursor.close();
        db.close();
        return returnList;
    }

     public List<OrderClass> getOrders(CustomerClass customerClass){

        List<OrderClass> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + CUSTOMER_TABLE + " WHERE " + COLUMN_CUSTOMER_ID + "=" + Integer.toString(customerClass.getId());
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);

        if (cursor.moveToFirst()){
            do {
                int orderID = cursor.getInt(0);
                int dishId=cursor.getInt(1);
                int customerId=cursor.getInt(2);
                int orderStatus=cursor.getInt(3);
                String placingDate=cursor.getString(4);
                String placingTime=cursor.getString(5);
                String acceptanceDate=cursor.getString(6);
                String acceptanceTime=cursor.getString(7);
                String cancellationDate=cursor.getString(8);
                String cancellationTime=cursor.getString(9);
                String readyDate=cursor.getString(10);
                String readyTime=cursor.getString(11);
                String completedDate=cursor.getString(12);
                String completedTime=cursor.getString(13);
                //boolean customerActive=cursor.getInt(13) == 1 ? true: false;

                OrderClass order = new OrderClass(orderID,dishId,customerId,orderStatus,
                        placingDate,placingTime,acceptanceDate,acceptanceTime,cancellationDate,
                        cancellationTime,readyDate,readyTime,completedDate,completedTime);
                returnList.add(order);

            }while(cursor.moveToNext());
        }
        else{

        }
        cursor.close();
        db.close();
        return returnList;
    }
    public boolean updateOrderStatus(OrderClass orderClass){

        return true;
    }
}
