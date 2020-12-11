package com.example.gdritzysfinal.ui.hotdogs;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.gdritzysfinal.MainActivity;
import com.example.gdritzysfinal.OrderItems;
import com.example.gdritzysfinal.R;

import static com.example.gdritzysfinal.ListToPass.ORDER_ITEMS;
import static com.example.gdritzysfinal.ListToPass.ORDER_ITEMSCOST;
import static com.example.gdritzysfinal.ListToPass.ORDER_ITEMSCUSTOM;

public class HotdogsFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_hotdogs, container, false);
        //how to change layout visibility https://stackoverflow.com/questions/3465841/how-to-change-visibility-of-layout-programmatically
        final LinearLayout hotdogMainLay = root.findViewById(R.id.hotdogMainlayout);
        final LinearLayout americanDogLay = root.findViewById(R.id.americanDogHD);
        final LinearLayout coneyDogLay = root.findViewById(R.id.coneyDogHD);
        final LinearLayout hotdogToppingsLay = root.findViewById(R.id.hotdogToppingLay);
        ImageButton americanDogHD = root.findViewById(R.id.americanDogBtn);
        ImageButton coneyDogHD = root.findViewById(R.id.coneyDogBtn);
        Button hotdogHome = root.findViewById(R.id.hotdogHomeBtn);
        //buttons for ordering items
        Button hotdogOrder = root.findViewById(R.id.hotdogOrderBtn);
        Button coneyDogOrder = root.findViewById(R.id.coneyDogOrderBtn);
        //checkboxes for the hotdog toppings
        final CheckBox hotdogKetchupCheck = root.findViewById(R.id.ketchupCheck);
        final CheckBox hotdogMustardCheck = root.findViewById(R.id.mustardCheck);
        final CheckBox hotdogRelishCheck = root.findViewById(R.id.relishCheck);
        final CheckBox hotdogOnionCheck = root.findViewById(R.id.onionCheck);
        final CheckBox hotdogSauerkrautCheck = root.findViewById(R.id.sauerkrautCheck);
        final CheckBox hotdogChiliCheck = root.findViewById(R.id.chiliCheck);
        final CheckBox hotdogCheeseCheck = root.findViewById(R.id.cheeseCheck);

        final Intent intent = new Intent(getActivity(), MainActivity.class);
        final String[] orderItemsString = {intent.getStringExtra(ORDER_ITEMS)};
        final String[] orderItemsCostsString = {intent.getStringExtra(ORDER_ITEMSCOST)};
        final String[] orderItemsCustomString = {intent.getStringExtra(ORDER_ITEMSCUSTOM)};

        //buttons to navigate the layouts
        americanDogHD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hotdogMainLay.setVisibility(view.GONE);
                americanDogLay.setVisibility(view.VISIBLE);
                hotdogToppingsLay.setVisibility(view.VISIBLE);
            }
        });
        coneyDogHD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hotdogMainLay.setVisibility(view.GONE);
                coneyDogLay.setVisibility(view.VISIBLE);
                hotdogToppingsLay.setVisibility(view.VISIBLE);
            }
        });

        //returns to the main hot dog screen
        hotdogHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hotdogMainLay.setVisibility(view.VISIBLE);
                americanDogLay.setVisibility(view.GONE);
                coneyDogLay.setVisibility(view.GONE);
                hotdogToppingsLay.setVisibility(view.GONE);
            }
        });

        //buttons to add the hotdogs to the orderitems ArrayList
        hotdogOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("Test", "Hot Dog Button Clicked");
                orderItemsString[0] = orderItemsString[0] +  ", Hot Dog";
                intent.putExtra((ORDER_ITEMS), orderItemsString[0]);
                orderItemsCostsString[0] = "1.99";
                intent.putExtra((ORDER_ITEMSCOST), orderItemsCostsString[0]);
                orderItemsCustomString[0] = getHotDogToppings(hotdogKetchupCheck, hotdogMustardCheck, hotdogRelishCheck, hotdogOnionCheck, hotdogSauerkrautCheck, hotdogChiliCheck, hotdogCheeseCheck);
                String custom = getHotDogToppings(hotdogKetchupCheck, hotdogMustardCheck, hotdogRelishCheck, hotdogOnionCheck, hotdogSauerkrautCheck, hotdogChiliCheck, hotdogCheeseCheck);
                intent.putExtra((ORDER_ITEMSCUSTOM), orderItemsCustomString[0]);
                //Log.d("Test", "Passed intent in hotdog fragment");
                //Log.d("Test", "Hotdogs " + orderItemsString[0]);
                MainActivity.orderList.add(new OrderItems("Hot Dog", 1.99, custom));
                Log.d("Hotdogs", String.valueOf(MainActivity.orderList.get(MainActivity.orderList.size()-1)));
                //MainActivity.orderList.get(1).setCustom("Test");
                //Log.d("Hotdog Fragment", String.valueOf(MainActivity.getItems()));
            }
        });

        coneyDogOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderItemsString[0] = "Coney Dog";
                intent.putExtra((ORDER_ITEMS), orderItemsString[0]);
                orderItemsCostsString[0] = "2.49";
                intent.putExtra((ORDER_ITEMSCOST), orderItemsCostsString[0]);
                orderItemsCustomString[0] = getHotDogToppings(hotdogKetchupCheck, hotdogMustardCheck, hotdogRelishCheck, hotdogOnionCheck, hotdogSauerkrautCheck, hotdogChiliCheck, hotdogCheeseCheck);
                String custom = getHotDogToppings(hotdogKetchupCheck, hotdogMustardCheck, hotdogRelishCheck, hotdogOnionCheck, hotdogSauerkrautCheck, hotdogChiliCheck, hotdogCheeseCheck);
                intent.putExtra((ORDER_ITEMSCUSTOM), orderItemsCustomString[0]);
                MainActivity.orderList.add(new OrderItems("Coney Dog", 2.49, custom));
                Log.d("Hotdogs", String.valueOf(MainActivity.orderList.get(MainActivity.orderList.size()-1)));
            }
        });

        return root;
    }

    //function that returns a string for the hotdog toppings
    public String getHotDogToppings(CheckBox hdKC, CheckBox hdMC, CheckBox hdRC, CheckBox hdOC, CheckBox hdSC, CheckBox hdCHC, CheckBox hdCC){
        String custom = "";
        if(hdKC.isChecked()){custom += "Ketchup, ";}
        if(hdMC.isChecked()){custom += "Mustard, ";}
        if(hdRC.isChecked()){custom+= "Bacon, ";}
        if(hdOC.isChecked()){custom+= "Mayo, ";}
        if(hdSC.isChecked()){custom+= "Ketchup, ";}
        if(hdCHC.isChecked()){custom += "Mustard, ";}
        if(hdCC.isChecked()){custom += "Pickles, ";}

        return custom;
    }
}