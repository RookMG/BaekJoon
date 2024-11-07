#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
struct Node {
	int r, c, color;

	Node(int _r, int _c, int _color) {
		r = _r;
		c = _c;
		color = _color;
	}
};
int R, C, green, red, ans = 0, region[50][50], delta[4][2] = { {1,0},{-1,0},{0,1},{0,-1} };
vector<int> colors;
vector<pair<int, int>> starts;
vector<vector<int>> visit;
queue<Node> q;

bool isIn(int r, int c) {
	return 0 <= r && r < R && 0 <= c && c < C;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> R >> C >> green >> red;
	for (int r = 0;r < R;r++) {
		for (int c = 0;c < C;c++) {
			cin >> region[r][c];
			if (region[r][c] == 2) starts.push_back({ r,c });
		}
	}
	colors = vector(starts.size(), 2);
	for (int i = 0;i < green + red;i++) colors[i] = i<green?0:1;

	do {
		visit = vector(R, vector(C, (int)1e9));
		while (!q.empty()) q.pop();
		for (int i = 0;i < starts.size();i++) {
			if (colors[i] == 2) continue;
			q.push({ starts[i].first, starts[i].second, colors[i]});
			visit[starts[i].first][starts[i].second] = colors[i];
		}
		for (int turn = 1, blossom = 0;!q.empty();turn++) {
			for (int s = q.size();s > 0;s--) {
				Node now = q.front();
				q.pop();
				if (visit[now.r][now.c] == -1) continue;
				for (int d = 0;d < 4;d++) {
					int nr = now.r + delta[d][0], nc = now.c + delta[d][1];
					if (!isIn(nr, nc) || region[nr][nc] == 0 || visit[nr][nc] < turn * 2 ) continue;
					if (visit[nr][nc] == turn * 2 + (1 - now.color)) {
						ans = max(ans, ++blossom);
						visit[nr][nc] = -1;
						continue;
					}
					else if (visit[nr][nc] == turn * 2 + now.color) {
						continue;
					}
					visit[nr][nc] = turn * 2 + now.color;
					q.push({ nr,nc, now.color });
				}
			}
		}
	} while (next_permutation(colors.begin(), colors.end()));
	
	cout << ans;
}