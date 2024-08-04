#include <iostream>
#include <map>
#include <vector>
#include <algorithm>
#define MAX 500000
using namespace std;
int N;
long long ans = 0;
map<int, int> cnt;
bool notPrime[MAX + 51];
vector<long long> dp = vector<long long>(MAX+51), ndp = vector<long long>(MAX + 51);

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;
	for (int i = 0, num;i < N;i++) {
		cin >> num;
		cnt[num]++;
	}

	notPrime[1] = true;
	for (int i = 2;i <= MAX;i++) {
		if (notPrime[i]) continue;
		for (int j = i << 1;j <= MAX;j+=i) {
			notPrime[j] = true;
		}
	}

	dp[0] = 1;
	for (auto el : cnt) {
		int num = el.first, size = el.second;
		fill(ndp.begin(), ndp.end(), 0);
		for (int i = 0;i <= MAX;i++) {
			for (int j = 0;j <= size;j++) {
				if (i + num * j > MAX) break;
				ndp[i + num * j] += dp[i];
			}
		}
		swap(dp, ndp);
	}
	for (int i = 2;i <= MAX;i++) if (!notPrime[i]) ans += dp[i];
	cout << ans;
}