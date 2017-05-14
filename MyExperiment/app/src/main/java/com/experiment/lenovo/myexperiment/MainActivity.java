package com.experiment.lenovo.myexperiment;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        TextView qt=(TextView)(findViewById(R.id.edittext));
        int q=Integer.parseInt(String.valueOf(qt.getText()));
        int price;
        TextView priceTextView = (TextView) findViewById(R.id.pricetext);
        CheckBox cb1=(CheckBox)findViewById(R.id.whippedcream);
        CheckBox cb2=(CheckBox)findViewById(R.id.chocolatecream);
        EditText ed1=(EditText)findViewById(R.id.name);
        String s="Name: "+ed1.getText()+"\n";
        if(cb1.isChecked() && cb2.isChecked())
        {
            price=q*7;
        }
        else
        {
            if(cb1.isChecked() || cb2.isChecked())
                price=q*6;
            else
                price=q*5;
        }
        String x=s+"Total"+NumberFormat.getCurrencyInstance().format(price)+"\nThank You!!!";
        priceTextView.setText(s+"Total"+NumberFormat.getCurrencyInstance().format(price)+"\nThank You!!!");
    }
    public void mailOrder(View view) {
        TextView qt=(TextView)(findViewById(R.id.edittext));
        int q=Integer.parseInt(String.valueOf(qt.getText()));
        int price;
        TextView priceTextView = (TextView) findViewById(R.id.pricetext);
        CheckBox cb1=(CheckBox)findViewById(R.id.whippedcream);
        CheckBox cb2=(CheckBox)findViewById(R.id.chocolatecream);
        EditText ed1=(EditText)findViewById(R.id.name);
        String s="Name: "+ed1.getText()+"\n";
        if(cb1.isChecked() && cb2.isChecked())
        {
            price=q*7;
        }
        else
        {
            if(cb1.isChecked() || cb2.isChecked())
                price=q*6;
            else
                price=q*5;
        }
        String x=s+"Total"+NumberFormat.getCurrencyInstance().format(price)+"\nThank You!!!";
        priceTextView.setText(s+"Total"+NumberFormat.getCurrencyInstance().format(price)+"\nThank You!!!");
        composeEmail(x,"Order Summary");
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    public void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.pricetext);
        priceTextView.setText("Total"+NumberFormat.getCurrencyInstance().format(number));
    }
    public void increment(View view)
    {

        TextView qt=(TextView)(findViewById(R.id.edittext));
        int q=Integer.parseInt(String.valueOf(qt.getText()));
        qt.setText(String.valueOf(++q));

    }
    public void decrement(View view)
    {

        TextView qt=(TextView)(findViewById(R.id.edittext));
        int q=Integer.parseInt(String.valueOf(qt.getText()));
        if(q>1)
        qt.setText(String.valueOf(--q));

    }
    public void composeEmail(String body, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_TEXT, body);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
