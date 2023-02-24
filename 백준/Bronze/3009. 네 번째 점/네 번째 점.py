x=[0,0,0]
y=[0,0,0]
for _ in range(3):
    x[_],y[_] = map(int,input().split())
for _ in range(3):
    if x.count(x[_]) == 1:
        a = x[_]
    if y.count(y[_]) == 1:
        b = y[_]
print(a,b)