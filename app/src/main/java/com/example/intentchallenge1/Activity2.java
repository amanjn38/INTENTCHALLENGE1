package com.example.intentchallenge1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity implements View.OnClickListener {
    EditText etlocation,etnumber,etweb,etname;
    ImageView ivhappy,ivsad,ivnuetral;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        etlocation = findViewById(R.id.etlocation);
        etnumber = findViewById(R.id.etnumber);
        etweb = findViewById(R.id.etweb);
        etname = findViewById(R.id.etname);

        ivhappy = findViewById(R.id.ivhappy);
        ivnuetral = findViewById(R.id.ivnuetral);
        ivsad = findViewById(R.id.ivsad);

        ivsad.setOnClickListener(this);
        ivhappy.setOnClickListener(this);
        ivnuetral.setOnClickListener(this);

}
        @Override
        public void onClick(View v){




        if(etname.getText().toString().isEmpty()||etnumber.getText().toString().isEmpty()||etlocation.getText().toString().isEmpty()||etweb.getText().toString().isEmpty())
            {
                Toast.makeText(this,"Please enter all elds",Toast.LENGTH_SHORT).show();
            }

            else

            {
            Intent intent = new Intent();
            intent.putExtra("Name",etname.getText().toString().trim());
            intent.putExtra("Number",etnumber.getText().toString().trim());
            intent.putExtra("Location",etlocation.getText().toString().trim());
            intent.putExtra("Web",etweb.getText().toString().trim());

            if(v.getId()==R.id.ivhappy)
            {
                intent.putExtra("Mood","happy");
            }
            else if(v.getId()==R.id.ivnuetral)
            {
                intent.putExtra("Mood","nuetral");
            }
            else
            {   intent.putExtra("Mood","bad");
                 }
            setResult(RESULT_OK,intent);
            Activity2.this.finish();





}
}
}