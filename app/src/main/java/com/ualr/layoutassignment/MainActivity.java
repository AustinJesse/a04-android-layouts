package com.ualr.layoutassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;


public class MainActivity extends AppCompatActivity {
    private Button calculateBtn;
    private MaterialButton DiscountBtn;
    private TextInputEditText productValue;
    private CheckBox product1;
    private CheckBox product2;
    private CheckBox product3;
    private CheckBox product4;

    private TextView totalMoney;


    // TODO 02. Create a new method called "calculateTotal" for calculating the invoice's total amount of money

    // TODO 03. Bind the "calculateTotal" method to the button with the "CALCULATE TOTAL" label

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

        this.calculateBtn = findViewById(R.id.button_cal);
        this.DiscountBtn = findViewById(R.id.Discount);
        this.product1 = findViewById(R.id.checkBox);
        this.product2 = findViewById(R.id.checkBox2);
        this.product3 = findViewById(R.id.checkBox3);
        this.product4 = findViewById(R.id.checkBox4);
        this.totalMoney = findViewById(R.id.textView5);

        this.calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateTotal();
                //Log.d("total", "Works");
            }
        });
    }



    // TODO 02. Create a new method called "calculateTotal" for calculating the invoice's total amount of money

    // TODO 03. Bind the "calculateTotal" method to the button with the "CALCULATE TOTAL" label

    private void calculateTotal(){
        float moneyDue = 0;
        String moneyString;

        if (product1.isChecked()){
            this.productValue = findViewById(R.id.text1);
            moneyString = productValue.getText().toString();
            moneyDue += Float.parseFloat(moneyString);
        }
        if (product2.isChecked()){
            this.productValue = findViewById(R.id.text2);
            moneyString = productValue.getText().toString();
            moneyDue += Float.parseFloat(moneyString);
        }
        if (product3.isChecked()){
            this.productValue = findViewById(R.id.text3);
            moneyString = productValue.getText().toString();
            moneyDue += Float.parseFloat(moneyString);
        }
        if (product4.isChecked()){
            this.productValue = findViewById(R.id.text4);
            moneyString = productValue.getText().toString();
            moneyDue += Float.parseFloat(moneyString);
        }

        if (DiscountBtn.isChecked()){
            moneyDue *= .50;
        }

        String totalMoneyDue = String.format("Total: $%.2f", moneyDue);
        //https://stackoverflow.com/questions/12627457/format-statement-in-a-string-resource-file

        totalMoney.setText(totalMoneyDue);


    }
}