#include <iostream>
#include <climits>

using namespace std;

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(false);
    int N, ans = INT_MIN;
    cin >> N;
    int psum[N + 1][N + 1];
    for (int r = 0; r < N; r++) {
        for (int c = 0; c < N; c++) {
            cin >> psum[r + 1][c + 1];
            psum[r + 1][c + 1] += psum[r + 1][c] + psum[r][c + 1] - psum[r][c];
        }
    }
    for (int size = 1; size <= N; size++) {
        for (int r = size; r <= N; r++) {
            for (int c = size; c <= N; c++) {
                ans = max(ans, psum[r][c] - psum[r - size][c] - psum[r][c - size] + psum[r - size][c - size]);
            }
        }
    }
    cout << ans;
    return 0;
}