#include <iostream>
#include <queue>
using namespace std;

priority_queue<int,vector<int>,greater<int>> pq;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int n,temp;
	cin >> n;
	for (int i = 0; i < n * n; i++) {
		cin >> temp;
		pq.push(temp);
		if (pq.size() > n) {
			pq.pop();
		}
	}
	cout << pq.top();
}