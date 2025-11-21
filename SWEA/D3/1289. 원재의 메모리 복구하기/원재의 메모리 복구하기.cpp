#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

int main(int argc, char** argv)
{
	int test_case,T,ans;
	string temp;
	char bef, cur;
	bool first = true;
	cin >> T;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		cin >> temp;
		ans = 0;
		first = true;
		for (int i = 0; i < temp.size(); i++) {
			cur = temp[i];
			if (first && cur == '0') {
				continue;
			}
			else if (first && cur!='0') {
				first = false;
				bef = cur;
				ans++;
				continue;
			}
			if (cur != bef) {
				bef = cur;
				ans++;
			}
		}

		cout << '#' << test_case << ' ' << ans << '\n';
	}
	return 0;
}