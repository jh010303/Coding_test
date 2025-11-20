#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<string> mp;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int cnt,start,end,ans;
	bool paslin;
	string temp;
	for (int i = 0; i <10; i++) {
		cin >> cnt;
		mp.clear();
		ans = 0;
		paslin = true;
		for (int j = 0; j < 8; j++) {
			cin >> temp;
			mp.push_back(temp);
		}
		for (int j = 0; j < 8; j++) {
			for (int r = 0; r < 8; r++) {
				// 가로
				if (r + cnt - 1 < 8) {
					start = r, end = r + cnt - 1;
					while (start < end) {
						if (mp[j][start] != mp[j][end]) {
							paslin = false;
							break;
						}
						start++;
						end--;
					}
				}
				else {
					paslin = false;
				}
				if (paslin) {
					ans++;
				}
				paslin = true;
				// 세로
				if (j + cnt - 1 < 8) {
					start = j, end = j + cnt - 1;
					while (start < end) {
						if (mp[start][r] != mp[end][r]) {
							paslin = false;
							break;
						}
						start++;
						end--;
					}
				}
				else {
					paslin = false;
				}
				if (paslin) {
					ans++;
				}
				paslin = true;
			}
		}
		cout << '#' << i + 1 << ' ' << ans << '\n';
	}
	return 0;
}