#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <unordered_map>
using namespace std;

vector<string> dic;
unordered_map<string, int> cnt;

bool custom(const string &a, const string &b) {
	if (cnt[a] > cnt[b]) return true;
	else if (cnt[a] < cnt[b]) return false;
	else if ((a).size() > (b).size()) return true;
	else if ((a).size() < (b).size()) return false;
	return a < b;
}

int main() {
	int n, m;
	string temp;
	cin.tie(NULL);
	cin.sync_with_stdio(false);
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> temp;
		if (cnt[temp] > 0) {
			cnt[temp]++;
			continue;
		}
		if (temp.size() >= m) {
			dic.push_back(temp);
			cnt[temp]++;
		}
	}
	stable_sort(dic.begin(), dic.end(), custom);
	for(int i=0; i<dic.size(); i++){
		cout << dic[i] << '\n';
	}
}