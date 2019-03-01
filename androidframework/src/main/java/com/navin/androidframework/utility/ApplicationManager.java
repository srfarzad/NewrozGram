package com.navin.androidframework.utility;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by F.Seyfi on 6/12/2016.
 */
public class ApplicationManager {

    public ApplicationManager() {
    }


    public static int getVersionCode(String packageName, Context context) {
        PackageInfo pInfo = null;
        try {
            pInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        int verCode = pInfo.versionCode;

        return verCode;
    }


    public static String getVersionName(String packageName, Context context)throws Exception  {
        PackageInfo pInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String verCode = pInfo.versionName;
        return verCode;
    }

 /*   public static int getVersionCode(Context context, String packageName) {
        PackageInfo pInfo = null;
        try {
            pInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
//        int verCode = pInfo.versionCode;
//        return verCode;
        return 10;
    }*/


    public static String getVersionName(Context context) {
        PackageInfo pInfo = null;
        try {
            pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String versionName = pInfo.versionName;

        return versionName;
    }


    public static boolean isPackageInstalled(String packagename, Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getPackageInfo(packagename, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }


   /* public static void installApk(Context context, String path) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            Uri uri = Uri.fromFile(new File(path));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setDataAndType(uri, "application/vnd.android.package-archive");
            context.startActivity(intent);
        } catch (Exception e) {

            Toast.makeText(context, "Apps cant launcher in Navin", Toast.LENGTH_SHORT).show();

        }

    }*/

    public static void ApplicationRunning(Activity context, String packagename) {


        if (packagename.startsWith("io.cordova")) {
            PackageManager pm = context.getPackageManager();
            Intent launchIntent = pm.getLaunchIntentForPackage(packagename);

            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            intent.setComponent(new ComponentName(packagename, packagename + ".MainActivity"));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

        } else {

            runApplication(context, packagename);
        }


    }

  /*  public static void installApk(Context context, String path, String packagename) {


        try {


            Intent intent = new Intent(Intent.ACTION_VIEW);
            Uri uri;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                uri = FileProvider.getUriForFile(context, context.getPackageName() + ".provider", new File(path));

                List<ResolveInfo> resInfoList = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                for (ResolveInfo resolveInfo : resInfoList) {
                    String packageName = resolveInfo.activityInfo.packageName;
                    context.grantUriPermission(packageName, uri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);
                }
            } else {
                uri = Uri.fromFile(new File(path));
            }

            *//*intent.setDataAndType(uri, "application/vnd.android.package-archive");

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(intent);*//*
            //intent = new Intent(Intent.ACTION_VIEW);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setDataAndType(Uri.fromFile(new File(path)), "application/vnd.android.package-archive");
            context.startActivity(intent);


        } catch (Exception e) {

            Logger.Log("Error install apk package", e.getMessage().toString());
        }
    }
*/

    public static void runApplication(Context context, String packagename) {
        PackageManager packageManager = context.getPackageManager();
        Intent launchIntent = packageManager.getLaunchIntentForPackage(packagename);
        launchIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(launchIntent);
    }

    public static boolean openApp(Context context, String packageName) {
        PackageManager manager = context.getPackageManager();
        Intent i = manager.getLaunchIntentForPackage(packageName + ".MainActivity");
        if (i == null) {
            return false;
            //throw new PackageManager.NameNotFoundException();
        }
        i.addCategory(Intent.CATEGORY_LAUNCHER);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
        return true;
    }





/*
    public List<Product> AppsInstalled(Context context){

        PackageManager packageManager = context.getPackageManager();
        List<ApplicationInfo> list = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);
        PackageInfo packageInfo;

        for (ApplicationInfo a:list) {


            Product p=new Product();

            p.setPackageName(""+a.packageName);
            p.setVersionCode(a.targetSdkVersion);

        }

    }

*/

/*

    // How to get the system and the user apps.
    public static ArrayList<Product> getAppsToUpdate(Context c) {

        PackageManager pm = c.getPackageManager();
        List<ApplicationInfo> installedApps = pm.getInstalledApplications(0);
        ArrayList<Product> myAppsToUpdate = new ArrayList<Product>();
        for (ApplicationInfo aInfo : installedApps) {

            if ((aInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
                // System apps
            } else {
                // Users apps
                Product pr = null;


                //appInfo.setAppName(aInfo.loadLabel(pm).toString());
                //appInfo.setPackageName(aInfo.packageName);
                //appInfo.setLaunchActivity(pm.getLaunchIntentForPackage(aInfo.packageName).toString());
                try {
                    PackageInfo info = pm.getPackageInfo(aInfo.packageName, 0);

                    pr.setPackageName(aInfo.packageName);
                    pr.setVersionCode(info.versionCode + "");

                    // appInfo.setVersionName(info.versionName.toString());
                    // appInfo.setVersionCode("" + info.versionCode);
                    myAppsToUpdate.add(pr);
                } catch (PackageManager.NameNotFoundException e) {
                    Log.e("ERROR", "we could not get the user's apps");
                }

            }
        }
        return myAppsToUpdate;
    }
*/


    public static String getIMEI(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        //return "TEST_DEVICE_1103";
        return telephonyManager.getDeviceId();
    }


    public static String getDeviceId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);

    }


    public static int getAndroidApi() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        int version = Build.VERSION.SDK_INT;
        String versionRelease = Build.VERSION.RELEASE;

        return version;
    }


    /*    public static String getDeviceName(){

            String deviceName = Build.BRAND;
            return deviceName;
        }*/

    public static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        //String model = Build.BRAND;

        return capitalize(manufacturer) + " ";
    }


    public static String getDeviceModel() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        }
        return capitalize(manufacturer) + " " + model;
    }

    private static String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] arr = str.toCharArray();
        boolean capitalizeNext = true;

//        String phrase = "";
        StringBuilder phrase = new StringBuilder();
        for (char c : arr) {
            if (capitalizeNext && Character.isLetter(c)) {
//                phrase += Character.toUpperCase(c);
                phrase.append(Character.toUpperCase(c));
                capitalizeNext = false;
                continue;
            } else if (Character.isWhitespace(c)) {
                capitalizeNext = true;
            }
//            phrase += c;
            phrase.append(c);
        }

        return phrase.toString();
    }


    public static void createAppShortCut(Context context, String packageName, String imagePath) {
        Intent shortcutIntent = context.getPackageManager().getLaunchIntentForPackage(packageName);

        //  Intent.ShortcutIconResource iconResource = Intent.ShortcutIconResource.fromContext(this, R.drawable.ic_launcher);


        Drawable iconDrawable = Drawable.createFromPath(imagePath);
        BitmapDrawable bd = (BitmapDrawable) iconDrawable;

        Intent intent = new Intent();
        intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "Shortcut Test");
        intent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, bd.getBitmap());
        intent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");

        context.sendBroadcast(intent);
    }


    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }


    public static boolean isMyServiceRunning(Context context, Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }


    public static String convertSecondsToHMmSs(long seconds) {
        long s = seconds % 60;
        long m = (seconds / 60) % 60;
        long h = (seconds / (60 * 60)) % 24;
        return String.format("%d:%02d:%02d", h, m, s);
    }


    public static int compareVersionNames(String oldVersionName, String newVersionName) {
        int res = 0;

        String[] oldNumbers = oldVersionName.split("\\.");
        String[] newNumbers = newVersionName.split("\\.");

        // To avoid IndexOutOfBounds
        int maxIndex = Math.min(oldNumbers.length, newNumbers.length);

        for (int i = 0; i < maxIndex; i++) {
            int oldVersionPart = Integer.valueOf(oldNumbers[i]);
            int newVersionPart = Integer.valueOf(newNumbers[i]);

            if (oldVersionPart < newVersionPart) {
                res = -1;
                break;
            } else if (oldVersionPart > newVersionPart) {
                res = 1;
                break;
            }
        }

        // If versions are the same so far, but they have different length...
        if (res == 0 && oldNumbers.length != newNumbers.length) {
            res = (oldNumbers.length > newNumbers.length) ? 1 : -1;
        }

        return res;
    }


}
