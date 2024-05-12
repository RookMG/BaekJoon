#include <stdio.h>

int GCD(int v1, int v2) {
    if (v1 < v2) {
        int tmp = v1;
        v1 = v2;
        v2 = tmp;
    }
    return v2 == 0 ? v1 : GCD(v2, v1 % v2);
}

int main() {
    int N, S, ans, pos;
    scanf("%d %d", &N, &S);
    scanf("%d", &pos);
    ans = pos > S ? pos - S : S - pos;
    for (int i = 1; i < N; i++) {
        scanf("%d", &pos);
        ans = GCD(ans, pos > S ? pos - S : S - pos);
    }
    printf("%d", ans);
}