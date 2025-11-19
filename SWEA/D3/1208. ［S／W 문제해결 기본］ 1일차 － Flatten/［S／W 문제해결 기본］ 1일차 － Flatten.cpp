#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> box;
int main() {
	int n,temp,max_box,min_box,ans=-1;
	for (int i = 0; i < 10; i++) {
		cin >> n;
		box.clear();
		for (int j = 0; j < 100; j++) {
			cin >> temp;
			box.push_back(temp);
		}
		for (int j = 0; j < n; j++) {
			max_box = *max_element(box.begin(), box.end());
			min_box = *min_element(box.begin(), box.end());
			if (max_box - min_box <=1) {
				break;
			}
			else {
				(*max_element(box.begin(), box.end()))--;
				(*min_element(box.begin(), box.end()))++;
			}
		}
		max_box = *max_element(box.begin(), box.end());
		min_box = *min_element(box.begin(), box.end());
		ans = max_box - min_box;
		cout << '#' << i + 1 << ' ' << ans << '\n';
	}
}