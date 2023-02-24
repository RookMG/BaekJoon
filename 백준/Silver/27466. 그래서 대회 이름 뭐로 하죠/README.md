# [Silver V] 그래서 대회 이름 뭐로 하죠 - 27466 

[문제 링크](https://www.acmicpc.net/problem/27466) 

### 성능 요약

메모리: 16764 KB, 시간: 120 ms

### 분류

그리디 알고리즘(greedy), 구현(implementation), 문자열(string)

### 문제 설명

<p>오늘도 운영진은 대회 이름을 정하고 있다. 몇 주째 대회 이름을 못 정하고 구글 드라이브, 지문/에디토리얼 파일, 디스코드 서버에 대회 이름으로 "대회 이름 뭐로 하죠"를 사용하고 있다.</p>

<p>그러던 어느 날, 그들은 KSA Automata Contest라는 이름을 떠올리게 되었고 대문자를 가져와서 KSAAC이라고 부르기로 했다. 이후 KSAAC의 발음이 "크사아악"인 사실을 알아채고 이름을 확정짓게 되었다.</p>

<p>운영진은 다음에 대회를 열 때는 원활한 진행을 위해 아래와 같이 대회 이름을 정하기로 했다.</p>

<ul>
	<li>먼저 협상을 통해 알파벳 대문자로 구성된 길이 $N$의 문자열 $S$를 정한다.</li>
	<li>$S$에서 $0$개 이상의 문자를 지워서 대회 이름 $T$를 만든다.</li>
	<li>이때 $T$는 길이가 $M$인 <strong>운영진이 좋아하는 이름</strong>이어야 한다. <strong>운영진이 좋아하는 이름</strong>이란, 맨 뒷글자는 알파벳 자음(<code><span style="color:#e74c3c;">A</span></code>부터 <code><span style="color:#e74c3c;">Z</span></code> 중 <code><span style="color:#e74c3c;">A</span></code>, <code><span style="color:#e74c3c;">E</span></code>, <code><span style="color:#e74c3c;">I</span></code>, <code><span style="color:#e74c3c;">O</span></code>, <code><span style="color:#e74c3c;">U</span></code>를 제외한 글자들)이고, 뒤에서부터 각각 두 번째와 세 번째 글자는 <code><span style="color:#e74c3c;">A</span></code>인 문자열이다.</li>
</ul>

<p>운영진이 또 다시 대회 이름을 정하기 위해 몇 주의 시간을 낭비하지 않도록 도와주자!</p>

### 입력 

 <p>첫 번째 줄에 두 정수 $N$, $M$이 주어진다.</p>

<p>두 번째 줄에는 문자열 $S$가 주어진다.</p>

### 출력 

 <p>첫 번째 줄에 위에서 설명한 방법으로 대회 이름을 정할 수 있으면 <code><span style="color:#e74c3c;">YES</span></code>, 없으면 <code><span style="color:#e74c3c;">NO</span></code>를 출력한다.</p>

<p>만약 정할 수 있으면 두 번째 줄에 대회 이름으로 가능한 문자열 $T$를 출력한다.</p>

<p>정답이 여러 개 존재한다면 아무거나 출력해도 상관없다.</p>

