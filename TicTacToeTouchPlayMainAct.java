package org.vkedco.mobappdev.tic_tac_toe_touch_play_00001;

/*
 ******************************************************
 * Main activity on TicTacToeTouchPlay app.
 * Bugs to vladimir dot kulyukin at gmail dot com
 ******************************************************
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class TicTacToeTouchPlayMainAct extends Activity {
	
	TicTacToeTouchPlayApp mTTTApp = null;
	TicTacToeBoardSketcher mTouchImageSketcher = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tic_tac_toe_cp_main_act);
        mTouchImageSketcher = (TicTacToeBoardSketcher) this.findViewById(R.id.sketcher);
        mTTTApp = (TicTacToeTouchPlayApp) this.getApplication();
        mTouchImageSketcher.setTicTacToeApp(mTTTApp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tic_tac_toe_touch_play_menu, menu);
        return true;
    }
    
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch ( item.getItemId() ) {
		case R.id.item_clear_board: 
			mTTTApp.restartGameState();
			mTouchImageSketcher.setTicTacToeApp(mTTTApp);
			return true;
		default: return true; 
		}
	}
    
    @Override
	protected void onDestroy() {
		super.onDestroy();
		if ( mTouchImageSketcher != null ) {
			mTouchImageSketcher.disableDrawing();
			mTouchImageSketcher = null;
		}
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
		if ( mTouchImageSketcher != null ) {
			mTouchImageSketcher.disableDrawing();
			mTouchImageSketcher = null;
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		if ( mTouchImageSketcher != null ) {
			mTouchImageSketcher.disableDrawing();
		}
	}

	@Override
	protected void onStart() {
		super.onStart();
		if ( mTouchImageSketcher != null ) {
			mTouchImageSketcher.enableDrawing();
		}
		else {
			mTouchImageSketcher = (TicTacToeBoardSketcher) this.findViewById(R.id.sketcher);
			mTouchImageSketcher.enableDrawing();
		}
	}

	@Override
	protected void onStop() {
		super.onStop();
		if ( mTouchImageSketcher != null ) {
			mTouchImageSketcher.disableDrawing();
		}
	}
}
