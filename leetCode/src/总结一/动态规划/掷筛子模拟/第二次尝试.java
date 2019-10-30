package 总结一.动态规划.掷筛子模拟;

public class 第二次尝试 {

    static int m = (int) (Math.pow(10,9)+7);

    public int dieSimulator(int n, int[] rollMax) {


        if (n==1)
            return 6;

        int[][] a=new int[7][];  //todo 记录 投掷的最后的末尾 连续出现的一种字符情况的 种数
        //初始化 数组的大小；todo 每一个字符连续出现的最大值是有限制的；
        for (int i = 1; i <=6; i++) {
            a[i]=new int[Math.min(n,rollMax[i-1])+1]; //todo 限制连续出现的次数 和 投掷连续出现的次数的较小值
        }
        int[][] total =new int[n+1][7];//todo 记录第n 次投掷的每个字符结尾的所有情况；

        for (int i = 1; i <=6; i++) { //todo 初始化投掷地第一次
            a[i][1]=1;
            total[1][i]=1;
        }


        for (int i = 2; i <= n; i++) {  //todo 开始投掷n次
            for (int j = 1; j <= 6; j++) { //todo 出现的以六种字符结尾的所有情况
                int cishu =Math.min(i,rollMax[j-1]);
                for (int k = cishu; k >=1; k--) {
                    if (k==1){//todo 这个字符连续出现一次的情况
                        int t=0;
                        for (int l = 1; l <= 6; l++) {
                            if (l!=j)
                             t=t+total[i-1][l];
                            if (t>m)
                                t=t%m;
                        }
                        a[j][k]=t;
                    }else{//todo 连续出现多次
                        a[j][k]=a[j][k-1];
                    }
                    total[i][j]=total[i][j]+a[j][k];
                    if (total[i][j]>m)
                        total[i][j]=total[i][j]%m;

                }
            }


            /*for (int j = 1; j <6 ; j++) {
                System.out.println(Arrays.toString(a[j]));
        }*/

           /* System.out.println("total");
            System.out.println(Arrays.toString(total[i]));*/
        }

        int result=0;
        for (int i = 1; i <=6 ; i++) {
            for (int j = 1; j <a[i].length ; j++) {
                result=result+a[i][j];
                if (result>m)
                    result=result%m;
            }
        }


        return result;

    }


}
