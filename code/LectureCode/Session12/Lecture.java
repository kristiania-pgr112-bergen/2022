package LectureCode.Session12;

public class Lecture {
    static final String date = "2022-03-02";

    public static void main(String[] args) {

        int[] oneDimensional = {
                1, 2, 3,
        };

        int[][] twoDimensional = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(oneDimensional[1]);
        System.out.println(twoDimensional[1][1]);

    }
}