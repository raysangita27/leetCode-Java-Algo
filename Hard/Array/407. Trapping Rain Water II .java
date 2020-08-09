/*
Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.

Example:

Given the following 3x6 height map:
[
  [1,4,3,1,3,2],
  [3,2,1,3,2,4],
  [2,3,3,2,3,1]
]

Return 4.
![before](https://github.com/raysangita27/leetCode-Java-Algo/blob/master/images/rainwater_empty.png)

The above image represents the elevation map [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] before the rain.

 

![after](https://github.com/raysangita27/leetCode-Java-Algo/blob/master/images/rainwater_fill.png)

After the rain, water is trapped between the blocks. The total volume of water trapped is 4.

 

Constraints:

1 <= m, n <= 110
0 <= heightMap[i][j] <= 20000
*/
class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<Entry> heap = new PriorityQueue<>(new Comparator<Entry>(){
            public int compare(Entry a, Entry b){
                return a.height-b.height;
            }
        });
        boolean[][] visited = new boolean[m][n];
        // put the edge point into the heap
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (i==0 || i==m-1 || j==0 || j==n-1){
                    heap.offer(new Entry(i,j,heightMap[i][j]));
                    visited[i][j] = true;
                }
            }
        }
        // calculate water
        int water = 0;
        int[][] direcs = {{-1,0},{1,0},{0,-1},{0,1}};
        while (!heap.isEmpty()){
            Entry cur = heap.poll();
            int min = cur.height;
            for (int[] dir: direcs){
                int nx = cur.x+dir[0];
                int ny = cur.y+dir[1];
                if (nx>=0 && nx<m && ny>=0 && ny<n && !visited[nx][ny]){
                    water += Math.max(0,min-heightMap[nx][ny]);
                    visited[nx][ny] = true;
                    heap.offer(new Entry(nx, ny, Math.max(min, heightMap[nx][ny])));
                }
            }
        }
        return water;
        
    }
    
    static class Entry{
        int x;
        int y;
        int height;
        Entry(int x, int y, int height){
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }
}
