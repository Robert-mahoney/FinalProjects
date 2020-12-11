package com.example.gdritzysfinal.ui.sandwiches;

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

public class SandwichFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_sandwiches, container, false);
        //layouts for navigation
        final LinearLayout comboMainLay = root.findViewById(R.id.sandwichMainlayout);
        final LinearLayout cheeseBurgerLay = root.findViewById(R.id.cheeseBurgerSand);
        final LinearLayout doubleRitzLay = root.findViewById(R.id.doubleRitzSand);
        final LinearLayout fishLay = root.findViewById(R.id.fishSand);
        final LinearLayout chickenLay = root.findViewById(R.id.chickenSand);
        final LinearLayout pbjLay = root.findViewById(R.id.pbjSand);
        final LinearLayout burgerToppings = root.findViewById(R.id.burgerToppingsLay);
        //buttons to navigate through items
        ImageButton cheeseBurgerSand = root.findViewById(R.id.cheeseBurgerBtn);
        ImageButton doubleRitzSand = root.findViewById(R.id.doubleRitzBtn);
        ImageButton fishSand = root.findViewById(R.id.fishBtn);
        ImageButton chickenSand = root.findViewById(R.id.chickenBtn);
        ImageButton pbjSand = root.findViewById(R.id.pbjBtn);
        Button sandwichHome = root.findViewById(R.id.sandwichHomeBtn);
        //buttons to add items to order
        Button burgerOrderBtn = root.findViewById(R.id.burgerSandOrderBtn);
        Button doubleRitzOrderBtn = root.findViewById(R.id.doubleRitzSandOrderBtn);
        Button fishOrderBtn = root.findViewById(R.id.fishSandOrderBtn);
        Button chickenOrderBtn = root.findViewById(R.id.chickenSandOrderBtn);
        Button pbjOrderBtn = root.findViewById(R.id.pbjSandOrderBtn);
        //checkboxes for the hamburgers and chicken sandwich toppings
        final CheckBox burgerCheeseCheck = root.findViewById(R.id.cheeseCheck);
        final CheckBox burgerTomatoesCheck = root.findViewById(R.id.tomatoeCheck);
        final CheckBox burgerBaconCheck = root.findViewById(R.id.baconCheck);
        final CheckBox burgerMayoCheck = root.findViewById(R.id.mayoCheck);
        final CheckBox burgerKetchupCheck = root.findViewById(R.id.ketchupCheck);
        final CheckBox burgerMustardCheck = root.findViewById(R.id.mustardCheck);
        final CheckBox burgerPicklesCheck = root.findViewById(R.id.picklesCheck);
        final CheckBox burgerOnionsCheck = root.findViewById(R.id.onionsCheck);
        final CheckBox burgerLettuceCheck = root.findViewById(R.id.lettuceCheck);

        final Intent intent = new Intent(getActivity(), MainActivity.class);
        final String[] orderItemsString = {intent.getStringExtra(ORDER_ITEMS)};
        final String[] orderItemsCostsString = {intent.getStringExtra(ORDER_ITEMSCOST)};
        final String[] orderItemsCustomString = {intent.getStringExtra(ORDER_ITEMSCUSTOM)};

        //onclick listeners to scroll through the pages
        cheeseBurgerSand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comboMainLay.setVisibility(view.GONE);
                cheeseBurgerLay.setVisibility(view.VISIBLE);
                burgerToppings.setVisibility(view.VISIBLE);
            }
        });
        doubleRitzSand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comboMainLay.setVisibility(view.GONE);
                doubleRitzLay.setVisibility(view.VISIBLE);
                burgerToppings.setVisibility(view.VISIBLE);
            }
        });
        fishSand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comboMainLay.setVisibility(view.GONE);
                fishLay.setVisibility(view.VISIBLE);
                burgerToppings.setVisibility(view.VISIBLE);
            }
        });
        chickenSand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comboMainLay.setVisibility(view.GONE);
                chickenLay.setVisibility(view.VISIBLE);
                burgerToppings.setVisibility(view.VISIBLE);
            }
        });
        pbjSand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comboMainLay.setVisibility(view.GONE);
                pbjLay.setVisibility(view.VISIBLE);
            }
        });

        sandwichHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comboMainLay.setVisibility(view.VISIBLE);
                cheeseBurgerLay.setVisibility(view.GONE);
                doubleRitzLay.setVisibility(view.GONE);
                fishLay.setVisibility(view.GONE);
                chickenLay.setVisibility(view.GONE);
                pbjLay.setVisibility(view.GONE);
                burgerToppings.setVisibility(view.GONE);
            }
        });
        //buttons to add items to the order
        burgerOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderItemsString[0] = "Burger";
                intent.putExtra((ORDER_ITEMS), orderItemsString[0]);
                orderItemsCostsString[0] = "2.99";
                intent.putExtra((ORDER_ITEMSCOST), orderItemsCostsString[0]);
                orderItemsCustomString[0] = getBurgerToppings(burgerCheeseCheck, burgerTomatoesCheck, burgerBaconCheck, burgerMayoCheck, burgerKetchupCheck, burgerMustardCheck, burgerPicklesCheck, burgerOnionsCheck, burgerLettuceCheck);
                String customItem = getBurgerToppings(burgerCheeseCheck, burgerTomatoesCheck, burgerBaconCheck, burgerMayoCheck, burgerKetchupCheck, burgerMustardCheck, burgerPicklesCheck, burgerOnionsCheck, burgerLettuceCheck);
                intent.putExtra((ORDER_ITEMSCUSTOM), orderItemsCustomString[0]);
                MainActivity.orderList.add(new OrderItems("Cheese Burger", 2.99, customItem));
                Log.d("Sandwich", String.valueOf(MainActivity.orderList.get(MainActivity.orderList.size()-1)));
            }
        });

        doubleRitzOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderItemsString[0] = "Double Ritz Burger";
                intent.putExtra((ORDER_ITEMS), orderItemsString[0]);
                orderItemsCostsString[0] = "3.99";
                intent.putExtra((ORDER_ITEMSCOST), orderItemsCostsString[0]);
                orderItemsCustomString[0] = getBurgerToppings(burgerCheeseCheck, burgerTomatoesCheck, burgerBaconCheck, burgerMayoCheck, burgerKetchupCheck, burgerMustardCheck, burgerPicklesCheck, burgerOnionsCheck, burgerLettuceCheck);
                String customItem = getBurgerToppings(burgerCheeseCheck, burgerTomatoesCheck, burgerBaconCheck, burgerMayoCheck, burgerKetchupCheck, burgerMustardCheck, burgerPicklesCheck, burgerOnionsCheck, burgerLettuceCheck);
                intent.putExtra((ORDER_ITEMSCUSTOM), orderItemsCustomString[0]);
                MainActivity.orderList.add(new OrderItems("Double Ritz Burger", 3.99, customItem));
            }
        });

        fishOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderItemsString[0] = "Fish Sandwich";
                intent.putExtra((ORDER_ITEMS), orderItemsString[0]);
                orderItemsCostsString[0] = "2.99";
                intent.putExtra((ORDER_ITEMSCOST), orderItemsCostsString[0]);
                orderItemsCustomString[0] = getBurgerToppings(burgerCheeseCheck, burgerTomatoesCheck, burgerBaconCheck, burgerMayoCheck, burgerKetchupCheck, burgerMustardCheck, burgerPicklesCheck, burgerOnionsCheck, burgerLettuceCheck);
                String customItem = getBurgerToppings(burgerCheeseCheck, burgerTomatoesCheck, burgerBaconCheck, burgerMayoCheck, burgerKetchupCheck, burgerMustardCheck, burgerPicklesCheck, burgerOnionsCheck, burgerLettuceCheck);
                intent.putExtra((ORDER_ITEMSCUSTOM), orderItemsCustomString[0]);
                MainActivity.orderList.add(new OrderItems("Double Ritz Combo", 2.99, customItem));
                Log.d("Sandwich", String.valueOf(MainActivity.orderList.get(MainActivity.orderList.size()-1)));
            }
        });

        chickenOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderItemsString[0] = "Chicken Sandwich";
                intent.putExtra((ORDER_ITEMS), orderItemsString[0]);
                orderItemsCostsString[0] = "2.99";
                intent.putExtra((ORDER_ITEMSCOST), orderItemsCostsString[0]);
                orderItemsCustomString[0] = getBurgerToppings(burgerCheeseCheck, burgerTomatoesCheck, burgerBaconCheck, burgerMayoCheck, burgerKetchupCheck, burgerMustardCheck, burgerPicklesCheck, burgerOnionsCheck, burgerLettuceCheck);
                String customItem = getBurgerToppings(burgerCheeseCheck, burgerTomatoesCheck, burgerBaconCheck, burgerMayoCheck, burgerKetchupCheck, burgerMustardCheck, burgerPicklesCheck, burgerOnionsCheck, burgerLettuceCheck);
                intent.putExtra((ORDER_ITEMSCUSTOM), orderItemsCustomString[0]);
                MainActivity.orderList.add(new OrderItems("Chicken Sandwich", 2.99, customItem));
                Log.d("Sandwich", String.valueOf(MainActivity.orderList.get(MainActivity.orderList.size()-1)));
            }
        });

        pbjOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderItemsString[0] = "Double Ritz Combo";
                intent.putExtra((ORDER_ITEMS), orderItemsString[0]);
                orderItemsCostsString[0] = "1.99";
                intent.putExtra((ORDER_ITEMSCOST), orderItemsCostsString[0]);
                orderItemsCustomString[0] = "";
                intent.putExtra((ORDER_ITEMSCUSTOM), orderItemsCustomString[0]);
                MainActivity.orderList.add(new OrderItems("PB and J Sandwich", 1.99, " "));
                Log.d("Sandwich", String.valueOf(MainActivity.orderList.get(MainActivity.orderList.size()-1)));
            }
        });
        return root;
    }

    //function to return a string of toppings to the burger
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
}