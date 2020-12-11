package com.example.gdritzysfinal.ui.salads;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.gdritzysfinal.MainActivity;
import com.example.gdritzysfinal.OrderItems;
import com.example.gdritzysfinal.R;

import static com.example.gdritzysfinal.ListToPass.ORDER_ITEMS;
import static com.example.gdritzysfinal.ListToPass.ORDER_ITEMSCOST;
import static com.example.gdritzysfinal.ListToPass.ORDER_ITEMSCUSTOM;

public class SaladsFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_salads, container, false);
        //how to change layout visibility https://stackoverflow.com/questions/3465841/how-to-change-visibility-of-layout-programmatically
        final LinearLayout saladMainLay = root.findViewById(R.id.saladMainlayout);
        final LinearLayout choiceGardenLay = root.findViewById(R.id.choiceGardenSalad);
        final LinearLayout deluxeGardenLay = root.findViewById(R.id.deluxeGardenSalad);
        final LinearLayout sideLay = root.findViewById(R.id.sideSalad);
        final LinearLayout tacoLay = root.findViewById(R.id.tacoSalad);
        final LinearLayout chickenLay = root.findViewById(R.id.chickenSalad);
        final LinearLayout dressingLay = root.findViewById(R.id.dressingLayout);
        //image buttons for navigation
        ImageButton choiceGardenSalad = root.findViewById(R.id.choiceSaladBtn);
        ImageButton deluxeGardenSalad = root.findViewById(R.id.deluxeSaladBtn);
        ImageButton sideSalad = root.findViewById(R.id.sideSaladBtn);
        ImageButton tacoSalad = root.findViewById(R.id.tacoSaladBtn);
        ImageButton chickenSalad = root.findViewById(R.id.chickenSaladBtn);
        Button saladHome = root.findViewById(R.id.saladHomeBtn);
        //buttons to order items
        Button choiceGardenSaladOrder = root.findViewById(R.id.choiceOrderBtn);
        Button deluxeGardenSaladOrder = root.findViewById(R.id.deluxeOrderBtn);
        Button sideSaladOrder = root.findViewById(R.id.sideOrderBtn);
        Button tacoSaladOrder = root.findViewById(R.id.tacoOrderBtn);
        Button chickenSaladOrder = root.findViewById(R.id.chickenSaladOrderBtn);
        final NumberPicker dressingPick = root.findViewById(R.id.dressingSelect);

        final Intent intent = new Intent(getActivity(), MainActivity.class);
        final String[] orderItemsString = {intent.getStringExtra(ORDER_ITEMS)};
        final String[] orderItemsCostsString = {intent.getStringExtra(ORDER_ITEMSCOST)};
        final String[] orderItemsCustomString = {intent.getStringExtra(ORDER_ITEMSCUSTOM)};
        //sets up the number picker for the dressing on the salad
        dressingPick.setMaxValue(5);
        dressingPick.setMinValue(0);
        final String[] dressings = {"Buttermilk Ranch", "Fat Free Ranch", "Light Italian", "Fat Free California French", "Thousand Island", "Dijon Honey Mustard"};
        dressingPick.setDisplayedValues(dressings);
        //buttons to change the layouts to access the individual item orders
        choiceGardenSalad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saladMainLay.setVisibility(view.GONE);
                choiceGardenLay.setVisibility(view.VISIBLE);
                dressingLay.setVisibility(view.VISIBLE);
            }
        });
        deluxeGardenSalad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saladMainLay.setVisibility(view.GONE);
                deluxeGardenLay.setVisibility(view.VISIBLE);
                dressingLay.setVisibility(view.VISIBLE);
            }
        });
        sideSalad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saladMainLay.setVisibility(view.GONE);
                sideLay.setVisibility(view.VISIBLE);
                dressingLay.setVisibility(view.VISIBLE);
            }
        });
        tacoSalad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saladMainLay.setVisibility(view.GONE);
                tacoLay.setVisibility(view.VISIBLE);
                dressingLay.setVisibility(view.VISIBLE);
            }
        });
        chickenSalad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saladMainLay.setVisibility(view.GONE);
                chickenLay.setVisibility(view.VISIBLE);
                dressingLay.setVisibility(View.VISIBLE);
            }
        });

        //return to the main salad screen
        saladHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saladMainLay.setVisibility(view.VISIBLE);
                choiceGardenLay.setVisibility(view.GONE);
                deluxeGardenLay.setVisibility(view.GONE);
                sideLay.setVisibility(view.GONE);
                chickenLay.setVisibility(view.GONE);
                tacoLay.setVisibility(view.GONE);
                dressingLay.setVisibility(view.GONE);
            }
        });

        //buttons to add the items to the order
        choiceGardenSaladOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderItemsString[0] = "Choice Garden Salad";
                intent.putExtra((ORDER_ITEMS), orderItemsString[0]);
                orderItemsCostsString[0] = "3.99";
                intent.putExtra((ORDER_ITEMSCOST), orderItemsCostsString[0]);
                orderItemsCustomString[0] = dressings[dressingPick.getValue()];
                intent.putExtra((ORDER_ITEMSCUSTOM), orderItemsCustomString[0]);
                MainActivity.orderList.add(new OrderItems("Choice Garden Salad", 3.99, dressings[dressingPick.getValue()]));
                Log.d("Salad", String.valueOf(MainActivity.orderList.get(MainActivity.orderList.size()-1)));
            }
        });

        deluxeGardenSaladOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderItemsString[0] = "Deluxe Garden Salad";
                intent.putExtra((ORDER_ITEMS), orderItemsString[0]);
                orderItemsCostsString[0] = "5.99";
                intent.putExtra((ORDER_ITEMSCOST), orderItemsCostsString[0]);
                orderItemsCustomString[0] = dressings[dressingPick.getValue()];
                intent.putExtra((ORDER_ITEMSCUSTOM), orderItemsCustomString[0]);
                MainActivity.orderList.add(new OrderItems("Deluxe Garden Salad", 5.99, dressings[dressingPick.getValue()]));
                Log.d("Salad", String.valueOf(MainActivity.orderList.get(MainActivity.orderList.size()-1)));
            }
        });

        sideSaladOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderItemsString[0] = "Side Salad";
                intent.putExtra((ORDER_ITEMS), orderItemsString[0]);
                orderItemsCostsString[0] = "1.99";
                intent.putExtra((ORDER_ITEMSCOST), orderItemsCostsString[0]);
                orderItemsCustomString[0] = dressings[dressingPick.getValue()];
                intent.putExtra((ORDER_ITEMSCUSTOM), orderItemsCustomString[0]);
                MainActivity.orderList.add(new OrderItems("Side Salad", 1.99, dressings[dressingPick.getValue()]));
                Log.d("Salad", String.valueOf(MainActivity.orderList.get(MainActivity.orderList.size()-1)));
            }
        });

        tacoSaladOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderItemsString[0] = "Taco Salad";
                intent.putExtra((ORDER_ITEMS), orderItemsString[0]);
                orderItemsCostsString[0] = "4.99";
                intent.putExtra((ORDER_ITEMSCOST), orderItemsCostsString[0]);
                orderItemsCustomString[0] = dressings[dressingPick.getValue()];
                intent.putExtra((ORDER_ITEMSCUSTOM), orderItemsCustomString[0]);
                MainActivity.orderList.add(new OrderItems("Taco Salad", 4.99, dressings[dressingPick.getValue()]));
                Log.d("Salad", String.valueOf(MainActivity.orderList.get(MainActivity.orderList.size()-1)));
            }
        });

        chickenSaladOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderItemsString[0] = "Chicken Garden Salad";
                intent.putExtra((ORDER_ITEMS), orderItemsString[0]);
                orderItemsCostsString[0] = "3.99";
                intent.putExtra((ORDER_ITEMSCOST), orderItemsCostsString[0]);
                orderItemsCustomString[0] = dressings[dressingPick.getValue()];
                intent.putExtra((ORDER_ITEMSCUSTOM), orderItemsCustomString[0]);
                MainActivity.orderList.add(new OrderItems("Choice Garden Salad", 3.99, dressings[dressingPick.getValue()]));
                Log.d("Salad", String.valueOf(MainActivity.orderList.get(MainActivity.orderList.size()-1)));
            }
        });
        return root;
    }
}