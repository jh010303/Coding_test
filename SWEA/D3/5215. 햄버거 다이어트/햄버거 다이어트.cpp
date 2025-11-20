#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<pair<int, int>> ingredients;

int n, l, ans = -1;

void back_tracking(int index,int score, int cal) {
	if (cal > l) {
		return;
	}
	if (index >= ingredients.size()) {
		ans = max(ans, score);
		return;
	}
	back_tracking(index + 1, score, cal);
	score+=ingredients[index].first;
	cal+=ingredients[index].second;
	back_tracking(index + 1, score, cal);
}

int main(int argc, char** argv)
{
	int test_case;
	int T,score,cal;

	cin >> T;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		ans = -1;
		ingredients.clear();
		cin >> n >> l;
		for (int i = 0; i < n; i++) {
			cin >> score >> cal;
			ingredients.push_back({ score,cal });
		}
		back_tracking(0,0,0);
		cout << '#' << test_case << ' ' << ans << '\n';
	}
	return 0;
}