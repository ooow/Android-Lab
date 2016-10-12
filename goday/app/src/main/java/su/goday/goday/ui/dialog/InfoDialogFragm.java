package su.goday.goday.ui.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import su.goday.goday.R;

/**
 * Created by Гога on 28.09.2016.
 */
public class InfoDialogFragm extends DialogFragment implements View.OnClickListener {
    private TextView textView;
    private TextView buttonOk;
    private String text;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog, container);

        buttonOk = (TextView) view.findViewById(R.id.buttonOk);
        textView = (TextView) view.findViewById(R.id.textView);

        buttonOk.setOnClickListener(this);
        textView.setText(text);
        return view;
    }

    public InfoDialogFragm setText(String text) {
        this.text = text;
        return this;
    }

    @Override
    public void onClick(View v) {
        if (v == buttonOk) {
            dismiss();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().setLayout(width, height);
        }
    }
}
