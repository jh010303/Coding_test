#include <string>
#include <vector>
#include <stack>
using namespace std;

int solution(vector<vector<int>> board, vector<int> moves) {
    int answer = 0,val,bef=-1;
    bool none;
    stack<int> stk;
    for (int move : moves) {
        none = false;
        for (int i = 0; i < board.size(); i++) {
            val = board[i][move - 1];
            if (val == 0) {
                continue;
            }
            else {
                stk.push(val);
                board[i][move - 1] = 0;
                none = true;
                break;
            }
        }
        if (stk.size() == 0 || !none) {
            continue;
        }
        else if (stk.size() == 1) {
            bef = stk.top();
        }
        else {
            if (val == bef) {
                stk.pop();
                stk.pop();
                answer += 2;
            }
            if(!stk.empty()) bef = stk.top();
        }
    }
    return answer;
}