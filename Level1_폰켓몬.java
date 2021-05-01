package me.kingsubin.studyrepo.algorithm.programmers;

import java.util.*;

public class Level1_폰켓몬 {
    public static int solution(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int num : nums) {
            set.add(num);
        }

        return Math.min(set.size(), nums.length/2);
    }

    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,4};
        System.out.println(solution(nums));
    }
}
