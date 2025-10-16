#include <iostream>
#include <vector>
#include <math.h>
#include <algorithm>

using namespace std;

vector<vector<pair<int, string>>> room_list;

bool visited[301];

bool dic_sort(const pair<int,string> &a, const pair<int, string>& b) {
	return a.second < b.second;
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int p, m,l;
	string n;
	bool pushed = false;
	cin >> p >> m;
	for (int i = 0; i < p; i++) {
		cin >> l >> n;
		for (int j = 0; j < room_list.size(); j++) {
			if (visited[j]) continue;
			if (abs(l - room_list[j][0].first) <= 10) {
				room_list[j].push_back({ l,n });
				pushed = true;
				if (room_list[j].size() >= m) {
					visited[j] = true;
				}
				break;
			}
		}
		if (!pushed) {
			room_list.push_back({ {l,n} });
			if (room_list[room_list.size() - 1].size() >= m) {
				visited[room_list.size() - 1] = true;
			}
		}
		pushed = false;
	}
	for (int i = 0; i < room_list.size(); i++) {
		if (!visited[i]) {
			cout << "Waiting!" << '\n';
			sort(room_list[i].begin(), room_list[i].end(), dic_sort);
			for (int r = 0; r < room_list[i].size(); r++) {
				cout << room_list[i][r].first << ' ' << room_list[i][r].second << '\n';
			}
		}
		else {
			cout << "Started!" << '\n';
			sort(room_list[i].begin(), room_list[i].end(), dic_sort);
			for (int r = 0; r < room_list[i].size(); r++) {
				cout << room_list[i][r].first << ' ' << room_list[i][r].second << '\n';
			}
		}
	}
}