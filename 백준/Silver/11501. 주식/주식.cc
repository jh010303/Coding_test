#include <iostream>
#include <vector>

using namespace std;

vector<int> stock;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int t,n,temp,high=0;
	long ans;
	cin >> t;
	for (int i = 0; i < t; i++) {
		ans = 0;
		stock.clear();
		cin >> n;
		for (int j = 0; j < n; j++) {
			cin >> temp;
			stock.push_back(temp);
		}
		high = stock.back();
		for (int j = stock.size() - 2; j >= 0; j--) {
			if (high > stock[j]) {
				ans += high - stock[j];
			}
			else {
				high = stock[j];
			}
		}
		cout << ans << '\n';
	}
}