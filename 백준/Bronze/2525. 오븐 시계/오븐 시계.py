h,m = map(int,input().split())
n = int(input())
m += n
h += m//60
print(h%24,m%60)