package com.example.franck.fintechhomework.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.franck.fintechhomework.R;

/**
 * Created by Franck on 16.10.2017.
 */

public class OperationFragment extends Fragment {
    private MyFragmentListener listener;

    public final static String TAG = "Oper";

    private FirstNumFragment firstNumFragment;
    private SecondNumFragment secondNumFragment;
    private ResultFragment resultFragment;
    private OperationFragment operationFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.operation_fragment, container, false);
    }


    @Override
    public void onStart() {
        super.onStart();
        Button btnPlus = (Button) getActivity().findViewById(R.id.btnPlus);
        Button btnMinus = (Button) getActivity().findViewById(R.id.btnMinus);
        Button btnDev = (Button) getActivity().findViewById(R.id.btnDev);
        Button btnMult = (Button) getActivity().findViewById(R.id.btnMult);
        Log.d("Hello", "smth");

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initFragment(1);
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initFragment(2);
            }
        });

        btnDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initFragment(3);
            }
        });

        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initFragment(4);
            }
        });

    }


    public void initFragment(int oper) {
        resultFragment = new ResultFragment();
        int msg1 = 0;
        int msg2 = 0;
        Bundle bundle = getArguments();
        if (bundle != null) {
            msg1 = bundle.getInt(FirstNumFragment.TAG);
            msg2 = bundle.getInt(SecondNumFragment.TAG);
            Log.d("Mytag", "first " + msg1 + " sec " + msg2);
        }
        Log.d("Mytag", "first " + msg1 + " sec " + msg2);
        bundle = new Bundle();
        bundle.putInt(FirstNumFragment.TAG, msg2);
        bundle.putInt(SecondNumFragment.TAG, msg1);
        bundle.putInt(TAG, oper);
        resultFragment.setArguments(bundle);
        if (getActivity().getSupportFragmentManager().findFragmentByTag(ResultFragment.TAG) == null) {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    resultFragment,ResultFragment.TAG).commit();
        }

    }
}
