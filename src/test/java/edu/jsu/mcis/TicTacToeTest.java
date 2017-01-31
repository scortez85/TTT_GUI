package edu.jsu.mcis;

import java.util.*;
import edu.jsu.mcis.TicTacToe.Mark;
import javafx.scene.chart.Axis.TickMark;


import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
	private TicTacToe tic;
	
	@Before
	public void setUp(){
		tic = new TicTacToe();
	}
	
	@Test
	public void testInitialBoardIsEmpty() {
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				assertEquals(Mark.Empty, tic.getBoardPosition(row,col));
			}
		}
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		tic.playerMark(0, 2);
		assertEquals(tic.getMark(0, 2), Mark.X);
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		tic.playerMark(2,0);
		assertEquals(tic.getMark(2,0),Mark.X);
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		tic.playerMark(0,0);
		tic.playerMark(0,0);
		assertEquals(Mark.X, tic.getMark(0, 0));
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		tic.playerMark(0,0);
		Mark winningPlayer = tic.checkForWinner();
		assertEquals(Mark.Empty, winningPlayer);
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		tic.playerMark(0,0);
		tic.playerMark(1,0);
		tic.playerMark(0,1);
		tic.playerMark(2,0);
		tic.playerMark(0,2);
		
		Mark winner = tic.checkForWinner();
		assertEquals(Mark.X, winner);
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		
		tic.playerMark(0,0);
		tic.playerMark(1,1);

		tic.playerMark(2,0);
		tic.playerMark(0,2);

		tic.playerMark(0,1);
		tic.playerMark(1,0);

		tic.playerMark(1,2);
		tic.playerMark(2,1);
		
		tic.playerMark(2,2);
		Mark winner = tic.checkForWinner();
		assertEquals(Mark.TIE, winner);
	}	
}
