package com.example.instaapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class userAccFragment extends Fragment {



    public userAccFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Log.d("userAccFragment", "onCreateView called");
        return inflater.inflate(R.layout.fragment_user_acc,container, false);
    }
}