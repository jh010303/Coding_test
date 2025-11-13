#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> list_a;
vector<int> list_b;

int main() {
	int t, n, m, max_ele = -1, temp, sum = 0,index=0;
	cin >> t;
	for (int i = 0; i < t; i++) {
		list_a.clear();
		list_b.clear();
		max_ele = -1;
		cin >> n >> m;
		for (int j = 0; j < n; j++) {
			cin >> temp;
			list_a.push_back(temp);
		}
		for (int j = 0; j < m; j++) {
			cin >> temp;
			list_b.push_back(temp);
		}
		if (n < m) {
			for (int j = 0; j <= m-n; j++) {
				sum = 0;
				index = 0;
				for (int r = j; r < j+n; r++) {
					sum += list_a[index++] * list_b[r];
				}
				max_ele = max(sum, max_ele);
			}
		}
		else {
			for (int j = 0; j <= n-m; j++) {
				sum = 0;
				index = 0;
				for (int r = j; r < j + m; r++) {
					sum += list_a[r] * list_b[index++];
				}
				max_ele = max(sum, max_ele);
			}
		}
		cout << '#' << i + 1 << ' ' << max_ele << '\n';
	}
}