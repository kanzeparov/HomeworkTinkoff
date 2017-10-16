package com.example.franck.fintechhomework.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.franck.fintechhomework.R;

/**
 * Created by Franck on 16.10.2017.
 */

public class VvodTwoFragment extends Fragment {

    public static final String TAG = "VvodTwoFragmentTag";
    private OperationFragment operationFragment;

    public int getNumSecond() {
        return numSecond;
    }

    private int numSecond;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.vvod_two_fragment, container, false);
    }

    public void onStart() {
        super.onStart();
        operationFragment = new OperationFragment();
        Button button = (Button) getActivity().findViewById(R.id.buttonSecNum);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.d(TAG,"HERE)");
                if (getActivity().getSupportFragmentManager().findFragmentByTag(OperationFragment.TAG) == null) {
                    getActivity().getSupportFragmentManager().beginTransaction().add(R.id.container,
                            operationFragment,OperationFragment.TAG).commit();
                }
            }
        });
    }

}
