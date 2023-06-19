t = int(input())
for test in range(t):
    n = int(input())
    s = set()
    answer = "YES"
    list = []
    for i in range(n):
        list.append(input())
    list.sort()
    for num in list:
        for l in range(1,len(num)+1):
            if num[:l] in s:
                answer = "NO"
                break
        s.add(num)
    print(answer)