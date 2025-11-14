#include <iostream>
#include <vector>

using namespace std;

vector<pair<char, int>> file;

int main() {
	int t,n,siz,cursor;
	char alpha;
	cin >> t;
	for (int i = 0; i < t; i++) {
		cout << '#' << i + 1 << '\n';
		cin >> n;
		cursor = 0;
		file.clear();
		for (int j = 0; j < n; j++) {
			cin >> alpha >> siz;
			file.push_back({ alpha,siz });
		}
		for (int j = 0; j < file.size(); j++) {
			alpha = file[j].first; siz = file[j].second;
			for (int r = 0; r < siz; r++) {
				if (cursor >= 10) {
					cout << '\n';
					cursor = 0;
				}
				cout << alpha;
				cursor++;
			}
		}
		cout << '\n';
	}
}