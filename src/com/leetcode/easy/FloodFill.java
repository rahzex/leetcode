package com.leetcode.easy;

public class FloodFill {

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        return color == image[sr][sc] ? image : fill(image, sr, sc, color, image[sr][sc]);
    }

    private static int[][] fill(int[][] image, int sr, int sc, int color, int startColor) {

        if (image[sr][sc] == startColor) {
            image[sr][sc] = color;
            if (sr - 1 >= 0)
                fill(image, sr - 1, sc, color, startColor);
            if (sr + 1 < image.length)
                fill(image, sr + 1, sc, color, startColor);
            if (sc + 1 < image[0].length)
                fill(image, sr, sc + 1, color, startColor);
            if (sc - 1 >= 0)
                fill(image, sr, sc - 1, color, startColor);
        }

        return image;
    }

    public static void main(String[] args) {
        int[][] test = new int[][] { {1,0,1}
                                    ,{0,1,1}
                                    ,{1,0,1} };
        //[[1,1,1],[1,1,0],[1,0,1]]
        floodFill(test, 2, 2, 2);
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i][0]); System.out.print(test[i][1]); System.out.print(test[i][2]);
            System.out.println();
        }
    }
}
