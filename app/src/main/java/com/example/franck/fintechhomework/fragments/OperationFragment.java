package com.example.franck.fintechhomework.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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

public class OperationFragment extends Fragment {

    public static final String TAG = "OperationFragmentTag";
    private ResultFragment resultFragment;
    private int result;
    private VvodTwoFragment vvodTwoFragment;
    private VvodFragment vvodFragment;

    public int getResult() {
        return result;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.operation_fragment, container, false);
    }

    @Override
    public void onStart() {

        super.onStart();
        resultFragment = new ResultFragment();
        Button btnPlus = (Button) getActivity().findViewById(R.id.btnPlus);
        Button btnMinus = (Button) getActivity().findViewById(R.id.btnMinus);
        Button btnDiv = (Button) getActivity().findViewById(R.id.btnDev);
        Button btnMul = (Button) getActivity().findViewById(R.id.btnMult);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"HERE)");
                if (getActivity().getSupportFragmentManager().findFragmentByTag(ResultFragment.TAG) == null) {
                    getActivity().getSupportFragmentManager().beginTransaction().add(R.id.container,
                            resultFragment,ResultFragment.TAG).commit();
                    EditText editText = getActivity().findViewById(R.id.editFirstNum);
                    int numFirst = Integer.parseInt(editText.getText().toString());
                    EditText editText1 = getActivity().findViewById(R.id.editSecNum);
                    int numSecond = Integer.parseInt(editText1.getText().toString());
                    result = numFirst + numSecond;
                    Log.d(TAG,"result " + result);
                }
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"HERE)");
                if (getActivity().getSupportFragmentManager().findFragmentByTag(ResultFragment.TAG) == null) {
                    getActivity().getSupportFragmentManager().beginTransaction().add(R.id.container,
                            resultFragment,ResultFragment.TAG).commit();
                    EditText editText = getActivity().findViewById(R.id.editFirstNum);
                    int numFirst = Integer.parseInt(editText.getText().toString());
                    EditText editText1 = getActivity().findViewById(R.id.editSecNum);
                    int numSecond = Integer.parseInt(editText1.getText().toString());
                    result = numFirst - numSecond;
                    Log.d(TAG,"result " + result);
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"HERE)");
                if (getActivity().getSupportFragmentManager().findFragmentByTag(ResultFragment.TAG) == null) {
                    getActivity().getSupportFragmentManager().beginTransaction().add(R.id.container,
                            resultFragment,ResultFragment.TAG).commit();
                    EditText editText = getActivity().findViewById(R.id.editFirstNum);
                    int numFirst = Integer.parseInt(editText.getText().toString());
                    EditText editText1 = getActivity().findViewById(R.id.editSecNum);
                    int numSecond = Integer.parseInt(editText1.getText().toString());
                    result = numFirst / numSecond;
                    Log.d(TAG,"result " + result);
                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"HERE)");
                if (getActivity().getSupportFragmentManager().findFragmentByTag(ResultFragment.TAG) == null) {
                    getActivity().getSupportFragmentManager().beginTransaction().add(R.id.container,
                            resultFragment,ResultFragment.TAG).commit();
                    EditText editText = getActivity().findViewById(R.id.editFirstNum);
                    int numFirst = Integer.parseInt(editText.getText().toString());
                    EditText editText1 = getActivity().findViewById(R.id.editSecNum);
                    int numSecond = Integer.parseInt(editText1.getText().toString());
                    result = numFirst * numSecond;
                    Log.d(TAG,"result " + result);

                    Fragment f = new OperationFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt("Resulp", result);
                    f.setArguments(bundle);
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.commit();
                }

            }
        });

    }
}
