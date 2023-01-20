T = int(input())
for test in range(T):
    n1, m1, n2, m2 = map(float,input().split())
    answer = 1.0
    for i in range(int(m1)+1):
        answer *= (n1+1-i)/(n1+n2+2-i)
    mul = answer
    for i in range(int(m2)):
        mul *= (m1+i+1)/(i+1)*(n2+1-i)/(n1+n2-m1+1-i)
        answer += mul
    print(answer)