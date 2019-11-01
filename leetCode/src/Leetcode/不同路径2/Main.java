package Leetcode.不同路径2;


//todo 利用DFS深搜超出了时间限制，需要进行优化；
public class Main {


    int count=0;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        count=0;
        int[][] a=obstacleGrid;

        DFS(a,0,0);

        return count;

    }

    private void DFS(int[][] a, int x, int y) {

        if (x<a.length && y<a[0].length && a[x][y]==0 ){
            if (x==a.length-1 && y==a[0].length-1) {
                count++;
                return;
            }
            DFS(a,x+1,y);
            DFS(a,x,y+1);
        }

    }
}
