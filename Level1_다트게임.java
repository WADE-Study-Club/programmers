package me.kingsubin.studyrepo.algorithm.programmers;

/*
    점수|보너스|[옵션]
    점수 : 0 ~ 10
    보너스 : S, D, T
    옵션 : '*', '#', 없을수있음
    * : 이전라운드 * 2, 현재라운드 * 2
    # : 현재라운드 * -1
 */

import java.util.ArrayList;
import java.util.List;

public class Level1_다트게임 {
    static int[] roundCount = new int[3];

    public static int solution(String dartResult) {
        int answer = 0;

        // 라운드 인덱스 뽑기
        List<Integer> lastIndexs = new ArrayList<>();
        String[] rounds = new String[3];

        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if (c == 'S' || c == 'D' || c == 'T') {
                if ((i+1 < dartResult.length()) && (dartResult.charAt(i+1) == '#' || dartResult.charAt(i+1) == '*')) {
                    // 옵션 존재
                    lastIndexs.add(i+1);
                } else {
                    // 옵션 없음
                    lastIndexs.add(i);
                }
            }
        }

        // 각 라운드 구별
        rounds[0] = dartResult.substring(0, lastIndexs.get(0) + 1);
        rounds[1] = dartResult.substring(lastIndexs.get(0) + 1, lastIndexs.get(1) + 1);
        rounds[2] = dartResult.substring(lastIndexs.get(1) + 1, lastIndexs.get(2) + 1);

        // 각 라운드 점수 구하기
        for (int i = 0; i < 3; i++) {
            roundCount[i] = getCount(rounds[i], i);
        }

        // 점수 합산
        for (int i : roundCount) {
            answer += i;
        }
        return answer;
    }

    private static int getCount(String round, int currentRound) {
        int length = round.length();
        int result = round.charAt(0) - '0';
        char bonus = round.charAt(1);
        char option = '0';
        if (length > 2) {
            option = round.charAt(2);
        }

        if (round.contains("10")) {
            result = 10;
            bonus = round.charAt(2);

            if (length == 4) {
                option = round.charAt(3);
            }
        }

        if (bonus == 'D') {
            result = result * result;
        } else if (bonus == 'T') {
            result = result * result * result;
        }

        if (option != '0') {
            result = checkOption(option, result, currentRound);
        }

        return  result;
    }

    private static int checkOption(char option, int result, int currentRound) {
        if (option == '*') {
            result *= 2;
            if (currentRound > 0) {
                roundCount[currentRound-1] *= 2;
            }
        } else if (option == '#'){
            result *= -1;
        }
        return result;
    }

    public static void main(String[] args) {
        String dartResult = "1D2S#10S";
        int solution = solution(dartResult);
        System.out.println(solution);
    }
}
