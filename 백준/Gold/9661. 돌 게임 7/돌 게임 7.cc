#include <iostream>

using namespace std;

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(false);

    unsigned long long n;
    cin >> n;
    cout << (n % 5 == 2 or n % 5 == 0 ? "CY" : "SK");
    return 0;
}