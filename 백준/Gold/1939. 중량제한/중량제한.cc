#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int N, M, dist[100001], S, E;
vector<vector<pair<int,int>>> links;
priority_queue<pair<int, int>> pq;
int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> N >> M;
    links.resize(N + 1);
    for (int i = 0,a,b,c;i < M;i++) {
        cin >> a >> b >> c;
        links[a].push_back({ c, b });
        links[b].push_back({ c, a });
    }
    for(int i=1;i<=N;i++){
        sort(links[i].begin(),links[i].end());
        reverse(links[i].begin(),links[i].end());
    }
    cin >> S >> E;
    pq.push({ 0,S });
    for (;!pq.empty();) {
        auto [d, now] = pq.top();
        pq.pop();
        if(now==E){
            cout << d;
            break;
        }
        if (dist[now] > d) continue;
        for (auto el : links[now]) {
            auto [nd, next] = el;
            if(d == 0){
                pq.push({dist[next] = nd, next});
                continue;
            }
            if (dist[next] >= nd || dist[next] >= d) continue;
            pq.push({dist[next] = min(d,nd), next});
        }
    }
}