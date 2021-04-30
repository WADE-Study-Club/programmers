package me.kingsubin.studyrepo.algorithm.programmers;
/*
   3 <= nums.length <= 50
   1 <= nums.val <= 1,000 중복 X
 */
public class Level1_소수만들기 {
    static boolean[] primeMap = new boolean[3000];

    public static int solution(int[] nums) {
        makePrimeMap();
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i+1; j < nums.length - 1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int total = nums[i] + nums[j] + nums[k];
                    if (!primeMap[total]) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    private static void makePrimeMap() {
        for (int i = 2; i*i < primeMap.length; i++) {
            for (int j = i*2; j < primeMap.length; j+=i) {
                primeMap[j] = true;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 6, 4};
        System.out.println(solution(nums));
    }
}
