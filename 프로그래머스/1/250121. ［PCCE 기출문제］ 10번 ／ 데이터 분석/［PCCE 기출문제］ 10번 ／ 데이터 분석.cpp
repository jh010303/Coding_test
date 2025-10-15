#include <string>
#include <vector>
#include <algorithm>
#include <unordered_map>

using namespace std;

int sort_index;

bool srt(const vector<int> &a, const vector<int> &b) {
    return a[sort_index] < b[sort_index];
}

vector<vector<int>> solution(vector<vector<int>> data, string ext, int val_ext, string sort_by) {
    int tmp;
    vector<vector<int>> answer;
    unordered_map<string, int> cmd;
    cmd["date"] = 1, cmd["maximum"] = 2, cmd["remain"] = 3;
    for (int i = 0; i < data.size(); i++) {
        tmp = data[i][cmd[ext]];
        if (tmp < val_ext) {
            answer.push_back(data[i]);
        }
    }
    sort_index = cmd[sort_by];
    sort(answer.begin(), answer.end(),srt);
    return answer;
}