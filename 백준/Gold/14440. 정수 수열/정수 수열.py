import sys
input = sys.stdin.readline
def mat_mul(A,B):
    C = [[0]*len(A) for _ in range(len(B[0]))]
    for i in range(len(A)):
        for j in range(len(A[0])):
            for k in range(len(B[0])):
                C[i][k] = (C[i][k]+(A[i][j]*B[j][k])%100)%100
    return C
def mat_pow(A,num):
    if num==1:
        return A
    elif num%2==1:
        return mat_mul(mat_pow(A,num-1),A)
    else:
        return mat_pow(mat_mul(A,A),num//2)
x, y, a0, a1, n = map(int,input().split())
if n<=1:
    ans = a0 if n==0 else a1
else:
    pow = mat_pow([[x,y],[1,0]],n-1)
    ans = (pow[0][0]*a1+pow[0][1]*a0)%100
print(ans if ans>9 else "0"+str(ans))