import java.io.*;
import java.util.*;
public class Main {
    static class SegmentTree{
        long[] tree, lsum, lmul;
        int treeSize;
        public SegmentTree(int arrSize){
            int h = (int) Math.ceil(Math.log(arrSize)/ Math.log(2));
            this.treeSize = (int) Math.pow(2,h+1);
            tree = new long[treeSize];
            lsum = new long[treeSize];
            lmul = new long[treeSize];
            Arrays.fill(lmul,1);
        }
        public long init(long[] arr, int node, int start,int end){
            if(start == end) return tree[node] = arr[start];
            return tree[node] =(init(arr,node*2,start,(start+ end)/2) + init(arr,node*2+1,(start+end)/2+1,end))%MOD;
        }
        public void update(int node, int start, int end){
            if(lmul[node]==1&&lsum[node]==0) return;
            if(end!=start){
                lmul[node*2] = lmul[node*2]*lmul[node]%MOD;
                lmul[node*2+1] = lmul[node*2+1]*lmul[node]%MOD;
                lsum[node*2] = (lsum[node*2]*lmul[node]+lsum[node])%MOD;
                lsum[node*2+1] = (lsum[node*2+1]*lmul[node]+lsum[node])%MOD;
            }
            tree[node] = tree[node]*lmul[node]%MOD;
            tree[node] = (tree[node]+lsum[node]*(end-start+1))%MOD;
            lmul[node] = 1;
            lsum[node] = 0;

        }
        public void lazyUpdate(int node, int start, int end, int left, int right, long dsum, long dmul){
            update(node, start, end);
            if(right < start || end < left) return;
            if(left<=start&&end<=right){
                lmul[node]=lmul[node]*dmul%MOD;
                lsum[node]=lsum[node]*dmul%MOD;
                lsum[node]+=dsum;
                update(node, start, end);
                return;
            }
            lazyUpdate(node*2, start, (start+end)/2, left, right, dsum, dmul);
            lazyUpdate(node*2+1, (start+end)/2+1, end, left,right, dsum, dmul);
            tree[node] = (tree[node*2]+tree[node*2+1])%MOD;
        }
        public long sum(int node, int start, int end, int left, int right){
            update(node, start, end);
            if(left > end || right < start) return 0;
            if(left <= start && end <= right) return tree[node]%MOD;
            return (sum(node*2, start, (start+end)/2, left, right)+
                    sum(node*2+1, (start+end)/2+1, end, left, right))%MOD;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static final long MOD = 1_000_000_007;
    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());
        long[] nums = new long[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++) nums[i] = Long.parseLong(st.nextToken());
        SegmentTree segTree = new SegmentTree(n);
        segTree.init(nums,1,1,n);
        for(int i= Integer.parseInt(br.readLine());i>0;i--) {
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());
            switch (cmd){
                case '1':
                    segTree.lazyUpdate(1,1,n,l,r,Integer.parseInt(st.nextToken()),1);
                    break;
                case '2':
                    segTree.lazyUpdate(1,1,n,l,r,0,Integer.parseInt(st.nextToken()));
                    break;
                case '3':
                    segTree.lazyUpdate(1,1,n,l,r,Integer.parseInt(st.nextToken()),0);
                    break;
                case '4':
                    sb.append(segTree.sum(1,1,n,l,r)).append("\n");
                    break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}