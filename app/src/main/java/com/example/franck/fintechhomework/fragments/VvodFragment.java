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

public class VvodFragment extends Fragment {
    private VvodTwoFragment vvodFragment2;

    public int getNumFirst() {
        return numFirst;
    }

    private int numFirst;

    public static final String TAG = "VvodFragmentTag";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.vvod_fragment, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        vvodFragment2 = new VvodTwoFragment();
        Button button = (Button) getActivity().findViewById(R.id.buttonFirstNum);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.d(TAG,"here");
               if (getActivity().getSupportFragmentManager().findFragmentByTag(VvodTwoFragment.TAG) == null) {
                   Log.d(TAG,"here1");
                    getActivity().getSupportFragmentManager().beginTransaction().add(R.id.container,
                            vvodFragment2, VvodTwoFragment.TAG).commit();
               }
            }
        });

    }
}
