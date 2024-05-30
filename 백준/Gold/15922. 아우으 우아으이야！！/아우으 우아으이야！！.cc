#include <stdio.h>
int N, left, right, ans=0;
int main()
{
    scanf("%d",&N);
    scanf("%d %d",&left, &right);
    for(int i=1, x, y;i<N;i++) {
        scanf("%d %d",&x, &y);
        if(right < x) {
            ans += right - left;
            left = x;
        }
        right = y > right ? y : right;
    }
    printf("%d",ans + right - left);
}