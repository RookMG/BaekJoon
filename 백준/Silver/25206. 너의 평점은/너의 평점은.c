#include <stdio.h>

int main() {
    char subject[51], grade[3];
    double weight, score, div = 0.0, sum = 0.0;
    while (scanf("%s %lf %s", subject, &weight, grade) != EOF) {
        div += weight;
        switch (grade[0]) {
            case 'P':
                div -= weight;
            case 'F':
                continue;
            case 'A':
                score = 4.0;
                break;
            case 'B':
                score = 3.0;
                break;
            case 'C':
                score = 2.0;
                break;
            case 'D':
                score = 1.0;
                break;
        }
        if (grade[1] == '+') score += 0.5;
        sum += score * weight;
    }
    printf("%f", sum / div);
}