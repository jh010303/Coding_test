#include <iostream>
#include <vector>
using namespace std;

vector<long long> line;

int cut(int length) {
	int ans = 0;
	for (int i = 0; i < line.size(); i++) {
		ans += line[i] / length;
	}
	return ans;
}

int main() {
	int k, n, temp,max = 0,cnt = 0;
	cin >> k >> n;
	for (int i = 0; i < k; i++) {
		cin >> temp;
		line.push_back(temp);
		if (max < temp)max = temp;
	}
	long long start = 1, mid=0, end = max, ans = 0;
	while (start<=end) {
		mid = (start + end) / 2;
		cnt = 0;
		cnt = cut(mid);
		if (cnt < n) {
			end = mid - 1;
		}
		else {
			ans = mid;
			start = mid + 1;
		}
	}
	cout << ans;
}