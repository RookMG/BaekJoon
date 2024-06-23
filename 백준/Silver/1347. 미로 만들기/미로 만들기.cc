#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;
vector<vector<char>> map = vector<vector<char>>(101,vector<char>(101,'#'));
int N, r, c, rmin, rmax, cmin, cmax, dir = 0;
int delta[4][2] = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	r = c = rmin = rmax = cmin = cmax = 50;
	string s;
	cin >> N >> s;
	map[r][c] = '.';
	for (auto ch : s){
		switch (ch){
		case 'L':
			dir = (dir + 3) % 4;
			break;
		case 'R':
			dir = (dir + 1) % 4;
			break;
		case 'F':
			r += delta[dir][0];
			c += delta[dir][1];
			map[r][c] = '.';
			rmin = min(rmin, r);
			rmax = max(rmax, r);
			cmin = min(cmin, c);
			cmax = max(cmax, c);
			break;
		}
	}
	for (r = rmin; r <= rmax; r++){
		for (c = cmin; c <= cmax; c++) cout << map[r][c];
		cout << '\n';
	}
}