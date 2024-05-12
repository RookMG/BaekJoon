#include <stdio.h>

int main() {
    int N;
    scanf("%d", &N);
    int dist[N], cost[N], min, ans = 0;
    for (int i = 1; i < N; i++) scanf("%d", &dist[i]);
    for (int i = 0; i < N; i++) scanf("%d", &cost[i]);
    min = cost[0];
    for (int i = 1; i < N; i++) {
        ans += dist[i] * min;
        min = min > cost[i] ? cost[i] : min;
    }
    printf("%d", ans);
}