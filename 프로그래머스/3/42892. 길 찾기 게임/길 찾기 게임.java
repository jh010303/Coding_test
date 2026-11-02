import java.util.*;

class Solution {
    class N{
        int n;
        int x;
        int y;
        N left;
        N right;
        
        public N(int n, int x, int y){
            this.n = n;
            this.x = x;
            this.y = y;
            this.left = null;
            this.right = null;
        }
    }
    
    List<N> nodeList = new ArrayList<>();
    
    public List<List<Integer>> solution(int[][] nodeinfo) {
        for(int i=0; i<nodeinfo.length; i++){
            nodeList.add(new N(i+1,nodeinfo[i][0], nodeinfo[i][1]));
        }
        
        nodeList.sort((a,b)->{
            return Integer.compare(b.y,a.y);
        });

        N root = nodeList.get(0);
        for(int i=1; i<nodeList.size(); i++){
            N temp = nodeList.get(i);
            insert(root,temp);
        }
        
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        answer.add(new ArrayList<>());
        
        preOrder(root,answer);
        postOrder(root,answer);
        return answer;
    }
    
    void preOrder(N p,List<List<Integer>> answer){
        answer.get(0).add(p.n);
        if(p.left!=null){
            preOrder(p.left,answer);
        }
        if(p.right!=null){
            preOrder(p.right,answer);
        }
    }
    
    void postOrder(N p,List<List<Integer>> answer){
        if(p.left!=null){
            postOrder(p.left,answer);
        }
        if(p.right!=null){
            postOrder(p.right,answer);
        }
        answer.get(1).add(p.n);
    }
    
    void insert(N p, N c){
        if(p.x>c.x){
            if(p.left==null){
                p.left=c;
            }
            else{
                insert(p.left,c);
            }
        }
        else if(p.x<c.x){
            if(p.right==null){
                p.right=c;
            }
            else{
                insert(p.right,c);
            }
        }
    }

}

// 노드를 레벨에 따라 나눔
// 맨 첫 레벨은 1개 밖에 없음. 바로 부모노드
// 재귀함수로 진행
// 부모노드 다음 레벨의 배열을 보고 순회
// l이 되는 조건이면 l로 두고 다음 진행
// r이 되는 조건이면 r로 두고 다음 진행
// l, r로 둘 때 tree를 담는 배열에 저장