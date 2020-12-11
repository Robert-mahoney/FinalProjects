package com.example.gdritzysfinal.ui.checkout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.gdritzysfinal.MainActivity;
import com.example.gdritzysfinal.OrderItems;
import com.example.gdritzysfinal.R;

import org.w3c.dom.Text;

import static android.view.View.GONE;
import static com.example.gdritzysfinal.ListToPass.ORDER_ITEMS;
import static com.example.gdritzysfinal.ListToPass.ORDER_ITEMSCOST;
import static com.example.gdritzysfinal.ListToPass.ORDER_ITEMSCUSTOM;

public class CheckoutFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_checkout, container, false);
        final Intent intent = new Intent(getActivity(), MainActivity.class);
        final String[] orderItemsString = {intent.getStringExtra(ORDER_ITEMS)};
        final String[] orderItemsCostsString = {intent.getStringExtra(ORDER_ITEMSCOST)};
        final String[] orderItemsCustomString = {intent.getStringExtra(ORDER_ITEMSCUSTOM)};
        final TextView orderOutput = root.findViewById(R.id.orderOutput);
        orderOutput.setMovementMethod(new ScrollingMovementMethod());
        final TextView costOutput = root.findViewById(R.id.costOutput);
        final Button finishOrder = root.findViewById(R.id.checkoutBtn);
        final Button placeOrder = root.findViewById(R.id.placeOrderBtn);
        final Button editOrder = root.findViewById(R.id.editOrderBtn);
        final Button removeItem = root.findViewById(R.id.removeItemBtn);
        final Button removeItemBack = root.findViewById(R.id.backBtn);
        final EditText creditNum = root.findViewById(R.id.creditNum);
        final EditText creditDate = root.findViewById(R.id.creditDate);
        final EditText creditCvv = root.findViewById(R.id.creditCVV);
        final EditText itemDelete = root.findViewById(R.id.removeItemNum);
        final LinearLayout placeOrderLay = root.findViewById(R.id.placeOrderLay);
        final LinearLayout editOrderLay = root.findViewById(R.id.editItemsLay);
        Log.d("Test", "Order " + orderItemsString[0]);
        String output = "Checkout: ";
        Double cost = 0.0;
        String costOut = "Total: ";
        Log.d("Checkout", String.valueOf(MainActivity.getItems()));
        int itemNum = 1;
        for(OrderItems i: MainActivity.getItems()){
            output += ("\n" + String.valueOf(itemNum) + " " + i.getItemName() + " " + i.getCustom());
            cost += i.getCost();
            itemNum++;
        }
        orderOutput.setText(output);
        costOut += (String.format("$ %.2f", cost));
        costOutput.setText(costOut);

        //brings up the credit card layout
        finishOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishOrder.setVisibility(GONE);
                editOrder.setVisibility(GONE);
                placeOrderLay.setVisibility(View.VISIBLE);

            }
        });

        //brings up the edit order layout
        editOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishOrder.setVisibility(GONE);
                editOrder.setVisibility(GONE);
                editOrderLay.setVisibility(View.VISIBLE);

            }
        });

        //places the order and clears the order list
        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creditNum.setText("");
                creditDate.setText("");
                creditCvv.setText("");
                MainActivity.orderList.clear();
                placeOrderLay.setVisibility(View.GONE);
                finishOrder.setVisibility(View.VISIBLE);
                editOrder.setVisibility(View.VISIBLE);

            }
        });

        //removes the selected Item from the order then reprints the order layout
        removeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int deleteNum = Integer.valueOf(String.valueOf(itemDelete.getText()));
                if( deleteNum <= MainActivity.orderList.size()-1 ){
                    MainActivity.orderList.remove(deleteNum-1);
                }
                String output = "Checkout: ";
                Double cost = 0.0;
                String costOut = "Total: ";
                int itemNum = 1;
                for(OrderItems i: MainActivity.getItems()){
                    output += ("\n" + String.valueOf(itemNum) + " " + i.getItemName() + " " + i.getCustom());
                    cost += i.getCost();
                    itemNum++;
                }
                orderOutput.setText(output);
                costOut += (String.format("$ %.2f", cost));
                costOutput.setText(costOut);
            }
        });

        //returns to the main checkout screen
        removeItemBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editOrderLay.setVisibility(GONE);
                finishOrder.setVisibility(View.VISIBLE);
                editOrder.setVisibility(View.VISIBLE);
            }
        });
        return root;
    }
}