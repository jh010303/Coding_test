import java.util.*;

class Solution {
    Double[] sums = new Double[401];
    public List<Double> solution(int k, int[][] ranges) {         List<Double> answer = new ArrayList<>();
        int prev = k;
        int i=0;
                                     
        while(k!=1){
            if(k%2==0){
                k/=2;
            }
            else{
                k=k*3+1;
            }
            double area = ((double)(prev+k))/2;
            sums[i] = (i==0?0:sums[i-1])+area;
            prev = k;
            i++;
        }
        i--;
        for(int j=0; j<ranges.length; j++){
            int start = ranges[j][0];
            int end = ranges[j][1];
            if(start-1>i+end){
                answer.add(-1.0);
            }
            else if(start-1==i+end){
                answer.add(0.0);
            }
            else{
                answer.add(sums[i+end]-(start-1<0?0:sums[start-1]));
            }
        }
        return answer;
    }
}