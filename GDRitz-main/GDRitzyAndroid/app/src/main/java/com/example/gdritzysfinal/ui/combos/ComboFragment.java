package com.example.gdritzysfinal.ui.combos;

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

public class ComboFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_combos, container, false);
        //how to change layout visibility https://stackoverflow.com/questions/3465841/how-to-change-visibility-of-layout-programmatically
        //set up the layouts to scroll through the different items
        final LinearLayout comboMainLay = root.findViewById(R.id.comboMainlayout);
        final LinearLayout singleRitzLay = root.findViewById(R.id.singleRitzCombo);
        final LinearLayout doubleRitzLay = root.findViewById(R.id.doubleRitzCombo);
        final LinearLayout hotdogLay = root.findViewById(R.id.hotdogCombo);
        final LinearLayout chickenLay = root.findViewById(R.id.chickenCombo);
        final LinearLayout coolDealLay = root.findViewById(R.id.coolDealCombo);
        final LinearLayout itzyRitzyLay = root.findViewById(R.id.itzyRitzyCombo);
        final LinearLayout burgerToppingsLay = root.findViewById(R.id.burgerToppingsLay);
        final LinearLayout hotdogToppingsLay = root.findViewById(R.id.hotdogToppingsLay);
        //buttons to navigate to the item orders
        ImageButton singleRitzCombo = root.findViewById(R.id.singleRitzBtn);
        ImageButton doubleRitzCombo = root.findViewById(R.id.doubleRitzBtn);
        ImageButton hotdogCombo = root.findViewById(R.id.hotdogBtn);
        ImageButton chickenCombo = root.findViewById(R.id.chickenBtn);
        ImageButton coolDealCombo = root.findViewById(R.id.coolDealBtn);
        final ImageButton itzyRitzyCombo = root.findViewById(R.id.itzyRitzyBtn);
        Button comboHome = root.findViewById(R.id.comboHomeBtn);
        //buttons to be used to order each individual item
        Button singleRitzComboOrder = root.findViewById(R.id.singleRitzComboOrderBtn);
        Button doubleRitzComboOrder = root.findViewById(R.id.doubleRitzComboOrderBtn);
        Button hotdogComboOrder = root.findViewById(R.id.hotdogComboOrderBtn);
        Button chickenComboOrder = root.findViewById(R.id.chickenComboOrderBtn);
        Button coolDealComboOrder = root.findViewById(R.id.coolDealComboOrderBtn);
        Button itzyRitzyComboOrder = root.findViewById(R.id.itzyRitzyComboOrderBtn);
        //checkboxes for the hamburgers and chicken sandwich toppings
        final CheckBox burgerCheeseCheck = root.findViewById(R.id.cheeseCheck);
        final CheckBox burgerTomatoesCheck = root.findViewById(R.id.tomatoesCheck);
        final CheckBox burgerBaconCheck = root.findViewById(R.id.baconCheck);
        final CheckBox burgerMayoCheck = root.findViewById(R.id.mayoCheck);
        final CheckBox burgerKetchupCheck = root.findViewById(R.id.ketchupCheck);
        final CheckBox burgerMustardCheck = root.findViewById(R.id.mustardCheck);
        final CheckBox burgerPicklesCheck = root.findViewById(R.id.picklesCheck);
        final CheckBox burgerOnionsCheck = root.findViewById(R.id.onionsCheck);
        final CheckBox burgerLettuceCheck = root.findViewById(R.id.lettuceCheck);
        //checkboxes for the hotdog toppings
        final CheckBox hotdogKetchupCheck = root.findViewById(R.id.ketchupCheckHD);
        final CheckBox hotdogMustardCheck = root.findViewById(R.id.mustardCheckHD);
        final CheckBox hotdogRelishCheck = root.findViewById(R.id.relishCheckHD);
        final CheckBox hotdogOnionCheck = root.findViewById(R.id.onionCheckHD);
        final CheckBox hotdogSauerkrautCheck = root.findViewById(R.id.sauerkrautCheckHD);
        final CheckBox hotdogChiliCheck = root.findViewById(R.id.chiliCheckHD);
        final CheckBox hotdogCheeseCheck = root.findViewById(R.id.cheeseCheckHD);

        final Intent intent = new Intent(getActivity(), MainActivity.class);
        final String[] orderItemsString = {intent.getStringExtra(ORDER_ITEMS)};
        final String[] orderItemsCostsString = {intent.getStringExtra(ORDER_ITEMSCOST)};
        final String[] orderItemsCustomString = {intent.getStringExtra(ORDER_ITEMSCUSTOM)};


        //these buttons change the visibilities of the layouts to allow the user to access the item order layouts
        singleRitzCombo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comboMainLay.setVisibility(view.GONE);
                singleRitzLay.setVisibility(view.VISIBLE);
                burgerToppingsLay.setVisibility((view.VISIBLE));
            }
        });
        doubleRitzCombo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comboMainLay.setVisibility(view.GONE);
                doubleRitzLay.setVisibility(view.VISIBLE);
                burgerToppingsLay.setVisibility((view.VISIBLE));
            }
        });
        hotdogCombo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comboMainLay.setVisibility(view.GONE);
                hotdogLay.setVisibility(view.VISIBLE);
                hotdogToppingsLay.setVisibility(view.VISIBLE);
            }
        });
        chickenCombo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comboMainLay.setVisibility(view.GONE);
                chickenLay.setVisibility(view.VISIBLE);
                burgerToppingsLay.setVisibility((view.VISIBLE));
            }
        });
        coolDealCombo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comboMainLay.setVisibility(view.GONE);
                coolDealLay.setVisibility(view.VISIBLE);
                burgerToppingsLay.setVisibility((view.VISIBLE));
            }
        });
         itzyRitzyCombo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comboMainLay.setVisibility(view.GONE);
                itzyRitzyLay.setVisibility(view.VISIBLE);
                burgerToppingsLay.setVisibility((view.VISIBLE));
            }
        });
         //returns to the main combo screen
        comboHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comboMainLay.setVisibility(view.VISIBLE);
                singleRitzLay.setVisibility(view.GONE);
                doubleRitzLay.setVisibility(view.GONE);
                hotdogLay.setVisibility(view.GONE);
                chickenLay.setVisibility(view.GONE);
                coolDealLay.setVisibility(view.GONE);
                itzyRitzyLay.setVisibility(view.GONE);
                burgerToppingsLay.setVisibility(view.GONE);
                hotdogToppingsLay.setVisibility(view.GONE);
            }
        });

        //uses the order buttons to add the items to the orders
        singleRitzComboOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Log.d("Test", "single button click");
                orderItemsString[0] = "Single Ritz Combo";
                intent.putExtra((ORDER_ITEMS), orderItemsString[0]);
                orderItemsCostsString[0] = "4.99";
                intent.putExtra((ORDER_ITEMSCOST), orderItemsCostsString[0]);
                orderItemsCustomString[0] = "cheese"; //getBurgerToppings(burgerCheeseCheck, burgerTomatoesCheck, burgerBaconCheck, burgerMayoCheck, burgerKetchupCheck, burgerMustardCheck, burgerPicklesCheck, burgerOnionsCheck, burgerLettuceCheck);
                String custom = getBurgerToppings(burgerCheeseCheck, burgerTomatoesCheck, burgerBaconCheck, burgerMayoCheck, burgerKetchupCheck, burgerMustardCheck, burgerPicklesCheck, burgerOnionsCheck, burgerLettuceCheck);
                intent.putExtra((ORDER_ITEMSCUSTOM), orderItemsCustomString[0]);
                //Log.d("Test", "Passed intent in combo fragment");
                //Log.d("Test", "Gallery " + orderItemsString[0]);
                OrderItems singleCombo = new OrderItems("Single Ritz Combo", 4.99, custom);
                MainActivity.addItem(singleCombo);
                Log.d("Combo", String.valueOf(MainActivity.orderList.get(MainActivity.orderList.size()-1)));
                //Log.d("Gallery Fragmnet", singleCombo.toString());
                //Log.d("Gallery Fragment", String.valueOf(MainActivity.getItems()));
            }
        });

        doubleRitzComboOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("Test", "single button click");
                orderItemsString[0] = "Double Ritz Combo";
                intent.putExtra((ORDER_ITEMS), orderItemsString[0]);
                orderItemsCostsString[0] = "5.99";
                intent.putExtra((ORDER_ITEMSCOST), orderItemsCostsString[0]);
                orderItemsCustomString[0] = getBurgerToppings(burgerCheeseCheck, burgerTomatoesCheck, burgerBaconCheck, burgerMayoCheck, burgerKetchupCheck, burgerMustardCheck, burgerPicklesCheck, burgerOnionsCheck, burgerLettuceCheck);
                String custom = getBurgerToppings(burgerCheeseCheck, burgerTomatoesCheck, burgerBaconCheck, burgerMayoCheck, burgerKetchupCheck, burgerMustardCheck, burgerPicklesCheck, burgerOnionsCheck, burgerLettuceCheck);
                intent.putExtra((ORDER_ITEMSCUSTOM), orderItemsCustomString[0]);
                Log.d("Test", "Passed intent in combo fragment");
                MainActivity.orderList.add(new OrderItems("Double Ritz Combo", 5.99, custom));
                Log.d("Combo", String.valueOf(MainActivity.orderList.get(MainActivity.orderList.size()-1)));
            }
        });

        hotdogComboOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderItemsString[0] = "Hot Dog Combo";
                intent.putExtra((ORDER_ITEMS), orderItemsString[0]);
                orderItemsCostsString[0] = "5.99";
                intent.putExtra((ORDER_ITEMSCOST), orderItemsCostsString[0]);
                orderItemsCustomString[0] = getHotDogToppings(hotdogKetchupCheck, hotdogMustardCheck, hotdogRelishCheck, hotdogOnionCheck, hotdogSauerkrautCheck, hotdogChiliCheck, hotdogCheeseCheck);
                String custom = getHotDogToppings(hotdogKetchupCheck, hotdogMustardCheck, hotdogRelishCheck, hotdogOnionCheck, hotdogSauerkrautCheck, hotdogChiliCheck, hotdogCheeseCheck);
                intent.putExtra((ORDER_ITEMSCUSTOM), orderItemsCustomString[0]);
                MainActivity.orderList.add(new OrderItems("Hot Dog Combo", 3.99, custom));
                Log.d("Combo", String.valueOf(MainActivity.orderList.get(MainActivity.orderList.size()-1)));
            }
        });

        chickenComboOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderItemsString[0] = "Chicken Sandwich Combo";
                intent.putExtra((ORDER_ITEMS), orderItemsString[0]);
                orderItemsCostsString[0] = "4.99";
                intent.putExtra((ORDER_ITEMSCOST), orderItemsCostsString[0]);
                orderItemsCustomString[0] = getBurgerToppings(burgerCheeseCheck, burgerTomatoesCheck, burgerBaconCheck, burgerMayoCheck, burgerKetchupCheck, burgerMustardCheck, burgerPicklesCheck, burgerOnionsCheck, burgerLettuceCheck);
                String custom = getBurgerToppings(burgerCheeseCheck, burgerTomatoesCheck, burgerBaconCheck, burgerMayoCheck, burgerKetchupCheck, burgerMustardCheck, burgerPicklesCheck, burgerOnionsCheck, burgerLettuceCheck);
                intent.putExtra((ORDER_ITEMSCUSTOM), orderItemsCustomString[0]);
                MainActivity.orderList.add(new OrderItems("Chicken Sandwich Combo", 4.99, custom));
                Log.d("Combo", String.valueOf(MainActivity.orderList.get(MainActivity.orderList.size()-1)));
            }
        });

        coolDealComboOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderItemsString[0] = "Cool Deal Combo";
                intent.putExtra((ORDER_ITEMS), orderItemsString[0]);
                orderItemsCostsString[0] = "6.99";
                intent.putExtra((ORDER_ITEMSCOST), orderItemsCostsString[0]);
                orderItemsCustomString[0] = getBurgerToppings(burgerCheeseCheck, burgerTomatoesCheck, burgerBaconCheck, burgerMayoCheck, burgerKetchupCheck, burgerMustardCheck, burgerPicklesCheck, burgerOnionsCheck, burgerLettuceCheck);
                String custom = getBurgerToppings(burgerCheeseCheck, burgerTomatoesCheck, burgerBaconCheck, burgerMayoCheck, burgerKetchupCheck, burgerMustardCheck, burgerPicklesCheck, burgerOnionsCheck, burgerLettuceCheck);
                intent.putExtra((ORDER_ITEMSCUSTOM), orderItemsCustomString[0]);
                MainActivity.orderList.add(new OrderItems("Cool Deal Combo", 6.99, custom));
                Log.d("Combo", String.valueOf(MainActivity.orderList.get(MainActivity.orderList.size()-1)));
            }
        });

        itzyRitzyComboOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderItemsString[0] = "Itzy Ritzy Combo";
                intent.putExtra((ORDER_ITEMS), orderItemsString[0]);
                orderItemsCostsString[0] = "3.99";
                intent.putExtra((ORDER_ITEMSCOST), orderItemsCostsString[0]);
                orderItemsCustomString[0] = getBurgerToppings(burgerCheeseCheck, burgerTomatoesCheck, burgerBaconCheck, burgerMayoCheck, burgerKetchupCheck, burgerMustardCheck, burgerPicklesCheck, burgerOnionsCheck, burgerLettuceCheck);
                String custom = getBurgerToppings(burgerCheeseCheck, burgerTomatoesCheck, burgerBaconCheck, burgerMayoCheck, burgerKetchupCheck, burgerMustardCheck, burgerPicklesCheck, burgerOnionsCheck, burgerLettuceCheck);
                intent.putExtra((ORDER_ITEMSCUSTOM), orderItemsCustomString[0]);
                MainActivity.orderList.add(new OrderItems("Itzy Ritzy Combo", 3.99, custom));
                Log.d("Combo", String.valueOf(MainActivity.orderList.get(MainActivity.orderList.size()-1)));
            }
        });




        return root;
    }

    //this function returns a string for the toppings on the burgers
    public String getBurgerToppings(CheckBox bCC, CheckBox bTC, CheckBox bBC, CheckBox bMC, CheckBox bKC, CheckBox bMC2, CheckBox bPC, CheckBox bOC, CheckBox bLC ){
        String custom = "";
        if(bCC.isChecked()){custom += "Cheese, ";}
        if(bTC.isChecked()){custom += "Tomatoes, ";}
        if(bBC.isChecked()){custom+= "Bacon, ";}
        if(bMC.isChecked()){custom+= "Mayo, ";}
        if(bKC.isChecked()){custom+= "Ketchup, ";}
        if(bMC2.isChecked()){custom += "Mustard, ";}
        if(bPC.isChecked()){custom += "Pickles, ";}
        if(bOC.isChecked()){custom += "Onions, ";}
        if(bLC.isChecked()){custom += "Lettuce, ";}
        return custom;
    }

    //this function returns a string for the toppins on the hotdogs
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