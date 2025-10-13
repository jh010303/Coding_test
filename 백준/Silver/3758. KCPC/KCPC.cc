#include <iostream>
#include <vector>
#include <string.h>

using namespace std;
int team_score[101][101];
int team_sum[101];
int team_count[101];
int time_log[101];

int main() {
	cin.tie(NULL);
	cin.sync_with_stdio(false);
	int test_case, n, k, t, m, team_id, j, s,ans=1;
	cin >> test_case;
	for (int i = 0; i < test_case; i++) {
		memset(team_score, 0, sizeof(team_score));
		memset(team_sum, 0, sizeof(team_sum));
		memset(team_count, 0, sizeof(team_count));
		memset(time_log, 0, sizeof(time_log));
		cin >> n >> k >> t >> m;
		for (int z = 0; z < m; z++) {
			cin >> team_id >> j >> s;
			if (s > team_score[team_id][j]) {
				team_sum[team_id] += (s - team_score[team_id][j]);
				team_score[team_id][j] = s;
			}
			team_count[team_id]++;
			time_log[team_id] = z;
		}
		for (int z = 1; z <= n; z++) {
			if (t == z)continue;
			if (team_sum[t] < team_sum[z]) {
				ans++;
			}
			else if (team_sum[t] == team_sum[z]) {
				if (team_count[t] > team_count[z]) {
					ans++;
				}
				else if (team_count[t] == team_count[z] && time_log[t] > time_log[z]) {
					ans++;
				}
			}
		}
		cout << ans << '\n';
		ans = 1;
	}
}
