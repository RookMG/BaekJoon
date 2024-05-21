#include <stdio.h>

int fact[] = {1,1,2,6,24,120,720,5040,40320};

int binomial(int n, int r){
	return n<r?0:fact[n]/fact[r]/fact[n-r];
}

int main()
{
	int N, M, K ,cnt = 0;
	scanf("%d %d %d", &N, &M, &K);
	for (int i = K; i <= M; i++) cnt += binomial(M, i) * binomial(N - M, M - i);
	printf("%.10f", 1.0*cnt / binomial(N, M));
}
