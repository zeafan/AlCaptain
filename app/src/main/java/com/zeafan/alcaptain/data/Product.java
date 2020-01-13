package com.zeafan.alcaptain.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import org.json.JSONArray;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

@SuppressWarnings("serial")
public class  Product implements Serializable {
    // Table Columns Names
    public static final String KEY_GUID = "Guid";
    public static final String KEY_GROUP_GUID = "GroupGuid";
    public static final String KEY_CODE = "Code";
    public static final String KEY_NAME = "Name";
    public static final String KEY_LATIN_NAME = "LatinName";
    public static final String KEY_QUANTITY = "Quantity";
    public static final String KEY_UNITY = "Unity1";
    public static final String KEY_PRICE1_UNIT1 = "PriceUnit1";
    public static final String KEY_DISCOUNTS = "Discounts";
    public static final String KEY_PICTURE_PATH = "PicturePath";

    // Table Name
    public static String DATABASE_TABLE = "DistDeviceMt000";
    // Class Fields
    public String Guid;
    public String GroupGuid;
    public String Code;
    public String Name;
    public double Quantity;
    public String LatinName;
    public double Price1;
    public int DefaultUnit;
    public String Discounts;
    public String PicturePath;


}
