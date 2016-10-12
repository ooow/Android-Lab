package su.goday.goday.ui.main;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import su.goday.goday.R;

/**
 * Created by Гога on 11.10.2016.
 */
public class MainContextFragment extends Fragment implements View.OnClickListener {
    TextView text1;
    TextView text2;
    TextView text3;
    TextView text4;
    TextView text5;
    TextView text6;
    TextView text7;
    CalendarMiniCircle view1;
    CalendarMiniCircle view2;
    CalendarMiniCircle view3;
    CalendarMiniCircle view4;
    CalendarMiniCircle view5;
    CalendarMiniCircle view6;
    CalendarMiniCircle view7;

    public MainContextFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_context, container, false);

        view1 = (CalendarMiniCircle) view.findViewById(R.id.circle1);
        view2 = (CalendarMiniCircle) view.findViewById(R.id.circle2);
        view3 = (CalendarMiniCircle) view.findViewById(R.id.circle3);
        view4 = (CalendarMiniCircle) view.findViewById(R.id.circle4);
        view5 = (CalendarMiniCircle) view.findViewById(R.id.circle5);
        view6 = (CalendarMiniCircle) view.findViewById(R.id.circle6);
        view7 = (CalendarMiniCircle) view.findViewById(R.id.circle7);
        view1.setOnClickListener(this);
        view2.setOnClickListener(this);
        view3.setOnClickListener(this);
        view4.setOnClickListener(this);
        view5.setOnClickListener(this);
        view6.setOnClickListener(this);
        view7.setOnClickListener(this);

        text1 = (TextView) view.findViewById(R.id.text1);
        text2 = (TextView) view.findViewById(R.id.text2);
        text3 = (TextView) view.findViewById(R.id.text3);
        text4 = (TextView) view.findViewById(R.id.text4);
        text5 = (TextView) view.findViewById(R.id.text5);
        text6 = (TextView) view.findViewById(R.id.text6);
        text7 = (TextView) view.findViewById(R.id.text7);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.circle1:
                view1.setPartOf();
                text1.setText(view1.getPartOf() + "/5");
                break;
            case R.id.circle2:
                view2.setPartOf();
                text2.setText(view2.getPartOf() + "/5");
                break;
            case R.id.circle3:
                view3.setPartOf();
                text3.setText(view3.getPartOf() + "/5");
                break;
            case R.id.circle4:
                view4.setPartOf();
                text4.setText(view4.getPartOf() + "/5");
                break;
            case R.id.circle5:
                view5.setPartOf();
                text5.setText(view5.getPartOf() + "/5");
                break;
            case R.id.circle6:
                view6.setPartOf();
                text6.setText(view6.getPartOf() + "/5");
                break;
            case R.id.circle7:
                view7.setPartOf();
                text7.setText(view7.getPartOf() + "/5");
                break;
            default:
                break;
        }
    }
}
