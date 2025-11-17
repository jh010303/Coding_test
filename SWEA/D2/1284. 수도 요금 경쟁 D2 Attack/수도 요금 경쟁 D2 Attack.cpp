#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int t,p,q,r,s,w,ans1,ans2;
	cin >> t;
	for (int i = 0; i < t; i++) {
		cout << '#' << i + 1 << ' ';
		ans1 = 0, ans2 = 0;
		cin >> p >> q >> r >> s >> w;
		ans1 = w * p;

		if (w <= r) ans2 = q;
		else {
			ans2 = q+(w - r) * s;
		}
		cout << min(ans1, ans2) << '\n';
	}
}