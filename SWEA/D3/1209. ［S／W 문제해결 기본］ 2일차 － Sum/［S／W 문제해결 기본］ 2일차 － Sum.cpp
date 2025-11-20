#include <iostream>
#include <algorithm>
#include <memory.h>

using namespace std;

int mp[101][101];

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int t,ans=-1,sum=0;
	for (int i = 0; i < 10; i++) {
		cin >> t;
		memset(mp, 0, sizeof(mp));
		ans = -1;
		for (int j = 0; j < 100; j++) {
			for (int r = 0; r < 100; r++) {
				cin >> mp[j][r];
			}
		}
		for (int j = 0; j < 100; j++) {
			sum = 0;
			for (int r = 0; r < 100; r++) {
				sum += mp[j][r];
			}
			if (ans < sum) {
				ans = sum;
			}
		}
		for (int j = 0; j < 100; j++) {
			sum = 0;
			for (int r = 0; r < 100; r++) {
				sum += mp[r][j];
			}
			if (ans < sum) {
				ans = sum;
			}
			sum = -1;
		}
		sum = 0;
		for (int j = 0; j < 100; j++) {
			sum += mp[j][j];
		}
		if (ans < sum) {
			ans = sum;
		}
		sum = 0;
		for (int j = 0; j < 100; j++) {
			sum += mp[j][100-j];
		}
		if (ans < sum) {
			ans = sum;
		}
		cout << '#' << i + 1 << ' ' << ans << '\n';
	}
}