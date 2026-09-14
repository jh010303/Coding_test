#include <string>
#include <vector>
#include <map>
#include <iostream>
using namespace std;

map<string, int> want_map;

int solution(vector<string> want, vector<int> number, vector<string> discount) {
    int answer = 0, check = 1;
    for (int i = 0; i < want.size(); i++)  want_map[want[i]] = number[i];

    for (int i = 0; i <= discount.size() - 10; i++) {
        check = 1;
        map<string, int> discount_map;
        for (int j = i; j < i + 10; j++) {
            discount_map[discount[j]]++;
        }
        // map 2개 비교하기
        if (want_map.size() != discount_map.size()) continue;
        for (auto& want : want_map) {
            if (discount_map[want.first] == want.second) continue;
            else {
                check = 0;
                break;
            }
        }
        if (check) answer++;
    }
    return answer;
}