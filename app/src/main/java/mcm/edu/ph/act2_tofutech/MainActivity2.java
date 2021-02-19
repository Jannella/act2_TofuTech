package mcm.edu.ph.act2_tofutech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity{

    TextView Final;
    Button Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Final = findViewById(R.id.txtFinal);
        Back = findViewById(R.id.btnBack);


        int outcomes = 0;

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        outcomes = intent.getIntExtra("OUTCOMES", 0);

        switch(outcomes){
            case 2:
                String s1 = bundle.getString("STRING_S1");
                Final.setText(s1);
                break;
            case 3:
                String s2 = bundle.getString("STRING_S2");
                Final.setText(s2);
                break;
            case 6:
                String s3 = bundle.getString("STRING_S3");
                Final.setText(s3);
                break;
            case 7:
                String s4 = bundle.getString("STRING_S4");
                Final.setText(s4);
                break;
        }
        final MediaPlayer mp = MediaPlayer.create(this,R.raw.click);
        Back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp.start();
                switch (v.getId()) {
                    case R.id.btnBack:
                        Intent back = new Intent(MainActivity2.this, Start.class);
                        startActivity(back);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        break;
                }
            }
        });
    }
}