package com.example.franck.fintechhomework.fragments;

import android.content.Intent;
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

public class FirstNumFragment extends Fragment {

    private MyFragmentListener listener;
    private EditText editText;

    public final static String TAG = "FirstNum";

    private FirstNumFragment firstNumFragment;
    private SecondNumFragment secondNumFragment;
    private ResultFragment resultFragment;
    private OperationFragment operationFragment;


    public static FirstNumFragment newInstance(int num) {
        Bundle args = new Bundle();
        args.putInt("num from first", num);

        FirstNumFragment fragment = new FirstNumFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        return inflater.inflate(R.layout.first_fragment, container, false);
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

    }


    @Override
    public void onStart() {
        super.onStart();

        secondNumFragment = new SecondNumFragment();
        Button btn = (Button) getActivity().findViewById(R.id.firstFragmentBtn);
        editText = (EditText) getActivity().findViewById(R.id.firstFragmentEditText);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt(TAG, Integer.parseInt(editText.getText().toString()));
                secondNumFragment.setArguments(bundle);
                if (getActivity().getSupportFragmentManager().findFragmentByTag(SecondNumFragment.TAG) == null) {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,
                           secondNumFragment, SecondNumFragment.TAG).commit();

                }
            }
        });
    }
}
