#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<pair<int, int>> fast[10001];
int dp[10001];


int main() {
	int n, d,start,end,dis;
	cin >> n >> d;
	for (int i = 0; i < n; i++) {
		cin >> start >> end >> dis;
		fast[end].push_back({ start,dis });
	}
	dp[0] = 0;
	for (int i = 1; i <= d; i++) {
		dp[i] = dp[i - 1] + 1;
		for (int j = 0; j < fast[i].size(); j++) {
			dp[i] = min(dp[i], fast[i][j].second + dp[fast[i][j].first]);
		}
	}
	cout << dp[d];
}