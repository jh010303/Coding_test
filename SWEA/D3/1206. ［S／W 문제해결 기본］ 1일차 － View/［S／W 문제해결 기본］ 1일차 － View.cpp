#include <iostream>
#include <memory.h>
#include <algorithm>

using namespace std;

int apart[1001];

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int t,ans = 0,max_h1,max_h2;
	for (int i = 0; i < 10; i++) {
		cin >> t;
		ans = 0;
		memset(apart, 0, sizeof(apart));
		for (int j = 0; j < t; j++) {
			cin >> apart[j];
		}
		for (int j = 0; j < t; j++) {
			max_h1 = max(j - 1 >= 0 ? apart[j - 1] : 0, j + 1 < t ? apart[j + 1] : 0);
			max_h2 = max(j - 2 >= 0 ? apart[j - 2] : 0, j + 2 < t ? apart[j + 2] : 0);
			max_h1 = max(max_h1, max_h2);
			ans += (apart[j] - max_h1 > 0 ? apart[j] - max_h1 : 0);
			max_h1 = 0; max_h2 = 0;
		}
		cout << '#' << i + 1 << ' ' << ans << '\n';
	}
}