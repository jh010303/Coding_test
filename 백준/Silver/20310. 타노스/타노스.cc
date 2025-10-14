#include <iostream>

using namespace std;

bool deleted[301];
int main() {
	string n;
	int one_count = 0, zero_count = 0,count=0;
	cin >> n;
	for (int i = 0; i < n.size(); i++) {
		if (n[i] == '0') {
			zero_count++;
		}
		else {
			one_count++;
		}
	}
	for (int i = 0; i < n.size(); i++) {
		if (count >= one_count/2)break;
		if (n[i] == '1') {
			deleted[i] = true;
			count++;
		}
	}
	count = 0;
	for (int i = n.size()-1; i >=0; i--) {
		if (count >= zero_count/2)break;
		if (n[i] == '0') {
			deleted[i] = true;
			count++;
		}
	}
	for (int i = 0; i < n.size(); i++) {
		if (!deleted[i]) {
			cout << n[i];
		}
	}
}