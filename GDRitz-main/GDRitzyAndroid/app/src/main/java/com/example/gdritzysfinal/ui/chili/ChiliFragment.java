package com.example.gdritzysfinal.ui.chili;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.NumberPicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.gdritzysfinal.MainActivity;
import com.example.gdritzysfinal.OrderItems;
import com.example.gdritzysfinal.R;

import static com.example.gdritzysfinal.ListToPass.ORDER_ITEMS;
import static com.example.gdritzysfinal.ListToPass.ORDER_ITEMSCOST;
import static com.example.gdritzysfinal.ListToPass.ORDER_ITEMSCUSTOM;

public class ChiliFragment extends Fragment{
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_chili, container, false);
        //number picker is to decide which chili item is ordered
        final NumberPicker chiliType = root.findViewById(R.id.chiliSelect);
        //orderChili uses function to add chili to order
        Button orderChili = root.findViewById(R.id.orderChiliBtn);
        final Intent intent = new Intent(getActivity(), MainActivity.class);
        final String[] orderItemsString = {intent.getStringExtra(ORDER_ITEMS)};
        final String[] orderItemsCostsString = {intent.getStringExtra(ORDER_ITEMSCOST)};
        final String[] orderItemsCustomString = {intent.getStringExtra(ORDER_ITEMSCUSTOM)};
        //sets up the number picker for the chili type
        chiliType.setMaxValue(3);
        chiliType.setMinValue(0);
        final String[] chiliArray = {"3-Way Chili", "4-Way Chili", "5-Way Chili", "7-Way Chili"};
        chiliType.setDisplayedValues(chiliArray);
        final double[] costList = {2.99, 3.49, 3.99, 4.49};
        final String[] costListStrings = {"2.99", "3.49", "3.99", "4.49"};

        //adds chili to the order by getting the number picker value
        orderChili.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderItemsString[0] = chiliArray[chiliType.getValue()];
                intent.putExtra((ORDER_ITEMS), orderItemsString[0]);
                orderItemsCostsString[0] = costListStrings[chiliType.getValue()];
                intent.putExtra((ORDER_ITEMSCOST), orderItemsCostsString[0]);
                orderItemsCustomString[0] = "";
                intent.putExtra((ORDER_ITEMSCUSTOM), orderItemsCustomString[0]);
                MainActivity.orderList.add(new OrderItems(chiliArray[chiliType.getValue()], costList[chiliType.getValue()], " "));
                Log.d("Chili", String.valueOf(MainActivity.orderList.get(MainActivity.orderList.size()-1)));
            }
        });


        return root;
    }
}