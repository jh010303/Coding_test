#include <iostream>

using namespace std;

long long dp[1001];

long long f(int n) {
	if (n < 2) return 1;
	if (dp[n] > 0) return dp[n];
	dp[n] = f(n - 1) + f(n - 2);
	return dp[n]%10007;
}

int main() {
	int n;
	long long ans;
	cin >> n;
	ans = f(n);
	cout << ans;
}