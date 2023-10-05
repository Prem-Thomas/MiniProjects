package MiniProjects;

import java.util.Random;
import java.util.Scanner;

class TicTacTeo
{
	//   Arrays     loopings      if-else       Class       Objects        Inheritance
	 static char[][] board;
	public TicTacTeo() 
	{
		board=new char[3][3];
		initBoard();
	}
	
	void initBoard() 
	{
		for(int i=0;i<board.length;i++) 
		{
			for (int j = 0; j < board[i].length; j++) 
			{
				board[i][j]=' ';
			}
		}
	}
	static void disBoard() {

		System.out.println("-------------");
		for(int i=0;i<board.length;i++) {
			System.out.print("| ");
			for(int j=0;j<board[i].length;j++) {
				System.out.print(board[i][j]+" | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}
	static void PlaceMark(int row,int col,char mark) 
	{
		if(row>=0 && row <= 2 && col>=0 && col<=2)
		{
		board[row][col]=mark;
		}
		else 
		{
			System.err.println("Invalid Postion");
		}
	}
	static boolean colWin() {
		for(int j=0;j<=2;j++) 
		{
			if(board[0][j]!=' ' && board[0][j]==board[1][j]&&board[1][j]==board[2][j]) {
				return true;
			}
		}
		return false;
	}
	static boolean RowWin() {
		for (int i = 0; i <=2; i++) {
			if(board[i][0]!=' ' && board[i][0]==board[i][1]&&board[i][1]==board[i][2]) {
				return true;
			}
		}
		return false;
	}
	static boolean checkDiag() {
		if(board[0][0]!=' ' && board [0][0]==board[1][1]
				&& board[1][1]==board[2][2]
				|| board[0][2]!=' '&& board[0][2]==board[1][1]&&board[1][1]==board[2][0]) {
			return true;
		}
		return false;
	}
	static boolean isCheckDraw() 
	{
		for(int i=0;i<=2;i++) {
			for(int j=0;j<=2;j++) {
				if(board[i][j]==' ')
				{
					return false;
				}
			}
	}
		return true;		
	}
}
	
    abstract class Player
  {
	String name;
	char mark;
	abstract void makeMove();
	 boolean  isValidMove(int row, int col) 
		{
  		if(row>=0 && row<=2 && col>=0 && col<=2) 
  		{
				if(TicTacTeo.board[row][col]==' ')
				{
				     return true;
				}
			}
			
			return false;
		}
  }

	class HumanPlayer extends Player
	{
	
		 HumanPlayer(String name,char mark) 
		 {
          this.name=name;
          this.mark=mark;
		 }
		 void makeMove() 
		 {
		 Scanner sc=new Scanner(System.in);
		 int row;
		 int col;
		 do 
		 {
			 System.out.println("Enter the row and col ");
			 row =sc.nextInt();
			 col =sc.nextInt();
		 }while(!isValidMove(row,col));
		 TicTacTeo.PlaceMark(row, col, mark);
		}
		 
		 
	}


	class AIPlayer extends Player
	{
		
		 AIPlayer(String name,char mark) 
		 {
          this.name=name;
          this.mark=mark;
		 }
		 void makeMove() 
		 {
		 Scanner sc=new Scanner(System.in);
		 int row;
		 int col;
		 do 
		 {
			 Random r=new Random();
			row= r.nextInt(3);
			col=r.nextInt(3);
		 }while(!isValidMove(row,col));
		 TicTacTeo.PlaceMark(row, col, mark);
		}
	}

public class LaunchGame {
public static void main(String[] args) {
	TicTacTeo t=new TicTacTeo();
	HumanPlayer p1= new HumanPlayer("Bob", 'x');
	AIPlayer p2=new AIPlayer("Computer", 'O' );
    Player cp;
	cp=p1;

		while(true) {
			
			System.out.println(cp.name+" Turn");
		    cp.makeMove();
		   TicTacTeo.disBoard();
	    if(TicTacTeo.RowWin()||TicTacTeo.colWin()||TicTacTeo.checkDiag()) 
	    {
		    	System.out.println(cp.name+" has Won");
		    	break;
		    }else if(TicTacTeo.isCheckDraw()) 
		    {
		       System.out.println("Game is The Draw");
		       break;
		    }
	    else {
		    	if(cp==p1) {
		    		cp=p2;
		    	}else {
		    		cp=p1;
		    	}
		    }
	    
		}
    
}
}

    
	
 



