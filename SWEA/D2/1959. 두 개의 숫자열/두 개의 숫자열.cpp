#include <iostream>
#include <algorithm>
#include <memory.h>

using namespace std;

int ai[21];
int bi[21];
int main(int argc, char** argv)
{
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int test_case,T,ans=-1000001,sum=0,origin_index=0;
	int n, m;
	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		cin >> n >> m;
		memset(ai, 0, sizeof(ai));
		memset(bi, 0, sizeof(bi));
		ans = -1000001;
		sum = 0;
		for (int i = 0; i < n; i++) {
			cin >> ai[i];
		}
		for (int i = 0; i < m; i++) {
			cin >> bi[i];
		}

		// ai 기준
		if (n >= m) {
			for (int i = 0; i <= n - m; i++) {
				sum = 0;
				origin_index = 0;
				for (int j = i; j <= i + m; j++) {
					sum += (ai[j] * bi[origin_index++]);
				}
				ans = max(ans, sum);
			}
		}
		// bi 기준
		else {
			for (int i = 0; i <= m - n; i++) {
				sum = 0;
				origin_index = 0;
				for (int j = i; j <= i + n; j++) {
					sum += (ai[origin_index++] * bi[j]);
				}
				ans = max(ans, sum);
			}
		}
		cout << '#' << test_case << ' ' << ans << '\n';
	}
	return 0;
}