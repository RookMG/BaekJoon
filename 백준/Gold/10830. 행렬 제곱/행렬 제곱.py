import sys
input = sys.stdin.readline
def mat_mul(A,B):
    C = [[0]*len(A) for _ in range(len(B[0]))]
    for i in range(len(A)):
        for j in range(len(A[0])):
            for k in range(len(B[0])):
                C[i][k] = (C[i][k]+(A[i][j]*B[j][k])%1000)%1000
    return C
def mat_pow(A,num):
    if num==1:
        return A
    elif num%2==1:
        return mat_mul(mat_pow(A,num-1),A)
    else:
        return mat_pow(mat_mul(A,A),num//2)
n, b = list(map(int,input().split()))
mat = []
for i in range(n):
    mat.append(list(map(int,input().split())))
ans = mat_pow(mat,b)
for line in ans:
    for i in line:
        print(i%1000,end=" ")
    print()