#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int T, N;
	string ans;
	cin >> T;
	for (int t = 0; t < T; t++) {
		cin >> N;
		ans = "0";
		vector<string> inputs;
		for (int i = 0; i < N; i++) {
			string word;
			cin >> word;
			inputs.push_back(word);
		}
		for (int i = 0; i < N && ans == "0"; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j || inputs[i][0]!=inputs[j][inputs[j].size()-1]) continue;
				string forward = inputs[i] + inputs[j], backward = inputs[i] + inputs[j];
				reverse(backward.begin(), backward.end());
				if (forward == backward) ans = forward;
			}
		}
		cout << ans << "\n";
	}
}