#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

unordered_map<string, int> kind_index;
vector<vector<string>> clothes(31,vector<string>());

void init_clothes() {
	for (int i = 0; i < 31; i++) {
		clothes[i].clear();
	}
}

int main() {
	int t, n,ans=1;
	string cloth, kind;
	cin >> t;
	for (int i = 0; i < t; i++) {
		cin >> n;
		ans = 1;
		kind_index.clear();
		init_clothes();
		for (int j = 0; j < n; j++) {
			cin >> cloth >> kind;
			if (kind_index[kind] == 0) {
				kind_index[kind] = j+1;
				clothes[j].push_back(cloth);
			}
			else {
				clothes[kind_index[kind] - 1].push_back(cloth);
			}
		}
		for (auto kind : kind_index) {
			ans *= (clothes[kind.second-1].size()+1);
		}
		cout << ans - 1 << '\n';
	}
}