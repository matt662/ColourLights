package me.mattfluder.colourlights;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;


public class ManualFragment extends Fragment {
    View view;
    private SeekBar redSeekBar, blueSeekBar, greenSeekBar;
    private EditText editRed, editGreen, editBlue;
    private Button sendButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_manual,container,false);

        redSeekBar = (SeekBar) view.findViewById(R.id.seekBarRed);
        redSeekBar.setMax(255);
        sendButton = (Button) view.findViewById(R.id.sendButton);
        editRed = (EditText) view.findViewById(R.id.editRed);
        editBlue = (EditText) view.findViewById(R.id.editBlue);
        editGreen = (EditText) view.findViewById(R.id.editGreen);
        redSeekBar = (SeekBar) view.findViewById(R.id.seekBarRed);
        redSeekBar.setMax(255);
        redSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                if (fromUser) {
                    editRed.setText(String.valueOf(progress));
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

        });
        blueSeekBar = (SeekBar) view.findViewById(R.id.seekBarBlue);
        blueSeekBar.setMax(255);
        blueSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                if (fromUser) {
                    editBlue.setText(String.valueOf(progress));
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

        });
        greenSeekBar = (SeekBar) view.findViewById(R.id.seekBarGreen);
        greenSeekBar.setMax(255);
        greenSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                if (fromUser) {
                    editGreen.setText(String.valueOf(progress));
                    //getActivity().
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

        });
        editRed.setFilters(new InputFilter[] { new InputFilterMinMax("0", "255") });
        editRed.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    // Toast.makeText(getApplicationContext(), "got the focus",
                    // Toast.LENGTH_LONG).show();

                } else
                    // Toast.makeText(getApplicationContext(), "lost the focus",
                    // Toast.LENGTH_LONG).show();
                    if (editRed.getText().toString().equals("")) {
                        // redSeekBar.setProgress(0);
                        editRed.setText("0");
                    }
                redSeekBar.setProgress(Integer.parseInt(editRed.getText().toString()));
            }

        });
        editGreen.setFilters(new InputFilter[] { new InputFilterMinMax("0",
                "255") });
        editGreen.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    // Toast.makeText(getApplicationContext(), "got the focus",
                    // Toast.LENGTH_LONG).show();

                } else
                    // Toast.makeText(getApplicationContext(), "lost the focus",
                    // Toast.LENGTH_LONG).show();
                    if (editGreen.getText().toString().equals("")) {
                        // redSeekBar.setProgress(0);
                        editGreen.setText("0");
                    }
                greenSeekBar.setProgress(Integer.parseInt(editGreen.getText().toString()));

            }

        });
        editBlue.setFilters(new InputFilter[] { new InputFilterMinMax("0",
                "255") });
        editBlue.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    // Toast.makeText(getApplicationContext(), "got the focus",
                    // Toast.LENGTH_LONG).show();

                } else
                    // Toast.makeText(getApplicationContext(), "lost the focus",
                    // Toast.LENGTH_LONG).show();
                    if (editBlue.getText().toString().equals("")) {
                        // redSeekBar.setProgress(0);
                        editBlue.setText("0");
                    }
                blueSeekBar.setProgress(Integer.parseInt(editBlue.getText().toString()));
            }

        });
        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Send(v);
            }
        });
        return view;
    }
    private class InputFilterMinMax implements InputFilter {

        private int min, max;

        public InputFilterMinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public InputFilterMinMax(String min, String max) {
            this.min = Integer.parseInt(min);
            this.max = Integer.parseInt(max);
        }

        @Override
        public CharSequence filter(CharSequence source, int start, int end,
                                   Spanned dest, int dstart, int dend) {
            try {
                int input = Integer.parseInt(dest.toString()
                        + source.toString());
                if (isInRange(min, max, input))
                    return null;
            } catch (NumberFormatException nfe) {
            }
            return "";
        }

        private boolean isInRange(int a, int b, int c) {
            return b > a ? c >= a && c <= b : c >= b && c <= a;
        }
    }

}