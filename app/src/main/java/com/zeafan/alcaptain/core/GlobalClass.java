package com.zeafan.alcaptain.core;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Base64;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.zeafan.alcaptain.R;
import com.zeafan.alcaptain.data.DBAdapter;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import java.util.Vector;
import static android.support.v4.app.ActivityCompat.requestPermissions;
//import com.bixolon.printer.BixolonPrinter;

public class GlobalClass extends Application {
    //public static Picasso picassoWithCache;
    static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_hindi = "dd-MM-yyyy";
    public static final String URL_DATE_TIME_FORMAT_hindi = "dd-MM-yyyy    HH:mm";
    public static final String MINUTE_FORMAT = "mm:ss";
    public static final String HOUR_MINUTE_FORMAT = "HH:mm";
    public static final String URL_DATE_TIME_FORMAT = "yyyy-MM-dd_HH:mm";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm";
    public static final String DATE_TIME_FORMAT_Location = "yyyy-MM-dd HH:mm:ss";
    public static final String PRINTING_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm";
    public static final String FULL_DATE_TIME_FORMAT = "EEE MMM dd HH:mm:ss zzz yyyy";
    public static final String KEY_DISTRIBUTOR_DEVICE_NAME = "DistributorDeviceName";
    public static final String KEY_DB_NAME = "DbName";
    public static final String KEY_Using_DNS = "UsingDns";
    public static final String KEY_LOCAL_HOST = "localHost";
    public static final String KEY_STATIC_HOST = "staticHost";
    public static final String KEY_DNS_HOST = "dnsHost";
    public final static double AroundDiscountConst = 5;
    public final static short Day_DeleteSerialNumberReturn = -15;
    public static final String BarcodeScannerApkFileName = Environment.getExternalStorageDirectory().getPath() + "/barcode_scanner_4.7.3.apk";
    public static final String PrinterShareApkFileName = Environment.getExternalStorageDirectory().getPath() + "/printershare_10.7.7.apk";
    public static final String LinePrintServiceApkFileName = Environment.getExternalStorageDirectory().getPath() + "/line_print_service.apk";
    public static final String EmptyGuid = "00000000-0000-0000-0000-000000000000";
    public static final String FPDate = "AmnCfg_FPDate";
    public static final String EPDate = "AmnCfg_EPDate";
    public static  boolean CustomerSaved =true ;
    public static LocalNumbersFormat localNumbersFormat;
    public static Context APP_CTX;
    public static String TAX_NUMBER = "";
    public static ArrayList<Character> barCodeCharArr = new ArrayList<>(); //Arraylist that contains chars of bar code that added to it char by char
   // public static String barCode = "";  //bar code string that contains all the barcode chars
    public static String localHost = "";
    public static String staticHost = "";
    public static String dnsHost = "";
    public static boolean UsingDns=false;
    public static String deviceName = "";
    public static String dbName = "Select database name...";
    public static SharedPreferences SharedPreferences;
    public static int ConnectionTimeout = 10000;  // Ten Seconds
    public static int PostingDataDelay = 300000; // Every Five Minutes
    public static String LoginBackgroundUriString = "";
    public static String CustomCompanyName = "Al Ameen Distribution";
    public static String ImagesFolderPath = "/com.syriansoft.ameendistribution.images/";
    public static String UsedFont = "fonts/.ttf";
    public static boolean ShowAddProductActivity = true;
    public static int _listPosition = -1;
    public static boolean CustomerUpdated = false;
    public static Locale CurrentLocale = null;
    public static int AddProductsMethod;
    public static boolean ShowQuantityOnProductImage;
    public static boolean ShowProductNameOnImage;
    public static boolean ShowSyncReminderMessage;
    public static boolean EnforceDailySync = false;
    public static String Customer_Header = "";
    public static boolean ShowUnitFieldInPrint = true;
    public static boolean Show_Indian_Numbers = false;
    public static boolean ShowBonusFieldInPrint = true;
    public static boolean ShowPrintedPriceFieldInPrint = true;
    public static boolean ShowCustomerTaxNumber = false;
    public static boolean ShowSinglePriceFieldInPrint = true;
    public static boolean UseDetailedPrintWay = true;
    public static boolean ShowTotalFieldInPrint = true;
    public static boolean ShowItemDiscFieldInPrint = false;
    public static boolean ShowVatValueInPrint = false;
    public static boolean ShowVatRatioInPrint = false;
    public static boolean ShowUsingPrintModel2 = false;
    public static boolean PrintGroupProduct = true;
    public static boolean PrintLatinName = true;
    public static boolean ShowItemNameH = true;
    public static boolean AutoCheckOffers = false;
    public static int ProductsViewStyle;
    public static int promotionId = 0;
    public static boolean SendMyLocationToServer = false;
    //the option for print in the Setting to use in all project
//=======================  Footer =================================
    public static boolean FooterShowTotalField = true;
    public static boolean FooterShowDiscountField = true;
    public static boolean FooterShowTotalTaxField = true;
    public static boolean FooterShowNetField = true;
    public static boolean FooterShowBalanceField = true;
    public static boolean FooterShowRemainingField = true;
    public static boolean FooterShowFirstPayField = true;
    //=======================  Header =================================
    public static boolean HeaderShowBillTypeTitleField = true;
    public static boolean HeaderShowDistributorField = true;
    public static boolean HeaderShowDistributorCodeField = true;
    public static boolean HeaderShowBillNumberField = true;
    public static boolean HeaderShowPayTypeField = true;
    public static boolean Add_Decimal_Number_Bonus = false;
    public static boolean HeaderShowDateField = true;
    public static boolean HeaderShowCustomerField = true;
    public static boolean HeaderShowAddressField = true;
    public static boolean HeaderShowNoteField = false;
    public static boolean TransactionByMultiCurrency = false;
    //========================================================
    public static int PrintStringSize = 1;
    public static int TypeOfSerialNumber = 0;
    public static boolean CheckSerialNumber = true;
    public static int PrintPaperSize = 8;
    public static int PrintStringType = 1;
    //public static int CopyNumber = 1;
    public static boolean IsInBillFrag = true;
    //========================================================
    public static boolean AllowRepeatProduct = true;
    //========================================================
    public static boolean activeVisit = false;
    public static String temptypeOfVisit = "";
    public static HashMap<String, Integer> UsedProQtyList = new HashMap<>();
    public static boolean WorkOnline = true;
    public static boolean BackgroundSync = true;
    public static String host = "";
    public static DecimalFormat PriceDecimalFormat = null;
    public static DecimalFormat QtyDecimalFormat = null;
    public static int ZerAccuracy = 100;
    public static int ZerAccuracyQty = 100;
    public static int DeciamlFormatNumber = 0;
    public static int DeciamlFormatQty = 0;
    public static boolean TrialVersion = false;
    public static String printerAddress;
    public static BluetoothAdapter mBluetoothAdapter;
    public static Vector<BluetoothDevice> remoteDevices;

    public static String NewCustomerGuids_key = "NewCustomer";
    public static String SaveBillTypelstNumber = "BillTypelstNumber";
    public static String SaveBilllstNumber = "BilllstNumber";
    public static boolean FooterShowTotalQty = false;
    public static boolean FooterShowTotalBonus = false;
    public static boolean FooterShowTotalItems = false;
    //    public static boolean AddProductByBarCode = true;
    private static String ServiceUrlProtocol = "http://";
    private static String ServicePath = "/DistributionService/DistributionWebHttpEndPoint/";
    public static boolean ShowBuildNumber = true;
    public static boolean ShowFloorNumber = true;
    public static boolean ShowStreet= true;
    public static boolean ShowArea= true;
    public static boolean ShowCity= true;
    public static boolean ShowCountry = true;
    public static boolean ShowPOBox = true;
    public static boolean ShowZipCode = true;
    public static boolean ShowMoreDetails = true;
    public static boolean ShowWorksDay= true;
    public static boolean ShowCF_Feilds= true;
    // method for base64 to bitmap
    public static Bitmap decodeBase64(String input) {
        byte[] decodedByte = Base64.decode(input, 0);
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }

    public static String encodeTobase64(Bitmap image) {
        Bitmap immage = image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immage.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);
        Log.d("Image Log:", imageEncoded);
        return imageEncoded;
    }

    public static String convertToHindi(Date value, int type) {
        if (value != null) {
            if (type == 1) {
                if (GlobalClass.Show_Indian_Numbers) {
                    SimpleDateFormat date = new SimpleDateFormat(GlobalClass.DATE_FORMAT_hindi, Locale.getDefault());
                    String Data = date.format(value.getTime());
                    int arabic_zero_unicode = 1632;
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < Data.length(); ++i) {
                        int i2 = (int) Data.charAt(i);
                        if (i2 > 47 && i2 < 58) {
                            builder.append((char) ((int) Data.charAt(i) - 48 + arabic_zero_unicode));
                        } else {
                            builder.append((char) ((int) Data.charAt(i)));
                        }
                    }
                    return builder.toString();
                } else {
                    SimpleDateFormat date = new SimpleDateFormat(GlobalClass.DATE_FORMAT, Locale.getDefault());
                    String date_arabic = date.format(value.getTime());
                    int Eng_zero_unicode = 1584;
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < date_arabic.length(); ++i) {
                        int i2 = (int) date_arabic.charAt(i);
                        if (i2 > 1631 && i2 < 1642) {
                            builder.append((char) ((int) date_arabic.charAt(i) - Eng_zero_unicode));
                        } else {
                            builder.append((char) ((int) date_arabic.charAt(i)));
                        }
                    }
                    return builder.toString();
                }
            } else if (type == 2) {
                if (GlobalClass.Show_Indian_Numbers) {
                    SimpleDateFormat date = new SimpleDateFormat(GlobalClass.URL_DATE_TIME_FORMAT_hindi, Locale.getDefault());
                    String Data = date.format(value.getTime());
                    int arabic_zero_unicode = 1632;
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < Data.length(); ++i) {
                        int i2 = (int) Data.charAt(i);
                        if (i2 > 47 && i2 < 58) {
                            builder.append((char) ((int) Data.charAt(i) - 48 + arabic_zero_unicode));
                        } else {
                            builder.append((char) ((int) Data.charAt(i)));
                        }
                    }
                    return builder.toString();
                } else {
                    SimpleDateFormat date = new SimpleDateFormat(GlobalClass.URL_DATE_TIME_FORMAT, Locale.getDefault());
                    String date_arabic = date.format(value.getTime());
                    int Eng_zero_unicode = 1584;
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < date_arabic.length(); ++i) {
                        int i2 = (int) date_arabic.charAt(i);
                        if (i2 > 1631 && i2 < 1642) {
                            builder.append((char) ((int) date_arabic.charAt(i) - Eng_zero_unicode));
                        } else {
                            builder.append((char) ((int) date_arabic.charAt(i)));
                        }
                    }
                    return builder.toString();
                }
            }
        }
        return null;
    }

    public static String ConvertInArabicNumberFormat(Date date) {
        String date_arabic = StaticCore.DateToString(date, GlobalClass.DATE_TIME_FORMAT_Location);
        int Eng_zero_unicode = 1584;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < date_arabic.length(); ++i) {
            int i2 = (int) date_arabic.charAt(i);
            if (i2 > 1631 && i2 < 1642) {
                builder.append((char) ((int) date_arabic.charAt(i) - Eng_zero_unicode));
            } else {
                builder.append((char) ((int) date_arabic.charAt(i)));
            }
        }
        return builder.toString();
    }

    public static String convertToHindi(int value) {
        String value2 = String.valueOf(value);
        if (GlobalClass.Show_Indian_Numbers) {
            int arabic_zero_unicode = 1632;
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < value2.length(); ++i) {
                int i2 = (int) value2.charAt(i);
                if (i2 > 47 && i2 < 58) {
                    builder.append((char) ((int) value2.charAt(i) - 48 + arabic_zero_unicode));
                } else {
                    builder.append((char) ((int) value2.charAt(i)));
                }
            }
            return builder.toString();
        } else {
            int Eng_zero_unicode = 1584;
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < value2.length(); ++i) {
                int i2 = (int) value2.charAt(i);
                if (i2 > 1631 && i2 < 1642) {
                    builder.append((char) ((int) value2.charAt(i) - Eng_zero_unicode));
                } else {
                    builder.append((char) ((int) value2.charAt(i)));
                }
            }
            return builder.toString();
        }
    }

    public static String convertToHindi(String value) {
        final String language = Locale.getDefault().getLanguage();
//language of system is Arabic
        if (language.equals("ar")) {
            char index_0 = value.charAt(0);
            if (GlobalClass.Show_Indian_Numbers) {
                return number_hindi(value);
            } else {
                if (index_0 == '-') {
                    StringBuilder builder = new StringBuilder();
                    int Eng_zero_unicode = 1584;
                    for (int i = 1; i < value.length(); i++) {
                        int i2 = (int) value.charAt(i);
                        if (i2 > 1631 && i2 < 1642) {
                            builder.append((char) ((int) value.charAt(i) - Eng_zero_unicode));
                        } else {
                            builder.append((char) ((int) value.charAt(i)));
                        }
                    }
                    builder.append('-');
                    return builder.toString();
                } else {
                    return number_Arabic(value);
                }
            }
        }
        //language of system is English
        else {
            char index_0 = value.charAt(0);
            if (!GlobalClass.Show_Indian_Numbers) {
                return number_Arabic(value);
            } else {
                if (index_0 == '-') {
                    StringBuilder builder = new StringBuilder();
                    int arabic_zero_unicode = 1632;
                    for (int i = 1; i < value.length(); i++) {
                        int i2 = (int) value.charAt(i);
                        if (i2 > 47 && i2 < 58) {
                            builder.append((char) ((int) value.charAt(i) - 48 + arabic_zero_unicode));
                        } else {
                            builder.append((char) ((int) value.charAt(i)));
                        }
                    }
                    builder.append('-');
                    return builder.toString();
                } else {
                    return number_hindi(value);
                }
            }

        }
    }

    static public String number_hindi(String value) {
        int arabic_zero_unicode = 1632;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            int i2 = (int) value.charAt(i);
            if (i2 > 47 && i2 < 58) {
                builder.append((char) ((int) value.charAt(i) - 48 + arabic_zero_unicode));
            } else {
                builder.append((char) ((int) value.charAt(i)));
            }
        }
        return builder.toString();
    }

    static public String number_Arabic(String value) {
        int Eng_zero_unicode = 1584;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < value.length(); ++i) {
            int i2 = (int) value.charAt(i);
            if (i2 > 1631 && i2 < 1642) {
                builder.append((char) ((int) value.charAt(i) - Eng_zero_unicode));
            } else {
                builder.append((char) ((int) value.charAt(i)));
            }
        }
        return builder.toString();
    }

    public static String convertToHindi(double value) {
        String value2 = String.valueOf(value);
        if (GlobalClass.Show_Indian_Numbers) {
            int arabic_zero_unicode = 1632;
            StringBuilder builder = new StringBuilder();
            if (value2.charAt(0) == '-') {
                for (int i = 1; i < value2.length(); ++i) {
                    int i2 = (int) value2.charAt(i);
                    if (i2 > 47 && i2 < 58) {
                        builder.append((char) ((int) value2.charAt(i) - 48 + arabic_zero_unicode));
                    } else {
                        builder.append((char) ((int) value2.charAt(i)));
                    }
                }
                builder.append('-');
                return builder.toString();
            } else {
                for (int i = 0; i < value2.length(); ++i) {
                    int i2 = (int) value2.charAt(i);
                    if (i2 > 47 && i2 < 58) {
                        builder.append((char) ((int) value2.charAt(i) - 48 + arabic_zero_unicode));
                    } else {
                        builder.append((char) ((int) value2.charAt(i)));
                    }
                }
                return builder.toString();
            }
        } else {
            int Eng_zero_unicode = 1584;
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < value2.length(); ++i) {
                int i2 = (int) value2.charAt(i);
                if (i2 > 1631 && i2 < 1642) {
                    builder.append((char) ((int) value2.charAt(i) - Eng_zero_unicode));
                } else {
                    builder.append((char) ((int) value2.charAt(i)));
                }
            }
            return builder.toString();
        }
    }

    public static String arabicToDecimal(String number) {
        char[] chars = new char[number.length()];
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            if (ch >= 0x0660 && ch <= 0x0669)
                ch -= 0x0660 - '0';
            else if (ch >= 0x06f0 && ch <= 0x06F9)
                ch -= 0x06f0 - '0';
            chars[i] = ch;
        }
        return new String(chars);
    }

    public static double round(double value, int places) {
        try {
            if (places < 0) throw new IllegalArgumentException();

            BigDecimal bd = new BigDecimal(value);
            bd = bd.setScale(places, RoundingMode.HALF_UP);
            return bd.doubleValue();
        } catch (Exception e) {
            StaticCore.SendRepotEx(e);
            return value;
        }
    }

//    public static Bitmap mergeBitmaps(Bitmap topBitmap, Bitmap bottomBitmap) {
//        Bitmap mergedBitmap;
//        int height;
//        int max_width=Printing.A4Paper.get_pageWidth();
//        height = topBitmap.getHeight() + bottomBitmap.getHeight();
//        mergedBitmap = Bitmap.createBitmap(max_width, height, Bitmap.Config.ARGB_8888);
//        Canvas comboImage = new Canvas(mergedBitmap);
//        float width_topBitmap= (max_width - topBitmap.getWidth()) >> 1;
//        float width_bottomBitmap= (max_width - bottomBitmap.getWidth()) >> 1;
//        comboImage.drawBitmap(topBitmap,width_topBitmap, 0f, null);
//        comboImage.drawBitmap(bottomBitmap, width_bottomBitmap, topBitmap.getHeight() + 20, null);
//
//        return mergedBitmap;
//    }

    public static boolean BackupData(Context context) {
        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();
            if (sd.canWrite()) {
                String currentDBPath = "/data/" + context.getPackageName() + "/databases/" + DBAdapter.DATABASE_NAME;
                String backupDBPath = DBAdapter.DATABASE_BACKUP_NAME;
                File currentDB = new File(data, currentDBPath);
                File backupDB = new File(sd, backupDBPath);
                FileChannel src = new FileInputStream(currentDB).getChannel();
                FileChannel dst = new FileOutputStream(backupDB).getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();

            }

            return true;
        } catch (Exception e) {
            StaticCore.SendRepotEx(e);
            return false;
        }
    }

    public static boolean BackupPreferences(Context context) {
        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();
            String packageName = context.getPackageName();
            String settingsPath = "/data/" + packageName + "/shared_prefs/" + packageName + "_preferences.xml";

            if (sd.canWrite()) {
                File currentPreferencesFile = new File(data, settingsPath);
                File backupPreferencesFile = new File(sd, packageName + "_preferences.xml");
                FileChannel src = new FileInputStream(currentPreferencesFile).getChannel();
                FileChannel dst = new FileOutputStream(backupPreferencesFile).getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();
            }

            return true;
        } catch (Exception e) {
            StaticCore.SendRepotEx(e);
            return false;
        }
    }

    public static boolean RestoreData(Activity context, File currentDB) {
        try {
          File dbFile = context.getDatabasePath(DBAdapter.DATABASE_NAME);
                FileChannel src = new FileInputStream(currentDB).getChannel();
                FileChannel dst = new FileOutputStream(dbFile).getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();
            return true;
        } catch (Exception e) {
            StaticCore.SendRepotEx(e);
            ShowDialogError(context,context.getString(R.string.errr_store_data)+"\n"+ e.toString());
            return false;
        }
    }
    public static boolean RestorePreferences(Context context) {
        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();

            if (sd.canWrite()) {
                String packageName = context.getPackageName();
                String currentFilePath = "/data/" + packageName + "/shared_prefs/" + packageName + "_preferences.xml";
                String backupFilePath = packageName + "_preferences.xml";
                File currentFile = new File(data, currentFilePath);
                File backupFile = new File(sd, backupFilePath);

                FileChannel src = new FileInputStream(currentFile).getChannel();
                FileChannel dst = new FileOutputStream(backupFile).getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();
            }
            return true;
        } catch (Exception e) {
            StaticCore.SendRepotEx(e);
            return false;
        }
    }

    public static String getLanguageCode() {
        return Locale.getDefault().getLanguage();
    }

    public static void initFormats(Context context) {
        AmeenOption AmnCfg_PricePrec = AmeenOption.GetByName(context, "AmnCfg_PricePrec");
        AmeenOption AmnCfg_QtyPrec = AmeenOption.GetByName(context, "AmnCfg_QtyPrec");
        AmeenOption AmnCFGZerAccuracy = AmeenOption.GetByName(context, "AmnCFGZerAccuracy");
        AmeenOption AmnCFGZerAccuracyQty = AmeenOption.GetByName(context, "AmnCFGZerAccuracyQty");


        DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance(Locale.US);
        df.setNegativePrefix("-");
        df.setGroupingSize(3);
        df.setGroupingUsed(true);

        {
            int pricePrec = 0;

            if (AmnCfg_PricePrec != null) {
                pricePrec = Integer.parseInt(AmnCfg_PricePrec.Value);
                DeciamlFormatNumber = pricePrec;
            }

            switch (pricePrec) {
                case 0:
                    df.setMaximumFractionDigits(0);
                    df.setMinimumFractionDigits(0);
                    break;
                case 1:
                    df.setMaximumFractionDigits(1);
                    df.setMinimumFractionDigits(1);
                    break;
                case 2:
                    df.setMaximumFractionDigits(2);
                    df.setMinimumFractionDigits(2);
                    break;
                case 3:
                    df.setMaximumFractionDigits(3);
                    df.setMinimumFractionDigits(3);
                    break;
                case 4:
                    df.setMaximumFractionDigits(4);
                    df.setMinimumFractionDigits(4);
                    break;
                case 5:
                    df.setMaximumFractionDigits(5);
                    df.setMinimumFractionDigits(5);
                    break;
                case 6:
                    df.setMaximumFractionDigits(6);
                    df.setMinimumFractionDigits(6);
                    break;
                case 7:
                    df.setMaximumFractionDigits(7);
                    df.setMinimumFractionDigits(7);
                    break;
                default:
                    df.setMaximumFractionDigits(2);
                    df.setMinimumFractionDigits(2);
                    break;
            }

            PriceDecimalFormat = df;
        }

        {
            DecimalFormat df1 = (DecimalFormat) DecimalFormat.getInstance(Locale.US);
            df1.setNegativePrefix("-");
            df1.setGroupingSize(3);
            df1.setGroupingUsed(true);
            int qtyPrec = 0;

            if (AmnCfg_QtyPrec != null) {
                qtyPrec = Integer.parseInt(AmnCfg_QtyPrec.Value);
                DeciamlFormatQty = qtyPrec;
            }

            switch (qtyPrec) {
                case 0:
                    df1.setMaximumFractionDigits(0);
                    df1.setMinimumFractionDigits(0);
                    break;
                case 1:
                    df1.setMaximumFractionDigits(1);
                    df1.setMinimumFractionDigits(1);
                    break;
                case 2:
                    df1.setMaximumFractionDigits(2);
                    df1.setMinimumFractionDigits(2);
                    break;
                case 3:
                    df1.setMaximumFractionDigits(3);
                    df1.setMinimumFractionDigits(3);
                    break;
                case 4:
                    df1.setMaximumFractionDigits(4);
                    df1.setMinimumFractionDigits(4);
                    break;
                case 5:
                    df1.setMaximumFractionDigits(5);
                    df1.setMinimumFractionDigits(5);
                    break;
                case 6:
                    df1.setMaximumFractionDigits(6);
                    df1.setMinimumFractionDigits(6);
                    break;
                case 7:
                    df1.setMaximumFractionDigits(7);
                    df1.setMinimumFractionDigits(7);
                    break;
                default:
                    df1.setMaximumFractionDigits(2);
                    df1.setMinimumFractionDigits(2);
                    break;
            }

            QtyDecimalFormat = df1;
        }

        if (AmnCFGZerAccuracy != null) {
            int count = Integer.parseInt(AmnCFGZerAccuracy.Value);
            String str = "1";

            for (int i = 0; i < count; i++) {
                str += "0";
            }

            ZerAccuracy = Integer.valueOf(str);
        }

        if (AmnCFGZerAccuracyQty != null) {
            int count = Integer.parseInt(AmnCFGZerAccuracyQty.Value);
            String str = "1";

            for (int i = 0; i < count; i++) {
                str += "0";
            }

            ZerAccuracyQty = Integer.valueOf(str);
        }
    }

    public static String zeroAccQty() {
        String qtyZero = String.valueOf(ZerAccuracyQty);
        String newZeroAccQty;
        if (!qtyZero.equals("10")) {
            newZeroAccQty = qtyZero.replace("1", "0.");
            int length = newZeroAccQty.length();
            newZeroAccQty.substring(length - 1);
            newZeroAccQty += "1";
        } else if (qtyZero.equals("10")) {
            newZeroAccQty = "0.1";
        } else {
            newZeroAccQty = "0.0";
        }
        return newZeroAccQty;
    }

    public static String getVersionName(Context context) {
        String versionName = "N/A";

        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            versionName = context.getResources().getString(R.string.version) + " " + info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            StaticCore.SendRepotEx(e);
            e.printStackTrace();
            return versionName;
        }

        return versionName;
    }

    public static boolean isPackageInstalled(String packagename, Context context) {
        PackageManager pm = context.getPackageManager();

        try {
            pm.getPackageInfo(packagename, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            StaticCore.SendRepotEx(e);
            return false;
        }
    }
/*
    public static void BackupData(Context context) {
        try {
            File sd = Environment.getExternalStorageDirectory();
            //File data = Environment.getDataDirectory();

            if (sd.canWrite()) {
                String currentDBPath = "/data/data/" + context.getPackageName() + "/databases/" + DBAdapter.DATABASE_NAME;
                String backupDBPath = DBAdapter.DATABASE_BACKUP_NAME;
                File currentDB = new File(currentDBPath);
                File backupDB = new File(sd, backupDBPath);

                if (currentDB.exists()) {
                    FileChannel src = new FileInputStream(currentDB).getChannel();
                    FileChannel dst = new FileOutputStream(backupDB).getChannel();
                    dst.transferFrom(src, 0, src.size());
                    src.close();
                    dst.close();
                }
            }
        } catch (Exception e) {

        }
    }

    public static void RestoreData(Context context) {
        try {
            File sd = Environment.getExternalStorageDirectory();
            //File data = Environment.getDataDirectory();

            if (sd.canWrite()) {
                String currentDBPath = "/data/data/" + context.getPackageName() + "/databases/" + DBAdapter.DATABASE_NAME;
                String backupDBPath = DBAdapter.DATABASE_BACKUP_NAME;
                File currentDB = new File(currentDBPath);
                File backupDB = new File(sd, backupDBPath);

                if (currentDB.exists()) {
                    FileChannel src = new FileInputStream(currentDB).getChannel();
                    FileChannel dst = new FileOutputStream(backupDB).getChannel();
                    dst.transferFrom(src, 0, src.size());
                    src.close();
                    dst.close();
                }
            }
        } catch (Exception e) {

        }
    }
*/

    public static void installBarcodeScannerApp(Context context) {
        File DbFile = new File("mnt/sdcard/barcode_scanner_4.7.3.apk");

        try {
            int length = 0;
            boolean fileCreated = DbFile.createNewFile();
            InputStream inputStream = context.getAssets().open("apk/barcode_scanner_4.7.3.apk");
            FileOutputStream fOutputStream = new FileOutputStream(DbFile);
            byte[] buffer = new byte[inputStream.available()];

            while ((length = inputStream.read(buffer)) > 0) {
                fOutputStream.write(buffer, 0, length);
            }

            fOutputStream.flush();
            fOutputStream.close();
            inputStream.close();
        } catch (Exception ignored) {
            StaticCore.SendRepotEx(ignored);
        }

        Intent installIntent = new Intent(Intent.ACTION_VIEW);
        installIntent.setDataAndType(Uri.fromFile(new File(BarcodeScannerApkFileName)), "application/vnd.android.package-archive");
        installIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(installIntent);
    }

    public static void installPrintShareApp(Context context) {
        //File DbFile = new File("mnt/sdcard/printershare_10.7.7.apk");
        File DbFile = new File(PrinterShareApkFileName);

        try {
            int length = 0;
            boolean fileCreated = DbFile.createNewFile();
            InputStream inputStream = context.getAssets().open("apk/printershare_10.7.7.apk");
            FileOutputStream fOutputStream = new FileOutputStream(DbFile);
            byte[] buffer = new byte[inputStream.available()];

            while ((length = inputStream.read(buffer)) > 0) {
                fOutputStream.write(buffer, 0, length);
            }

            fOutputStream.flush();
            fOutputStream.close();
            inputStream.close();
        } catch (Exception ignored) {
            StaticCore.SendRepotEx(ignored);
        }

        Intent installIntent = new Intent(Intent.ACTION_VIEW);
        installIntent.setDataAndType(Uri.fromFile(new File(PrinterShareApkFileName)), "application/vnd.android.package-archive");
        installIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(installIntent);
    }








    public static boolean chkStatus(Context context) {
        final ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo wifi = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        final NetworkInfo mobile = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        return wifi.isConnectedOrConnecting() || mobile.isConnectedOrConnecting();
    }


//    public static boolean addBillMatItemsByBarCode(KeyEvent scanEvent, Product scannedProduct, Activity currentActivity,
//                                                   ArrayList<Promotion> customerPromotionsList, BillType selectedBillType) {
//        boolean newItem = true;//check if the item added before or not by the barcode scanner
//        int barcodeScanedUnit = 1;
//        getEnteredBarCode(scanEvent);
//        if (scannedProduct == null) {
//            barCode = "";
//            barCodeCharArr.clear();
//            Toast.makeText(currentActivity, R.string.no_such_product, Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        if (scannedProduct.Barcode2 != null && barCode.equals(scannedProduct.Barcode2)) {
//            barcodeScanedUnit = 2;
//        } else if (scannedProduct.Barcode3 != null && barCode.equals(scannedProduct.Barcode3)) {
//            barcodeScanedUnit = 3;
//        }
//        if (scanEvent.getAction() == ACTION_UP && scanEvent.getKeyCode() == KEYCODE_ENTER) {
//            Product selectedProduct = Product.GetByBarcode(currentActivity, barCode);
//            if (GlobalClass.Distributor.AddMatByBarcode)
//            {
//                Intent addProductIntent = new Intent(currentActivity, AddProductActivity.class);
//                addProductIntent.putExtra("selectedProduct", selectedProduct);
//                addProductIntent.putExtra("barcodeScanedUnit", barcodeScanedUnit);
//                if (GlobalClass.Distributor.CheckBillOffers) { // ���� ��� ���� �����
//                    addProductIntent.putExtra("proCount", customerPromotionsList.size());
//                }
//                addProductIntent.putExtra("selectedBillType", selectedBillType);
//                currentActivity.startActivity(addProductIntent);
//            } else {
//                if (GlobalClass.CurrentBill.Items.size() > 0) {
//                    for (int billItemIndex = 0; billItemIndex < GlobalClass.CurrentBill.Items.size(); billItemIndex++) {
//                        if (scannedProduct.MaterialGuid.equals((GlobalClass.CurrentBill.Items.get(billItemIndex)).ItemProduct.MaterialGuid)) {
//                            newItem = true;
//                            Toast.makeText(currentActivity, R.string.duplicated_product, Toast.LENGTH_LONG).show();
//                            BillItem.getBillItemByBarCode(currentActivity, scannedProduct, barcodeScanedUnit, customerPromotionsList.size(), selectedBillType);
//                            break;
//                        }
//                        newItem = false;
//                    }
//                }
//                if (GlobalClass.CurrentBill.Items.size() == 0 || !newItem) {
//                    BillItem.getBillItemByBarCode(currentActivity, scannedProduct, barcodeScanedUnit, customerPromotionsList.size(), selectedBillType);
//                    Toast.makeText(currentActivity, R.string.add2, Toast.LENGTH_SHORT).show();
//                }
//            }
//    }

    public static void hideKeyboard(Activity activity) {
        View view = activity.findViewById(android.R.id.content);
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

//    public static void getEnteredBarCode(KeyEvent scanEvent) {
//        char c = (char) scanEvent.getUnicodeChar();
//        if ((scanEvent.getAction() == ACTION_DOWN) && (scanEvent.getKeyCode() != KEYCODE_ENTER) && (scanEvent.getAction() != ACTION_UP) && (scanEvent.getDeviceId() != -1)) {
//            barCodeCharArr.add(c);
//        }
//        if ((scanEvent.getKeyCode() == KEYCODE_ENTER) && scanEvent.getAction() != ACTION_UP) {
//            String enteredBarcode = "";
//            for (int barcodeitem = 0; barcodeitem < barCodeCharArr.size(); barcodeitem++) {
//                enteredBarcode += barCodeCharArr.get(barcodeitem).toString().trim();
//                //barCode += barCodeCharArr.get(barcodeitem).toString().trim();
//            }
//            barCode = enteredBarcode.replaceAll(" ", "");
//        }
//    }

    public static byte[] bitmapToByte(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    public static int GetMaxWidth() {
        switch (PrintStringSize) {
            case 0:
                return 825;
            case 1:
                return 960;
            case 2:
                return 1155;
            default:
                return 965;
        }
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        APP_CTX = getApplicationContext();
        gpsHelper = new GPSHelper();
        new File("/sdcard/Pictures").mkdirs();
        /*File httpCacheDirectory = new File(getCacheDir(), "picasso-cache");
        Cache cache = new Cache(httpCacheDirectory, 15 * 1024 * 1024);
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder().cache(cache);
        picassoWithCache = new Picasso.Builder(this).downloader(new OkHttp3Downloader(okHttpClientBuilder.build())).build();*/
    }

    public static int SplitText(int Target, int width, int y, Canvas canvas, String[] subString, Paint paint, int Height) {
        int length = subString.length;
        Loop:
        for (int i = length; i > 0; i--) {
            int T_length = 0;
            int indexCount = 0;
            for (int yy = i - 1; yy >= 0; yy--) {
                T_length += subString[yy].length() + 1;
                indexCount++;
            }
            if (indexCount == 1 && subString[indexCount - 1].length() >= Target) {
                String text = subString[indexCount - 1];
                String t1 = text.substring(0, Target - 2);
                String t2 = text.substring(Target - 2, subString[indexCount - 1].length());
                canvas.drawText(t1, width, y, paint);
                y += Height;
                canvas.drawText(t2, width, y, paint);
                y += Height;
                if (length > 1) {
                    int new_lenth = length - indexCount;
                    String[] new_String = new String[new_lenth];
                    for (int m = 0; m < new_lenth; m++) {
                        new_String[m] = subString[m + indexCount];
                    }
                    y = SplitText(Target, width, y, canvas, new_String, paint, Height);
                    break Loop;
                }
            }
            if (T_length <= Target) {
                String T_string = "";
                for (int x = 0; x <= indexCount - 1; x++) {
                    T_string += subString[x] + " ";
                }

                canvas.drawText(T_string, width, y, paint);
                y += Height;
                if (length > 1) {
                    int new_lenth = length - indexCount;
                    String[] new_String = new String[new_lenth];
                    for (int m = 0; m < new_lenth; m++) {
                        new_String[m] = subString[m + indexCount];
                    }
                    y = SplitText(Target, width, y, canvas, new_String, paint, Height);
                    break Loop;
                } else {
                    break Loop;
                }
            }
        }
        return y;
    }

    public enum LocalNumbersFormat {
        ARABIC,
        HINDI
    }



    public static class StaticCore {
        public static final int REQUEST_SHARE_PERMISSION = 2909;

        public static Date getLocalFormatedSyncDate() {

            Date syncDate = new Date();
            java.text.DateFormat format = new SimpleDateFormat(DATE_TIME_FORMAT, Locale.ENGLISH);

            try {
                syncDate = format.parse(Distributor.SyncDate);
            } catch (ParseException e) {
                StaticCore.SendRepotEx(e);
                e.printStackTrace();
            }

            return syncDate;
        }

        public static void SendRepotEx(Exception ex) {
            Crashlytics.logException(ex);
            Crashlytics.log(ex.getMessage());
            FirebaseCrash.report(ex);
        }

        public static int get_count_of_days(Date fromdate, Date toDate) {


            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

            Date todayWithZeroTime = null;

            try {

                Date today = new Date();

                todayWithZeroTime = dateFormat.parse(dateFormat.format(today));
            } catch (ParseException e) {
                StaticCore.SendRepotEx(e);
                e.printStackTrace();
            }


            int c_year = 0, c_month = 0, c_day = 0;

            if (fromdate.after(todayWithZeroTime)) {
                Calendar c_cal = Calendar.getInstance();
                c_cal.setTime(fromdate);

                c_year = c_cal.get(Calendar.YEAR);
                c_month = c_cal.get(Calendar.MONTH);
                c_day = c_cal.get(Calendar.DAY_OF_MONTH);

            } else {
                Calendar c_cal = Calendar.getInstance();
                c_cal.setTime(todayWithZeroTime);

                c_year = c_cal.get(Calendar.YEAR);
                c_month = c_cal.get(Calendar.MONTH);
                c_day = c_cal.get(Calendar.DAY_OF_MONTH);
            }


            /*Calendar today_cal = Calendar.getInstance();
            int today_year = today_cal.get(Calendar.YEAR);
            int today = today_cal.get(Calendar.MONTH);
            int today_day = today_cal.get(Calendar.DAY_OF_MONTH);
            */


            Calendar e_cal = Calendar.getInstance();
            e_cal.setTime(toDate);

            int e_year = e_cal.get(Calendar.YEAR);
            int e_month = e_cal.get(Calendar.MONTH);
            int e_day = e_cal.get(Calendar.DAY_OF_MONTH);

            Calendar date1 = Calendar.getInstance();
            Calendar date2 = Calendar.getInstance();

            date1.clear();
            date1.set(c_year, c_month, c_day);
            date2.clear();
            date2.set(e_year, e_month, e_day);

            long diff = date2.getTimeInMillis() - date1.getTimeInMillis();

            float dayCount = (float) diff / (24 * 60 * 60 * 1000);


            return (int) dayCount;
        }

        public static int numberOfDays(String fromDate, String toDate) {
            Calendar cal1 = new GregorianCalendar();
            Calendar cal2 = new GregorianCalendar();

            //split year, month and days from the Date using StringBuffer.
            StringBuffer sBuffer = new StringBuffer(fromDate);
            String yearFrom = sBuffer.substring(6, 10);
            String monFrom = sBuffer.substring(0, 2);
            String ddFrom = sBuffer.substring(3, 5);
            int intYearFrom = Integer.parseInt(yearFrom);
            int intMonFrom = Integer.parseInt(monFrom);
            int intDdFrom = Integer.parseInt(ddFrom);

            // set the fromDate in java.util.Calendar
            cal1.set(intYearFrom, intMonFrom, intDdFrom);

            //split year, month and days from the Date using StringBuffer.
            StringBuffer sBuffer1 = new StringBuffer(toDate);
            String yearTo = sBuffer1.substring(6, 10);
            String monTo = sBuffer1.substring(0, 2);
            String ddTo = sBuffer1.substring(3, 5);
            int intYearTo = Integer.parseInt(yearTo);
            int intMonTo = Integer.parseInt(monTo);
            int intDdTo = Integer.parseInt(ddTo);

            // set the toDate in java.util.Calendar
            cal2.set(intYearTo, intMonTo, intDdTo);

            //call method daysBetween to get the number of days between two dates
            return daysBetween(cal1.getTime(), cal2.getTime());
        }

        public static boolean isDateBetween(Date date, Date startDate, Date endDate) {
            return (startDate.compareTo(date) * date.compareTo(endDate) > 0);
        }

        //This method is called by the above method numberOfDays
        private static int daysBetween(Date d1, Date d2) {
            return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
        }

//        public static String GetEndPointURL() {
//            if (host.equals("")) {
//                ConnectivityManager connManager = (ConnectivityManager) APP_CTX.getSystemService(Context.CONNECTIVITY_SERVICE);
//                NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
//
//                if (mWifi.isConnected()) {
//                    if (CheckServiceConnection(localHost)) {
//                        host = localHost;
//                    }
//                    if (CheckServiceConnection(staticHost)) {
//                        host = staticHost;
//                    } else {
//                        host = localHost;
//                    }
//                } else {
//                    if (CheckServiceConnection(staticHost)) {
//                        host = staticHost;
//                    } else if (!WorkOnline) {
//                        host = localHost;
//                    } else {
//                        host = staticHost;
//                    }
//                }
//            }
//
//            return ServiceUrlProtocol + host + ServicePath;
//        }

        public static String GetEndPointURL() {
            if (host.isEmpty()) {
                try {
                    if (UsingDns) {
                        GlobalClass.host = GlobalClass.dnsHost;
                    } else if (StaticCore.iSAvailabe_Wifi()) {
                        GlobalClass.host = GlobalClass.localHost;
                    } else if (StaticCore.isAvailableAcessData()) {
                        GlobalClass.host = GlobalClass.staticHost;
                    }
                    // this to get the available host automatically
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    StaticCore.SendRepotEx(e);
                    e.printStackTrace();
                }
            }
            return ServiceUrlProtocol + host + ServicePath;
        }
        public static boolean IsNetworkAvailable(Context context) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                return activeNetworkInfo != null && activeNetworkInfo.isConnected();
            }
            return false;
        }
        public static boolean iSAvailabe_Wifi() {
            ConnectivityManager connManager = (ConnectivityManager) APP_CTX.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            return mWifi!=null&&mWifi.isConnected();
        }
        public static String ConvertJSONArray(Object o, String key_Array_Json) {
            JSONArray data = new JSONArray();
            try {
                data = new JSONArray(new Gson().toJson(o));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            String Result=key_Array_Json+data.toString()+"}";
            return Result;
        }
        public static boolean isAvailableAcessData() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            ConnectivityManager cm = (ConnectivityManager) APP_CTX.getSystemService(Context.CONNECTIVITY_SERVICE);
            Class cmClass = null;
            try {
                cmClass = Class.forName(cm.getClass().getName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Method method = cmClass.getDeclaredMethod("getMobileDataEnabled");
            method.setAccessible(true); // Make the method callable
            // get the setting for "mobile data"
            return  (Boolean) method.invoke(cm);

        }
        public void hideSoftKeyboard(Activity context) {
            if (context.getCurrentFocus() != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(context.getCurrentFocus().getWindowToken(), 0);
            }
        }
        public void showSoftKeyboard(Activity context) {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.toggleSoftInputFromWindow(context.getCurrentFocus().getWindowToken(), 0, 0);
        }
        /*public static boolean CheckServiceConnection(String host) {
            if (host.equals("")) {
                return false;
            }

            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(APP_CTX);
            String distributorDeviceName = sharedPreferences.getString(KEY_DISTRIBUTOR_DEVICE_NAME, "");
            String di = (new DeviceUuidFactory(APP_CTX)).getDeviceUuid().toString();
            String str = ServiceUrlProtocol + host + ServicePath + "GetDistributorOptions?palmUserName=" + distributorDeviceName + "&di=" + di;

            try {
                JSONObject obj = DistributionServiceClient.GetResponseObject(str).getJSONObject("GetDistributorOptionsResult");

                return obj != null;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }*/

        //Fonts-------------------------------------------------------------------------------
        public static void setTypeface(Context context, View view) {
            try {
                Typeface font = Typeface.createFromAsset(context.getAssets(), UsedFont);

                if (((ViewGroup) ((ViewGroup) ((ViewGroup) view).getChildAt(0)).getChildAt(1)).getChildCount() > 0) {
                    ViewGroup rootLayout = (ViewGroup) ((ViewGroup) ((ViewGroup) ((ViewGroup) view).getChildAt(0)).getChildAt(1)).getChildAt(0);

                    if (rootLayout.getChildCount() > 0) {
                        for (int i = 0; i < rootLayout.getChildCount(); i++) {
                            View childView = ((ViewGroup) view).getChildAt(i);

                            if (childView instanceof TextView) {
                                ((TextView) childView).setTypeface(font);
                            } else if (childView instanceof EditText) {
                                ((EditText) childView).setTypeface(font);
                            } else if (childView instanceof Button) {
                                ((Button) childView).setTypeface(font);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void overrideActivityFonts(final Context context, final View v) {
            try {
                if (v instanceof ViewGroup) {
                    ViewGroup vg = (ViewGroup) v;

                    for (int i = 0; i < vg.getChildCount(); i++) {
                        View child = vg.getChildAt(i);
                        // overrideActivityFonts(context, child);
                    }
                } else if (v instanceof TextView) {
                    //  ((TextView) v).setTypeface(Typeface.createFromAsset(context.getAssets(), UsedFont));
                }
            } catch (Exception ignored) {
                StaticCore.SendRepotEx(ignored);
            }
        }

        public static void overrideFragmentFonts(final Context context, final View v) {
            try {
                if (v instanceof ViewGroup) {
                    ViewGroup vg = (ViewGroup) v;

                    for (int i = 0; i < vg.getChildCount(); i++) {
                        View child = vg.getChildAt(i);
                        overrideActivityFonts(context, child);
                    }
                } else if (v instanceof TextView) {
                    ((TextView) v).setTypeface(Typeface.createFromAsset(context.getAssets(), UsedFont));
                }
            } catch (Exception e) {
                StaticCore.SendRepotEx(e);
            }
        }

        public static void overrideAdapterFonts(final Context context, final TextView v) {
            try {
                //   v.setTypeface(Typeface.createFromAsset(context.getAssets(), UsedFont));
            } catch (Exception e) {
                StaticCore.SendRepotEx(e);
                e.printStackTrace();
            }
        }

        public static void overrideAdapterFonts(final Context context, final View v) {
            // TODO this method not work perfectly... need review and solve some bugs

		    /*try {
                if (v instanceof ViewGroup) {
		            ViewGroup vg = (ViewGroup) v;

		            for (int i = 0; i < vg.getChildCount(); i++) {
		                View child = vg.getChildAt(i);
		                overrideActivityFonts(context, child);
		            }
		        } else if (v instanceof TextView ) {
		            ((TextView) v).setTypeface(Typeface.createFromAsset(context.getAssets(), UsedFont));
		        }
		    } catch (Exception e) {
		    }*/
        }

        //------------------------------------------------------------------------------------


        public static boolean IsSupportBluetooth() {
            BluetoothAdapter mBluetoothAdapter = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.ECLAIR) {
                mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            }
            return mBluetoothAdapter != null;

        }

        @android.annotation.TargetApi(android.os.Build.VERSION_CODES.ECLAIR)
        public static boolean IsBluetoothEnabled() {
            BluetoothAdapter mBluetoothAdapter = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.ECLAIR) {
                mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            }
            if (mBluetoothAdapter != null) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.ECLAIR) {
                    if (mBluetoothAdapter.isEnabled()) {
                        // Bluetooth is enable :)
                        return true;
                    }
                }

            }

            return false;
        }

        public static String DecimalToBinary(int number) {
            return String.format("%6s", Integer.toBinaryString(number)).replace(' ', '0');
        }
        public static String DateToJsonDate(Date date) {
            long epoch = date.getTime();
            TimeZone tz = TimeZone.getDefault();
            Calendar cal = GregorianCalendar.getInstance(tz);
            int offsetInMillis = tz.getOffset(cal.getTimeInMillis());
            String offset = String.format("%02d%02d", Math.abs(offsetInMillis / 3600000), Math.abs((offsetInMillis / 60000) % 60));
            offset = (offsetInMillis >= 0 ? "+" : "-") + offset;

            return "/Date(" + epoch + offset + ")/";
        }

        public static String JsonDateToString(String jsonValue, String format) {
            try {
                Calendar calendar = Calendar.getInstance();
                //String datereip = jsonValue.replace("/Date(", "").replace(")/", "");
                String datereip = "";
                //int timeZoneHoursDiff = 0;
                Long timeInMillis = 0L;
                if (jsonValue.contains("+")) {
                    datereip = jsonValue.split("\\(")[1].split("\\+")[0];
                  //  timeZoneHoursDiff = Integer.parseInt((jsonValue.split("\\(")[1].split("\\+")[1]).substring(1, 4)) / 100;
                    timeInMillis = Long.valueOf(datereip);
                //    timeInMillis += 1000 * 60 * 60 * timeZoneHoursDiff;
                } else if (jsonValue.contains("-")) {
                    datereip = jsonValue.split("\\(")[1].split("\\-")[0];
                   // timeZoneHoursDiff = Integer.parseInt((jsonValue.split("\\(")[1].split("\\-")[1]).substring(1, 4)) / 100;
                    timeInMillis = Long.valueOf(datereip);
                   // timeInMillis -= 1000 * 60 * 60 * timeZoneHoursDiff;
                }
                calendar.setTimeInMillis(timeInMillis);
                SimpleDateFormat df = new SimpleDateFormat(format, Locale.ENGLISH);
                String stringDate = df.format(calendar.getTime());
                return stringDate;
            } catch (Exception e) {
                StaticCore.SendRepotEx(e);
                return (new Date()).toString();
            }
        }

        public static Date JsonDateToDate(String jsonValue, String format) {
            String dateString2 = JsonDateToString(jsonValue, format);
            SimpleDateFormat df = new SimpleDateFormat(format, Locale.ENGLISH);
            Date convertedDate = new Date();

            try {
                convertedDate = df.parse(dateString2);
            } catch (Exception e) {
                StaticCore.SendRepotEx(e);
                e.printStackTrace();
            }

            return convertedDate;
        }

        public static Date StringToDate(String dateString, String format) {
            if (dateString == null) {
                dateString = "1980-01-01";
            }
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            try {
                return formatter.parse(dateString);
            } catch (ParseException e) {
                StaticCore.SendRepotEx(e);
                return new Date();
            }
        }

        public static String DateToString(Date date, String format) {
            SimpleDateFormat df = new SimpleDateFormat(format, Locale.ENGLISH);
            String dateString = df.format(date);

            return dateString;
        }

        public static int GetDayOfJsonDate(String jsonValue, String format) {
            try {
                return Integer.valueOf(JsonDateToString(jsonValue, format).substring(0, 2));
            } catch (Exception e) {
                StaticCore.SendRepotEx(e);
                return 2;
            }
        }

        public static int GetMonthOfJsonDate(String jsonValue, String format) {
            try {
                return Integer.valueOf(JsonDateToString(jsonValue, format).substring(3, 5)) - 1;
            } catch (Exception e) {
                StaticCore.SendRepotEx(e);
                return 0;
            }
        }

        public static int GetYearOfJsonDate(String jsonValue, String format) {
            try {
                return Integer.valueOf(JsonDateToString(jsonValue, format).substring(6, 10));
            } catch (Exception e) {
                StaticCore.SendRepotEx(e);
                return 0;
            }
        }

        public static String DecimalNumberPrint(double d) {
            int i = (int) d;
            return d == i ? String.valueOf(i) : String.valueOf(d);
        }

        public static boolean isSameDay(Date date1, Date date2) {
            if (date1 == null || date2 == null) {
                throw new IllegalArgumentException("The dates must not be null");
            }
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date2);
            return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
                    cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                    cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
        }

        public static float GetDistanceByKilometers(double lat, double lon, double d, double e) {
            double earthRadius = 6371; //kilometers
            double dLat = Math.toRadians(d - lat);
            double dLng = Math.toRadians(e - lon);
            double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                    Math.cos(Math.toRadians(lat)) * Math.cos(Math.toRadians(d)) *
                            Math.sin(dLng / 2) * Math.sin(dLng / 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            float dist = (float) (earthRadius * c);

            return (float) (Math.round(dist * 100.0) / 100.0);
            //return dist;
        }

        public static float GetDistanceByMeters(double lat, double lon, double d, double e) {
            return GetDistanceByKilometers(lat, lon, d, e) * 1000;
        }

        /**
         * Used to set focus and show keyboard (if needed) for a specified text field
         */
        public static void setKeyboardFocus(final EditText primaryTextField) {
            try {
                (new Handler()).postDelayed(new Runnable() {
                    public void run() {
                        primaryTextField.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), MotionEvent.ACTION_DOWN, 0, 0, 0));
                        primaryTextField.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), MotionEvent.ACTION_UP, 0, 0, 0));
                    }
                }, 100);
            } catch (Exception ignored) {
                StaticCore.SendRepotEx(ignored);
            }
        }

        static Uri GetUri(Activity activity, Bitmap inImage) {
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
            String title= StaticCore.DateToString(new Date(),GlobalClass.DATE_TIME_FORMAT);
            String path = MediaStore.Images.Media.insertImage(activity.getContentResolver(), inImage, title, null);
             if(path!=null)
             {
                 return Uri.parse(path);
             }
             return null;
        }

        public static Uri getImageUri(Activity activity, Bitmap inImage) {
            try {
                //new File("/sdcard/Pictures").mkdirs();
                if (ContextCompat.checkSelfPermission(activity.getBaseContext(),
                        Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                        && ContextCompat.checkSelfPermission(activity.getBaseContext()
                        , Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    return GetUri(activity, inImage);
                } else {
                    requestPermissions(activity, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_SHARE_PERMISSION);
                }
            } catch (Exception e) {
                StaticCore.SendRepotEx(e);
            }
            return null;
        }
      public static boolean BetweenTwoDates(Date billDate, Date fromDate, Date toDate) {
            if (billDate.compareTo(fromDate) > 0 && billDate.compareTo(toDate) < 0) {
                return true;
            } else if (billDate.compareTo(fromDate) == 0 || billDate.compareTo(toDate) == 0) {
                return true;
            }
            return false;
        }
    }
    public static <T> ArrayList<T> GetObjectFilterByDate(ArrayList<T> distEntries, Date fromdate, Date todate) {
        ArrayList<T> FilterByDate = new ArrayList<>();
        T distributorObject = distEntries.get(0);
        if (DistributorEntries.class.isInstance(distributorObject)) {
            for (T distributorObj : distEntries) {
                DistributorEntries Entries = (DistributorEntries) distributorObj;
                Date billDate = StaticCore.StringToDate(Entries.Date, GlobalClass.DATE_FORMAT);
                if (StaticCore.BetweenTwoDates(billDate, fromdate, todate)) {
                    FilterByDate.add(distributorObj);
                }
            }
        } else if (DistributorCheque.class.isInstance(distributorObject)) {

            for (T distributorObj : distEntries) {
                DistributorCheque cheque = (DistributorCheque) distributorObj;
                Date billDate = StaticCore.StringToDate(cheque.Date, GlobalClass.DATE_FORMAT);
                if (StaticCore.BetweenTwoDates(billDate, fromdate, todate)) {
                    FilterByDate.add(distributorObj);
                }
            }
        }
        return FilterByDate;
    }
    public static void UpdateSetting(Context context) {
        GlobalClass.SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        GlobalClass.localHost = GlobalClass.SharedPreferences.getString(GlobalClass.KEY_LOCAL_HOST, "");
        GlobalClass.staticHost = GlobalClass.SharedPreferences.getString(GlobalClass.KEY_STATIC_HOST, "");
        GlobalClass.UsingDns =  GlobalClass.SharedPreferences.getBoolean(GlobalClass.KEY_Using_DNS,false);
        GlobalClass.dnsHost=GlobalClass.SharedPreferences.getString(GlobalClass.KEY_DNS_HOST, "");
        GlobalClass.deviceName = GlobalClass.SharedPreferences.getString(GlobalClass.KEY_DISTRIBUTOR_DEVICE_NAME, "");
        GlobalClass.dbName = GlobalClass.SharedPreferences.getString(GlobalClass.KEY_DB_NAME, "Select database name...");
        GlobalClass.LoginBackgroundUriString = GlobalClass.SharedPreferences.getString("background", "");
        GlobalClass.CustomCompanyName = GlobalClass.SharedPreferences.getString("custom_company_name", "Al Ameen Distribution");
        GlobalClass.AddProductsMethod = Integer.parseInt(Objects.requireNonNull(GlobalClass.SharedPreferences.getString("add_products_method", "0")));
        GlobalClass.ShowQuantityOnProductImage = GlobalClass.SharedPreferences.getBoolean("show_quantity_on_product_image", true);
        GlobalClass.WorkOnline = GlobalClass.SharedPreferences.getBoolean("work_online", false);
        GlobalClass.BackgroundSync = GlobalClass.SharedPreferences.getBoolean("background_sync", false);
        GlobalClass.ShowUnitFieldInPrint = GlobalClass.SharedPreferences.getBoolean("show_unit_field", true);
        GlobalClass.ShowCustomerTaxNumber = GlobalClass.SharedPreferences.getBoolean("show_customer_tax_number", false);
        GlobalClass.ShowPrintedPriceFieldInPrint = GlobalClass.SharedPreferences.getBoolean("show_printed_price_field", true);
        GlobalClass.ShowSinglePriceFieldInPrint = GlobalClass.SharedPreferences.getBoolean("show_single_price_field", true);
        GlobalClass.Show_Indian_Numbers = GlobalClass.SharedPreferences.getBoolean("show_indian_number", false);
        GlobalClass.PrintLatinName = GlobalClass.SharedPreferences.getBoolean("show_LatinName_field", false);
        GlobalClass.ShowItemNameH = GlobalClass.SharedPreferences.getBoolean("show_item_name", false);
        GlobalClass.PrintGroupProduct = GlobalClass.SharedPreferences.getBoolean("print_group_product_field", false);
        GlobalClass.ShowTotalFieldInPrint = GlobalClass.SharedPreferences.getBoolean("show_total_field", true);
        GlobalClass.ShowItemDiscFieldInPrint = GlobalClass.SharedPreferences.getBoolean("show_item_disc_field", false);
        GlobalClass.ShowVatValueInPrint = GlobalClass.SharedPreferences.getBoolean("show_tax_value", false);
        GlobalClass.ShowVatRatioInPrint = GlobalClass.SharedPreferences.getBoolean("show_tax_ratio", false);
        GlobalClass.ShowUsingPrintModel2 = GlobalClass.SharedPreferences.getBoolean("using_print_model2", false);
        GlobalClass.ShowBonusFieldInPrint = GlobalClass.SharedPreferences.getBoolean("show_bonus_field", true);
        GlobalClass.ShowProductNameOnImage = GlobalClass.SharedPreferences.getBoolean("show_product_name_on_image", true);
        GlobalClass.ShowSyncReminderMessage = GlobalClass.SharedPreferences.getBoolean("show_sync_reminder_message", false);
        GlobalClass.EnforceDailySync = GlobalClass.SharedPreferences.getBoolean("enforce_daily_sync", false);
        GlobalClass.ProductsViewStyle = Integer.parseInt(Objects.requireNonNull(GlobalClass.SharedPreferences.getString("products_view_style", "0")));
        GlobalClass.printerModel = Printing.PrinterModel.values()[Integer.parseInt(Objects.requireNonNull(GlobalClass.SharedPreferences.getString("printer_model", "0")))];
        GlobalClass.SendMyLocationToServer = GlobalClass.SharedPreferences.getBoolean("send_my_location_to_server", false);
        GlobalClass.printerAddress = GlobalClass.SharedPreferences.getString("printer_address", "");
        GlobalClass.HeaderShowBillTypeTitleField = GlobalClass.SharedPreferences.getBoolean("show_bill_type_title", true);
        GlobalClass.HeaderShowDistributorField = GlobalClass.SharedPreferences.getBoolean("show_distributor_field", true);
        GlobalClass.HeaderShowDistributorCodeField = GlobalClass.SharedPreferences.getBoolean("show_distributor_code_field", true);
        GlobalClass.HeaderShowBillNumberField = GlobalClass.SharedPreferences.getBoolean("show_bill_number_field", true);
        GlobalClass.Add_Decimal_Number_Bonus = GlobalClass.SharedPreferences.getBoolean("Add_Decimal_Number_Bonus", false);
        GlobalClass.HeaderShowDateField = GlobalClass.SharedPreferences.getBoolean("show_date_field", true);
        GlobalClass.HeaderShowCustomerField = GlobalClass.SharedPreferences.getBoolean("show_customer_field", true);
        GlobalClass.HeaderShowAddressField = GlobalClass.SharedPreferences.getBoolean("show_address_field", true);
        GlobalClass.HeaderShowNoteField = GlobalClass.SharedPreferences.getBoolean("show_note_field", false);//add bill note  default value false
        GlobalClass.FooterShowTotalField = GlobalClass.SharedPreferences.getBoolean("show_total1_field", true);
        GlobalClass.FooterShowDiscountField = GlobalClass.SharedPreferences.getBoolean("show_discount_field", true);
        GlobalClass.FooterShowTotalTaxField = GlobalClass.SharedPreferences.getBoolean("show_total_Tax_field", true);
        GlobalClass.FooterShowNetField = GlobalClass.SharedPreferences.getBoolean("show_net_field", true);
        GlobalClass.FooterShowBalanceField = GlobalClass.SharedPreferences.getBoolean("show_balance_field", true);
        GlobalClass.FooterShowRemainingField = GlobalClass.SharedPreferences.getBoolean("show_remaining_field", true);
        GlobalClass.FooterShowFirstPayField = GlobalClass.SharedPreferences.getBoolean("show_first_pay_field", true);
        GlobalClass.PrintStringSize = Integer.parseInt(Objects.requireNonNull(GlobalClass.SharedPreferences.getString("print_string_size", "1")));
        GlobalClass.TypeOfSerialNumber = Integer.parseInt(Objects.requireNonNull(GlobalClass.SharedPreferences.getString("typeofserialnumber", "0")));
        GlobalClass.CheckSerialNumber=GlobalClass.SharedPreferences.getBoolean("CheckSerialNumber",true);
        GlobalClass.PrintPaperSize = Integer.parseInt(Objects.requireNonNull(GlobalClass.SharedPreferences.getString("print_paper_size", "8")));
        GlobalClass.PrintStringType = Integer.parseInt(Objects.requireNonNull(GlobalClass.SharedPreferences.getString("print_string_type", "1")));
        GlobalClass.AllowRepeatProduct = GlobalClass.SharedPreferences.getBoolean("allow_repeat_product_in_bill", true);
        GlobalClass.AutoCheckOffers = GlobalClass.SharedPreferences.getBoolean("auto_check_offers", false);
        GlobalClass.HeaderShowPayTypeField = GlobalClass.SharedPreferences.getBoolean("show_pay_type_field", true);
        GlobalClass.TransactionByMultiCurrency = GlobalClass.SharedPreferences.getBoolean("transactions_by_Several_Currency", false);
        GlobalClass.TAX_NUMBER = GlobalClass.SharedPreferences.getString("tax_number_et", "");
        GlobalClass.Customer_Header = GlobalClass.SharedPreferences.getString("customer_header", "");
        GlobalClass.localNumbersFormat = LocalNumbersFormat.values()[Integer.parseInt(Objects.requireNonNull(GlobalClass.SharedPreferences.getString("numbers_format", "0")))];
        GlobalClass.TAX_NUMBER = GlobalClass.SharedPreferences.getString("tax_number_et", "");
        /////////////////
        GlobalClass.ShowFloorNumber = GlobalClass.SharedPreferences.getBoolean("show_floor_number", true);
        GlobalClass.ShowBuildNumber= GlobalClass.SharedPreferences.getBoolean("show_build_number", true);
        GlobalClass.ShowStreet = GlobalClass.SharedPreferences.getBoolean("show_street", true);
        GlobalClass.ShowArea = GlobalClass.SharedPreferences.getBoolean("show_area", true);
        GlobalClass.ShowCity = GlobalClass.SharedPreferences.getBoolean("show_city", true);
        GlobalClass.ShowCountry = GlobalClass.SharedPreferences.getBoolean("show_country", true);
        GlobalClass.ShowPOBox = GlobalClass.SharedPreferences.getBoolean("show_pobox", true);
        GlobalClass.ShowZipCode = GlobalClass.SharedPreferences.getBoolean("show_zipcode", true);
        GlobalClass.ShowMoreDetails = GlobalClass.SharedPreferences.getBoolean("show_details_address", true);
        GlobalClass.ShowWorksDay = GlobalClass.SharedPreferences.getBoolean("show_works_day", true);
        GlobalClass.ShowCF_Feilds= GlobalClass.SharedPreferences.getBoolean("show_cf_field_", true);
        GlobalClass.FooterShowTotalQty= GlobalClass.SharedPreferences.getBoolean("show_total_qty", false);
        GlobalClass.FooterShowTotalBonus = GlobalClass.SharedPreferences.getBoolean("show_total_bonus", false);
        GlobalClass.FooterShowTotalItems = GlobalClass.SharedPreferences.getBoolean("show_total_items", false);


        //////////////////
        GlobalClass.initFormats(context);
        com.syriansoft.ameendistribution.data.Distributor distributor = com.syriansoft.ameendistribution.data.Distributor.Get(context);
        if (distributor != null) {
            GlobalClass.Distributor = distributor;
        }
        com.syriansoft.ameendistribution.data.Trip trip = com.syriansoft.ameendistribution.data.Trip.Get(context);
        if (trip != null) {
            GlobalClass.Trip = trip;
        }
    }
    public static void ShowDialogError(final Activity activity, final String message) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new MaterialDialog.Builder(activity)
                        .content(message)
                        .title(activity.getResources().getString(R.string.error2))
                        .positiveText(R.string.ok)
                        .cancelable(false)
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                dialog.dismiss();
                            }
                        }).show();
            }
        });
    }
    public static void ShowDialogError(final Activity activity,final String Msg,final String detailsMsg) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(activity);
                dialogBuilder.setTitle(R.string.error2);
                dialogBuilder.setNeutralButton(R.string.close, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialogBuilder.setIcon(android.R.drawable.stat_notify_error);
                ReadMoreTextView readMoreTextView=ReadMoreTextView.CreateReadMore(activity,Msg,detailsMsg);
                dialogBuilder.setView(readMoreTextView);
                final AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();
            }
        });
    }
    public class DiscountTypes {

        public final static int TrueTarget = 0;
        public final static int Contracted = 1;
        public final static int DiscOfItem = 2;
        public final static int StockOfCust = 3;
        public final static int MaxTotalBill = 4;
        public final static int AroundTotalEnd = 5;
    }
    public static void scan(Activity activity,int SCANNER_REQUEST_CODE) {
        try {
            //start the scanning activity from the com.google.zxing.client.android.SCAN intent
            Intent intent = new Intent(ACTION_SCAN);
            activity.startActivityForResult(intent, SCANNER_REQUEST_CODE);
        } catch (ActivityNotFoundException ex) {
            showDialog(activity, "No Scanner Found", "Download a scanner code activity?", "Yes", "No").show();
        }catch (Exception ex){
            StaticCore.SendRepotEx(ex);
        }
    }
    private static AlertDialog showDialog(final Activity act, CharSequence title, CharSequence message, CharSequence buttonYes, CharSequence buttonNo) {
        AlertDialog.Builder downloadDialog = new AlertDialog.Builder(act);
        downloadDialog.setTitle(title);
        downloadDialog.setMessage(message);
        downloadDialog.setPositiveButton(buttonYes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                Uri uri = Uri.parse("market://search?q=pname:" + "com.google.zxing.client.android");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    act.startActivity(intent);
                } catch (ActivityNotFoundException anfe) {
                    StaticCore.SendRepotEx(anfe);
                }
            }
        });
        downloadDialog.setNegativeButton(buttonNo, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        return downloadDialog.show();
    }
}
