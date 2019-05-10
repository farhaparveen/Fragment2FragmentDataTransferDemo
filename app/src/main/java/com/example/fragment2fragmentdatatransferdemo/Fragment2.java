package com.example.fragment2fragmentdatatransferdemo;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Fragment2 extends Fragment {

    FragmentTwoListener listener;
    Button btnFragTwo;
    EditText editFragTwo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //this code is used to inflate the fragment2 into framelayout container
      View view=inflater.inflate(R.layout.fragment_fragment2, container, false);
        btnFragTwo=view.findViewById(R.id.btnFragment2);
        editFragTwo=view.findViewById(R.id.editTxtFragment2);
        //fetching the text entered in edittext and sending it to activity through the listener on button click event
        btnFragTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edittxtFragTwoString=editFragTwo.getText().toString();
                listener.onButtonClickOfFragTwo(edittxtFragTwoString);
            }
        });

      return view;
    }

//this interface acts as bridge between fragment2 to fragment1 so that data is first send to activity from fragment2
    //and from then activity to fragment1

    interface FragmentTwoListener
    {
        void onButtonClickOfFragTwo(String str);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener=(FragmentTwoListener)context;
    }
    //receiving the text from activity send from fragment1 to fragment2 and setting the string received in edittext

    void receiveFromActivityToFrag2ViaFrag1(String str)
    {

        editFragTwo.setText(str);
    }
}
