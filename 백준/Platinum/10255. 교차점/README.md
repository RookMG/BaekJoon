# [Platinum IV] 교차점 - 10255 

[문제 링크](https://www.acmicpc.net/problem/10255) 

### 성능 요약

메모리: 14000 KB, 시간: 160 ms

### 분류

많은 조건 분기(case_work), 기하학(geometry), 선분 교차 판정(line_intersection)

### 문제 설명

<p>이제 사각형의 경계선과 선분의 교차점에 관한 간단한 기하 문제를 풀어볼 것이다.</p>

<p>매우 다행히도 사각형은 항상 축에 평행한 형태로만 놓여 있다.</p>

<p>어떤 사각형과 어떤 선분의 교차점은 항상 0개이거나, 1개이거나, 2개이거나, 무한하다.</p>

<p>각각의 경우에 대한 몇 가지 예제는 아래와 같다.</p>

<p style="text-align: center;"><img src="https://www.acmicpc.net/upload/images2/inter1.png"></p>

<p style="text-align: center;">(a) 교점이 0개인 경우</p>

<p style="text-align: center;"><img src="https://www.acmicpc.net/upload/images2/inter2.png"></p>

<p style="text-align: center;">(b) 교점이 1개인 경우</p>

<p style="text-align: center;"><img src="https://www.acmicpc.net/upload/images2/inter3.png"></p>

<p style="text-align: center;">(c) 교점이 2개인 경우</p>

<p style="text-align: center;"><img src="https://www.acmicpc.net/upload/images2/inter4.png"></p>

<p style="text-align: center;">(d) 교점이 무한히 많은 경우</p>

### 입력 

 <p>첫 줄에 테스트 케이스의 수 T가 주어진다.</p>

<p>각 테스트 케이스는 4개의 정수로 시작한다. <span style="line-height:1.6em">각 정수는 xmin, ymin, xmax, ymax이며, 이것은 사각형의 왼쪽 아래 꼭짓점이 (xmin, ymin)이고 오른쪽 위 꼭짓점이 (xmax, ymax)임을 의미한다. </span><span style="line-height:1.6em">(-10,000 ≤ xmin < xmax ≤ 10,000,</span><span style="line-height:1.6em"> -10,000 ≤ ymin < ymax ≤ 10,000</span><span style="line-height:1.6em">) </span><span style="line-height:1.6em">그 다음 줄에도 4개의 정수 x1, y1, x2, y2가 주어진다. </span><span style="line-height:1.6em">이는 선분의 한쪽 끝점이 (x1,y1)이며 다른쪽 끝점이 (x2,y2)임을 의미한다. </span><span style="line-height:1.6em">(-10,000 ≤ x1, y1, x2, y2 ≤ 10,000)</span></p>

<p>선분의 길이는 항상 0보다 크다.</p>

### 출력 

 <p>테스트 케이스마다 하나의 정수를 출력한다.</p>

<p>만일 주어진 사각형과 선분의 교차점의 개수가 유한하다면 교차점의 개수를 출력하고, 교차점이 무한히 많다면 4를 출력한다.</p>

