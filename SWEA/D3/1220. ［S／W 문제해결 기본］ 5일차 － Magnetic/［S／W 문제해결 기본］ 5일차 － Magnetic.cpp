#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int mp[101][101];

int main(int argc, char** argv)
{
	int test_case;
	int T,ans,n;
	bool start = false;

	for (test_case = 1; test_case <= 10; ++test_case)
	{
		cin >> T;
		ans = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				cin >> mp[i][j];
			}
		}
		for (int i = 0; i < 100; i++) {
			start = false;
			for (int j = 0; j < 100; j++) {
				if (!start && mp[j][i] == 1) {
					start = true;
				}
				else if (start && mp[j][i] == 2) {
					ans++;
					start = false;
				}
			}
		}

		cout << '#' << test_case << ' ' << ans << '\n';
	}
	return 0;
}