package com.example.aditi.TimeTableApp;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment {
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar cal= Calendar.getInstance();
        int intHour=cal.get(Calendar.HOUR);
        int intMinute=cal.get(Calendar.MINUTE);
        return new TimePickerDialog( getActivity(), (TimePickerDialog.OnTimeSetListener) getActivity(),intHour,intMinute,true);
    }
}
