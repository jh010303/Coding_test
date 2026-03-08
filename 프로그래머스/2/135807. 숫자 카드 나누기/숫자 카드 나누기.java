class Solution {
    static int arrSize;
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        arrSize = arrayA.length;
        int minA = minE(arrayA);
        int minB = minE(arrayB);
        
        int gcaA = getGCA(arrayA,minA);
        if(gcaA>1){
            boolean success = true;
            for(int i=0; i<arrSize; i++){
                if(arrayB[i]%gcaA==0){
                    success = false;
                    break;
                }
            }
            if(success){
                answer = Math.max(answer,gcaA);
            }
        }
        int gcaB = getGCA(arrayB,minB);
        if(gcaB>1){
            boolean success = true;
            for(int i=0; i<arrSize; i++){
                if(arrayA[i]%gcaB==0){
                    success = false;
                    break;
                }
            }
            if(success){
                answer = Math.max(answer,gcaB);
            }
        }
        
        return answer;
    }
    
    static int getGCA(int[] array, int minE){
        int ans = 1;
        for(int i=minE; i>=1; i--){
            boolean success = true;
            for(int j=0; j<arrSize; j++){
                if(array[j]%i!=0){
                    success = false;
                    break;
                }
            }
            if(success){
                ans = i;
                break;
            }
        }
        return ans;
    }
    
    static int minE(int[] array){
        int temp = Integer.MAX_VALUE;
        for(int i=0; i<arrSize; i++){
            if(array[i]<temp){
                temp = array[i];
            }
        }
        return temp;
    }
}