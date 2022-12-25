def solution(babbling):
    answer = 0
    words = {'wooaya', 'yemaaya', 'yemaayawoo', 'wooayama', 'ma', 'wooye', 'mawooye', 'yema', 'ayawooma', 'maye', 'ayawoo', 'ayamaye', 'wooayaye', 'ayamawooye', 'mayewooaya', 'mawooayaye', 'mawoo', 'ayawooyema', 'yewoo', 'ayamawoo', 'yewooaya', 'mawooaya', 'ayayemawoo', 'yeayawoo', 'wooyeaya', 'maayaye', 'woomaaya', 'yewoomaaya', 'mayeayawoo', 'ayayewoo', 'yeayama', 'yeayamawoo', 'ayama', 'ayayewooma', 'yemawooaya', 'wooma', 'maayayewoo', 'maayawooye', 'wooayayema', 'yeaya', 'woomaayaye', 'ayayema', 'mawooyeaya', 'woo', 'ayawooye', 'yewooma', 'yemawoo', 'yeayawooma', 'ayamayewoo', 'wooyeayama', 'ayaye', 'ayawoomaye', 'yewooayama', 'wooyema', 'aya', 'wooyemaaya', 'ye', 'mayewoo', 'maayawoo', 'maaya', 'wooayamaye', 'woomaye', 'mayeaya', 'woomayeaya'}
    for _ in babbling:
        answer += 1 if _ in words else 0
    return answer