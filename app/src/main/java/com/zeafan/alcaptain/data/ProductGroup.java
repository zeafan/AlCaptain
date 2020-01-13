package com.zeafan.alcaptain.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.zeafan.alcaptain.core.GlobalClass;
import java.util.ArrayList;
import java.util.Locale;
public class ProductGroup {
    // Table Columns Names
    public static final String KEY_GUID = "Guid";
    public static final String KEY_NAME = "Name";
    public static final String KEY_LATIN_NAME = "LatinName";
    public static final String KEY_Img_Path = "PathImage";
    // Table Name
    public static String DATABASE_TABLE = "DistDeviceGr000";
    // Class Fields
    public String Guid;
    public String Name;
    public String LatinName;
    public String PathImage;

    public static boolean DeleteAll(Context context) {
        DBAdapter adapter = new DBAdapter(context);
        try {
            adapter.Open();
            return  (DBAdapter.database.delete(DATABASE_TABLE, null, null) > -1);
        } catch (Exception e) {
            adapter.Close();
            GlobalClass.StaticCore.SendRepotEx(e);
            e.printStackTrace();
            return false;
        } finally {
            adapter.Close();
        }
    }

    public static boolean Delete(Context context, String guid) {
        DBAdapter adapter = new DBAdapter(context);
        boolean result = false;

        try {

            adapter.Open();
            result = (DBAdapter.database.delete(DATABASE_TABLE, KEY_GUID + "=" + guid, null) > 0);
            adapter.Close();
            return result;
        } catch (Exception e) {
            GlobalClass.StaticCore.SendRepotEx(e);
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<ProductGroup> GetGroupsList(Context context) {
        ArrayList<ProductGroup> productsList = new ArrayList<ProductGroup>();
        DBAdapter adapter = new DBAdapter(context);

        try {
            String selectQuery = "SELECT * FROM " + DATABASE_TABLE;


            adapter.Open();
            Cursor cursor = DBAdapter.database.rawQuery(selectQuery, null);

            if (cursor.moveToFirst()) {
                do {
                    ProductGroup row = new ProductGroup();

                    int i = 0;
                    row.Guid = cursor.getString(i++);
                    row.Name = cursor.getString(i++);
                    row.LatinName = cursor.getString(i++);
                    productsList.add(row);
                } while (cursor.moveToNext());

            }
        } catch (Exception e) {
            GlobalClass.StaticCore.SendRepotEx(e);
            e.printStackTrace();
        }

        return productsList;
    }



    public static boolean Update(Context context, ProductGroup productGroup) {
        DBAdapter adapter = new DBAdapter(context);

        try {

            adapter.Open();

            ContentValues values = new ContentValues();

            values.put(KEY_GUID, productGroup.Guid);
            values.put(KEY_NAME, productGroup.Name);
            values.put(KEY_LATIN_NAME, productGroup.LatinName);
            return  (DBAdapter.database.update(DATABASE_TABLE, values, KEY_GUID + "=" + productGroup.Guid, null) > -1);
        } catch (Exception e) {
            GlobalClass.StaticCore.SendRepotEx(e);
            e.printStackTrace();
            return false;
        }finally {
            adapter.Close();
        }
    }




    public boolean SaveInDatabase(Context context) {
        DBAdapter adapter = new DBAdapter(context);

        try {
            adapter.Open();
            DBAdapter.database.beginTransaction();
            ContentValues values = new ContentValues();

            values.put(KEY_GUID, Guid);
            values.put(KEY_NAME, Name);
            values.put(KEY_LATIN_NAME, LatinName);
           return DBAdapter.database.insert(DATABASE_TABLE, null, values)>-1;
        } catch (Exception e) {
            GlobalClass.StaticCore.SendRepotEx(e);
            e.printStackTrace();
            return false;
        } finally {
            DBAdapter.database.setTransactionSuccessful();
            DBAdapter.database.endTransaction();
            adapter.Close();
        }
    }

    public boolean Update(Context context) {
        boolean result = false;
        DBAdapter adapter = new DBAdapter(context);

        try {

            adapter.Open();

            ContentValues values = new ContentValues();

            values.put(KEY_GUID, Guid);
            values.put(KEY_NAME, Name);
            values.put(KEY_LATIN_NAME, LatinName);
            result = (DBAdapter.database.update(DATABASE_TABLE, values, KEY_GUID + "='" + Guid + "'", null) > 0);
            adapter.Close();
            return result;
        } catch (Exception e) {
            GlobalClass.StaticCore.SendRepotEx(e);
            e.printStackTrace();
            return false;
        }
    }

    public String getName() {
        final String language = Locale.getDefault().getLanguage();
        if (!language.equals("ar") && LatinName != null && !LatinName.isEmpty())
            return LatinName;

        return Name;
    }
}
