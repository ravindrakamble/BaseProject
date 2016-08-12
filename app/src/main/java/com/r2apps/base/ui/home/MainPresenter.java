package com.r2apps.base.ui.home;

import com.r2apps.base.model.response.LoginResponse;
import com.r2apps.base.model.response.NewsResponse;
import com.r2apps.base.rest.APIManager;
import com.r2apps.base.rest.ApiService;
import com.r2apps.base.util.AppConstants;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by user on 7/13/2016.
 */
public class MainPresenter {
    private MainView mainActivityView;
    private ApiService apiService;

    public MainPresenter(MainView mainView){
        this.mainActivityView = mainView;
        apiService = APIManager.getInstance().getAPIService();
    }

    public void fetchNews(){
        Observable<List<NewsResponse>> login = apiService.fetchNews();
        login.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<NewsResponse>>() {
                    @Override
                    public void onCompleted() {
                        /**
                         * Currently there is nothing to handle on complete.
                         */
                    }

                    @Override
                    public void onError(Throwable e) {
                        mainActivityView.onFailure(AppConstants.Request.FETCH_NEWS, (byte) 0, e.getMessage());
                    }

                    @Override
                    public void onNext(List<NewsResponse> newsResponse) {
                        mainActivityView.onResponse(AppConstants.Request.FETCH_NEWS, newsResponse);
                    }
                });
    }
}
