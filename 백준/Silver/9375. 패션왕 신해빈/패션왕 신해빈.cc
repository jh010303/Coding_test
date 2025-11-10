#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

unordered_map<string, int> kind_index;
vector<vector<string>> clothes(31,vector<string>());

int main() {
	int t, n,ans=1,cloth_i;
	string cloth, kind;
	cin >> t;
	for (int i = 0; i < t; i++) {
		cin >> n;
		ans = 1;
		kind_index.clear();
		clothes = vector<vector<string>>(31, vector <string>());
		for (int j = 0; j < n; j++) {
			cin >> cloth >> kind;
			cloth_i = kind_index[kind];
			if (cloth_i == 0) {
				kind_index[kind] = j+1;
				clothes[j].push_back(cloth);
			}
			else {
				clothes[cloth_i - 1].push_back(cloth);
			}
		}
		for (auto kind : kind_index) {
			ans *= (clothes[kind.second-1].size()+1);
		}
		cout << ans - 1 << '\n';
	}
}