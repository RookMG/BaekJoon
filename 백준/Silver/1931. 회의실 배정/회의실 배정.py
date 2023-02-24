num = int(input())
ref = list()
for i in range(num) :
    ref.append(list(map(int,input().split())))
ref.sort(key=lambda x : x[0])
ref.sort(key=lambda x : x[1])
count = 1
end = ref[0][1]
for i in range(1,num) :
    if ref[i][0]>=end :
        count+=1
        end = ref[i][1]
print(count)