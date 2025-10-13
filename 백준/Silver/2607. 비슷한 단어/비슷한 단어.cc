#include <iostream>
#include <unordered_map>
#include <set>
#include <math.h>
using namespace std;

unordered_map<char, int> word_mp, temp_mp;

int main() {
	cin.tie(NULL);
	cin.sync_with_stdio(false);

	int n,ans=0,word_size,temp_size,dif=0;
	string word, temp,merged,set_str;
	cin >> n;
	cin >> word;
	word_size = word.size();
	for (int i = 0; i < word_size; i++) {
		word_mp[word[i]]++;
	}

	for (int i = 0; i < n-1; i++) {
		cin >> temp;
		temp_size = temp.size();
		merged = word + temp;
		set<char> str_set(merged.begin(), merged.end());
		for (int j = 0; j < temp_size; j++) {
			temp_mp[temp[j]]++;
		}
		for (char c : str_set) {
			dif += abs(word_mp[c] - temp_mp[c]);
		}
		if (dif==0 || dif == 1 || abs(word_size-temp_size)==0 && dif ==2) ans++;
		dif = 0;
		temp_mp.clear();
		str_set.clear();
	}
	
	cout << ans;
}