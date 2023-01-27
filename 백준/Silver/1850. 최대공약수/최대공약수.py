def gcd(a,b):
    return gcd(b, a % b) if b else a
n,m = map(int,input().split())
print("1"*gcd(n,m))