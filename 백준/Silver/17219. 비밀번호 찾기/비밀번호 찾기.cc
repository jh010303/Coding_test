#include <iostream>
#include <unordered_map>

using namespace std;

unordered_map<string, string> site_password;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int n, m;
	cin >> n >> m;
	string site, password;

	for (int i = 0; i < n; i++) {
		cin >> site >> password;
		site_password[site] = password;
	}

	for (int i = 0; i < m; i++) {
		cin >> site;
		cout << site_password[site] << '\n';
	}
}