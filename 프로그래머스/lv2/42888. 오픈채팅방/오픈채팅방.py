def solution(record):
    answer = []
    chat = []
    users = {}
    for line in record:
        line = line.split(sep = " ")
        if line[0] == "Enter" :
            users[line[1]]=line[2]
        if line[0] == "Change" :
            users[line[1]]=line[2]
        else :
            chat.append((line[0],line[1]))
    for line in chat:
        out = users[line[1]]+"님이 "+("들어왔습니다." if line[0]=="Enter" else "나갔습니다.")
        answer.append(out)
    return answer