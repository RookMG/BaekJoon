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

    int init(vector<ll> &arr, int node, int start, int end) {
        if (start == end) return tree[node] = arr[start];
        return tree[node]
                       = min(init(arr, node * 2, start, (start + end) / 2),
                             init(arr, node * 2 + 1, (start + end) / 2 + 1, end));
    }

    int findMin(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 1e9;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        return min(findMin(node * 2, start, (start + end) / 2, left, right),
                   findMin(node * 2 + 1, (start + end) / 2 + 1, end, left, right));
    }

    void update(int node, int start, int end, int target, ll value) {
        if (target > end || target < start) {
            return;
        }
        if (target == start && end == target) {
            tree[node] = value;
            return;
        }
        update(node * 2, start, (start + end) / 2, target, value);
        update(node * 2 + 1, (start + end) / 2 + 1, end, target, value);
        tree[node] = min(tree[node * 2], tree[node * 2 + 1]);
    }
};


int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(false);
    int N, M;
    cin >> N;
    vector<ll> arr = vector<ll>(N + 1);
    for (int i = 1; i <= N; i++) cin >> arr[i];
    cin >> M;
    SegmentTree segTree;
    segTree.init(N);
    segTree.init(arr, 1, 1, N);
    for (int cmd, s, e, i = 0; i < M; i++) {
        cin >> cmd >> s >> e;
        if (cmd == 1)
            segTree.update(1, 1, N, s, e);
        else
            cout << segTree.findMin(1, 1, N, s, e) << '\n';
    }
    return 0;
}