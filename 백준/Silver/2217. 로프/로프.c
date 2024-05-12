#include <stdio.h>

#define MAX_SIZE 100001

int heap[MAX_SIZE];
int heapSize = 0;

void heapPush(int val) {
    heap[heapSize] = val;
    int current = heapSize;
    while (current > 0 && heap[current] > heap[(current - 1) / 2]) {
        int temp = heap[(current - 1) / 2];
        heap[(current - 1) / 2] = heap[current];
        heap[current] = temp;
        current = (current - 1) / 2;
    }
    heapSize++;
}

void heapPop(int *val) {
    *val = heap[0];
    heapSize--;
    heap[0] = heap[heapSize];

    int current = 0;
    while (current * 2 + 1 < heapSize) {
        int child;
        if (current * 2 + 2 == heapSize) {
            child = current * 2 + 1;
        } else {
            child = heap[current * 2 + 1] > heap[current * 2 + 2] ? current * 2 + 1 : current * 2 + 2;
        }
        if (heap[current] > heap[child]) {
            break;
        }
        int temp = heap[current];
        heap[current] = heap[child];
        heap[child] = temp;

        current = child;
    }
}

int main() {
    int N, val, ans = 0;
    scanf("%d", &N);
    for (int i = 0; i < N; i++) {
        scanf("%d", &val);
        heapPush(val);
    }
    for (int i = 1; i <= N; i++) {
        heapPop(&val);
        ans = ans > val * i ? ans : val * i;
    }
    printf("%d", ans);
}