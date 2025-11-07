#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int n, ans = 500001, totalCntR = 0, totalCntB = 0, cntR = 0, cntB = 0;
	bool startR = false, startB = false;
	string temp;
	char cur, bef;
	cin >> n;
	cin >> temp;
	if (temp.find('R') == string::npos || temp.find('B')==string::npos) {
		cout << '0';
		return 0;
	}

	for (int i = 0; i < temp.size(); i++) {
		if (temp[i] == 'B') {
			totalCntR += cntR;
			cntR = 0;
			cntB++;
		}
		if (temp[i] == 'R') {
			totalCntB += cntB;
			cntB = 0;
			cntR++;
		}
	}

	ans = min(ans, min(totalCntB,totalCntR));
	totalCntR = 0, totalCntB = 0;
	for (int i = 0; i < temp.size(); i++) {
		if (temp[i] == 'B') {
			startR = true;
			if (startB) {
				totalCntB++;
			}
		}
		if (temp[i] == 'R') {
			startB = true;
			if (startR) {
				totalCntR++;
			}
		}
	}
	ans = min(ans, min(totalCntB, totalCntR));
	cout << ans;
}