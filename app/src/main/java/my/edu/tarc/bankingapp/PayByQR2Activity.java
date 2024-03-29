package my.edu.tarc.bankingapp;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PayByQR2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_by_qr2);

        Intent intent = getIntent();
        String message = intent.getStringExtra(PayByQRActivity.EXTRA_ACCNO);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.tvAccNo);
        textView.setText(message);

        Button btnConfirmPay = findViewById(R.id.btnConfirmPay);

        btnConfirmPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(PayByQR2Activity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_payment, null);
                Button btnClose = mView.findViewById(R.id.btnOK);

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();

                btnClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                });
                finish();
            }



        });
    }
}
