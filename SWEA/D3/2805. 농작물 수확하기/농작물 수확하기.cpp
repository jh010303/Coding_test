#include <iostream>
#include <algorithm>
#include <memory.h>

using namespace std;

int farm[50][50];

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int t,size,ans=0,start,ran;
	string temp;
	bool first = true;
	cin >> t;
	for (int i = 0; i <t; i++) {
		cin >> size;
		start = size / 2;
		ran = 0;
		ans = 0;
		first = true;
		memset(farm, 0, sizeof(farm));
		for (int j = 0; j < size; j++) {
			cin >> temp;
			for (int r = 0; r < temp.size(); r++) {
				farm[j][r] = temp[r] - '0';
			}
		}
		for (int j = 0; j < size; j++) {
			if (j > size / 2) {
				if (first) {
					ran = size / 2 - 1;
					first = false;
				}
				for (int r = start - ran; r <= start + ran; r++) {
					ans += farm[j][r];
				}
				ran--;
			}
			else {
				for (int r = start - ran; r <= start + ran; r++) {
					ans += farm[j][r];
				}
				ran++;
			}
		}
		cout << '#' << i + 1 << ' ' << ans << '\n';
	}
}