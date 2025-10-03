#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main() {
	string number, num_str;
	int idx = 0, num = 1;
	cin >> number;
	while (idx != number.length()) {
		num_str = to_string(num);
		for (int i = 0; i < num_str.length(); i++) {
			if (number[idx] == num_str[i]) {
				idx++;
				if (idx >= number.length()) {
					break;
				}
			}
		}
		num++;
	}
	cout << num - 1;
}