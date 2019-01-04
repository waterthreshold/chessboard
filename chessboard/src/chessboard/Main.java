package chessboard;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input =new Scanner(System.in);
		boolean [][]board=new boolean[6][6];
		for(int i=1;i<board.length-1;i++){
			for(int j=1;j<board.length-1;j++){
				board[i][j]=true;
			}
		}
		
		int n;
		System.out.println("first_player input :1	later_player input:-1");
		n=input.nextInt();
		boolean skip=true;
		int x ,y,num = 0;
		int  direction;
		while(skip){
			if(n==1){
				System.out.println("How many chess you want?:");
				num=input.nextInt();
				if(num==1){
					System.out.println("input x,y coordinate:");
					x=input.nextInt();
					y=input.nextInt();
					if(board[x][y]){
						board[x][y]=false;
						n=n*(-1);
						print(board);
					}
					
				}
				else if(num==2){
					System.out.println("input x,y coordinate:");
					x=input.nextInt();
					y=input.nextInt();
					if(board[x][y]){
						board[x][y]=false;
								
						System.out.println("right :2 right_down:1 down:0 left_down:-1");
						direction=input.nextInt();
						if(direction==2){
							if(board[x][y+1]){
								board[x][y+1]=false;
								n=n*(-1);
								print(board);
							}
						}
						else if(direction==1){
							if(board[x+1][y+1]){
								board[x+1][y+1]=false;
								n=n*(-1);
								print(board);
							}
						}
						else if(direction==0){
							if(board[x+1][y]){
								board[x+1][y]=false;
								n=n*(-1);
								print(board);
							}
						}
						else if(direction==-1){
							if(board[x+1][y-1]){
								board[x+1][y-1]=false;
								n=n*(-1);
								print(board);
							}
						}
					}
				}				
			}
			
			
			
			else if(n==-1){
				AI(board,num);
				System.out.println("AI:");
				print(board);
				n=n*(-1);
			}
			if(check(board)==16){
				break;
			}
		}
		if(n==-1){
			System.out.println("AI WIN!!!");
		}
		else{
			System.out.println("player WIN");
		}
	}

	private static int check(boolean[][] board) {
		// TODO Auto-generated method stub
		int count=0;
		for(int i=1;i<board.length-1;i++){
			for(int j=1;j<board.length-1;j++){
				if(!board[i][j]){
					count++;
				}
			}
		}
		return count;
	}

	private static void print(boolean[][] board) {
		// TODO Auto-generated method stub
		for(int i=1;i<board.length-1;i++){
			for(int j=1;j<board.length-1;j++){
				if(board[i][j]){
					System.out.print("O ");
				}
				else{
					System.out.print("X ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void AI(boolean[][] board,int num) {
		// TODO Auto-generated method stub
		boolean continues=true;
		if(check(board)%3==1){
			for(int i=1;i<board.length-1;i++){
				for(int j=1;j<board.length-1;j++){
					if(board[i][j]){
						if(board[i][j+1]){
							board[i][j+1]=false;
							board[i][j]=false;
							continues=false;
							break;
						}
						else if(board[i+1][j+1]){
							board[i+1][j+1]=false;
							board[i][j]=false;
							continues=false;
							break;
						}
						else if(board[i+1][j]){
							board[i+1][j]=false;
							board[i][j]=false;
							continues=false;
							break;
						}
						else if(board[i+1][j-1]){
							board[i+1][j]=false;
							board[i][j]=false;
							continues=false;
							break;
						}
					}
				}
				if(!continues){
					break;
				}
			}
			
		}
		else {
			for(int i=1;i<board.length-1;i++){
				for(int j=1;j<board.length-1;j++){
					if(board[i][j]){
						board[i][j]=false;
						continues=false;
						break;
					}
				}
				if(!continues){
					break;
				}
			}
			
		}
		
		
	}

}
