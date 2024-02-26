#include <iostream>
#include <utility>
#include <deque>

using namespace std;

deque<pair<int, int> > dq;

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(false);

    int n;
    cin >> n;

    for (int i = 1; i <= n; ++i) {
        int next;
        cin >> next;
        dq.push_back(make_pair(i, next));
    }
    for (int i = 1; i <= n; ++i) {
        cout << dq.front().first << " ";
        int next = dq.front().second;
        dq.pop_front();
        if (next > 0) {
            for (int j = 1; j < next; ++j) {
                dq.push_back(dq.front());
                dq.pop_front();
            }
        } else {
            for (int j = 0; j > next; --j) {
                dq.push_front(dq.back());
                dq.pop_back();
            }
        }
    }
    return 0;
}