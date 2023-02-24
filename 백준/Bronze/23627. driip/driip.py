text = input()
leng = len(text)
ans = 'not cute'
if leng>5 :
    if text[leng-5:leng]=='driip':
        ans = 'cute'
print(ans)