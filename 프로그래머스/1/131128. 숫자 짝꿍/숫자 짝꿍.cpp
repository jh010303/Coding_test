#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>
using namespace std;

string solution(string X, string Y) {
    string answer = "";
    unordered_map<char, int> x_map;
    unordered_map<char, int> y_map;
    char temp;
    int j = 0;
    bool not_zero = false;
    for (int i = 0; i < X.size(); i++) {
        x_map[X[i]]++;
    }
    for (int i = 0; i < Y.size(); i++) {
        y_map[Y[i]]++;
    }
    for (int i = 9; i >= 0; i--) {
        temp = i + '0';
        j = min(x_map[temp], y_map[temp]);
        if (i > 0 && j > 0) {
            not_zero = true;
        }
        for (int r = 0; r < j; r++) {
            answer += temp;
        }
    }
    if (answer == "") {
        return "-1";
    }
    else if (!not_zero) {
        return "0";
    }
    return answer;
}