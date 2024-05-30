#include <stdio.h>
int main()
{
    int dp[10001] = { 1,1,2 }, T, N;
    for (int i = 3; i <= 10000; i++) dp[i] = (i >> 1) + dp[i - 3] + 1;
    scanf("%d", &T);
    for (int t = 0; t < T; t++) {
        scanf("%d", &N);
        printf("%d\n", dp[N]);
    }
}