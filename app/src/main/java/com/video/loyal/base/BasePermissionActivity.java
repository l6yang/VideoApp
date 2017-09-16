package com.video.loyal.base;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Size;

import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RationaleListener;

public abstract class BasePermissionActivity extends BaseActivity implements RationaleListener {

    public final void requestPermissions(@IntRange int reqCode, @Size(min = 1) @NonNull String[] permissions) {
        AndPermission.with(this)
                .requestCode(reqCode)
                .permission(permissions)
                .rationale(this)
                .callback(this)
                .start();
    }

    @Override
    public void showRequestPermissionRationale(int requestCode, Rationale rationale) {
        AndPermission.rationaleDialog(this, rationale).show();
    }
}
