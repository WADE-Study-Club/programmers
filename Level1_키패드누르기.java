package me.kingsubin.studyrepo.algorithm.programmers;

/*
    왼손 시작 *, 오른손 시작 #, number : 0~9
     1, 4, 7 은 무조건 왼손
     3, 6, 9 는 무조건 오른손
     두 손가락에서의 키패드 거리가 같다면 hand 쪽으로 누른다.
 */

public class Level1_키패드누르기 {
    static int leftPosition = 10;
    static int rightPosition = 12;
    static final char LEFT = 'L';
    static final char RIGHT = 'R';
    static String hand = "";

    public static String solution(int[] numbers, String s) {
        StringBuilder sb = new StringBuilder();
        hand = s;

        for (int number : numbers) {
            sb.append(getAnswer(number));
        }

        return sb.toString();
    }

    private static char getAnswer(int number) {
        if (number == 1 || number == 4 || number == 7) {
            leftPosition = number;
            return LEFT;
        }

        if (number == 3 || number == 6 || number == 9) {
            rightPosition = number;
            return RIGHT;
        }

        // 2, 5, 8, 0 일때는 leftPosition, rightPosition 을 비교해야함
        int leftDistance = getDistance(number, leftPosition);
        int rightDistance = getDistance(number, rightPosition);

        return getHand(leftDistance - rightDistance, number);
    }

    private static int getDistance(int number, int position) {
        position = position == 0 ? 11 : position;
        number = number == 0 ? 11 : number;

        int curX = (position - 1) / 3;
        int curY = (position - 1) % 3;
        int targetX = number / 3;
        int targetY = 1;

        return Math.abs(curX - targetX) + Math.abs(curY - targetY);
    }

    private static char getHand(int distance, int number) {
        if (distance < 0) {
            leftPosition = number;
            return LEFT;
        } else if (distance > 0) {
            rightPosition = number;
            return RIGHT;
        }

        // 어느손인지 비교
        if (hand.equals("left")) {
            leftPosition = number;
            return LEFT;
        } else {
            rightPosition = number;
            return RIGHT;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        System.out.println(solution(numbers, hand));
    }
}
