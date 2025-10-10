#include <iostream>
#include <algorithm>

#define MAX 99999999

using namespace std;
int map[6][6];
int n, m, ans;

int dp_f(int y,int x,int pre) {
	int val = 0;
	if (x<0 || x>=m || y<0 || y>=n) {
		return MAX;
	}
	if (y == 0) {
		return map[y][x];
	}
	if (pre == 0) {
		val = map[y][x] + min(dp_f(y - 1, x, 1), dp_f(y - 1, x + 1, 2));
	}
	else if (pre == 1) {
		val = map[y][x] + min(dp_f(y - 1, x-1, 0), dp_f(y - 1, x + 1, 2));
	}
	else if (pre == 2) {
		val = map[y][x] + min(dp_f(y - 1, x - 1, 0), dp_f(y - 1, x, 1));
	}
	return val;
	
}

int main() {
	cin.tie(NULL);
	cin.sync_with_stdio(false);
	cin >> n >> m;
	ans = MAX;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> map[i][j];
		}
	}
	
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < 3; j++) {
			ans = min(ans, dp_f(n-1, i, j));
		}
	}

	cout << ans;
}