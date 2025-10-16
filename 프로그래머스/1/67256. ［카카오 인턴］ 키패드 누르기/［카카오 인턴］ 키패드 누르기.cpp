#include <string>
#include <vector>
#include <unordered_map>
#include <math.h>

using namespace std;

unordered_map<int, pair<int, int>> keypad_pos;

void init_keypad_pos() {
    for (int i = 0; i < 3; i++) {
        for (int j = 1; j <= 3; j++) {
            keypad_pos[i * 3 + j] = { i,j - 1 };
        }
    }
    keypad_pos[10] = { 3,0 };
    keypad_pos[0] = { 3,1 };
    keypad_pos[11] = { 3,2 };
}


double distance(pair<int,int> a, pair<int,int> b) {
    return abs(a.first - b.first) + abs(a.second - b.second);
}

string solution(vector<int> numbers, string hand) {
    init_keypad_pos();
    string answer = "";
    pair<int, int> right = { 3,2 }, left = { 3,0 },cur;
    double r_dis, l_dis;
    for (int number:numbers) {
        cur = keypad_pos[number];
        if (number == 1 || number == 4 || number == 7) {
            left = cur;
            answer += 'L';
            continue;
        }
        else if (number == 3 || number == 6 || number == 9) {
            right = cur;
            answer += 'R';
            continue;
        }
        else {
            r_dis = distance(cur, right);
            l_dis = distance(cur, left);
            if (r_dis < l_dis) {
                right = cur;
                answer += 'R';
            }
            else if (r_dis > l_dis) {
                left = cur;
                answer += 'L';
            }
            else {
                if (hand == "right") {
                    right = cur;
                    answer += 'R';
                }
                else if (hand == "left") {
                    left = cur;
                    answer += 'L';
                }
            }
        }
    }

    return answer;
}