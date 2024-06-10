#include <stdio.h>
int N, X, ans = 0;
bool set[2000001];
int main() {
    scanf("%d", &N);
    for(int i=0;i<N;++i){
        scanf("%d", &X);
        set[X] = true;
    }
    scanf("%d", &X);
    for(int i=(X>>1)+1;i<X;++i) if(set[i]&&set[X-i]) ++ans;
    printf("%d", ans);
}