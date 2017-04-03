package com.coursera.agaidaichuk.lab5modernui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MoreInfoAlertDialog extends DialogFragment {
    public static MoreInfoAlertDialog newInstance() {
        return new MoreInfoAlertDialog();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        return new AlertDialog.Builder(getActivity()).setTitle(R.string.alertTitle)
                .setMessage(R.string.alertMessage)
                .setPositiveButton(getString(R.string.alertPositive), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent openLink = new Intent(Intent.ACTION_VIEW);
                        openLink.setData(Uri.parse("http://moma.org"));
                        startActivity(openLink);
                        dialog.dismiss();
                    }
                })
                .setNegativeButton(getString(R.string.alertNegative), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                }).show();
    }
}
