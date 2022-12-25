n = int(input())
nlist = list(map(int,input().split()))
nlist.sort()
m = int(input())
def bins(left, right, arr, num) :
    if left >right :
        print(0)
        return 0
    mid = (left+right)//2
    if arr[mid]>num:
        bins(left,mid-1,arr,num)
    elif arr[mid]<num:
        bins(mid+1,right,arr,num)
    else :
        print(1)
        return 1
mlist = list(map(int,input().split()))
for i in range(m):
    bins(0,n-1,nlist,mlist[i])