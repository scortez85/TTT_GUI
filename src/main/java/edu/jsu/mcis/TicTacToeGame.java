package edu.jsu.mcis;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeGame extends JPanel{
	private TicTacToe tictactoe;
	private int boardSize = 3;
	private JButton[][] GameBoard;
	
	public static void main(String[] args){
		TicTacToeGame WinnerPanel = new TicTacToeGame();
		JFrame Frame = new JFrame("Tic Tac Toe");
		Frame.setSize(new Dimension(300,300));
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.add(WinnerPanel);
		Frame.pack();
		Frame.setVisible(true);
		Frame.pack();
	}


	public TicTacToeGame(){
		tictactoe = new TicTacToe();
		GameBoard = new JButton[boardSize][boardSize];
		setLayout(new GridLayout(boardSize, boardSize));
		for(int row = 0; row < boardSize; row++){
			for(int col = 0; col < boardSize; col++){
				GameBoard[row][col] = new JButton("");
				GameBoard[row][col].setPreferredSize(new Dimension(100, 100));
				GameBoard[row][col].addActionListener(new TempListener());
				GameBoard[row][col].setName("Location" + row + col);
				add(GameBoard[row][col]);
			}
		}
	}
	private class TempListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			JButton button = (JButton)event.getSource();
			tictactoe.playerMark(Integer.parseInt("" +button.getName().substring(8).charAt(0)),Integer.parseInt("" +button.getName().substring(8).charAt(1)));
			button.setText(getPlayerMark(Integer.parseInt("" +button.getName().substring(8).charAt(0)),Integer.parseInt("" +button.getName().substring(8).charAt(1))));
			checkForWinner();
		}
	}
	private String getPlayerMark(int row, int col){
		TicTacToe.Mark player = tictactoe.getBoardPosition(row, col);
		
		if(player == TicTacToe.Mark.X){
			return "X";
		}
		else if(player == TicTacToe.Mark.O){
			return "O";
		}
		else{
			return "";
		}
		
	}
	
	private void checkForWinner(){
		TicTacToe.Mark winner = tictactoe.checkForWinner();
		final String result;
		
		JOptionPane WinnerPane = new JOptionPane();
		if(winner == TicTacToe.Mark.X){
			result = "X";
		}
		else if(winner == TicTacToe.Mark.O){
			result = "O";
		}
		else if(winner == TicTacToe.Mark.TIE){
			result = "TIE";
		}
		else{
			result = "Empty";
		}
		if(!result.equals("Empty")){
				new Thread(new Runnable(){
						public void run(){
								JOptionPane.showMessageDialog(null, "The winner is " + result , "Game Over", JOptionPane.INFORMATION_MESSAGE);
						}
				}).start();
		}
	}
	}
