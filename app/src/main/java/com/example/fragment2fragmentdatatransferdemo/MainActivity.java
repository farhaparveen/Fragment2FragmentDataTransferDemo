package com.example.fragment2fragmentdatatransferdemo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment1.FragmentOneListener,Fragment2.FragmentTwoListener{

    Fragment1 fragment1;
    Fragment2 fragment2;
    FragmentManager manager;
    FragmentTransaction transaction;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment1=new Fragment1();
        fragment2=new Fragment2();
        //this code is used to add the fragments to the framelayout container using fragmentmanager
        manager=getSupportFragmentManager();
        transaction=manager.beginTransaction();
        transaction.add(R.id.containerFragment1,fragment1);
        transaction.add(R.id.containerFragment2,fragment2);
        transaction.commit();
    }


    //implementing method fragment1 listener for data transfer between fragment1 to fragment2
    @Override
    public void onButtonClickOfFragOne(String str) {

fragment2.receiveFromActivityToFrag2ViaFrag1(str);

    }

    // //implementing method fragment2 listener for data transfer between fragment1 to fragment2
    @Override
    public void onButtonClickOfFragTwo(String str) {
fragment1.receiveFromActivityToFrag1ViaFrag2(str);
    }
}
