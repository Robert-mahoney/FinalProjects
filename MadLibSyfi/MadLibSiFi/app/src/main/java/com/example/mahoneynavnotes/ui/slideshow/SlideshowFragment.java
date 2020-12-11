package com.example.mahoneynavnotes.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mahoneynavnotes.R;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private TextView mFirstName;        //instantiating the object here it acts like a global variable
    private TextView mLastName;
    private TextView mCity;
    private TextView mSchool;
    private TextView mBrother;
    private TextView mSister;
    private Button submit;
    private TextView outputText;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        mFirstName = (TextView) root.findViewById(R.id.txtFirstName);
        mLastName = (TextView) root.findViewById(R.id.txtLastName);
        mCity = (TextView) root.findViewById(R.id.txtCity);
        mSchool = (TextView) root.findViewById(R.id.txtSchool);
        mBrother = (TextView) root.findViewById(R.id.txtBrother);
        mSister = (TextView) root.findViewById(R.id.txtSister);
        mSister = (TextView) root.findViewById(R.id.txtSister);
        outputText = (TextView) root.findViewById(R.id.txtOutput);
        submit = (Button) root.findViewById(R.id.btnSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String first = mFirstName.getText().toString(); //getText just gets the info out of the TextView
                String last = mLastName.getText().toString();
                String city = mCity.getText().toString();
                String school = mSchool.getText().toString();
                String brother = mBrother.getText().toString();
                String sister = mSister.getText().toString();

                first = first.substring(0, (int) (Math.random() * first.length()));

                last = last.substring((int) (Math.random() * last.length()));

                city = city.substring(0, (int) (Math.random() * city.length()));

                school = school.substring((int) (Math.random() * school.length()));

                brother = brother.substring(0, (int) (Math.random() * brother.length()));

                sister = sister.substring((int) (Math.random() * sister.length()));


                // output SyFi name on screen
                outputText.setText("");
                outputText.append(first + last + " " + city + school + " from " + brother + sister);
                outputText.append(" welcome to the party!"); //append is same as println
            }
        });

        return root;
    }
}
