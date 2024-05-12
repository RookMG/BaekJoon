#include <stdio.h>

int main() {
    int ans = 0, sound[5] = {}, sum = 0;
    char input[2501];
    scanf("%s", input);
    for (int i = 0; input[i] != '\0'; i++) {
        int order;
        switch (input[i]) {
            case 'q':
                order = 0;
                break;
            case 'u':
                order = 1;
                break;
            case 'a':
                order = 2;
                break;
            case 'c':
                order = 3;
                break;
            case 'k':
                order = 4;
        }
        ++sound[order];
        if (order == 0) {
            ans = ++sum > ans ? sum : ans;
            continue;
        }
        if (--sound[order - 1] < 0) {
            ans = -1;
            break;
        }
        if (order == 4) --sum;
    }
    printf("%d", sum==0?ans:-1);
}