#include <iostream>
#include <set>
#include <vector>
#include <algorithm>
#include <memory.h>

using namespace std;

bool ate[3001];
vector<int> sushi;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int n, d, k, c, temp, ans=-1, left=0, right=0,cnt=0;
	cin >> n >> d >> k >> c;
	for (int i = 0; i < n; i++) {
		cin >> temp;
		sushi.push_back(temp);
	}

	for (int i = 0; i < n; i++) {
		left = i, right = left + k;
		memset(ate, false, sizeof(ate));
		cnt = 1; ate[c] = true;
		for (int j = left; j < right; j++) {
			temp = sushi[j%n];
			if (!ate[temp]) {
				cnt++;
				ate[temp] = true;
			}
		}
		ans = max(ans, cnt);
	}
	cout << ans;
}