package com.example.franck.fintechhomework.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.franck.fintechhomework.R;

/**
 * Created by Franck on 16.10.2017.
 */

public class SecondNumFragment extends Fragment {
    private MyFragmentListener listener;

    public final static String TAG = "SecondNum";

    private FirstNumFragment firstNumFragment;
    private SecondNumFragment secondNumFragment;
    private ResultFragment resultFragment;
    private OperationFragment operationFragment;
    private EditText editText;

    public static SecondNumFragment newInstance(int num) {
        Bundle args = new Bundle();
        args.putInt("num from second", num);

        SecondNumFragment fragment = new SecondNumFragment();
        fragment.setArguments(args);
        return fragment;
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        int num = getArguments().getInt("num from second");
//    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof  MyFragmentListener) {
            listener = (MyFragmentListener) getActivity();
        } else {
            throw new RuntimeException("Activ");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.second_fragment, null);

        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        editText = (EditText) getActivity().findViewById(R.id.secondFragmentEditText);
        Button btn1 = (Button) getActivity().findViewById(R.id.secondFragmentBtn);
        operationFragment = new OperationFragment();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int msg = 0;
                Bundle bundle = getArguments();
                if (bundle != null) {
                    msg = bundle.getInt(FirstNumFragment.TAG);
                    Log.d("Mytag", "" + msg);
                }
                Log.d("Mytag", "" + msg);
                bundle = new Bundle();
                bundle.putInt(TAG, Integer.parseInt(editText.getText().toString()));
                bundle.putInt(FirstNumFragment.TAG, msg);
                operationFragment.setArguments(bundle);
                if (getActivity().getSupportFragmentManager().findFragmentByTag(OperationFragment.TAG) == null) {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,
                            operationFragment,OperationFragment.TAG).commit();
                }
            }
        });
    }
}

