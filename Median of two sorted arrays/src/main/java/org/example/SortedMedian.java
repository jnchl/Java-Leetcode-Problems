package org.example;

public class SortedMedian {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] nums = new int[nums1.length + nums2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        int index = 0;
        double val = 0;


        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        } else if (nums1.length == 0) {
            nums = nums2;
        } else if (nums2.length == 0) {
            nums = nums1;
        } else {

            while (k < nums.length) {

                if (nums1[i] < nums2[j]) {
                    nums[k] = nums1[i];
                    i++;

                    if (i == nums1.length) {
                        for (int t = k + 1; t < nums.length; t++) {
                            nums[t] = nums2[j];
                            j++;
                        }
                        break;
                    }

                } else {

                    nums[k] = nums2[j];
                    j++;

                    if (j == nums2.length) {
                        for (int t = k + 1; t < nums.length; t++) {
                            nums[t] = nums1[i];
                            i++;
                        }
                        break;
                    }

                }
                k++;
            }
        }

        if (nums.length % 2 == 0) {
            index = nums.length / 2 - 1;
            val = (double) (nums[index] + nums[index + 1]) / 2;
        } else {
            index = nums.length / 2;
            val = nums[index];
        }
        return val;
    }

    public static void main(String[] args) {
        int[] cos = {};
        int[] y = {1};

        System.out.println(findMedianSortedArrays(cos, y));
    }

}
