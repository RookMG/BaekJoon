#include <iostream>
#include <stack>

using namespace std;

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(false);

    int n, cnt = 0;
    cin >> n;
    for (int i = 0; i < n; i++) {
        stack<char> s;
        string word;
        cin >> word;
        for (int j = 0; j < word.length(); j++) {
            s.empty() || s.top() != word[j] ? s.push(word[j]) : s.pop();
        }
        if (s.empty()) cnt++;
    }

    cout << cnt;

    return 0;
}