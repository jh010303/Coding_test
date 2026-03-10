import java.util.*;
import java.io.*;

class Solution {
    static String[] answerNum = {"0","1","2","4"};
    public String solution(int n) {
        StringBuilder sb = new StringBuilder(divide(n));
        return sb.reverse().toString();
    }
    
    static String divide(int n){
        if(n==0){
            return "";
        }
        if(n<=3){
            return answerNum[n];
        }
        int r = n%3;
        n = n/3;
        if(r==0){
            n--;
            r=3;
        }
        return answerNum[r]+divide(n);
    }
}