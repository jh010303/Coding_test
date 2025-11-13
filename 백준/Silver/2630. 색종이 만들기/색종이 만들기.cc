#include <iostream>
#include <vector>
using namespace std;

int white=0,blue=0;
int mp[129][129];
int color[2] = { 0,0 };

bool checkAll(int y, int x, int size) {
	int color = mp[y][x];
	for (int i = y; i < y+size; i++) {
		for (int j = x; j < x+size; j++) {
			if (mp[i][j] != color) {
				return false;
			}
		}
	}
	return true;
}

void div(int y, int x, int size) {
	if (checkAll(y, x, size) || size==1) {
		color[mp[y][x]]++;
		return;
	}
	size /= 2;
	div(y, x, size);
	div(y, x + size, size);
	div(y + size, x, size);
	div(y + size, x+size, size);
}

int main() {
	int n,temp;
	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> temp;
			mp[i][j] = temp;
		}
	}
	div(0, 0, n);
	for (int i = 0; i < 2; i++) {
		cout << color[i] << '\n';
	}
}