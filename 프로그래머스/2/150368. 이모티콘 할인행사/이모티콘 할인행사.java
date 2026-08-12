import java.util.*;

class Solution {
    class TotalEmoticon{
        int cnt;
        int price;
        
        public TotalEmoticon(int cnt, int price){
            this.cnt = cnt;
            this.price = price;
        }
    }
    
    PriorityQueue<TotalEmoticon> cntPq = new PriorityQueue<>((a,b)->{
        return b.cnt-a.cnt;
    });
    
    PriorityQueue<TotalEmoticon> pricePq = new PriorityQueue<>((a,b)->{
        return b.price-a.price;
    });
    
    int[] discounts = {10,20,30,40};
    int cntMax = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        
        dfs(0,new double[emoticons.length], users, emoticons);
        
        while(!cntPq.isEmpty()){
            TotalEmoticon temp = cntPq.poll();
            if(cntMax>temp.cnt){
                break;
            }
            pricePq.offer(temp);
        }
        
        TotalEmoticon temp = pricePq.poll();
        answer[0] = temp.cnt; answer[1] = temp.price;
        return answer;
    }
    
    void dfs(int len, double[] discountList, int[][] users, int[] emoticons){
        if(len==emoticons.length){
            int userCnt = 0;
            int userTotal = 0;
            for(int i=0; i<users.length; i++){
                int account = 0;
                for(int j=0; j<emoticons.length; j++){
                    if(users[i][0]<=discountList[j]){
                        account+=(emoticons[j]*((100-discountList[j])/100));
                    }
                }
                if(users[i][1]<=account){
                    userCnt++;
                }
                else{
                    userTotal+=account;
                }
            }
            cntMax = Math.max(cntMax,userCnt);
            cntPq.offer(new TotalEmoticon(userCnt,userTotal));
            //System.out.println(userCnt+" "+usertotal);
            return;
        }
        
        for(int i=0; i<4; i++){
            discountList[len] = discounts[i];
            dfs(len+1,discountList,users,emoticons);
        }
    }
}