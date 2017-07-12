package com.xp.rxjavaretrofit.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xp.rxjavaretrofit.R;


/**
 * 默认loading
 *
 * @author xp Create on 17/1/3
 */
public class LoadingDialog {

    private Dialog dialog;
    private TextView loadingMsg;
    private Context mContext;
    private LinearLayout loadingRoot;

    public LoadingDialog(Context mContext) {
        this.mContext = mContext;
        dialog = new Dialog(mContext, R.style.LoadDialog);
        View view = View.inflate(mContext, R.layout.dialog_loading, null);

        loadingRoot = (LinearLayout) view.findViewById(R.id.loadingRoot);

        loadingMsg = (TextView) view.findViewById(R.id.loadingMsg);
        dialog = new Dialog(mContext, R.style.LoadDialog);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(true);
        dialog.setContentView(view);

        loadingRoot.setLayoutParams(new FrameLayout.LayoutParams(dp2px(100), dp2px(100)));
    }

    public LoadingDialog setCancelable(boolean cancel) {
        dialog.setCancelable(cancel);
        return this;
    }

    public LoadingDialog setCanceledOnTouchOutside(boolean cancel) {
        dialog.setCanceledOnTouchOutside(cancel);
        return this;
    }

    public LoadingDialog setOnCancelListener(DialogInterface.OnCancelListener listener) {
        dialog.setOnCancelListener(listener);
        return this;
    }

    public void show() {
        dialog.show();
    }

    public void dismiss() {
        dialog.dismiss();
    }

    public LoadingDialog setLoadingMassage(String msg) {
        loadingMsg.setText(TextUtils.isEmpty(msg) ? "正在加载" : msg);
        return this;
    }

    public boolean isShowing() {
        return dialog.isShowing();
    }

    public int dp2px(int dip) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f);
    }
}
