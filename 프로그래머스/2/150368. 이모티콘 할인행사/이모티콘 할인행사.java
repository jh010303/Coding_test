import java.util.*;

class Solution {
    class Emoticon{
        int d;
        int p;
        public Emoticon(int d, int p){
            this.d = d;
            this.p = p;
        }
    }
    
    class Sell implements Comparable<Sell>{
        int cnt;
        int p;
        
        public Sell(int cnt, int p){
            this.cnt = cnt;
            this.p = p;
        }
        
        @Override
        public int compareTo(Sell s){
            if(this.cnt!=s.cnt){
                return Integer.compare(s.cnt,this.cnt);
            }
            return Integer.compare(s.p,this.p);
        }
        
    }
    
    Emoticon[] emoticonList;
    int[] discounts = {40,30,20,10};
    
    PriorityQueue<Sell> sellQ = new PriorityQueue<>();
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        emoticonList = new Emoticon[emoticons.length];
        combine(users,emoticons,0);

        Sell s = sellQ.poll();
        answer[0] = s.cnt;
        answer[1] = s.p;
        return answer;
    }
    
    void combine(int[][] users, int[] emoticons, int index){
        if(index>=emoticons.length){ 
            doSell(users);
            return;
        }
        for(int i=0; i<4; i++){
            emoticonList[index] = new Emoticon(discounts[i],emoticons[index]);
            combine(users,emoticons,index+1);
        }
    }
    
    void doSell(int[][] users){
        int cnt = 0; int total = 0;
        for(int i=0; i<users.length; i++){
            int ud = users[i][0]; int up = users[i][1];
            int price = 0;
            for(int j=0; j<emoticonList.length; j++){
                int ed = emoticonList[j].d; int ep = emoticonList[j].p;
                if(ed>=ud){
                    price+=(ep/100*(100-ed));
                }
            }
            if(price>=up){
                cnt++;
            }
            else{
                total+=price;
            }
        }
        sellQ.add(new Sell(cnt,total));
    }
}
