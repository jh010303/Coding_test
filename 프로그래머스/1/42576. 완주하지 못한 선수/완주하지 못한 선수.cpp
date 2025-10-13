#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

unordered_map<string, int> mp;

string solution(vector<string> participant, vector<string> completion) {
	string answer = "";
	for (int i = 0; i < participant.size(); i++) {
		mp[participant[i]]++;
	}
	for (int i = 0; i < completion.size(); i++) {
		mp[completion[i]]--;
	}
	for (auto temp : mp) {
		if (temp.second >= 1) {
			answer = temp.first;
			break;
		}
	}
	return answer;
}