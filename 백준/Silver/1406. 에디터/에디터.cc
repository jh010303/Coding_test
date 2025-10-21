#include <iostream>
#include <stack>

using namespace std;

stack<char> left_stk, right_stk;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	string request;
	int m;
	char cmd, ch;
	cin >> request >> m;
	for (char c : request) {
		left_stk.push(c);
	}
	for (int i = 0; i < m; i++) {
		cin >> cmd;
		if (cmd == 'L') {
			if (!left_stk.empty()) {
				right_stk.push(left_stk.top());
				left_stk.pop();
			}
		}
		else if (cmd == 'D') {
			if (!right_stk.empty()) {
				left_stk.push(right_stk.top());
				right_stk.pop();
			}
		}
		else if (cmd == 'B') {
			if (!left_stk.empty()) {
				left_stk.pop();
			}
		}
		else if (cmd == 'P') {
			cin >> ch;
			left_stk.push(ch);
		}
	}

	while (!left_stk.empty()) {
		ch = left_stk.top();
		right_stk.push(ch);
		left_stk.pop();
	}
	while (!right_stk.empty()) {
		cout << right_stk.top();
		right_stk.pop();
	}
}