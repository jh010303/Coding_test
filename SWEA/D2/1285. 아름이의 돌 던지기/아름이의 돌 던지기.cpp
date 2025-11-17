#include <iostream>
#include <math.h>

using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int t, n, temp, cnt = 0, min_n = 100001;
	cin >> t;
	for (int i = 0; i < t; i++) {
		cout << '#' << i + 1 << ' ';
		cin >> n;
		cnt = 0;
		min_n = 100001;
		for (int j = 0; j < n; j++) {
			cin >> temp;
			temp = abs(temp - 0);
			if (min_n > temp) {
				min_n = temp;
				cnt = 1;
			}
			else if (min_n == temp) {
				cnt++;
			}
		}
		cout << min_n << ' ' << cnt << '\n';
	}
}