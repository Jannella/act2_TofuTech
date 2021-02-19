package mcm.edu.ph.act2_tofutech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Start extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button start = findViewById(R.id.btnStart);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.click);
        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp.start();
                switch (v.getId()) {
                    case R.id.btnStart:
                        Intent start = new Intent(Start.this, MainActivity.class);
                        startActivity(start);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        break;
                }
            }
        });
    }
}