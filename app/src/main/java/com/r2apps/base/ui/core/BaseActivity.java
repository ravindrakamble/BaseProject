package com.r2apps.base.ui.core;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by user on 7/12/2016.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private ProgressDialog progressDialog;
    public void setFocus(View view){
        view.requestFocus();
    }
}
