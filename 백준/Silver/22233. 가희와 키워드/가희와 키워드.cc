#include <iostream>
#include <sstream>
#include <vector>
#include <unordered_map>

using namespace std;

unordered_map<string, int> keyword_mp;
vector<string> tmp_list;

int main() {
	cin.tie(NULL);
	cin.sync_with_stdio(false);
	int n, m,count;
	string keyword;
	cin >> n >> m;
	count = n;
	for (int i = 0; i < n; i++) {
		cin >> keyword;
		keyword_mp[keyword]++;
	}
	for (int i = 0; i < m; i++) {
		tmp_list.clear();
		cin >> keyword;
		istringstream iss(keyword);
		while (getline(iss, keyword, ',')) {
			tmp_list.push_back(keyword);
		}
		for (int j = 0; j < tmp_list.size(); j++) {
			if (keyword_mp[tmp_list[j]]>0) {
				keyword_mp[tmp_list[j]]--;
				count--;
			}
		}
		cout << count << '\n';
	}

}