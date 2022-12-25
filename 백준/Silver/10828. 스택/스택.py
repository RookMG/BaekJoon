import sys
n = int(sys.stdin.readline())
stack=[]
pivot = 0
for i in range(n):
    command = sys.stdin.readline().split()
    if command[0] =='push':
        pivot += 1
        stack.append(command[1])
    elif command[0] =='pop':
        if pivot:
            print(stack.pop())
            pivot-=1
        else:
            print(-1)
    elif command[0] =='size':
        print(pivot)
    elif command[0] =='empty':
        if pivot:
            print(0)
        else:
            print(1)
    elif command[0] =='top':
        if pivot:
            print(stack[pivot-1])
        else:
            print(-1)