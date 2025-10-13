#include <string>
#include <vector>
#include <algorithm>
#include <math.h>
using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;
    bool erased = false;

    for (int i = 0; i < lost.size(); i++) {
        auto it = find(reserve.begin(), reserve.end(), lost[i]);
        if (it != reserve.end()) {
            reserve.erase(it);
            lost.erase(lost.begin() + i);
            i--;
        }
    }

    sort(lost.begin(), lost.end());
    sort(reserve.begin(), reserve.end());

    for (int i = 0; i < lost.size(); i++) {
        for (int j = 0; j < reserve.size(); j++) {
            if (abs(lost[i] - reserve[j]) == 1) {
                reserve.erase(reserve.begin()+j);
                erased = true;
                break;
            }
        }
        if (!erased) {
            answer++;
        }
        erased = false;
    }
    return n-answer;
}