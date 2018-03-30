package com.personal.test.formatphone;

import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;


/**
 * Created by Admin on 3/21/2018.
 */

public class DeviceAdmin extends DeviceAdminReceiver {
    @Override
    public void onPasswordChanged(Context ctxt, Intent intent) {
        DevicePolicyManager mgr=
                (DevicePolicyManager)ctxt.getSystemService(Context.DEVICE_POLICY_SERVICE);
        int msgId;

        if (mgr.isActivePasswordSufficient()) {
            msgId= R.string.compliant;
        }
        else msgId = R.string.not_compliant;

        Toast.makeText(ctxt, msgId, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPasswordFailed(Context ctxt, Intent intent) {
        Toast.makeText(ctxt, "u will never break!", Toast.LENGTH_LONG).show();
        String tag="tag";
        Log.v(tag,"this massage from error" );
    }

    @Override
    public void onPasswordSucceeded(Context ctxt, Intent intent) {
        Toast.makeText(ctxt, "good u enterd", Toast.LENGTH_LONG).show();
        String tag="tag";
        Log.v(tag, "this massage from success");
    }
}
