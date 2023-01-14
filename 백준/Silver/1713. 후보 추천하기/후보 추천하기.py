n = int(input())
k = int(input())
arr = list(map(int,input().split()))
record = dict()
for i in range(k):
    if arr[i] in record:
        record[arr[i]][0]+=1
    elif len(record)<n:
        record[arr[i]] = [1,i]
    else:
        del record[sorted(record, key=lambda x:record[x])[0]]
        record[arr[i]] = [1,i]
answer = [i for i in record]
answer.sort()
for a in answer:
    print(a,end=" ")