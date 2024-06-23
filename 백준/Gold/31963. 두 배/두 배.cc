#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

string to_binary_string(int num){
	string ret = "";
	for (int i = 1; num >= i; i <<= 1){
		ret = ((num&i) == 0 ? "0" : "1") + ret;
	}
	return ret;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	long long N, num, ans = 0, mexp = 0;
	cin >> N >> num;
	string mx, now;
	mx = to_binary_string(num);
	for (int i = 1; i < N; i++){
		cin >> num;
		now = to_binary_string(num);

		if (mx.length() + mexp < now.length() || (mx.length() + mexp == now.length() && mx <= now)){
			mx = now;
			mexp = 0;
			continue;
		}
		mexp = mx.length() + mexp - now.length();
		int mlen = min(mx.length(), now.length());
		for (int i = 0; i < mx.length(); i++){
			if (i == mlen){
				for (; i<mx.length(); i++){
					if (mx[i] == '0') continue;
					mexp++;
					i = mx.length();
					break;
				}
				break;
			}
			if (mx[i] == now[i]) continue;
			if (mx[i] > now[i]) mexp++;
			break;
		}

		mx = now;
		ans += mexp;
	}
	cout << ans;
	cin >> N;
}