A, B = map(int, input().split())
MOD = 1000000007
print(((pow(A,B,MOD)-1)*pow(A-1,MOD-2,MOD)%MOD) if A!=1 else B%MOD)