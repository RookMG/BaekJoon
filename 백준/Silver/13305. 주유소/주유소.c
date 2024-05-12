#include <stdio.h>

int main() {
    int N;
    scanf("%d", &N);
    long dist[N], cost[N], min, ans = 0;
    for (int i = 1; i < N; i++) scanf("%ld", &dist[i]);
    for (int i = 0; i < N; i++) scanf("%ld", &cost[i]);
    min = cost[0];
    for (int i = 1; i < N; i++) {
        ans += dist[i] * min;
        min = min > cost[i] ? cost[i] : min;
    }
    printf("%ld", ans);
}