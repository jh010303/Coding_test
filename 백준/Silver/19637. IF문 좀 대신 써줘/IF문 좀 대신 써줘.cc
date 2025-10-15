#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;

unordered_map<int, string> mp;
vector<int> if_list;

void if_func(int power) {
	if (!mp[power].empty()) {
		cout << mp[power] << '\n';
		return;
	}
	int low = 0, high = if_list.size() - 1, mid,val;
	while (low < high) {
		mid = (low + high) / 2;
		val = if_list[mid];
		if (power < val) {
			high = mid;
		}
		else if (power > val) {
			low = mid+1;
		}
		else {
			break;
		}
	}
	cout << mp[if_list[high]] << '\n';
}

int main() {
	cin.tie(NULL);
	cin.sync_with_stdio(false);

	int n, m, power;
	string style;
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> style >> power;
		if (mp[power].empty()) {
			mp[power] = style;
			if_list.push_back(power);
		}
	}

	for (int i = 0; i < m; i++) {
		cin >> power;
		if_func(power);
	}
}