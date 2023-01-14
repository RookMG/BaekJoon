record = [True for i in range(31)]
for i in range(28):
    n = int(input())
    record[n] = False
for i in range(1,31):
    if record[i]:
        print(i)