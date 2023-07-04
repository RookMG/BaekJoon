def mat_mul(A,B):
    global MOD
    C = [[0]*len(A) for _ in range(len(B[0]))]
    for i in range(len(A)):
        for j in range(len(A[0])):
            for k in range(len(B[0])):
                C[i][k] = (C[i][k]+(A[i][j]*B[j][k])%MOD)%MOD
    return C
def mat_pow(A,num):
    if num==1:
        return A
    elif num%2==1:
        return mat_mul(mat_pow(A,num-1),A)
    else:
        return mat_pow(mat_mul(A,A),num//2)
MOD,a,c,x,n,g = map(int,input().split())
arr = mat_pow([[a,c],[0,1]],n)
print((arr[0][0]*x+arr[0][1])%MOD%g)