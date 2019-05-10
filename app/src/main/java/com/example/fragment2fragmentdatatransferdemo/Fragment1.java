package com.example.fragment2fragmentdatatransferdemo;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Fragment1 extends Fragment {

    FragmentOneListener listener;
    Button btnFragOne;
    EditText editFragOne;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //this code is used to inflate the fragment1 into framelayout container
        View view=inflater.inflate(R.layout.fragment_fragment1, container, false);
        btnFragOne=view.findViewById(R.id.btnFragment1);
        editFragOne=view.findViewById(R.id.editTxtFragment1);

        //fetching the text entered in edittext and sending it to activity through the listener  on button click event
        btnFragOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edittxtFragOneString=editFragOne.getText().toString();
                listener.onButtonClickOfFragOne(edittxtFragOneString);
            }
        });
        return view;

    }
    //this interface acts as bridge between fragment1 to fragment2 so that data is first send to activity from fragment1
    //and from then activity to fragment2

    interface FragmentOneListener
    {
        void onButtonClickOfFragOne(String str);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener=(FragmentOneListener)context;
    }

    //receiving the text from activity send from fragment2 to fragment1 and setting the string received in edittext
    void receiveFromActivityToFrag1ViaFrag2(String str)
    {

        editFragOne.setText(str);
    }

}
