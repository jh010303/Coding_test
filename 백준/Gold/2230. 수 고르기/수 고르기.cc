#include <iostream>
#include <vector> 
#include <algorithm>

using namespace std;

vector<int> seq;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int n, m, temp,min=2000000001;
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> temp;
		seq.push_back(temp);

	}
	sort(seq.begin(), seq.end());
	
	int left = 0, right = 0, diff=0;
	while (left < n && right < n) {
		diff = seq[right] - seq[left];
		if (diff < m) {
			right++;
		}
		else {
			if (min > diff) {
				min = diff;
			}
			left++;
		}
	}
	cout << min;
}