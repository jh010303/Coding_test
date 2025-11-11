#include <iostream>
#include <math.h>
#include <algorithm>

using namespace std;

int dp[50001];

void init_dp() {
	for (int i = 2; i < sqrt(50000); i++) {
		dp[(int)pow(i, 2)] = 1;
	}
}

int main() {
	int n,cnt=0,pow_num;
	cin >> n;
	init_dp();
	for (int i = 1; i <= n; i++) {
		if (dp[i] == 1)continue;
		dp[i] = dp[i - 1] + 1;
		for (int j = 2; (int)pow(j, 2) < i; j++) {
			pow_num = (int)pow(j, 2);
			dp[i] = min(dp[i], dp[pow_num] + dp[i - pow_num]);
		}
	}
	cout << dp[n];
}