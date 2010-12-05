package net.bekit.android.clicker;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;

public class Clicker extends Activity implements OnTouchListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ImageButton btnClick = (ImageButton)findViewById(R.id.btnClick);
        btnClick.setOnTouchListener(this);
    }
    
    private MediaPlayer mMediaPlayer = null;

    public boolean onTouch(View v, MotionEvent event) {
	    switch(event.getAction()){
	    case MotionEvent.ACTION_DOWN:
	    	if (mMediaPlayer != null) {
			    mMediaPlayer.stop();
			    mMediaPlayer.release();
		    }
		    mMediaPlayer = MediaPlayer.create(this, R.raw.clicker001_down);
		    mMediaPlayer.start();
			return true;
	    case MotionEvent.ACTION_UP:
	    	if (mMediaPlayer != null) {
			    mMediaPlayer.stop();
			    mMediaPlayer.release();
		    }
		    mMediaPlayer = MediaPlayer.create(this, R.raw.clicker001_up);
		    mMediaPlayer.start();
		    return true;
			}	    
	    return false;
    }
        
    public boolean onKeyDown(int keyCode, KeyEvent event) {                  
        AudioManager mAudioManager = (AudioManager)getSystemService(AUDIO_SERVICE);
		switch (keyCode) {
        case KeyEvent.KEYCODE_VOLUME_UP :
        	mAudioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
			return true;
        case KeyEvent.KEYCODE_VOLUME_DOWN:
        	mAudioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
			return true;
        case KeyEvent.KEYCODE_BACK:
			return true;
        case KeyEvent.KEYCODE_DPAD_CENTER:
	    	if (mMediaPlayer != null) {
			    mMediaPlayer.stop();
			    mMediaPlayer.release();
		    }
		    mMediaPlayer = MediaPlayer.create(this, R.raw.clicker001_down);
		    mMediaPlayer.start();
			return true;
        }
			
        return false;
   }
    
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        AudioManager mAudioManager = (AudioManager)getSystemService(AUDIO_SERVICE);
		switch (keyCode) {
        case KeyEvent.KEYCODE_VOLUME_UP :
        	mAudioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_SAME, AudioManager.FLAG_SHOW_UI);
	    	if (mMediaPlayer != null) {
			    mMediaPlayer.stop();
			    mMediaPlayer.release();
		    }
		    mMediaPlayer = MediaPlayer.create(this, R.raw.clicker001_up);
		    mMediaPlayer.start();
			return true;
        case KeyEvent.KEYCODE_VOLUME_DOWN:
        	mAudioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_SAME, AudioManager.FLAG_SHOW_UI);
	    	if (mMediaPlayer != null) {
			    mMediaPlayer.stop();
			    mMediaPlayer.release();
		    }
		    mMediaPlayer = MediaPlayer.create(this, R.raw.clicker001_up);
		    mMediaPlayer.start();
			return true;
        case KeyEvent.KEYCODE_BACK:
        	Clicker.this.finish();
			return true;
        case KeyEvent.KEYCODE_DPAD_CENTER:
	    	if (mMediaPlayer != null) {
			    mMediaPlayer.stop();
			    mMediaPlayer.release();
		    }
		    mMediaPlayer = MediaPlayer.create(this, R.raw.clicker001_up);
		    mMediaPlayer.start();
			return true;
        }
        return false;
    }
    
}
