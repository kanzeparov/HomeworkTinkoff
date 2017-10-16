package com.example.franck.fintechhomework.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.franck.fintechhomework.R;

/**
 * Created by Franck on 16.10.2017.
 */

public class ResultFragment extends Fragment {
    private MyFragmentListener listener;

    public final static String TAG = "Result";

    private FirstNumFragment firstNumFragment;
    private SecondNumFragment secondNumFragment;
    private ResultFragment resultFragment;
    private OperationFragment operationFragment;


    public void onStart() {
        super.onStart();
        TextView textView = (TextView) getActivity().findViewById(R.id.resultFragmentTextView);
        int msg1 = 0;
        int msg2 = 0;
        int oper = 0;
        Double result = 0.0;
        Bundle bundle = getArguments();
        if (bundle != null) {

            msg1 = bundle.getInt(FirstNumFragment.TAG);
            msg2 = bundle.getInt(SecondNumFragment.TAG);
            oper = bundle.getInt(OperationFragment.TAG);
            Log.d("Mytag", "first " + msg1 + " sec " + msg2 + " oper " + oper);
        }
        switch (oper) {
            case 1:
                result = msg1 + (double)msg2;
                break;
            case 2:
                result = msg1 - (double)msg2;
                break;
            case 3:
                result = msg1 / (double)msg2;
                break;
            case 4:
                result = msg1 * (double)msg2;
                break;
        }
        textView.setText(result.toString());

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.result_fragment, container, false);
    }

}
