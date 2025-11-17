#include <iostream>
#include <vector>
#include <memory.h>
#include <string>

using namespace std;

bool visited[10];

bool check_visited() {
	for (auto vis : visited) {
		if (vis == false) return false;
	}
	return true;
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int t, n,origin,in=0;
	string num;
	cin >> t;
	for (int i = 0; i < t; i++) {
		cout << '#' << i + 1 << ' ';
		memset(visited, false, sizeof(visited));
		cin >> n;
		origin = n;
		in = 0;
		while (!check_visited()){
			if (in != 0) {
				n += origin;
			}
			num = to_string(n);
			for (int j = 0; j < num.size(); j++) {
				visited[num[j] - '0'] = true;
			}
			in++;
		}
		cout << n << '\n';
	}
}