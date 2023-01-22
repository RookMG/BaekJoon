input()
a = list(map(int,input().split()))
b = list(map(int,input().split()))
print(len(set(a+b))*2-len(a)-len(b))