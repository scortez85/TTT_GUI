package edu.jsu.mcis;

import java.util.*;


public class TicTacToe {
	public enum Mark{Empty, X, O, TIE};
	
	private final int boardSize = 3;
	
	private Mark[][] GameBoard = new Mark[boardSize][boardSize];
	
	private int turnCounter;
	
	private Mark userTurn;
	
	public TicTacToe(){
		turnCounter = 0;
		setUpBoard();
		userTurn = Mark.X;
	}
	
	private void setUpBoard(){
		for(int row=0; row < GameBoard.length; row++){
			for(int col = 0; col < GameBoard[0].length; col++){
				GameBoard[row][col]= Mark.Empty;
			}
		}
	}
	public void playerMark(int row, int col){
		if(row >= 0&& row <= 2 && col >= 0 && col <= 2){
			if(GameBoard[row][col]== Mark.Empty){
				GameBoard[row][col] = userTurn;
				turnCounter++;
				if(userTurn == Mark.X){
					userTurn = Mark.O;
				}
				else{
					userTurn = Mark.X;
				}
			}
		}
	}
	public Mark checkForWinner(){
		if(GameBoard[0][0] == GameBoard[1][1]&& GameBoard[1][1]== GameBoard[2][2]){
			return GameBoard[0][0];
		}
		else if(GameBoard[0][0] == GameBoard[1][0] && GameBoard[1][0]== GameBoard[2][0]){
			return GameBoard[0][0];
		}
		else if(GameBoard[0][0] == GameBoard[0][1] && GameBoard[0][1]== GameBoard[0][2]){
			return GameBoard[0][0];
		}
		else if(GameBoard[0][1]== GameBoard[1][1] && GameBoard[1][1] == GameBoard[2][1]){
			return GameBoard[0][1];
		}
		else if(GameBoard[0][2]== GameBoard[1][1] && GameBoard[1][1] == GameBoard[2][0]){
			return GameBoard[0][2];
		}
		else if(GameBoard[0][2]== GameBoard[1][2] && GameBoard[1][2] == GameBoard[2][2]){
			return GameBoard[0][2];
		}
		else if(GameBoard[1][0] == GameBoard[1][1] && GameBoard[1][1] == GameBoard[1][2]){
			return GameBoard[1][0];
		}
		else if(GameBoard[2][0] == GameBoard[2][1] && GameBoard[2][1] == GameBoard[2][2]){
			return GameBoard[2][0];
		}
		else if (turnCounter == 9){
			return Mark.TIE;
		}
		else{
			return Mark.Empty;
		}
	}
	
	public Mark getTurn(){
		return userTurn;
	}
	
	public Mark getBoardPosition(int row, int column){
		return GameBoard[row][column];
	}
	public Mark getMark(int row, int col) {
		if(GameBoard[row][col] == Mark.Empty) return Mark.Empty;
		else if(GameBoard[row][col] == Mark.X) return Mark.X;
		else return Mark.O;
	}
	
    
}




	
