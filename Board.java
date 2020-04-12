import java.util.*;
public class Board
{
    int [][] board;
    public Board(){
        board = new int [4][4];
    }  

    public void left(){
        for(int i = 0; i<3; i++){
            for(int r = 3; r>=0;r--){
                for(int c = 1; c<4; c++){
                    if(board[r][c]==board[r][c-1] || board[r][c-1]==0){
                        board[r][c-1]+=board[r][c];
                        board[r][c] = 0;                    
                    }
                }
            }
        }
    }

    public void up(){
        for(int i = 0; i<3; i++){
            for(int r = 3; r>0;r--){
                for(int c = 3; c>=0; c--){
                    if(board[r][c]==board[r-1][c] || board[r-1][c]==0){
                        board[r-1][c]+=board[r][c];
                        board[r][c] = 0;
                    }
                }
            }
        }
    }

    public void down(){
        for(int i = 0; i<3;i++){
            for(int r = 0; r<3;r++){
                for(int c = 0; c<4; c++){
                    if(board[r][c]==board[r+1][c] || board[r+1][c]==0){
                        board[r+1][c]+=board[r][c];
                        board[r][c] = 0;
                    }
                }
            }
        }
    }

    public void right(){
        for(int i = 0; i<3; i++){
            for(int r = 0; r<4;r++){
                for(int c = 0; c<3; c++){
                    if(board[r][c]==board[r][c+1] || board[r][c+1]==0){
                        board[r][c+1]+=board[r][c];
                        board[r][c]=0;
                    }
                }
            }
        }
    }

    public boolean win(){
        for(int r = 0; r<4; r++){
            for(int c = 0; c<4; c++){
                if(board[r][c]==2048)
                    return true;
            }
        }
        return false;
    }

    public boolean gameOver(){
        for(int r = 0; r<4; r++){
            for(int c = 0; c<4; c++){
                if(possibleMoves(r,c))
                    return false;
                if(board[r][c]==0)
                    return false;
            }
        }
        return true;
    }

    public boolean possibleMoves(int r, int c){
        if(r>0 && board[r][c]==board[r-1][c]) //up
            return true;
        if(r<3 && board[r][c]==board[r+1][c]) //down
            return true;
        if(c>0 && board[r][c]==board[r][c-1]) //left
            return true;
        if(c<3 && board[r][c]==board[r][c+1]) //right
            return true;
        return false;
    }

    public void startGame(){
        int R1 = (int)(4*Math.random());
        int C1 = (int)(4*Math.random());
        int R2 = (int)(4*Math.random());
        int C2 = (int)(4*Math.random());
        board[R1][C1] = newTile();
        board[R2][C2] = newTile();
    }

    public void midGame(){
        int R = (int)(4*Math.random());
        int C = (int)(4*Math.random());
        while(board[R][C]!=0){
            R = (int)(4*Math.random());
            C = (int)(4*Math.random());
        }
        board[R][C] = newTile();
    }

    public int newTile(){
        if(((int)(2*Math.random()))==1){
            return 4;
        }
        return 2;
    }

    public String cell(int row, int col){
        if(board[row][col] == 0){
            return "     ";
        }
        if(board[row][col] < 10){
            return "  "+board[row][col]+"  ";
        }
        if(board[row][col] <100){
            return "  "+board[row][col]+ " ";
        }
        if(board[row][col] <1000){
            return " "+ board[row][col]+ " ";
        }
        return " "+board[row][col];
    }
}
