package com.seventh.VoiceAssistant.Fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class SecondFragment extends Fragment {
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        LinearLayout colorLayout = new LinearLayout(getActivity());
        LinearLayout.LayoutParams ll = new LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        colorLayout.setBackgroundColor(Color.BLUE);
        colorLayout.setLayoutParams(ll);
        return colorLayout;
    }
}
