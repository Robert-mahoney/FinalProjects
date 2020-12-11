package com.example.gdritzysfinal.ui.specialties;

import android.content.Intent;
import android.os.Bundle;
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

public class SpecialtiesFragment extends Fragment{
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_specialties, container, false);
        //how to change layout visibility https://stackoverflow.com/questions/3465841/how-to-change-visibility-of-layout-programmatically
        final LinearLayout specialMainLay = root.findViewById(R.id.specialMainlayout);
        final LinearLayout fryLay = root.findViewById(R.id.frySpec);
        final LinearLayout vegetableLay = root.findViewById(R.id.vegetableSpec);
        ImageButton frySpecial = root.findViewById(R.id.fryBtn);
        ImageButton vegetableSpecial = root.findViewById(R.id.vegetablesBtn);
        Button specialHome = root.findViewById(R.id.specialHomeBtn);
        //checkbox for adding cheese only on the vegetables
        final CheckBox addCheese = root.findViewById(R.id.addCheese);
        //buttons to order items
        Button frySpecialOrder = root.findViewById(R.id.frySpecOrderBtn);
        Button vegetableSpecialOrder = root.findViewById(R.id.vegetableSpecOrderBtn);
        final Intent intent = new Intent(getActivity(), MainActivity.class);
        final String[] orderItemsString = {intent.getStringExtra(ORDER_ITEMS)};
        final String[] orderItemsCostsString = {intent.getStringExtra(ORDER_ITEMSCOST)};
        final String[] orderItemsCustomString = {intent.getStringExtra(ORDER_ITEMSCUSTOM)};
        //buttons to navigate through the layouts
        frySpecial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                specialMainLay.setVisibility(view.GONE);
                fryLay.setVisibility(view.VISIBLE);
            }
        });
        vegetableSpecial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                specialMainLay.setVisibility(view.GONE);
                vegetableLay.setVisibility(view.VISIBLE);
            }
        });

        specialHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                specialMainLay.setVisibility(view.VISIBLE);
                vegetableLay.setVisibility(view.GONE);
                fryLay.setVisibility(view.GONE);
            }
        });

        //buttons to add the items to the order
        frySpecialOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderItemsString[0] = "Shoestring Fries";
                intent.putExtra((ORDER_ITEMS), orderItemsString[0]);
                orderItemsCostsString[0] = "1.99";
                intent.putExtra((ORDER_ITEMSCOST), orderItemsCostsString[0]);
                orderItemsCustomString[0] = " ";
                intent.putExtra((ORDER_ITEMSCUSTOM), orderItemsCustomString[0]);
                MainActivity.orderList.add(new OrderItems("Shoestring Fries", 1.99, " "));
            }
        });

        vegetableSpecialOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderItemsString[0] = "Steamed Vegetables";
                intent.putExtra((ORDER_ITEMS), orderItemsString[0]);
                orderItemsCostsString[0] = "1.99";
                intent.putExtra((ORDER_ITEMSCOST), orderItemsCostsString[0]);
                String custom = " ";
                //checks if the cheese checkbox is checked
                if (addCheese.isChecked()){custom = "Cheese";}
                orderItemsCustomString[0] = custom;
                intent.putExtra((ORDER_ITEMSCUSTOM), orderItemsCustomString[0]);
                MainActivity.orderList.add(new OrderItems("Steamed Vegetables", 1.99, custom));
            }
        });

        return root;
    }
}
