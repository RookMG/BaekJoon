# [Platinum III] 루빅의 사각형 - 2549 

[문제 링크](https://www.acmicpc.net/problem/2549) 

### 성능 요약

메모리: 20836 KB, 시간: 916 ms

### 분류

백트래킹(backtracking), 양방향 탐색(bidirectional_search), 그래프 이론(graphs), 중간에서 만나기(mitm)

### 문제 설명

<p>4×4 격자판에 1에서 16까지 정수 번호가 매겨진 16개 타일이 임의로 놓여져 있다. 타일을 움직여 그림 1과 같이 타일을 놓이게 하려고 한다.</p>

<table class="table table-bordered td-center table-2549">
	<tbody>
		<tr>
			<td>1</td>
			<td>2</td>
			<td>3</td>
			<td>4</td>
		</tr>
		<tr>
			<td>5</td>
			<td>6</td>
			<td>7</td>
			<td>8</td>
		</tr>
		<tr>
			<td>9</td>
			<td>10</td>
			<td>11</td>
			<td>12</td>
		</tr>
		<tr>
			<td>13</td>
			<td>14</td>
			<td>15</td>
			<td>16</td>
		</tr>
	</tbody>
</table>

<p style="text-align: center; ">그림 1</p>

<p>타일을 움직이는 방법은 하나의 행(가로줄)을 오른쪽으로 원하는 칸 수만큼 순환적으로 움직이거나, 하나의 열(세로줄)을 원하는 칸 수만큼 아래쪽으로 순환적으로 움직이는 것이다. 그림 2는 그림 1의 2번째 행을 오른쪽으로 2칸 움직인 것이다. 그림 1의 2번째 행의 오른쪽 끝에 있는 7번 타일과 8번 타일이 오른쪽 경계를 넘어가서 왼쪽 끝으로 옮겨갔다.</p>

<table class="table table-bordered td-center table-2549">
	<tbody>
		<tr>
			<td>1</td>
			<td>2</td>
			<td class="b">3</td>
			<td>4</td>
		</tr>
		<tr>
			<td class="bb">7</td>
			<td class="bb">8</td>
			<td class="bb">5</td>
			<td class="bb">6</td>
		</tr>
		<tr>
			<td>9</td>
			<td>10</td>
			<td class="b">11</td>
			<td>12</td>
		</tr>
		<tr>
			<td>13</td>
			<td>14</td>
			<td class="b">15</td>
			<td>16</td>
		</tr>
	</tbody>
</table>

<p style="text-align: center; ">그림 2</p>

<p>그림 3은 그림 2의 3번째 열을 아래쪽으로 1칸 움직인 것이다. 그림 2의 3번째 열의 가장 아래에 있는 15번 타일이 가장 위쪽으로 옮겨갔다.</p>

<table class="table table-bordered td-center table-2549">
	<tbody>
		<tr>
			<td>1</td>
			<td>2</td>
			<td class="bb">15</td>
			<td>4</td>
		</tr>
		<tr>
			<td>7</td>
			<td>8</td>
			<td class="bb">3</td>
			<td>6</td>
		</tr>
		<tr>
			<td>9</td>
			<td>10</td>
			<td class="bb">5</td>
			<td>12</td>
		</tr>
		<tr>
			<td>13</td>
			<td>14</td>
			<td class="bb">11</td>
			<td>16</td>
		</tr>
	</tbody>
</table>

<p style="text-align: center; ">그림 3</p>

<p>그림 3과 같이 타일이 놓여진 격자판이 주어졌다면 3번째 열을 3칸 움직인 다음, 2번째 행을 2칸 움직이면 그림 1과 같이 타일이 놓이게 된다. 따라서 2번 움직이면 된다.</p>

<p>1에서 16까지 번호가 매겨진 타일이 임의로 놓여져 있을 때 그림 1과 같이 타일이 놓일 수 있도록 타일을 움직이는 순서를 출력하는 프로그램을 작성하시오. 여기서 움직이는 횟수는 최소로 하여야 한다.</p>

### 입력 

 <p>4×4 격자판에 놓여진 타일 번호가 행단 위로 4개 줄에 주어진다. 타일 번호는 1부터 16까지의 정수이다.</p>

<p>각 줄에는 해당하는 행에 놓여지는 4개 타일의 번호가 빈칸을 사이에 두고 순서대로 주어진다.</p>

### 출력 

 <p>첫 번째 줄에는 움직이는 횟수를, 두 번째 줄부터는 한 줄에 하나씩 타일을 움직이는 방법을 순서대로 출력한다.</p>

<p>이때, 격자판의 i번째 행을 k칸 움직였다면 정수 1과 i와 k를 빈칸을 사이에 두고 한 줄에 출력한다. 그리고 격자판의 i번째 열을 k칸 움직였다면 정수 2와 i와 k를 빈칸을 사이에 두고 한 줄에 출력한다. 여기서 i는 1 이상 4 이하, k는 1 이상 3 이하의 정수이다.</p>

