#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

queue<int> number;

void print_queue() {
	while (!number.empty()) {
		cout << number.front() << ' ';
		number.pop();
	}
	cout << '\n';
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int t, ans,temp,minus=1;
	for (int i = 0; i <10; i++) {
		cin >> t;
		minus = 1;
		for (int j = 0; j < 8; j++) {
			cin >> temp;
			number.push(temp);
		}
		temp = -1;
		while (temp!=0) {
			if (minus > 5)minus = 1;
			temp = number.front();
			number.pop();
			if (temp - minus <= 0) {
				temp = 0;
			}
			else {
				temp -= minus;
			}
			number.push(temp);
			minus++;
		}
		cout << '#' << i + 1 << ' ';
		print_queue();
	}
}