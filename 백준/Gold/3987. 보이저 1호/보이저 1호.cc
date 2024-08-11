#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;
int R, C, SR, SC, ans = 0, dirIdx = 0, delta[4][2] = {{-1,0},{0,1},{1,0},{0,-1}};
string dir = "URDL";
vector<string> region;
bool isIn(int r, int c){
    return 0<=r&&r<R&&0<=c&&c<C;
}
int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> R >> C;
    region.resize(R);
    for(int r = 0;r<R;r++){
        cin >> region[r];
    }
    cin >> SR >> SC;
    for(int dirInit=0;dirInit<4;dirInit++){
        int time = 0, r = SR - 1, c = SC - 1, d = dirInit;
        for(;time<1e6;time++){
            if(!isIn(r,c)||region[r][c]=='C') break;
            if(region[r][c]=='/'){
                d += 1 - 2*(d%2);
            }
            if(region[r][c]=='\\'){
                d = 3 - d;
            }
            r += delta[d][0];
            c += delta[d][1];
        }
        if(time>ans){
            dirIdx = dirInit;
            ans = time;
        }
    }
    cout << dir[dirIdx] << '\n' << (ans==1e6?"Voyager": to_string(ans));
}