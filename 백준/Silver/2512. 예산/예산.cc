#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> budget_list;

int budget_sum(int limit) {
	int sum = 0,temp=0;
	for(int i=0; i<budget_list.size(); i++){
		temp = budget_list[i];
		if (temp > limit) {
			sum += limit;
		}
		else {
			sum += temp;
		}
	}
	return sum;
}

int main() {
	int n, temp, low=1,ans=0,high=-1;
	long long budget;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> temp;
		if (high < temp)high = temp;
		budget_list.push_back(temp);
	}
	cin >> budget;
	ans = (low + high) / 2;
	while (low <= high) {
		if (budget == budget_sum(ans)) {
			break;
		}
		if (budget < budget_sum(ans)) {
			high = ans-1;
		}
		else {
			low = ans+1;
		}
		ans = (low + high) / 2;
	}
	cout << ans;
}