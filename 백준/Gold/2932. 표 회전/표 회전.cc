#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, K;

struct Move{
    int num, targetR, targetC, nowR, nowC;
};

vector<Move> moves;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> N >> K;
    for(int k=0,num,r,c;k<K;k++){
        cin >> num >> r >> c;
        moves.push_back({num,r,c,(num-1)/N+1,(num-1)%N+1});
    }
    for(auto &el:moves){
        int dr = (N+el.targetR-el.nowR)%N, dc = (N+el.targetC-el.nowC)%N;
        cout << dr+dc <<'\n';
        for(auto &elR:moves){
            if(el.nowR!=elR.nowR) continue;
            elR.nowC = (elR.nowC+dc-1)%N+1;
        }
        for(auto &elC:moves){
            if(el.nowC!=elC.nowC) continue;
            elC.nowR = (elC.nowR+dr-1)%N+1;
        }
    }
}