package com.tirkiyaicloud.businesscompliments.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.tirkiyaicloud.businesscompliments.R;
import com.tirkiyaicloud.businesscompliments.TextSize;

import org.w3c.dom.Text;


public class FragmentSetting extends Fragment implements SeekBar.OnSeekBarChangeListener {
    // TODO: Rename parameter arguments, choose names that match
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    SeekBar sc;
    TextView textView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentSetting() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static FragmentSetting newInstance(String param1, String param2) {
        FragmentSetting fragment = new FragmentSetting();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        TextView toolbarTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setText(R.string.menu2);
        toolbarTitle.setPadding(0, 0, 100, 0);
        sc = (SeekBar) view.findViewById(R.id.seekbar);
        sc.setOnSeekBarChangeListener(this);
        textView = (TextView) view.findViewById(R.id.test_text);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if (i > 11) {
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, i);
            TextSize textSize = TextSize.getInstance();
            textSize.setTextSize(i);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
