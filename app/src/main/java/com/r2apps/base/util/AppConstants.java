package com.r2apps.base.util;

/**
 * Created by user on 7/12/2016.
 */
public interface AppConstants {
    interface FieldCheck{
        byte EMPTY = 1;
        byte INVALID = 2;
        byte INCORRECT = 3;
    }
    interface Request{
        byte LOGIN = 1;
    }

    interface URL{
        String BASE = "http://demo4849864.mockable.io/";
        String LOGIN = "login";
    }
}
