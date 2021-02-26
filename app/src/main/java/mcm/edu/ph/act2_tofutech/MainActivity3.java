package mcm.edu.ph.act2_tofutech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener{

    TextView Final2;
    Button Back2;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Final2 = findViewById(R.id.txtFinal2);
        Back2 = findViewById(R.id.btnBack2);

        int outcomes = 0;

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        outcomes = intent.getIntExtra("OUTCOMES", 0);

        switch (outcomes) {
            case 1:
                String f1 = bundle.getString("STRING_F1");
                Final2.setText(f1);
                break;
            case 4:
                String f2 = bundle.getString("STRING_F2");
                Final2.setText(f2);
                break;
            case 5:
                String f3 = bundle.getString("STRING_F3");
                Final2.setText(f3);
                break;
            case 8:
                String f4 = bundle.getString("STRING_F4");
                Final2.setText(f4);
                break;
        }

        Back2.setOnClickListener(this);
    }

    public void onClick(View v) {
        mp = MediaPlayer.create(this, R.raw.click);
        mp.start();
        switch (v.getId()) {
            case R.id.btnBack2:
                Intent back = new Intent(MainActivity3.this, Start.class);
                startActivity(back);
                Music.bg.stop();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
        }
    }
}