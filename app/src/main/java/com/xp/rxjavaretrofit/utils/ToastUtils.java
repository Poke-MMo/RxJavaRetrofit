package com.xp.rxjavaretrofit.utils;

import android.app.Application;
import android.widget.Toast;

/**
 * @author: xp
 * @date: 2017/7/12
 */

public class ToastUtils {
    private static Toast toast;

    private static Application sContext;

    public static void init(Application application) {
        sContext = application;
    }

    public static void showShort(CharSequence sequence) {
        if (toast == null) {
            toast = Toast.makeText(sContext, sequence, Toast.LENGTH_SHORT);
        } else {
            toast.setText(sequence);
        }
        toast.show();

    }

}
