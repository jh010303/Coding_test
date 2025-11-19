#include <iostream>
#include <string>
#include <algorithm>
#include <set>

using namespace std;

string max_num;
int ans = -1;

bool check_distinct(string num) {
	set<char> st;
	for (int i = 0; i < num.size(); i++) {
		st.insert(num[i]);
	}
	return st.size() == num.size();
}

void back_tracking(string num, int swap_cnt) {
	string original = num;
	int start = -1, end = -1;
	char temp;
	if (swap_cnt == 0) {
		ans = max(ans, stoi(num));
		return;
	}
	for (int i = 0; i < num.size(); i++) {
		if (num[i] != max_num[i]) {
			start = i;
			break;
		}
	}
	for (int i = num.size()-1; i >=0; i--) {
		if (num[i] != max_num[i]) {
			end = i;
			break;
		}
	}
	if (start == -1 || end == -1) {
		if (check_distinct(num)) {
			for (int i = 0; i < swap_cnt; i++) {
				temp = num[num.size() - 1];
				num[num.size() - 1] = num[num.size() - 2];
				num[num.size() - 2] = temp;
			}
		}
		back_tracking(num, 0);
		return;
	}
	// case1
	int max_temp=-1,max_index=0;
	for (int i = start; i <=end; i++) {
		if (max_temp <= num[i] - '0') {
			max_temp = num[i] - '0';
			max_index = i;
		}
	}
	temp = num[0];
	num[0] = num[max_index];
	num[max_index] = temp;
	back_tracking(num, swap_cnt - 1);

	// case2
	int min_temp = 10, min_index=0;
	num = original;
	for (int i = start; i <= end; i++) {
		if (min_temp > num[i] - '0') {
			min_temp = num[i] - '0';
			min_index = i;
		}
	}
	temp = num[min_index];
	num[min_index] = num[max_index];
	num[max_index] = temp;
	back_tracking(num, swap_cnt - 1);
}

int main() {
	string num;
	int t,swap_cnt;
	cin >> t;
	for (int i = 0; i < t; i++) {
		cin >> num >> swap_cnt;
		max_num = num;
		ans = -1;
		sort(max_num.begin(), max_num.end(),greater<>());
		back_tracking(num, swap_cnt);
		cout << '#' << i + 1 << ' ' << ans << '\n';
	}
}