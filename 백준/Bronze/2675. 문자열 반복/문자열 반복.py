num = int(input())

for i in range(num):
    count, word = input().split()
    for j in word:
        print(int(count)*j, end='')
    print()