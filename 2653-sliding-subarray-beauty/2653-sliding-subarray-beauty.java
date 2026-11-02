class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {

        int n = nums.length;

        int[] result = new int[n - k + 1];
        int[] freq = new int[50];

        int left = 0;
        int right = 0;
        int l = 0;

        while (right < n) {

            if (nums[right] < 0) {
                freq[nums[right] + 50]++;
            }

            if (right - left + 1 == k) {

                int count = 0;

                for (int i = 0; i < 50; i++) {

                    count += freq[i];

                    if (count >= x) {
                        result[l] = i - 50;
                        break;
                    }
                }

                l++;

                if (nums[left] < 0) {
                    freq[nums[left] + 50]--;
                }

                left++;
            }

            right++;
        }

        return result;
    }
}