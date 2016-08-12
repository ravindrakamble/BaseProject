package com.r2apps.base.util;

/**
 * Created by user on 7/12/2016.
 */
public interface AppConstants {
    interface Request{
        byte LOGIN = 1;
        byte FETCH_NEWS = 2;
    }

    interface URL{
        String BASE = "http://demo4849864.mockable.io/";
        String LOGIN = "login";
        String NEWS_LIST = "news";
    }
}
