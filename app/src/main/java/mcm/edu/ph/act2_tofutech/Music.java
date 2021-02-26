package mcm.edu.ph.act2_tofutech;

import android.content.Context;
import android.media.MediaPlayer;

public class Music {
    public static MediaPlayer bg;

    public static void SoundPlayer(Context ctx, int raw_id) {
        bg = MediaPlayer.create(ctx, raw_id);
        bg.setLooping(true);
        bg.setVolume(100, 100);
        bg.start();
    }
}

