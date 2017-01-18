package su.goday.goday.ui.main;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import su.goday.goday.R;

/**
 * Created by Гога on 11.10.2016.
 */
public class MainContextFragment extends Fragment implements View.OnClickListener {
    private View taskLine;

    public MainContextFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_context, container, false);
        taskLine = view.findViewById(R.id.task_line);




        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            default:
                break;
        }
    }
}
