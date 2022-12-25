def solution(skill, skill_trees):
    answer = 0
    reverse = skill[::-1]
    for tree in skill_trees:
        need_next = False
        valid = True
        pos = 0
        for _ in reverse:
            if need_next :
                if _ not in tree:
                    valid = False
                elif tree.find(_)>pos:
                    valid = False
            if _ in tree:
                need_next = True
                pos = tree.find(_)
        if valid:
            answer+=1
    return answer