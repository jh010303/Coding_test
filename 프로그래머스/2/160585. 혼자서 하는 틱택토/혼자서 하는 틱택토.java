import java.util.*;

class Solution {
    int cnt = 0;
    int answer = 0;
    char[][] newBoard = new char[3][3];
    
    public int solution(String[] board) {
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                newBoard[i][j] = '.';
            }
        }
        
        initCnt(board);
        
        backTracking(board,0);
        
        return answer;
    }
    
    void backTracking(String[] board, int turn){
        if(turn==cnt || checkBingo()){
            if(compareBoard(board)){
                answer = 1;
            }
            return;
        }
        char tick = turn%2==0?'O':'X';
        
        for(int i=0; i<newBoard.length; i++){
            for(int j=0; j<newBoard[i].length; j++){
                if(newBoard[i][j]=='.'){
                    newBoard[i][j]=tick;
                    backTracking(board,turn+1);
                    newBoard[i][j]='.';
                }
            }
        }
    }
    
    boolean checkBingo(){
        char start = '.';
        for(int i=0; i<3; i++){
            start = newBoard[i][0];
            if(start=='.'){
                continue;
            }
            for(int j=1; j<3; j++){
                if(start!=newBoard[i][j]){
                    break;
                }
                else if(j==2){
                    return true;
                }
            }
        }
        for(int i=0; i<3; i++){
            start = newBoard[0][i];
            if(start=='.'){
                continue;
            }
            for(int j=1; j<3; j++){
                if(start!=newBoard[j][i]){
                    break;
                }
                else if(j==2){
                    return true;
                }
            }
        }
        start = newBoard[0][0];
        for(int i=1; i<3; i++){
            if(start=='.' || start!=newBoard[i][i]){
                break;
            }
            else if(i==2){
                return true;
            }
        }
        start = newBoard[0][2];
        for(int i=1; i<3; i++){
            if(start=='.' || start!=newBoard[i][2-i]){
                break;
            }
            else if(i==2){
                return true;
            }
        }
        return false;
    }
    
    boolean compareBoard(String[] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                if(board[i].charAt(j)!=newBoard[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    
    void initCnt(String[] board){
        for(int i=0; i<board.length; i++){
            String b = board[i];
            for(int j=0; j<b.length(); j++){
                if(b.charAt(j)!='.'){
                    cnt++;
                }
            }
        }
    }
}

// 규칙을 지켜서 진행해봄
// 규칙을 지켜서 board가 나온다면 return 1