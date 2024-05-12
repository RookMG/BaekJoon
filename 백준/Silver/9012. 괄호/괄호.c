#include <stdio.h>

int main() {
    int N;
    scanf("%d", &N);
    for (int i = 0; i < N; i++) {
        char line[51];
        scanf("%s", line);
        int open = 0, close = 0;
        for (int j = 0; line[j] != '\0'; j++) {
            if (line[j] == '(') {
                open++;
                continue;
            }
            if (++close > open) break;
        }
        printf(close == open ? "YES\n" : "NO\n");
    }
}