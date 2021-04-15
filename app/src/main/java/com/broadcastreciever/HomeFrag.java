package com.broadcastreciever;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.google.android.material.button.MaterialButton;


public class HomeFrag extends Fragment {
    View mView;
    private MaterialButton mStaticBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_home, container, false);
            mStaticBtn = mView.findViewById(R.id.mStaticBR);
//            mStaticBtn.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.home_to_staticBR));
        }
        return mView;
    }
}