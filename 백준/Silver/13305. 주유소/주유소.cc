#include <string>
#include <vector>
#include <iostream>
using namespace std;

int main() {
	int n;
	long long temp, price=0, min = 1000000001;
	vector<long long> distance_list, price_list;
	cin >> n;
	for (int i = 0; i < n - 1; i++) {
		cin >> temp;
		distance_list.push_back(temp);
	}
	for (int i = 0; i < n; i++) {
		cin >> temp;
		price_list.push_back(temp);
	}
	for (int i = 0; i < n-1; i++) {
		if (i == 0) {
			price += (price_list[i] * distance_list[i]);
			min = price_list[i];
		}
		else {
			if (min < price_list[i]) {
				price += (min * distance_list[i]);
			}
			else {
				price += (price_list[i] * distance_list[i]);
				min = price_list[i];
			}
		}
	}
	cout << price;
}