import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int l = Integer.MAX_VALUE; int r = Integer.MIN_VALUE; int mid = 0;
        for(int i=0; i<stones.length; i++){
            int stone = stones[i];
            r = Math.max(r,stone);
            l = Math.min(l,stone);
        }
        
        while(l<=r){
            mid = (l+r)/2;
            int maxL = continueZero(stones, mid);
            
            if(maxL<k){
                answer = Math.max(answer,mid);
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        
        return answer;
    }
    
    int continueZero(int[] stones, int mid){
        int maxCnt = -1;
        int cont = 0;
        for(int i=0; i<stones.length; i++){
            if(stones[i]>=mid){
                cont = 0;
            }
            else{
                cont++;
                maxCnt = Math.max(maxCnt,cont);
            }
        }
        return maxCnt;
    }
}


// stones 배열, stones안의 원소 종류 배열 선언
// stones 안의 원소들을 오름차순으로 저장하여 stones안의 원소 종류 배열에 저장
// stones안의 원소 종류 배열을 빼야할 것만 만듬 ex) 3 9 20 31 -> 3 6 11 11
// 가장 작은 것 부터 뺌, result에 더함
// 한 번씩 빼면서 연속된 0이 k의 길이를 가지고 있는지 확인
// 최악의 시간 복잡도가 20만 제곱인데 가능..?


// stones 배열, stones안의 원소 종류 배열
// stones 안의 원소들을 오름차순으로 저장하여 stones안의 원소 종류 배열에 저장
// 니니즈 친구들의 수가 무제한 건널 수 있는 수의 최소 -> stones 원소 최소, 건널 수 있는 수의 최대 -> stones 원소 최대
// 정답 후보는 stones의 원소 종류에 있음 -> 이분 탐색 O(logn)
// logn 만큼 하고 stones 배열을 전부 순회해서 연속된 0의 개수 찾기 => O(nlogn)
// 0의 가장 연속된 개수가 k보다 적다면 증가, 많다면 감소

