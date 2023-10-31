# [Gold IV] 트리의 기둥과 가지 - 20924 

[문제 링크](https://www.acmicpc.net/problem/20924) 

### 성능 요약

메모리: 125736 KB, 시간: 1328 ms

### 분류

깊이 우선 탐색, 그래프 이론, 그래프 탐색, 트리

### 제출 일자

2023년 10월 31일 17:19:27

### 문제 설명

<p style="text-align: center;"><img alt="" height="400px" src="https://upload.acmicpc.net/cb157759-0c85-4c0d-a121-771c6f25d688/-/preview/"></p>

<p>시청 공무원 마이크로는 과장으로부터 시에 있는 나무의 기둥의 길이와 가장 긴 가지의 길이를 파악하라는 업무 지시를 받았다.</p>

<p>마이크로는 ICPC Sinchon Winter Algorithm Camp에서 배운 트리 자료 구조를 이용하면 이 작업을 좀 더 수월하게 할 수 있으리라 판단했다. </p>

<p style="text-align: center;"><img alt="" height="400px" src="https://upload.acmicpc.net/4f327bb2-ffff-403c-9c45-ca27b8ba384f/-/preview/"></p>

<p>마이크로는 트리의 기둥과 가지를 분류하기 위해 기가 노드를 추가로 정의하였다.</p>

<p>기가 노드는 루트 노드에서 순회를 시작했을 때, 처음으로 자식 노드가 $2$개 이상인 노드다. 기둥-가지를 줄여 기가 노드라 이름 붙였다. 위 그림에서 기가 노드는 $4$번 노드다.</p>

<p style="text-align: center;"><img alt="" height="400px" src="https://upload.acmicpc.net/a5e04b5d-e28b-4a9c-97ce-dd45f500b824/-/preview/"></p>

<p>단, 위 그림과 같이 리프 노드가 단 $1$개인 경우 리프 노드가 동시에 기가 노드가 된다.</p>

<p style="text-align: center;"><img alt="" height="400px" src="https://upload.acmicpc.net/cc15e14f-82e2-4c5c-9dbc-7919b7b96649/-/preview/"></p>

<p>또한, 위 그림과 같이 루트 노드가 동시에 기가 노드인 경우도 가능하다.</p>

<p style="text-align: center;"><img alt="" height="400px" src="https://upload.acmicpc.net/1a596e90-2416-4c7e-aa8f-f8bdf035dbaa/-/preview/"><img alt="" height="400px" src="https://upload.acmicpc.net/86b4fbd7-b49b-4c58-9e10-a06d0365f8eb/-/preview/"></p>

<ul>
	<li>트리의 기둥은 루트 노드에서부터 기가 노드까지다. 위 그림에서 기둥은 $1-2-3-4$ 이다.<br>
	기둥의 길이는 기둥의 간선 길이의 합인 $1 + 2 + 3 = 6$ 이 된다.</li>
	<li>트리의 가지는 기가 노드에서부터 임의의 리프 노드까지다. 위 그림에서 가지는 $4-5-6-7$, $4-5-8$, $4-9$, $4-10-11$, $4-10-12$ 총 $5$개가 있다.<br>
	가지의 길이는 가지의 간선 길이의 합이다. 다행히도 가장 긴 가지의 길이 하나만 기재하면 된다. $4-10-12$ 가지가 간선 길이의 합 $3 + 3 = 6$ 으로 가장 긴 가지이다.</li>
</ul>

<p>마이크로는 시의 나무를 트리 자료 구조로 옮겼다. 그런데 과장이 마이크로에게 또 다른 업무를 지시했다! 너무 바쁜 마이크로를 대신해 트리의 기둥과 가장 긴 가지의 길이를 측정하자.</p>

### 입력 

 <p>첫 번째 줄에는 노드의 개수 $N$($1 \le N \le 200\,000$)과 루트 노드의 번호 $R$($1 \le R \le N$)이 주어진다.</p>

<p>이후 $N-1$개의 줄에 세 개의 정수 $a$, $b$, $d$($1 \le a, b \le N$, $ a \ne b$)가 주어진다. 이는 $a$번 노드와 $b$번 노드가 연결되어있으며 이 간선의 길이가 $d$($1 \le d \le 1\,000$)임을 의미한다. 노드는 $1$번부터 $N$번까지 정수 번호가 매겨져 있으며 같은 간선은 여러 번 주어지지 않는다. </p>

<p>트리가 아닌 그래프는 입력으로 주어지지 않는다.</p>

### 출력 

 <p>나무의 기둥의 길이와 가장 긴 가지의 길이를 출력한다.</p>

