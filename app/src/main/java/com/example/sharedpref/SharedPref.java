package com.example.sharedpref;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {

    Activity activity;
    SharedPreferences sharedPref;
    SharedPreferences.Editor mEditor;

    public SharedPref(Activity activity) {
        this.activity = activity;
    }

    public void setSharedPref(Boolean isWalletVerified,String name,Float walletValue,int amount) {

        if (sharedPref==null){
            sharedPref = activity.getSharedPreferences("ShPref",Context.MODE_PRIVATE);
        }

        if(mEditor == null)
            mEditor = sharedPref.edit();
        mEditor.putBoolean("isWalletVerified",isWalletVerified);
        mEditor.putString("User",name);
        mEditor.putFloat("walletValue",walletValue);
        mEditor.putInt("amount",amount);
        mEditor.commit();
        mEditor.apply();

    }

    public String getUser() {
//        if (sharedPref==null)
//            sharedPref = activity.getSharedPreferences("ShPref",Context.MODE_PRIVATE);
         return sharedPref.getString("User", "Name");

    }
    public Boolean getWalletVerification(){
        if (sharedPref==null)
            sharedPref = activity.getSharedPreferences("ShPref",Context.MODE_PRIVATE);

        return sharedPref.getBoolean("isWalletVerified",false);
    }
    public Float getWalletValue(){
        if (sharedPref==null)
            sharedPref = activity.getSharedPreferences("ShPref",Context.MODE_PRIVATE);

        return sharedPref.getFloat("walletValue",0.0F);
    }

    public int getAmount(){
        if (sharedPref==null){
            sharedPref = activity.getSharedPreferences("ShPref",Context.MODE_PRIVATE);
        }
        return sharedPref.getInt("amount",0);
    }


}




