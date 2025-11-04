#include <iostream>
using namespace std;

bool visited[10];
int answer[10];
int main() {
	int n,higher,count = 0;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> higher;
		count = 0;
		for (int j = 0; j < n; j++) {
			if (visited[j]) continue;
			else if (count < higher) {
				count++;
				continue;
			}
			visited[j] = true;
			answer[j] = i + 1;
			break;
		}
	}
	for (int i = 0; i < n; i++) {
		cout << answer[i] << ' ';
	}
}