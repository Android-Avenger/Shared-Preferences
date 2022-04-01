package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.sharedpref.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        SharedPref sharedPref = new SharedPref(this);


        mBinding.save.setOnClickListener(view -> {

                 sharedPref.setSharedPref(

                         mBinding.isChecked.isChecked(),
                         mBinding.userName.getText().toString(),
                         Float.parseFloat(mBinding.wallet.getText().toString()),
                         Integer.parseInt(mBinding.amount.getText().toString())
                 );

                 mBinding.tvAmount.setText(sharedPref.getAmount()+"");
                 mBinding.tvIsWalletVerified.setText(sharedPref.getWalletVerification().toString());
                 mBinding.tvUserName.setText(sharedPref.getUser());
                 mBinding.tvWallet.setText(sharedPref.getWalletValue()+"");
        });

    }
}