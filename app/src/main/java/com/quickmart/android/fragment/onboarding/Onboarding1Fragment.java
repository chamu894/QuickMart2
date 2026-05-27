package com.quickmart.android.fragment.onboarding;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quickmart.android.R;
import com.quickmart.android.fragment.authentication.SignupFragment;
import com.quickmart.android.model.PrefsHelper;

public class Onboarding1Fragment extends Fragment {

    private PrefsHelper prefshelper;


    public Onboarding1Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.prefshelper = PrefsHelper.getInstance(getActivity());

        return inflater.inflate(R.layout.fragment_onboarding1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        // මෙයාගෙන් තමා බැක් බටන් එක ක්ලික් කරාම මොනිටර් කරගන්නෙ
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                getActivity().finish();
            }
        });

        view.findViewById(R.id.nextBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prefshelper.setIsFirstLaunch(false);

                //recamanded
                getParentFragmentManager().beginTransaction()
                        .setCustomAnimations(
                                R.anim.slide_in_right,
                                R.anim.slide_out_left,
                                R.anim.slide_in_left,
                                R.anim.slide_out_right
                        )
                        .replace(R.id.fragmentContainer, new SignupFragment())
                        .addToBackStack(null)
                        .commit();

                //opshanal
//                getActivity().getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.fragmentContainer, new SignupFragment())
//                        .addToBackStack(null)
//                        .commit();


            }
        });

    }
}