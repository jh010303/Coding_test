import java.util.*;

class Solution {
    char[] op = {'+','-','*'}; // 연산자 순위 정함
    boolean[] used = new boolean[3];
    List<Long> num = new ArrayList<>(); // 계산해야 할 숫자 정함
    List<Character> opList = new ArrayList<>(); // 계산해야 할 연산자
    
    char[] totalOp = {'+','-','*'}; // 전체 연산자 종류
    
    long answer = -1;
    public long solution(String expression) {
        go(0,expression);
        return answer;
    }
    
    public void go(int depth, String expression){
        if(depth==3){
            init(expression);
            for(int i=0; i<3; i++){
                char curOp = op[i];
                for(int j=0; j< opList.size(); j++){
                    if(opList.get(j)==curOp){
                        if(curOp=='+'){
                            num.set(j,num.get(j)+num.get(j+1));
                        }
                        else if(curOp=='*'){
                            num.set(j,num.get(j)*num.get(j+1));
                        }
                        else if(curOp=='-'){
                            num.set(j,num.get(j)-num.get(j+1));
                        }
                        num.remove(j+1);
                        opList.remove(j);
                        j--;
                    }
                }
            }
            answer = Math.max(answer,Math.abs(num.get(0)));
        }
        else{
            for(int i=0; i<3; i++){
                if(!used[i]){
                    op[depth] = totalOp[i];
                    used[i] = true;
                    go(depth+1,expression);
                    used[i]=false;
                }
            }
        }
    }
    
    void init(String expression){
        String tempnum = "";
        num.clear(); opList.clear();
        for(int i=0; i<expression.length(); i++){
            char cur = expression.charAt(i);
            if(cur=='*' || cur=='-' || cur=='+'){
                num.add(Long.parseLong(tempnum));
                opList.add(cur);
                tempnum="";
            }
            else{
                tempnum+=cur;
            }
        }
        num.add(Long.parseLong(tempnum));
    }
}
