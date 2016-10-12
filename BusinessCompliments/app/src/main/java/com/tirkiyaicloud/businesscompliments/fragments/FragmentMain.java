package com.tirkiyaicloud.businesscompliments.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tirkiyaicloud.businesscompliments.ActivityTwo;
import com.tirkiyaicloud.businesscompliments.R;

public class FragmentMain extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    LinearLayout layout1;
    LinearLayout layout2;
    LinearLayout layout3;
    LinearLayout layout4;
    LinearLayout layout5;
    LinearLayout layout6;
    LinearLayout layout7;

    private OnFragmentInteractionListener mListener;

    public FragmentMain() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FragmentMain newInstance(String param1, String param2) {
        FragmentMain fragment = new FragmentMain();
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

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        TextView toolbarTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setText(R.string.app_name);
        layout1 = (LinearLayout) view.findViewById(R.id.layout1);
        layout2 = (LinearLayout) view.findViewById(R.id.layout2);
        layout3 = (LinearLayout) view.findViewById(R.id.layout3);
        layout4 = (LinearLayout) view.findViewById(R.id.layout4);
        layout5 = (LinearLayout) view.findViewById(R.id.layout5);
        layout6 = (LinearLayout) view.findViewById(R.id.layout6);
        layout7 = (LinearLayout) view.findViewById(R.id.layout7);
        layout1.setOnClickListener(this);
        layout2.setOnClickListener(this);
        layout3.setOnClickListener(this);
        layout4.setOnClickListener(this);
        layout5.setOnClickListener(this);
        layout6.setOnClickListener(this);
        layout7.setOnClickListener(this);
        /*linearLayout2.setOnClickListener(clickL2())*/
        ;
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
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), ActivityTwo.class);
        switch (view.getId()) {
            case R.id.layout1:
                intent.putExtra("title", "Деловой Комплимент");
                intent.putExtra("title1", "Как правильно делать комплименты");
                intent.putExtra("type", 1);
                intent.putExtra("tom", 1);
                startActivity(intent);
                break;
            case R.id.layout2:
                intent.putExtra("title", "Деловой Комплимент");
                intent.putExtra("title1", "Как правильно принимать комплименты");
                intent.putExtra("type", 1);
                intent.putExtra("tom", 2);
                startActivity(intent);
                break;
            case R.id.layout3:
                intent.putExtra("title", "ТОП-8 ошибок");
                intent.putExtra("type", 2);
                intent.putExtra("tom", 3);
                startActivity(intent);
                break;
            case R.id.layout4:
                intent.putExtra("title", "ФОРМУЛЫ");
                intent.putExtra("type", 2);
                intent.putExtra("tom", 4);
                startActivity(intent);
                break;
            case R.id.layout5:
                intent.putExtra("title", "Деловой Комплимент");
                intent.putExtra("title1", "Лучшие темы для комплиментов в бизнес-среде");
                intent.putExtra("type", 1);
                intent.putExtra("tom", 5);
                startActivity(intent);
                break;
            case R.id.layout6:
                intent.putExtra("title", "ПРИМЕРЫ");
                intent.putExtra("type", 2);
                intent.putExtra("tom", 6);
                startActivity(intent);
                break;
            case R.id.layout7:
                intent.putExtra("title", "УПРАЖНЕНИЯ");
                intent.putExtra("type", 2);
                intent.putExtra("tom", 7);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
