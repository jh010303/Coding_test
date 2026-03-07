import java.util.*;

class Solution {
    static int[][] book_t;
    static List<Integer> entry = new ArrayList<>();
    public int solution(String[][] book_time) {
        int answer = 1;
        book_t = new int[book_time.length][2];
        init(book_time);
        for(int i=0; i<entry.size(); i++){
            int entryTime = entry.get(i);
            int cnt = 0;
            for(int j=0; j<book_t.length; j++){
                int start = book_t[j][0];
                int end = book_t[j][1];
                if(start<=entryTime && entryTime<end){
                    cnt++;
                }
            }
            answer = Math.max(answer,cnt);
        }
        return answer;
    }
    
    public void init(String[][] book_time){
        for(int i=0; i<book_time.length; i++){
            book_t[i][0] = changeTime(Integer.parseInt(book_time[i][0].substring(0,2)), Integer.parseInt(book_time[i][0].substring(3)));
            book_t[i][1] = changeTime(Integer.parseInt(book_time[i][1].substring(0,2)), Integer.parseInt(book_time[i][1].substring(3))+10);
            entry.add(book_t[i][0]);
        }
    }
    
    public int changeTime(int t, int m){
        return t*60+m;
    }
}