import java.util.*;

class Solution {
    static class Menu implements Comparable<Menu>{
        String name;
        int cnt;
        
        public Menu(String name, int cnt){
            this.name = name;
            this.cnt = cnt;
        }
        
        @Override
        public int compareTo(Menu m){
            return m.cnt - this.cnt;
        }
    }
    
    static List<String> answer = new ArrayList<>();
    static PriorityQueue<Menu> que = new PriorityQueue<>();
    
    public List<String> solution(String[] orders, int[] course) {
        for(int i=course.length-1; i>=0; i--){ // course에 대해 진행
            int c = course[i];
            
            for(int j=0; j<orders.length; j++){ // 각 orders에 대해 진행
                char[] order = orders[j].toCharArray();
                Arrays.sort(order);
                if(order.length>=c){
                    bitMasking(orders,order,c);
                }
            }
            
            int max = Integer.MIN_VALUE;
            while(!que.isEmpty()){
                Menu top = que.poll();
                if(max<=top.cnt){
                    max = top.cnt;
                    answer.add(top.name);
                }
            }
        }
        for(int i=0; i<answer.size(); i++){
            for(int j=i+1; j<answer.size(); j++){
                if(answer.get(i).equals(answer.get(j))){
                    answer.remove(j);
                    j--;
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
    
    static void bitMasking(String[] orders, char[] order, int c){
        for(int i=0; i<(1<<order.length); i++){
            if(Integer.bitCount(i)==c){
                
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<order.length; j++){
                    if((i&(1<<j))!=0){
                        sb.append(order[j]);
                    }
                }
                
                int cnt = 0;
                for(int j=0; j<orders.length; j++){
                    String temp = orders[j];
                    if(sb.length()<=temp.length() && contains(sb.toString(),temp)){
                        cnt++;
                    }
                }

                if(cnt>=2){
                    que.offer(new Menu(sb.toString(),cnt));
                }
            }
        }
    }
    
    static boolean contains(String a, String b){
        for(int i=0; i<a.length(); i++){
            char cur = a.charAt(i);
            boolean success = false;
            for(int j=0; j<b.length(); j++){
                if(cur == b.charAt(j)){
                    success = true;
                    continue;
                }
            }
            if(!success){
                return false;
            }
        }
        return true;
    }
}