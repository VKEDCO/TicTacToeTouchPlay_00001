package org.vkedco.mobappdev.tic_tac_toe_touch_play_00001;

/*
 ***********************************************************
 * Bugs to vladimir dot kulyukin at gmail dot com
 ***********************************************************
 */

enum TicTacToePlayer {
	X('x'), O('o');
	char mName;
	TicTacToePlayer(char c) {
		mName = c;
	}
}
