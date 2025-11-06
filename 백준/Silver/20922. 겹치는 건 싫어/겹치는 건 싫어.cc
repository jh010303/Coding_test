#include <iostream>
#include <vector>

using namespace std;

int cnt[100001];
int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int n, k, temp, max=0;
	vector<int> seq;

	cin >> n >> k;
	for (int i = 0; i < n; i++) {
		cin >> temp;
		seq.push_back(temp);
	}

	int left = 0, right = 0;
	while (right < seq.size() && left<seq.size()) {
		if (cnt[seq[right]] < k) {
			cnt[seq[right]]++;
			right++;
		}
		else {
			cnt[seq[left]]--;
			left++;
		}
		if (max < right - left) {
			max = right - left;
		}
	}
	cout << max;
}