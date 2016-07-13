package com.r2apps.base.ui.login;

import android.text.TextUtils;

import com.r2apps.base.model.request.LoginRequest;
import com.r2apps.base.model.response.LoginResponse;
import com.r2apps.base.rest.APIManager;
import com.r2apps.base.rest.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.r2apps.base.util.AppConstants.*;

/**
 * Created by user on 7/12/2016.
 */
public class LoginPresenter {
    private LoginView loginView;
    private ApiService service;

    public LoginPresenter(LoginView loginView){
        this.loginView = loginView;
        service = APIManager.getInstance().getAPIService();
    }

    public void validateCredentials(String username, String password) {
        if (TextUtils.isEmpty(username)) {
            loginView.setUsernameError(FieldCheck.EMPTY);
            return;
        }
        if (TextUtils.isEmpty(password)) {
            loginView.setPasswordError(FieldCheck.EMPTY);
            return;
        }

        loginView.showProgress();
        executeLoginRequest(new LoginRequest(username, password));
    }

    private void executeLoginRequest(LoginRequest request) {
        Observable<LoginResponse> login = service.login(request);
        login.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LoginResponse>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        loginView.onFailure(Request.LOGIN, (byte) 0, e.getMessage());
                    }

                    @Override
                    public void onNext(LoginResponse loginResponse) {
                        loginView.onResponse(Request.LOGIN, loginResponse);
                    }
                });
    }

    public void onDestroy(){
        clear();
    }

    public void clear(){
        loginView = null;
        service = null;
    }
}
