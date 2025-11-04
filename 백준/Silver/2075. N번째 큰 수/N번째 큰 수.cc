#include <iostream>
#include <queue>
using namespace std;

priority_queue<long long,vector<long long>,greater<long long>> pq;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	long long n,temp;
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