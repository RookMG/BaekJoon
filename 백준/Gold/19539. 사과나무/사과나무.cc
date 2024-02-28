#include <iostream>

using namespace std;

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(false);

    int N, sum = 0, share = 0;

    cin >> N;

    for (int i = 0; i < N; ++i) {
        int num;
        cin >> num;
        sum += num;
        share += num / 2;
    }

    cout << (sum % 3 == 0 && sum / 3 <= share ? "YES" : "NO");

    return 0;
}