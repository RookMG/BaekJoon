def mat_mul(A,B):
    C = [[0]*len(A) for _ in range(len(B[0]))]
    for i in range(len(A)):
        for j in range(len(A[0])):
            for k in range(len(B[0])):
                C[i][k] = (C[i][k]+(A[i][j]*B[j][k])%1000000007)%1000000007
    return C
def mat_pow(A,num):
    if num==1:
        return A
    elif num%2==1:
        return mat_mul(mat_pow(A,num-1),A)
    else:
        return mat_pow(mat_mul(A,A),num//2)
n = int(input())
ans =  mat_pow([[1,1],[1,0]],n)[0]
print(ans[0]*ans[1]%1000000007)