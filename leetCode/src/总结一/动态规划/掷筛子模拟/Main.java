package 总结一.动态规划.掷筛子模拟;

public class Main {

    private static int m = (int)Math.pow(10,9)+7;
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Math.pow(10,9)+7);

    }

    public int dieSimulator(int n, int[] rollMax) {

        int he = cheng(n);
        int chuqu =0;
        for (int i = 0; i <rollMax.length ; i++) {
            if (rollMax[i]<n){
                int x=cheng(n-rollMax[i]-1);
                x=x*(n-rollMax[i])%m;
                chuqu=chuqu+x;
                if (chuqu>m)
                    chuqu=chuqu/m;
            }
        }

        return 2;
    }

    int  cheng (int x){

        int i=1;
        while (x!=0){
            i=i*6;
            if (i>m){
                i=i%m;
            }
            x--;
        }
        return i;
    }







}
