package com.example.gdritzysfinal.ui.icecream;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.gdritzysfinal.MainActivity;
import com.example.gdritzysfinal.OrderItems;
import com.example.gdritzysfinal.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class IcecreamFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_icecream, container, false);
        final CheckBox singleScoop = root.findViewById(R.id.singeScoop);
        final CheckBox doubleScoop = root.findViewById(R.id.doubleScoop);
        final CheckBox cakeCone = root.findViewById(R.id.cakeCone);
        final CheckBox waffleCone = root.findViewById(R.id.waffleCone);
        final CheckBox bowl = root.findViewById(R.id.bowlCone);
        final NumberPicker flavor = root.findViewById(R.id.flavorSelect);
        Button addIceCream = root.findViewById(R.id.addIceCream);
        //setting up the number picker for the ice cream flavors
        flavor.setMinValue(0);
        flavor.setMaxValue(15);
        final String[] flavorList = {"Richest Chocolate", "British Butter Toffee", "Cookie Butter", "Mint Chocolate Chunk", "Orange Dreamsicle",
                                "Peaches N' Cream", "All Natural StrawBerry", "Butter Pecan Cashew", "Chunky Dory Fudge", "Coffee Break",
                                "Mint Oreo", "O-O-Oreo", "Peanut Butter Cup", "Philadelphia Style Vanilla", "Sweet Cream", "Wild Mountain Blackberry"};
        flavor.setDisplayedValues(flavorList);
        //sets up a popup to display if the wrong checkboxes are marked
        final Snackbar mySnackbar = Snackbar.make(getActivity().findViewById(android.R.id.content), "Only Select One Box", BaseTransientBottomBar.LENGTH_SHORT);
        //adds the ice cream to the order once the button is clicked
        //gets the checkboxes and the number picker
        addIceCream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String size = "";
                String cone  ="";
                Double price = 0.0;
                if(singleScoop.isChecked() && !doubleScoop.isChecked()){
                    size = "Single Scoop";
                    price = 1.99;
                }
                else if (!singleScoop.isChecked() && doubleScoop.isChecked()){
                    size = "Double Scoop";
                    price = 2.99;
                }
                else{
                    mySnackbar.show();
                }
                if(cakeCone.isChecked() && !waffleCone.isChecked() && !bowl.isChecked()) {
                    cone= "Cake Cone";

                }
                else if (!cakeCone.isChecked() && waffleCone.isChecked() && !bowl.isChecked()){
                    cone = "Waffle Cone";
                }
                else if (!cakeCone.isChecked() && !waffleCone.isChecked() && bowl.isChecked()){
                    cone = "Bowl";
                }
                else{
                    mySnackbar.show();
                }
                if(!size.equals("") && !cone.equals("")){
                    MainActivity.orderList.add(new OrderItems(flavorList[flavor.getValue()], price,  size + " in a " + cone ));
                    Log.d("Ice Cream", String.valueOf(MainActivity.orderList.get(MainActivity.orderList.size()-1)));
                }
            }
        });
        return root;
    }
}