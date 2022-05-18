class Solution {
    public int[] productExceptSelf(int[] nums) {

        int length = nums.length;

        int[] result = new int[length];

        int gob = 1;
        for (int i = 0; i < length ; i++) {
            result[i] = gob;
            gob *= nums[i];
        }

        gob = 1;
        for (int i = length - 1; i >= 0 ; --i) {
            result[i] *= gob;
            gob *= nums[i];
        }

        return result;
    }
}