package com.example.franck.fintechhomework.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.franck.fintechhomework.R;

/**
 * Created by Franck on 16.10.2017.
 */

public class ResultFragment extends Fragment {

    public static final String TAG = "ResultFragmentTag";
    private OperationFragment operationFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.result_fragment, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        TextView textView = (TextView) getActivity().findViewById(R.id.result);
 //NULL POINTER EXCEPTION
        Bundle bundle = getArguments();

//        textView.setText(getArguments().getInt("ID"));
        if (bundle != null) {
            textView.setText(bundle.getInt("ID"));
        }
    }
}
