n = int(input())
for i in range(n):
    H,W,N = map(int,input().split())
    print(100*(N%H)+N//H+1) if N%H!=0 else print(100*H+N//H)