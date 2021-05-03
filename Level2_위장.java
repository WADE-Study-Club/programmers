package me.kingsubin.studyrepo.algorithm.programmers;

import java.util.*;

public class Level2_위장 {
    public static int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (String[] str: clothes) {
            String key = str[1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int answer = 1;
        for (int value : map.values()) {
            answer *= (value + 1);
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        String[][] clotehs = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clotehs));
    }
}
