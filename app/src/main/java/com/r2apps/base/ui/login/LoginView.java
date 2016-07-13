package com.r2apps.base.ui.login;

import com.r2apps.base.ui.core.ResponseHandlerView;

/**
 * Created by user on 7/12/2016.
 */
public interface LoginView extends ResponseHandlerView{
    void showProgress();

    void hideProgress();

    void setUsernameError(byte error);

    void setPasswordError(byte error);

    void navigateToHome();
}
