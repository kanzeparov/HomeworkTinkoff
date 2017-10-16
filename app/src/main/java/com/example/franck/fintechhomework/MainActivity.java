package com.example.franck.fintechhomework;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.franck.fintechhomework.fragments.FirstNumFragment;
import com.example.franck.fintechhomework.fragments.MyFragmentListener;
import com.example.franck.fintechhomework.fragments.OperationFragment;
import com.example.franck.fintechhomework.fragments.ResultFragment;
import com.example.franck.fintechhomework.fragments.SecondNumFragment;

public class MainActivity extends AppCompatActivity implements MyFragmentListener{
    private FirstNumFragment firstNumFragment;
    private SecondNumFragment secondNumFragment;
    private ResultFragment resultFragment;
    private OperationFragment operationFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumFragment = new FirstNumFragment();
        secondNumFragment = new SecondNumFragment();
        resultFragment = new ResultFragment();
        operationFragment = new OperationFragment();

        fragmentManager = getSupportFragmentManager();


    }

    public void OnClickFragment(View view) {

        fragmentTransaction = fragmentManager.beginTransaction();

        switch (view.getId()) {
            case R.id.btnadd:
                if (fragmentManager.findFragmentByTag(FirstNumFragment.TAG) == null) {
                    fragmentTransaction.add(R.id.container, firstNumFragment, FirstNumFragment.TAG);
                }
                break;
            case R.id.btnback:
                fragmentManager.beginTransaction().addToBackStack(null).commit();
                break;
            case R.id.btnsecond:
                if (fragmentManager.findFragmentByTag(SecondNumFragment.TAG) == null) {
                    fragmentTransaction.replace(R.id.container, secondNumFragment, SecondNumFragment.TAG);
                }
                break;
            case R.id.btnfirst:
                if (fragmentManager.findFragmentByTag(FirstNumFragment.TAG) == null) {
                    fragmentTransaction.replace(R.id.container, firstNumFragment, FirstNumFragment.TAG);
                }
                break;
            case R.id.btnres:
                if (fragmentManager.findFragmentByTag(ResultFragment.TAG) == null) {
                    fragmentTransaction.replace(R.id.container, resultFragment, ResultFragment.TAG);
                }
                break;
            case R.id.operatiorbtn:
                if (fragmentManager.findFragmentByTag(OperationFragment.TAG) == null) {
                    fragmentTransaction.replace(R.id.container, operationFragment, OperationFragment.TAG);
                }
                break;
        }


        fragmentTransaction.commit();

    }


    @Override
    public void myCallBack(int i) {

    }
}
