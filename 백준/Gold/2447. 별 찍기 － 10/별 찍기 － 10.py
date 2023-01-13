n = int(input())
size = 3
now = ["***","* *","***"]
while size<n:
    next = []
    for line in now:
        next.append(line*3)
    for line in now:
        next.append(line + " "*size + line)
    for line in now:
        next.append(line*3)
    size *=3
    now = next
for line in now:
    print(line)