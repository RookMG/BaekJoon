n = int(input())
delta = [(-1,0),(1,0),(0,1),(0,-1),(-1,1),(1,1),(-1,-1),(1,-1)]
map = []
for i in range(n):
    map.append(list(input()))
for r in range(len(map)):
    for c in range(len(map[0])):
        if map[r][c]=='.':
            bomb = 0
            for i in range(len(delta)):
                nr = r+delta[i][0]
                nc = c+delta[i][1]
                if 0<=nr<len(map) and 0<=nc<len(map[0]):
                    bomb += 0 if map[nr][nc]=='.' else int(map[nr][nc])
            print(str(bomb) if bomb<10 else "M", end = "")
        else:
            print("*", end = "")
    print()