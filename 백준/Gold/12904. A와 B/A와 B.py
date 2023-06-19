target, test = input(), input()
while len(test)!=len(target):
    if test[-1]=='A':
        test = test[:-1]
    else:
        test = test[:-1][::-1]
print(1 if target == test else 0)