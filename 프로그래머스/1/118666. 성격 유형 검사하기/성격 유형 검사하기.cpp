#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

unordered_map<char, int> result;
vector<vector<char>> chrc_list;

void init_chrc() {
    for (int i = 0; i < 4; i++) {
        chrc_list.push_back({ 'R','T' });
        chrc_list.push_back({ 'C','F' });
        chrc_list.push_back({ 'J','M' });
        chrc_list.push_back({ 'A','N' });
    }
}

string solution(vector<string> survey, vector<int> choices) {
    init_chrc();
    string answer = "", surv = "";
    char chrc1, chrc2;
    int choice;
    for (int i = 0; i < choices.size(); i++) {
        choice = choices[i];
        surv = survey[i];
        if (choice == 4)continue;
        else if (1 <= choice && choice <= 3) {
            if (choice == 1)result[surv[0]] += 3;
            else if (choice == 2)result[surv[0]] += 2;
            else if (choice == 3)result[surv[0]] += 1;
        }
        else {
            if (choice == 7)result[surv[1]] += 3;
            else if (choice == 6)result[surv[1]] += 2;
            else if (choice == 5)result[surv[1]] += 1;
        }
    }
    for (int i = 0; i < 4; i++) {
        chrc1 = chrc_list[i][0]; chrc2 = chrc_list[i][1];
        if (result[chrc1] > result[chrc2]) {
            answer += chrc1;
        }
        else if (result[chrc1] < result[chrc2]) {
            answer += chrc2;
        }
        else {
            answer+=min(chrc1, chrc2);
        }
    }
    return answer;
}