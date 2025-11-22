#include <iostream>
#include <algorithm>
#include <memory.h>
#include <unordered_map>
#include <string>

using namespace std;

unordered_map<string, string> pwd;

int main(int argc, char** argv)
{
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int test_case,T,ans=0;
	int n, m;
	string site, password;
	//cin >> T;

	//for (test_case = 1; test_case <= T; ++test_case)
	//{
		cin >> n >>  m;
		for (int i = 0; i < n; i++) {
			cin >> site >> password;
			pwd[site] = password;
		}
		for (int i = 0; i < m; i++) {
			cin >> site;
			cout << pwd[site] << '\n';

		}
		//ans = 0;
		//cout << '#' << test_case << ' ' << ans << '\n';
	//}
	return 0;
}