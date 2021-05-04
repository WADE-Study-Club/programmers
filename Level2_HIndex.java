package me.kingsubin.studyrepo.algorithm.programmers;

/*
    어떤 과학자가 발표한 논문 n편 중,
     h번 이상 인용된 논문이 h편 이상이고
     나머지 논문이 h번 이하 인용되었다면
     h의 최댓값이 이 과학자의 H-Index입니다.
 */

import java.util.Arrays;

public class Level2_HIndex {
    public static int solution(int[] citations) {
        Arrays.sort(citations);

        int hIndex = 0;
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int h = n - i;
            if (citations[i] >= h) {
                hIndex = h;
                break;
            }
        }

        return hIndex;
    }

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(solution(citations));
    }
}
