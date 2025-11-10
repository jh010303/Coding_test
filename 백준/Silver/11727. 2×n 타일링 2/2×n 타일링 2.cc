#include <iostream>

using namespace std;
long long dp[1001];

int dp_func(int n) {
	if (dp[n] != 0)return dp[n];
	dp[n] = (dp_func(n - 1) + 2*dp_func(n - 2))%10007;
	return dp[n];
}

int main() {
	int n;
	dp[1] = 1, dp[2] = 3;
	cin >> n;
	cout << dp_func(n);
}