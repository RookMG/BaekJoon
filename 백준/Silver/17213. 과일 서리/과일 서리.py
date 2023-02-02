from fractions import Fraction
m = int(input()) - 1
n = int(input()) - 1
answer = 1
div = 1
for i in range(n-m+1,n+1):
    answer*=i
for i in range(1,1+m):
    div*=i
print(Fraction(answer,div))