#include <iostream>
#include <memory.h>

using namespace std;

int score_map[101];

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int t, temp, max_n = -1,ans=0,test_num;
	cin >> t;
	for (int i = 0; i < t; i++) {
		cout << '#' << i + 1 << ' ';
		memset(score_map, 0, sizeof(score_map));
		max_n = -1;
		ans = 0;
		cin >> test_num;
		for (int j = 0; j < 1000; j++) {
			cin >> temp;
			score_map[temp]++;
		}
		for (int j = 0; j <= 100; j++) {
			if (max_n <= score_map[j]) {
				max_n = score_map[j];
				ans = j;
			}
		}
		cout << ans << '\n';
	}
}