n, m = map(int,input().split())
d = dict()
for i in range(n):
    site, key = map(str,input().split())
    d[site]=key
for i in range(m):
    print(d[input()])