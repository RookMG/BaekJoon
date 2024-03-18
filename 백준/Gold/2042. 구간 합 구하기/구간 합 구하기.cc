#include <iostream>
#include <vector>
#include <math.h>

#define ll long long
using namespace std;

class SegmentTree {
private:
    vector<ll> tree;

public:
    void init(int size) {
        tree = vector<ll>(pow(2, 1 + ceil(log(size) / log(2))));
    }

    ll init(vector<ll> &arr, int node, int start, int end) {
        if (start == end) return tree[node] = arr[start];
        return tree[node] = init(arr, node * 2, start, (start + end) / 2)
                            + init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
    }

    ll findSum(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        return findSum(node * 2, start, (start + end) / 2, left, right) +
               findSum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
    }

    void update(int node, int start, int end, int target, ll diff) {
        if (target > end || target < start) {
            return;
        }
        tree[node] += diff;
        if (start == end) {
            return;
        }
        update(node * 2, start, (start + end) / 2, target, diff);
        update(node * 2 + 1, (start + end) / 2 + 1, end, target, diff);
    }
};


int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(false);
    int N, M, K;
    cin >> N >> M >> K;
    vector<ll> arr = vector<ll>(N + 1);
    for (int i = 1; i <= N; i++) cin >> arr[i];
    SegmentTree segTree;
    segTree.init(N);
    segTree.init(arr, 1, 1, N);
    for (long cmd, s, e, i = 0; i < M + K; i++) {
        cin >> cmd >> s >> e;
        if (cmd == 1) {
            segTree.update(1, 1, N, s, e - arr[s]);
            arr[s] = e;
        } else
            cout << segTree.findSum(1, 1, N, s, e) << '\n';
    }
    return 0;
}
