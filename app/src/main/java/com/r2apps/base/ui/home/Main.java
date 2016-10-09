package com.r2apps.base.ui.home;

import com.r2apps.base.ui.core.MVP;
import com.r2apps.base.ui.core.ResponseHandlerView;
import com.r2apps.base.ui.login.Login;

/**
 * Created by user on 8/19/2016.
 */

public interface Main {
    interface View extends MVP.View,ResponseHandlerView {

        void navigateToHome();
    }

    interface Model extends MVP.Model{
        Main.Model prepare();
    }

    interface Presenter extends MVP.Presenter<Main.View>{
    }
}
