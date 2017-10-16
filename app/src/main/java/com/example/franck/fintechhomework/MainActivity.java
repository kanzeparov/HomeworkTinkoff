package com.example.franck.fintechhomework;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.franck.fintechhomework.fragments.OperationFragment;
import com.example.franck.fintechhomework.fragments.ResultFragment;
import com.example.franck.fintechhomework.fragments.VvodFragment;
import com.example.franck.fintechhomework.fragments.VvodTwoFragment;

public class MainActivity extends AppCompatActivity {
    private VvodFragment vvodFragment1;
    private VvodTwoFragment vvodFragment2;
    private OperationFragment operation;
    private ResultFragment result;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        vvodFragment1 = new VvodFragment();
        vvodFragment2 = new VvodTwoFragment();
        operation = new OperationFragment();
        result = new ResultFragment();

    }

    public FragmentManager getFragmentManagerFromActivity() {
        return fragmentManager;
    }

    public void OnClickFragment(View view) {
        fragmentTransaction = fragmentManager.beginTransaction();

        switch (view.getId()) {

            case R.id.btnAdd:
                if (fragmentManager.findFragmentByTag(VvodFragment.TAG) == null) {
                    fragmentTransaction.add(R.id.container, vvodFragment1, VvodFragment.TAG);
                } else if(fragmentManager.findFragmentByTag(VvodFragment.TAG) != null) {
                    fragmentTransaction.remove(vvodFragment2);
                    fragmentTransaction.remove(operation);
                    fragmentTransaction.remove(result);
                }
                break;
            case R.id.btnDel:
                if (fragmentManager.findFragmentByTag(VvodTwoFragment.TAG) == null) {
                    fragmentTransaction.add(R.id.container, vvodFragment2, VvodTwoFragment.TAG);
                } else if (fragmentManager.findFragmentByTag(VvodTwoFragment.TAG) != null) {
                    fragmentTransaction.remove(operation);
                    fragmentTransaction.remove(result);
                }
                break;
            case R.id.btnRep:
                if (fragmentManager.findFragmentByTag(OperationFragment.TAG) == null) {
                    fragmentTransaction.add(R.id.container, operation, OperationFragment.TAG);
                    fragmentTransaction.remove(result);
                } else if (fragmentManager.findFragmentByTag(OperationFragment.TAG) != null) {
                    fragmentTransaction.remove(result);
                }
                break;
            case R.id.btnRes:
                if (fragmentManager.findFragmentByTag(ResultFragment.TAG) == null) {
                    fragmentTransaction.add(R.id.container, result, ResultFragment.TAG);
                }
                break;
        }

        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();
    }


}
