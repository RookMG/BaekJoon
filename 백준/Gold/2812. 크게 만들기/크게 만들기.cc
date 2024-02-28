#include <iostream>
#include "deque"

using namespace std;

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(false);
    int N, K;
    cin >> N >> K;
    string line;
    cin >> line;
    deque<char> stack;
    for (int i = 0; i < N; i++) {
        while (K != 0 && !stack.empty() && stack.back() < line[i]) {
            stack.pop_back();
            K--;
        }
        if(i+K<N) stack.push_back(line[i]);
    }
    while (!stack.empty()) {
        cout << stack.front();
        stack.pop_front();
    }
    return 0;
}