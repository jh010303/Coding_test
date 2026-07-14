import java.util.*;

class Solution {
    int[][] extendLock;
    public boolean solution(int[][] key, int[][] lock) {
        initLock(key, lock);
        int[][] newKey = new int[key.length][key.length];
        boolean success = false;
        boolean flag = false;
        int target = 0; int cnt = 0;
        for(int i=0; i<lock.length; i++){
            for(int j=0; j<lock.length; j++){
                if(lock[i][j]==0){
                    target++;
                }
            }
        }
        
        for(int i=1; i<lock.length+key.length; i++){
            for(int j=1; j<lock.length+key.length; j++){
                
                // 회전 X
                flag = true;
                cnt = 0;
                for(int p=i; p<i+key.length; p++){
                    if(!flag){
                        break;
                    }
                    for(int q=j; q<j+key.length; q++){
                        if(key[p-i][q-j]==1 && extendLock[p][q]==0
                          && p>=key.length && p<key.length+lock.length
                          && q>=key.length && q<key.length+lock.length){
                            cnt++;
                        }
                        else if(key[p-i][q-j]==1 && extendLock[p][q]==1){
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag && cnt==target){
                    success = true;
                    return success;
                }
                
                // 왼쪽 회전
                keyRotateLeft(key,newKey);
                flag = true;
                cnt = 0;
                for(int p=i; p<i+key.length; p++){
                    if(!flag){
                        break;
                    }
                    for(int q=j; q<j+key.length; q++){
                        if(newKey[p-i][q-j]==1 && extendLock[p][q]==0
                          && p>=key.length && p<key.length+lock.length
                          && q>=key.length && q<key.length+lock.length){
                            cnt++;
                        }
                        else if(newKey[p-i][q-j]==1 && extendLock[p][q]==1){
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag && cnt==target){
                    success = true;
                    return success;
                }
                
                // 오른쪽 회전
                keyRotateRight(key,newKey);
                flag = true;
                cnt = 0;
                for(int p=i; p<i+key.length; p++){
                    if(!flag){
                        break;
                    }
                    for(int q=j; q<j+key.length; q++){
                        if(newKey[p-i][q-j]==1 && extendLock[p][q]==0
                          && p>=key.length && p<key.length+lock.length
                          && q>=key.length && q<key.length+lock.length){
                            cnt++;
                        }
                        else if(newKey[p-i][q-j]==1 && extendLock[p][q]==1){
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag && cnt==target){
                    success = true;
                    return success;
                }
                
                // 오른쪽 회전
                keyRotate180(key,newKey);
                flag = true;
                cnt = 0;
                for(int p=i; p<i+key.length; p++){
                    if(!flag){
                        break;
                    }
                    for(int q=j; q<j+key.length; q++){
                        if(newKey[p-i][q-j]==1 && extendLock[p][q]==0
                          && p>=key.length && p<key.length+lock.length
                          && q>=key.length && q<key.length+lock.length){
                            cnt++;
                        }
                        else if(newKey[p-i][q-j]==1 && extendLock[p][q]==1){
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag && cnt==target){
                    success = true;
                    return success;
                }
            }
        }
        return success;
    }
    
    void keyRotateLeft(int[][] key, int[][] newKey){
        for(int i=0; i<key.length; i++){
            Arrays.fill(newKey[i],0);
        }
        for(int i=0; i<key.length; i++){
            for(int j=0; j<key.length; j++){
                if(key[i][j]==1){
                    newKey[Math.abs(key.length-1-j)][i] = 1;
                }
            }
        }
    }
    
    
    void keyRotateRight(int[][] key, int[][] newKey){
        for(int i=0; i<key.length; i++){
            Arrays.fill(newKey[i],0);
        }
        for(int i=0; i<key.length; i++){
            for(int j=0; j<key.length; j++){
                if(key[i][j]==1){
                    newKey[j][Math.abs(key.length-1-i)] = 1;
                }
            }
        }
    }
    
    void keyRotate180(int[][] key, int[][] newKey){
        for(int i=0; i<key.length; i++){
            Arrays.fill(newKey[i],0);
        }
        for(int i=0; i<key.length; i++){
            for(int j=0; j<key.length; j++){
                if(key[i][j]==1){
                    newKey[Math.abs(key.length-1-i)][Math.abs(key.length-1-j)] = 1;
                }
            }
        }
    }
    
    void initLock(int[][] key, int[][] lock){
        extendLock = new int[key.length*2+lock.length][key.length*2+lock.length];
        for(int i=key.length; i<extendLock.length-key.length; i++){
            for(int j=key.length; j<extendLock.length-key.length; j++){
                extendLock[i][j]=lock[i-key.length][j-key.length];
            }
        }
    }
}

// key: 20 x 20
// lock: 40 x 40 => 가장 끝에서 돌려도 되게
// lock 크기는 lock 크기+key크기로 선언
// 각 위치에서 할 수 있는 행동 상하좌우 이동 or 시계 반시계 회전
// 6의 10제곱까지 가능
// lock 확장하는 방법
// lock 회전
// (1,0), (2,1), (2,2)
// 왼쪽 회전: (2,1), (1,2), (0,2)
// 왼쪽 회전은 y를 x로 x를 y로 바꿈. 1은 그대로 1, 0은 2, 2는 0
// y->x는 바꾸지 않음
// 오른쪽 회전: (0,1), (1,0),(2,0)
// x->y는 바꾸지 않음
// 180 회전: (1,2), (0,1), (0,0)