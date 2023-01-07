n = int(input())
size = 3
now = ["  *  "," * * ","*****"]
while size<n:
    next = []
    for line in now:
        next.append(" "*size + line + " "*size)
    for line in now:
        next.append(line + " " + line)
    size *=2
    now = next
for line in now:
    print(line)