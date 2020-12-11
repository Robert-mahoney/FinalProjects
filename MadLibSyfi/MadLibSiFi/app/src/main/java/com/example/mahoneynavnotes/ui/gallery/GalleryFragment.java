package com.example.mahoneynavnotes.ui.gallery;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mahoneynavnotes.R;

import java.text.BreakIterator;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private TextView editView;
    private int n=0;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        //this line loads in the xml file to the screen
        final View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        //create the textViews and number pickers on the screen
        final TextView mNoun1 = root.findViewById(R.id.txtNoun1);
        final TextView mNoun2 = root.findViewById(R.id.txtNoun2);
        final TextView mNoun3 = root.findViewById(R.id.txtNoun3);
        final TextView mNoun4 = root.findViewById(R.id.txtNoun4);
        final TextView mNoun5 = root.findViewById(R.id.txtNoun5);
        final TextView mNoun6 = root.findViewById(R.id.txtNoun6);
        final TextView mNoun7 = root.findViewById(R.id.txtNoun7);

        final TextView mVerb1 = root.findViewById(R.id.txtVerb1);
        final TextView mVerb2 = root.findViewById(R.id.txtVerb2);
        final TextView mAdj1 = root.findViewById(R.id.txtAdj1);

        final TextView mName = root.findViewById(R.id.txtName);
        final TextView mNumber = root.findViewById(R.id.txtNumber);
        final TextView outputText = root.findViewById(R.id.txtOutput);
        final Button submit = root.findViewById(R.id.btnSubmit);
        //waits for button to be clicked
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noun1 = mNoun1.getText().toString(); //getText just gets the info out of the TextView
                String noun2 = mNoun2.getText().toString();
                String noun3 = mNoun3.getText().toString();
                String noun4 = mNoun4.getText().toString();
                String noun5 = mNoun5.getText().toString();
                String noun6 = mNoun6.getText().toString();
                String noun7 = mNoun7.getText().toString();

                String verb1 = mVerb1.getText().toString();
                String verb2 = mVerb2.getText().toString();
                String adj1 = mAdj1.getText().toString();

                String name1 = mName.getText().toString();
                String number1 = mNumber.getText().toString();


                //prints out text on screen
                outputText.setText("");
                outputText.append(String.format("At %s, everybody sits in %s that are spaced %s",noun1,noun2,number1));
                outputText.append(String.format(" feet away from each other. This makes %s on the %s a %s",verb1,noun3,adj1));
                outputText.append(String.format(" activity, because everyone around can %s what you are saying.",verb2));
                outputText.append(String.format(" It's a wonder that %s get any work done with all",noun4));
                outputText.append(String.format(" the %s. There is an %s at %s named %s.",noun5,noun6,noun7,name1));
            }
        });

        return root;
    }
}