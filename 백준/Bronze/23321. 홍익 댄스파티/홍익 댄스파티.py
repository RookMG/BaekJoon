img = []
for i  in range(5) :
    img.append(list(input()))
for i in range(len(img[0])) :
    if img[1][i] == 'o' :
        img[0][i] = 'o'
        img[1][i] = 'w'
        img[2][i] = 'l'
        img[3][i] = 'n'
        img[4][i] = '.'
    elif img[1][i] == 'w' :
        img[0][i] = '.'
        img[1][i] = 'o'
        img[2][i] = 'm'
        img[3][i] = 'l'
        img[4][i] = 'n'
for i in range(5):
    print(''.join(img[i]))