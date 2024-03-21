#include <iostream>
#include <vector>
#define MAX 1e18
long long N, K, ans;
using namespace std;
int main() {
	cin.tie(0);
	cout.tie(0);
	ios_base::sync_with_stdio(false);

	cin >> N >> K;
	vector<long long> v;
	for (int i = 0; i < N; i++) {
		long long num; cin >> num;
		v.push_back(num);
	}

	for (long long l = 1, r = MAX;l<=r;) {
		long long m = (l+r) >> 1, sum = 0;
		for (long long num : v)  sum += num / m;
		if (K <= sum) {
			l = m + 1;
			ans = m;
		}
		else {
			r = m - 1;
		}
	}
	cout << ans;

	return 0;
}