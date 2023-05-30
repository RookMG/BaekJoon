t = int(input())
for _ in range(t):
    data = input().split()
    if data[0]=='1':
        a = 0
        for i in data[1].split('.'):
            a <<= 8
            a += int(i)
        print(a)
    else:
        a = int(data[1])
        div = 1<<56
        out = ""
        for i in range(8):
            out += str(a//div)+"."
            a%=div
            div>>=8
        print(out[:-1])