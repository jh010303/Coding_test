#include <iostream>
#include <queue>
#include <memory.h>
using namespace std;

int map[1001][1001];
int answer[1001][1001];
bool visited[1001][1001];
int dx[4] = { 1,-1,0,0 };
int dy[4] = { 0,0,1,-1 };
int n, m;
pair<int, int> goal;
queue<pair<pair<int, int>, int>> bfs_que;

void que_clear() {
	while (!bfs_que.empty()) {
		bfs_que.pop();
	}
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	memset(answer, -1, sizeof(answer));
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> map[i][j];
			if (map[i][j] == 0) {
				answer[i][j] = 0;
			}
			else if (map[i][j] == 2) {
				goal.first = i;
				goal.second = j;
			}
		}
	}

	bfs_que.push({ {goal.first,goal.second},0 });
	visited[goal.first][goal.second] = true;
	while (!bfs_que.empty()) {
		pair<int, int> cur = bfs_que.front().first;
		int depth = bfs_que.front().second;
		bfs_que.pop();
		answer[cur.first][cur.second] = depth;
		for (int i = 0; i < 4; i++) {
			int next_y = cur.first + dy[i];
			int next_x = cur.second + dx[i];
			if (next_y < 0 || next_y >= n || next_x < 0 || next_x >= m)continue;
			if (visited[next_y][next_x] || map[next_y][next_x] == 0)continue;
			bfs_que.push({ {next_y,next_x},depth + 1 });
			visited[next_y][next_x] = true;
		}
	}
	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cout << answer[i][j] << ' ';
		}
		if (i != n - 1) {
			cout << '\n';
		}
	}
}