package com.example.passwordmanager;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class ShowAlertDialog extends AppCompatDialogFragment {

    private String Title;
    private String Message;

    public boolean userInput;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(Title)
                .setMessage(Message)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        userInput = true;

                        getActivity().finish();

                        Toast toast = Toast.makeText(getContext(), "Account Deleted", Toast.LENGTH_LONG);
                        toast.show();
                    }
                })
                .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        userInput = false;
                    }
                });

        return builder.create();
    }

    public ShowAlertDialog(String title, String message) {
        Title = title;
        Message = message;
    }
}
