#include <iostream>
#include <string>
#include <unordered_map>

using namespace std;

string pokemon_list[100001];
unordered_map <string, int> pokemon_mp;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int n,m;
	string pokemon, ques;
	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		cin >> pokemon;
		pokemon_list[i + 1] = pokemon;
		pokemon_mp[pokemon] = i + 1;
	}

	for (int i = 0; i < m; i++) {
		cin >> ques;
		if ('1' <= ques[0] && ques[0] <= '9') {
			cout << pokemon_list[stoi(ques)] << '\n';
		}
		else {
			cout << pokemon_mp[ques] << '\n';
		}
	}
	
}