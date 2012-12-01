package org.vkedco.mobappdev.tic_tac_toe_touch_play_00001;

/*****************************************************
 * Custom Application class of TicTacToeTouchPlay app
 * Bugs to vladimir dot kulyukin at gmail dot com
 *****************************************************
 */

import android.app.Application;

public class TicTacToeTouchPlayApp extends Application {
	private TicTacToeGameBoardGeometry mGameBoardGeometry = null;
	private TicTacToeGameState mGameState = null;
	final static short BOARD_TOP_LEFT_X = 50;
	final static short BOARD_TOP_LEFT_Y = 125;
	final static short CELL_DIM = 125;
	private static int GAME_COUNT = 0;
	
	public TicTacToeTouchPlayApp() {
		mGameBoardGeometry = new TicTacToeGameBoardGeometry(BOARD_TOP_LEFT_X, BOARD_TOP_LEFT_Y, CELL_DIM);
		mGameState = new TicTacToeGameState(TicTacToePlayer.X);
	}
	
	final TicTacToeGameBoardGeometry getGameBoardGeometry() {
		return mGameBoardGeometry;
	}
	
	final TicTacToeGameState getGameState() {
		return mGameState;
	}
	
	final void restartGameState() {
		mGameState.restartGameState();
		++GAME_COUNT;
	}
	
	final static int getGameCount() {
		return GAME_COUNT;
	}
	
	final boolean isTerminal() {
		return TicTacToeGameEngine.isTerminal(mGameState);
	}
	
	final boolean isDraw() {
		return TicTacToeGameEngine.isDraw(mGameState);
	}
	
	final TicTacToePlayer getWinner() {
		return TicTacToeGameEngine.getWinner(mGameState);
	}
}
