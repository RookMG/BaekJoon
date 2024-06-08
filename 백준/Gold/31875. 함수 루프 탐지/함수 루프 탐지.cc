#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>
using namespace std;

int N, len = 0, cnt = 1, spos = 0;
vector<int> arr, pos;
unordered_map<string, int> idx;
vector<string> words;

int main()
{
	cin.tie(0);
	cout.tie(0);
	ios_base::sync_with_stdio(false);
	cin >> N;
	for (int i = 0; i < N; i++){
		string word;
		cin >> word;
		if (idx.find(word) == idx.end()){
			idx[word] = idx.size();
			words.push_back(word);
		}
		arr.push_back(idx[word]);
	}
	pos = vector<int>(idx.size(), -1);

	for (int s = 0, e = 0; e < N; e++){
		if (pos[arr[e]] == -1){
			pos[arr[e]] = e;
			continue;
		}
		s = pos[arr[e]];
		int dupLen = 0;
		for (; e + dupLen < N && arr[s + dupLen] == arr[e + dupLen]; dupLen++);
		if (dupLen / (e - s) + 1 > cnt){
			spos = s;
			len = e - s;
			cnt = dupLen / (e - s) + 1;
		}
		s += dupLen;
		e = s;
		fill(pos.begin(), pos.end(), -1);
	}
	string ans = "-1";
	if (cnt != 1){
		ans = to_string(len) + " " + to_string(cnt) + "\n";
		for (int i = 0; i < len; i++) ans += words[arr[spos + i]] + " ";
	}
	cout << ans;
}