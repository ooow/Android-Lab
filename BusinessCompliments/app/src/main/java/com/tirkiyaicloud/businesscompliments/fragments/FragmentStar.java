package com.tirkiyaicloud.businesscompliments.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tirkiyaicloud.businesscompliments.MainActivity;
import com.tirkiyaicloud.businesscompliments.R;
import com.tirkiyaicloud.businesscompliments.StarItems;

import java.util.ArrayList;

public class FragmentStar extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private StarItems starItems;
    private TextView air[];
    private ImageButton im[];
    private View topView;

    private OnFragmentInteractionListener mListener;

    public FragmentStar() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FragmentStar newInstance(String param1, String param2) {
        FragmentStar fragment = new FragmentStar();
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
        topView = inflater.inflate(R.layout.fragment_star, container, false);
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        TextView toolbarTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setText(R.string.menu1);
        toolbarTitle.setPadding(0, 0, 100, 0);
        setStars(topView);
        return topView;
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


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void setStars(View view) {
        starItems = StarItems.getInstance();
        ArrayList<Pair<String, TextView>> items = starItems.getStarItems();

        LinearLayout lpole[] = new LinearLayout[15];
        lpole[0] = (LinearLayout) view.findViewById(R.id.l1);
        lpole[1] = (LinearLayout) view.findViewById(R.id.l2);
        lpole[2] = (LinearLayout) view.findViewById(R.id.l3);
        lpole[3] = (LinearLayout) view.findViewById(R.id.l4);
        lpole[4] = (LinearLayout) view.findViewById(R.id.l5);
        lpole[5] = (LinearLayout) view.findViewById(R.id.l6);
        lpole[6] = (LinearLayout) view.findViewById(R.id.l7);
        lpole[7] = (LinearLayout) view.findViewById(R.id.l8);
        lpole[8] = (LinearLayout) view.findViewById(R.id.l9);
        lpole[9] = (LinearLayout) view.findViewById(R.id.l10);
        lpole[10] = (LinearLayout) view.findViewById(R.id.l11);
        lpole[11] = (LinearLayout) view.findViewById(R.id.l12);
        lpole[12] = (LinearLayout) view.findViewById(R.id.l13);
        lpole[13] = (LinearLayout) view.findViewById(R.id.l14);
        lpole[14] = (LinearLayout) view.findViewById(R.id.l15);

        for (int i = 0; i < lpole.length; i++) {
            lpole[i].setVisibility(View.GONE);
        }

        TextView air[] = new TextView[30];
        air[0] = (TextView) view.findViewById(R.id.texv1);
        air[1] = (TextView) view.findViewById(R.id.texv2);
        air[2] = (TextView) view.findViewById(R.id.texv3);
        air[3] = (TextView) view.findViewById(R.id.texv4);
        air[4] = (TextView) view.findViewById(R.id.texv5);
        air[5] = (TextView) view.findViewById(R.id.texv6);
        air[6] = (TextView) view.findViewById(R.id.texv7);
        air[7] = (TextView) view.findViewById(R.id.texv8);
        air[8] = (TextView) view.findViewById(R.id.texv9);
        air[9] = (TextView) view.findViewById(R.id.texv10);
        air[10] = (TextView) view.findViewById(R.id.texv11);
        air[11] = (TextView) view.findViewById(R.id.texv12);
        air[12] = (TextView) view.findViewById(R.id.texv13);
        air[13] = (TextView) view.findViewById(R.id.texv14);
        air[14] = (TextView) view.findViewById(R.id.texv15);
        air[15] = (TextView) view.findViewById(R.id.texv16);
        air[16] = (TextView) view.findViewById(R.id.texv17);
        air[17] = (TextView) view.findViewById(R.id.texv18);
        air[18] = (TextView) view.findViewById(R.id.texv19);
        air[19] = (TextView) view.findViewById(R.id.texv20);
        air[20] = (TextView) view.findViewById(R.id.texv21);
        air[21] = (TextView) view.findViewById(R.id.texv22);
        air[22] = (TextView) view.findViewById(R.id.texv23);
        air[23] = (TextView) view.findViewById(R.id.texv24);
        air[24] = (TextView) view.findViewById(R.id.texv25);
        air[25] = (TextView) view.findViewById(R.id.texv26);
        air[26] = (TextView) view.findViewById(R.id.texv27);
        air[27] = (TextView) view.findViewById(R.id.texv28);
        air[28] = (TextView) view.findViewById(R.id.texv29);
        air[29] = (TextView) view.findViewById(R.id.texv30);

        int count = 0;
        if (items.size() > 15)
            count = items.size() - 15;
        int m = 0;
        int j = 0;
        for (int i = items.size() - 1; i >= count; i--) {
            lpole[m].setVisibility(View.VISIBLE);
            air[j].setText(items.get(i).first);
            air[j + 1].setText(items.get(i).second.getText());
            j += 2;
            m++;
        }

        for (int i = 0; i < count; i++) {
            items.remove(i);
        }
        im = new ImageButton[15];
        im[0] = (ImageButton) view.findViewById(R.id.im1);
        im[1] = (ImageButton) view.findViewById(R.id.im2);
        im[2] = (ImageButton) view.findViewById(R.id.im3);
        im[3] = (ImageButton) view.findViewById(R.id.im4);
        im[4] = (ImageButton) view.findViewById(R.id.im5);
        im[5] = (ImageButton) view.findViewById(R.id.im6);
        im[6] = (ImageButton) view.findViewById(R.id.im7);
        im[7] = (ImageButton) view.findViewById(R.id.im8);
        im[8] = (ImageButton) view.findViewById(R.id.im9);
        im[9] = (ImageButton) view.findViewById(R.id.im10);
        im[10] = (ImageButton) view.findViewById(R.id.im11);
        im[11] = (ImageButton) view.findViewById(R.id.im12);
        im[12] = (ImageButton) view.findViewById(R.id.im13);
        im[13] = (ImageButton) view.findViewById(R.id.im14);
        im[14] = (ImageButton) view.findViewById(R.id.im15);

        for (int i = 0; i < im.length; i++) {
            im[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.im1:
                starItems.deleteItem((TextView) topView.findViewById(R.id.texv2));
                im[0].setImageDrawable(getResources().getDrawable(R.mipmap.in_star));
                im[0].setEnabled(false);
                break;
            case R.id.im2:
                starItems.deleteItem((TextView) topView.findViewById(R.id.texv4));
                im[1].setImageDrawable(getResources().getDrawable(R.mipmap.in_star));
                im[1].setEnabled(false);
                break;
            case R.id.im3:
                starItems.deleteItem((TextView) topView.findViewById(R.id.texv6));
                im[2].setImageDrawable(getResources().getDrawable(R.mipmap.in_star));
                im[2].setEnabled(false);
                break;
            case R.id.im4:
                starItems.deleteItem((TextView) topView.findViewById(R.id.texv8));
                im[3].setImageDrawable(getResources().getDrawable(R.mipmap.in_star));
                im[3].setEnabled(false);
                break;
            case R.id.im5:
                starItems.deleteItem((TextView) topView.findViewById(R.id.texv10));
                im[4].setImageDrawable(getResources().getDrawable(R.mipmap.in_star));
                im[4].setEnabled(false);
                break;
            case R.id.im6:
                starItems.deleteItem((TextView) topView.findViewById(R.id.texv12));
                im[5].setImageDrawable(getResources().getDrawable(R.mipmap.in_star));
                im[5].setEnabled(false);
                break;
            case R.id.im7:
                starItems.deleteItem((TextView) topView.findViewById(R.id.texv14));
                im[6].setImageDrawable(getResources().getDrawable(R.mipmap.in_star));
                im[6].setEnabled(false);
                break;
            case R.id.im8:
                starItems.deleteItem((TextView) topView.findViewById(R.id.texv16));
                im[7].setImageDrawable(getResources().getDrawable(R.mipmap.in_star));
                im[7].setEnabled(false);
                break;
            case R.id.im9:
                starItems.deleteItem((TextView) topView.findViewById(R.id.texv18));
                im[8].setImageDrawable(getResources().getDrawable(R.mipmap.in_star));
                im[8].setEnabled(false);
                break;
            case R.id.im10:
                starItems.deleteItem((TextView) topView.findViewById(R.id.texv20));
                im[9].setImageDrawable(getResources().getDrawable(R.mipmap.in_star));
                im[9].setEnabled(false);
                break;
            case R.id.im11:
                starItems.deleteItem((TextView) topView.findViewById(R.id.texv22));
                im[10].setImageDrawable(getResources().getDrawable(R.mipmap.in_star));
                im[10].setEnabled(false);
                break;
            case R.id.im12:
                starItems.deleteItem((TextView) topView.findViewById(R.id.texv24));
                im[11].setImageDrawable(getResources().getDrawable(R.mipmap.in_star));
                im[11].setEnabled(false);
                break;
            case R.id.im13:
                starItems.deleteItem((TextView) topView.findViewById(R.id.texv26));
                im[12].setImageDrawable(getResources().getDrawable(R.mipmap.in_star));
                im[12].setEnabled(false);
                break;
            case R.id.im14:
                starItems.deleteItem((TextView) topView.findViewById(R.id.texv28));
                im[13].setImageDrawable(getResources().getDrawable(R.mipmap.in_star));
                im[13].setEnabled(false);
                break;
            case R.id.im15:
                starItems.deleteItem((TextView) topView.findViewById(R.id.texv30));
                im[14].setImageDrawable(getResources().getDrawable(R.mipmap.in_star));
                im[14].setEnabled(false);
                break;
        }
    }

}
