#include <iostream>
#include <stack>
#include <queue>
#include <vector>
#include <algorithm>
#include <memory.h>

using namespace std;

vector<vector<int>> vertex(1001);
stack<int> dfs_stk;
queue<int> bfs_que;

bool visited[1001];
int main() {
	int n, m, v,a,b,top,next;
	cin >> n >> m >> v;
	for (int i = 0; i < m; i++) {
		cin >> a >> b;
		vertex[a].push_back(b);
		vertex[b].push_back(a);
	}
	for (int i = 0; i <= n; i++) sort(vertex[i].begin(), vertex[i].end(),greater<>());
	dfs_stk.push(v);
	bfs_que.push(v);
	while (!dfs_stk.empty()) {
		top = dfs_stk.top();
		if (visited[top]) {
			dfs_stk.pop();
			continue;
		}
		dfs_stk.pop();
		cout << top << ' ';
		visited[top] = true;
		for (int i = 0; i < vertex[top].size(); i++) {
			next = vertex[top][i];
			if (visited[next])continue;
			dfs_stk.push(next);
		}
	}
	memset(visited, 0, sizeof(visited));
	for (int i = 0; i < n; i++) sort(vertex[i].begin(), vertex[i].end());
	cout << '\n';
	while (!bfs_que.empty()) {
		top = bfs_que.front();
		bfs_que.pop();
		cout << top << ' ';
		visited[top] = true;
		for (int i = 0; i < vertex[top].size(); i++) {
			next = vertex[top][i];
			if (visited[next])continue;
			bfs_que.push(next);
			visited[next] = true;
		}
	}
}