import java.util.*;
import java.io.*;

class Solution {
    
    StringTokenizer st;
    PriorityQueue<Integer> maxQ = new PriorityQueue<>(
        (a,b)->{
            return Integer.compare(b,a);
        }
    );
    PriorityQueue<Integer> minQ = new PriorityQueue<>(
        (a,b)->{
            return Integer.compare(a,b);
        }
    );
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        for(int i=0; i<operations.length; i++){
            st = new StringTokenizer(operations[i]);
            String cmd = st.nextToken(); int num = Integer.parseInt(st.nextToken());
            if(cmd.equals("I")){
                addQ(num);
            }
            else if(cmd.equals("D") && num==1){
                deleteMax();
            }
            else{
                deleteMin();
            }
        }
        
        if(!maxQ.isEmpty() || !minQ.isEmpty()){
            answer[0] = maxQ.poll();
            answer[1] = minQ.poll();
        }
        return answer;
    }
    
    void deleteMin(){
        if(minQ.isEmpty()){
            return;
        }
        
        int minNum = minQ.poll();
        
        List<Integer> deleteList = new ArrayList<>();
        
        int size = maxQ.size();
        for(int i=0; i<size; i++){
            int deleteNum = maxQ.poll();
            if(deleteNum==minNum){
                break;
            }
            deleteList.add(deleteNum);
        }
        
        for(int i=0; i<deleteList.size(); i++){
            maxQ.offer(deleteList.get(i));
        }
    }
    
    void deleteMax(){
        if(maxQ.isEmpty()){
            return;
        }
        
        int maxNum = maxQ.poll();
        
        List<Integer> deleteList = new ArrayList<>();
        
        int size = minQ.size();
        for(int i=0; i<size; i++){
            int deleteNum = minQ.poll();
            if(deleteNum==maxNum){
                break;
            }
            deleteList.add(deleteNum);
        }
        
        for(int i=0; i<deleteList.size(); i++){
            minQ.offer(deleteList.get(i));
        }
    }
    
    void addQ(int num){
        maxQ.offer(num);
        minQ.offer(num);
    }
}