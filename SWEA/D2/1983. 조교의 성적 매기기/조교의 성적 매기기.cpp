#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<pair<int, double>> students;
string score[10] = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };

bool custom_srt(const pair<int, double>& a, const pair<int, double>& b) {
	return a.second > b.second;
}

int main() {
	int t,n,k,mid,final,prac;
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	cin >> t;
	for (int i = 0; i < t; i++) {
		cout << '#' << i + 1 << ' ';
		cin >> n >> k;
		students.clear();
		for (int j = 0; j < n; j++) {
			cin >> mid >> final >> prac;
			students.push_back({ j+1,mid * 0.35 + final * 0.45 + prac * 0.2 });
		}
		sort(students.begin(), students.end(), custom_srt);
		for (int j = 0; j < students.size(); j++) {
			if (students[j].first == k) {
				cout << score[j / (n/10)] << '\n';
				break;
			}
		}
	}
}