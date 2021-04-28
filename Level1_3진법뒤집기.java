package me.kingsubin.studyrepo.algorithm.programmers;

/*
    1 <= n <= 1억
    1. 3진법 만들기
    2. 뒤집기
    3. 다시 10진법 수로 Return
 */

public class Level1_3진법뒤집기 {
    public static int solution(int n) {
        int answer = 0;

        // 10진법 -> 3진법 뒤집은거
        StringBuilder reverseThreeRadix = new StringBuilder();
        while (n > 0) {
            reverseThreeRadix.append(n % 3);
            n /= 3;
        }

        // 3진법 -> 10진법
        long before10 = Long.parseLong(reverseThreeRadix.toString());

        int count = 0;
        while (before10 > 0) {
            long index = before10 % 10;
            answer += index * (int) Math.pow(3, count++);
            before10 /= 10;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 45;
        System.out.println(solution(n));
    }
}
