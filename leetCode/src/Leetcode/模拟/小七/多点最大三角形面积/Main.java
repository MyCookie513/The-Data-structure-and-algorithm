package Leetcode.模拟.小七.多点最大三角形面积;

import java.util.Map;

public class Main {



    public double largestTriangleArea(int[][] points) {

        double result =0;
        for (int i = 0; i <points.length-2 ; i++) {
            for (int j = i+1; j <points.length-1 ; j++) {
                for (int k = j+1; k < points.length; k++) {
                    result= Math.max(result,getArea(points[i],points[j],points[k]));
                }
            }
        }
        return result;

    }

    /**
     *三个点构成的三角形的面积： todo  返回 x1*y2 -x2*y1 的绝对值
     */
    double getArea(int[] a,int[] b ,int[] c){
        int x1=b[0]-a[0];
        int x2=c[0]-a[0];
        int y1=b[1]-a[1];
        int y2=c[1]-a[1];
        return Math.abs(x1*y2-x2*y1)/2.0 ;
    }







}
