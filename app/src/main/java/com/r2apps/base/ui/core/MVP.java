package com.r2apps.base.ui.core;

import android.support.annotation.StringRes;

/**
 * Created by user on 8/11/2016.
 */

public interface MVP {
    interface View{
        void close();
        void showProgress();
        void hideProgress();
        boolean isInternetAvailable();
        void showNoInternetDialog();
        void hideSoftKeyboard();
    }

    interface Model{

    }

    interface Presenter<V>{
        void takeView(V view);
        boolean hasView();
        V view();
        void onDestroy();
    }
}
