#include <iostream>
#include <vector>
using namespace std;

bool ate[20001];
int main() {
	int n, k,ans=0;
	bool right = false;
	string list;
	cin >> n >> k;
	cin >> list;
	for (int i = 0; i < list.size(); i++) {
		if (list[i] == 'P') {
			for (int j = i - k; j <= i; j++) {
				if (j >= 0) {
					if (!ate[j] && list[j] == 'H') {
						ans++;
						ate[j] = true;
						right = true;
						break;
					}
				}
			}
			if (!right) {
				for (int j = i; j <= i + k; j++) {
					if (j < list.size()) {
						if (!ate[j] && list[j] == 'H') {
							ate[j] = true;
							ans++;
							break;
						}
					}
				}
			}
		}
		right = false;
	}
	cout << ans;
}