package Leetcode.不同路径2;

public class 第二次尝试解答 {




    //todo 题意比较简单，利用动态规划递推的方式解决；
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int[][] a =obstacleGrid;

        if (a==null)
            return 0;

        int x =a.length-1;
        int y=a[0].length-1;
        if ( a[0][0]==1){
            return 0;
        }

        int[][] b=new int[x+1][y+1];
        b[0][0]=1;

        for (int i = 0; i <=x; i++) {
            for (int j = 0; j <=y ; j++) {
                if (a[i][j]==1)
                    continue;
                int i0=i-1;
                int j0=j-1;
                if (i0>=0)
                    b[i][j]=b[i0][j]+b[i][j];
                if (j0>=0 ){
                    b[i][j]=b[i][j0]+b[i][j];
                }
            }
            
        }
        return b[x][y];

    }


}
