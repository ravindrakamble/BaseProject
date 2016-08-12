package com.r2apps.base.ui.home;

import com.r2apps.base.ui.core.ResponseHandlerView;

/**
 * Created by user on 7/13/2016.
 */
public interface MainView extends ResponseHandlerView {
    void showProgress();

    void hideProgress();
}
