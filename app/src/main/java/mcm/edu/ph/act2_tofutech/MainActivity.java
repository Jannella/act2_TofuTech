package mcm.edu.ph.act2_tofutech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView storyBg, dec1, dec2;
    ImageView image1;
    Button btn1, btn2;
    MediaPlayer mp;
    int con = 0;
    int con1, con1a;
    String story = "You forgot to do your assignments as you played video" +
            "\ngames all night long, and it is already time for you" +
            "\nto go to school. " +
            "\n\nWhat are you supposed to do at this very moment?";
    String decision = "Stay at home and" +
            "\ndo your assignments";
    String decision2 = "Do your assignments" +
            "\nat school while your" +
            "\nteacher is discussing.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storyBg = findViewById(R.id.storyBg);
        dec1 = findViewById(R.id.dec1);
        dec2 = findViewById(R.id.dec2);
        image1 = findViewById(R.id.imageView);

        storyBg.setText(story);
        dec1.setText(decision);
        dec2.setText(decision2);
        image1.setImageResource(R.drawable.student1);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    public void onClick(View v) {

        mp = MediaPlayer.create(this, R.raw.click);
        mp.start();

        Intent success = new Intent(MainActivity.this, MainActivity2.class);
        Intent fail = new Intent(MainActivity.this, MainActivity3.class);

        int outcomes = 0;


        switch (v.getId()) {
            case R.id.btn1:
                if (con > 0 && con1 > 0) {
                    con1a = 1;
                    break;
                }
                if (con > 0) {
                    con1 = 1;
                    image1.setImageResource(R.drawable.student3);
                    break;
                }
                if (con == 0) {
                    con = 1;
                    image1.setImageResource(R.drawable.student2);
                }
                break;

            case R.id.btn2:
                if (con > 0 && con1 > 0) {
                    con1a = 2;
                    break;
                }
                if (con > 0) {
                    con1 = 2;
                    image1.setImageResource(R.drawable.student3);
                    break;
                }
                if (con == 0) {
                    con = 2;
                    image1.setImageResource(R.drawable.student2);
                }
                break;
        }

        if (con == 1) {
            storyBg.setText("You got caught by your mother skipping school." +
                    "\n\nWhat would be your next move?");
            dec1.setText("Tell her you" +
                    "\ncaught a fever.");
            dec2.setText("Be honest about" +
                    "\nthe situation.");

            if (con1 == 1) {
                storyBg.setText("She took your temperature, and found out that" +
                        "\nyou're lying." +
                        "\n\nWhat will you do now?");
                dec1.setText("Sneak away and run.");
                dec2.setText("Just tell her you" +
                        "\nforgot to answer" +
                        "\nyour assignments, and" +
                        "\napologize.");
                if (con1a == 1) {
                    outcomes = 1;
                    String outcomeF1 = "You successfully escaped and reached school, but" +
                            "\nyou left your assignments at home and there's only" +
                            "\n5 minutes left before the deadline.";
                    fail.putExtra("STRING_F1", outcomeF1);
                    fail.putExtra("OUTCOMES", outcomes);
                    startActivity(fail);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                } else if (con1a == 2) {
                    outcomes = 2;
                    String outcomeS1 = "Your mother warned you not to lie to her face again," +
                            "\nand let you finish so you could catch the deadline.";
                    success.putExtra("STRING_S1", outcomeS1);
                    success.putExtra("OUTCOMES", outcomes);
                    startActivity(success);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
            } else if (con1 == 2) {
                storyBg.setText("You got scolded for playing too much video games" +
                        "\ninstead of taking care of your home works." +
                        "\n\nWhat will you do now?");
                dec1.setText("Apologize to her" +
                        "\nfor being stupid, and" +
                        "\nkeep blaming yourself.");
                dec2.setText("Tell her to leave" +
                        "\nyou alone for now," +
                        "\nand talk about it " +
                        "\nmore later.");
                if (con1a == 1) {
                    outcomes = 3;
                    String outcomeS2 = "Your mother felt bad for scolding you, so she left." +
                            "\nNow you can continue doing what you need to finish.";
                    success.putExtra("STRING_S2", outcomeS2);
                    success.putExtra("OUTCOMES", outcomes);
                    startActivity(success);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                } else if (con1a == 2) {
                    outcomes = 4;
                    String outcomeF2 = "Your mother was not pleased by your behavior, and" +
                            "\ncontinuously nagged until there was no time left " +
                            "\nfor you to finish your assignments.";
                    fail.putExtra("STRING_F2", outcomeF2);
                    fail.putExtra("OUTCOMES", outcomes);
                    startActivity(fail);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
            }
        } else if (con == 2) {
            storyBg.setText("You're almost finished with your assignments." +
                    "\nHowever, your teacher noticed you were not" +
                    "\nlistening to her." +
                    "\n\nwhat would be your next move?");
            dec1.setText("Tell her you were" +
                    "\nlistening, and just" +
                    "\ntaking down notes.");
            dec2.setText("Act calmly, and" +
                    "\ncontinue with what" +
                    "\nyou're doing.");
            if (con1 == 1) {
                storyBg.setText("She asked you a question about her lesson, and" +
                        "\nyou have no idea what the answer is." +
                        "\n\nWhat will you do now?");
                dec1.setText("Just stay silent since" +
                        "\nyou don't know" +
                        "\nanything.");
                dec2.setText("Sneak a look at your" +
                        "\nclassmate's notes to" +
                        "\nanswer the question.");
                if (con1a == 1) {
                    outcomes = 5;
                    String outcomeF3 = "Your teacher did not allow you to sit or do anything" +
                            "\nuntil her class dismisses, thus you cannot" +
                            "\nfinish your assignments.";
                    fail.putExtra("STRING_F3", outcomeF3);
                    fail.putExtra("OUTCOMES", outcomes);
                    startActivity(fail);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                } else if (con1a == 2) {
                    outcomes = 6;
                    String outcomeS3 = "You got the correct answer. Your teacher left you, and" +
                            "\nnow you can continue doing your assignments.";
                    success.putExtra("STRING_S3", outcomeS3);
                    success.putExtra("OUTCOMES", outcomes);
                    startActivity(success);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
            } else if (con1 == 2) {
                storyBg.setText("Your teacher walked towards you to check what" +
                        "\nyou're writing." +
                        "\n\nWhat will you do now?");
                dec1.setText("Just tell her that" +
                        "\nyou forgot to do" +
                        "\nyour assignments, and" +
                        "\nbeg for forgiveness.");
                dec2.setText("Just stay calm and," +
                        "\ntell her it's nothing.");
                if (con1a == 1) {
                    outcomes = 7;
                    String outcomeS4 = "Your teacher gave you another chance, but warned" +
                            "\nyou that it would be your last.";
                    success.putExtra("STRING_S4", outcomeS4);
                    success.putExtra("OUTCOMES", outcomes);
                    startActivity(success);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                } else if (con1a == 2) {
                    outcomes = 8;
                    String outcomeF4 = "Your teacher took your paper to confirm, and found" +
                            "\nout you were doing the assignments she has given." +
                            "\nShe was not happy about that, thus she won't" +
                            "\naccept your assignments.";
                    fail.putExtra("STRING_F4", outcomeF4);
                    fail.putExtra("OUTCOMES", outcomes);
                    startActivity(fail);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                }
            }
        }
    }
}
