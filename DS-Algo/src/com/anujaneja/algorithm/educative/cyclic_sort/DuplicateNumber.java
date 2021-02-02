package com.anujaneja.algorithm.educative.cyclic_sort;

import java.util.List;

/**
 * https://medium.com/solvingalgo/solving-algorithmic-problems-find-a-duplicate-in-an-array-3d9edad5ad41
 *
 *
 * Marker
 There is something interesting to mention. So far, our solutions are not really making use of the fact that each integer is between 1 and n. Due to this interesting constraint, each value has its own corresponding index in the array.
 The solution is to consider this particular array as a sort of linked list. Any index is pointing to the value of that index.
 Image for post
 Example with [2, 3, 3, 1]
 We iterate over each element and mark its corresponding index by setting its sign to minus. If we already marked it as negative, it means its index is a duplicate.
 Let’s see a concrete step by step example:
 Input: [2, 3, 3, 1]
 * Index 0:
 Absolute value = 2
 Put a minus sign to a[2] => [2, 3, -3, 1]
 * Index 1:
 Absolute value = 3
 Put a minus sign to a[3] => [2, 3, -3, -1]
 * Index 2:
 Absolute value = 3
 As a[3] is already negative, it means 3 is a duplicate

 This solution is O(n) time and O(1) space. Yet, it requires to mutate the input list.
 Runner Technique
 There is another solution which also considers the given array as a sort of linked list (again, this is possible because of the constraint that each integer is between 1 and n).
 Let’s analyze the example [1, 2, 3, 4, 2]:
 Image for post
 Example with [1, 2, 3, 4, 2]
 With this representation, we can simply say that a duplicate exists when a cycle does exist. Moreover, the duplicate is the entry point of the cycle (in this case, the second element).
 If we take inspiration from Floyd’s cycle-finding algorithm, we can derive the following algorithm:
 Initiate two pointers slow and fast
 For each step, slow is moving one step at a time with slow = a[slow], whereas fast is moving two steps at a time with fast = a[a[fast]]
 When slow == fast, we are in a cycle
 Is the algorithm completed? Not yet. The entry point of this cycle will be the duplicate. We have to reset slow and move both pointers step by step until they are equals again.
 */
public class DuplicateNumber {

    /**
     * Marker technique...
     * -1 in case of no element or single element...
     * @param nums
     * @return
     */
    public static int duplicateNumberMarkerTechnique(int[] nums) {
        if(nums.length<2) {
            return -1;
        }
        int i=0;

        while(i<nums.length) {
            int number = Math.abs(nums[i]);

            if(nums[number]<0) {
                return number;
            } else {
                nums[number] = -1*nums[number];
            }
            i++;
        }


        return -1;
    }


    /**
     * Runner technique...
     *
     * @param nums
     * @return
     */
    public static int duplicateNumberRunnerTech(int[] nums) {
        if(nums.length<2) {
            return -1;
        }
        int i=0;


        int slow = nums[0];
        int fast = nums[nums[0]];

        while(slow!=fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow=0;

        while(slow!=fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,2};

        int duplicate = duplicateNumberMarkerTechnique(nums);

        System.out.println("duplicate="+duplicate);


        nums = new int[] {1};

        duplicate = duplicateNumberMarkerTechnique(nums);

        System.out.println("duplicate="+duplicate);

        nums = new int[] {};

        duplicate = duplicateNumberMarkerTechnique(nums);

        System.out.println("duplicate="+duplicate);


        nums = new int[] {1,3,2,2};

        duplicate = duplicateNumberMarkerTechnique(nums);

        System.out.println("duplicate="+duplicate);

        nums = new int[] {1,2,3,4,2};

        duplicate = duplicateNumberRunnerTech(nums);

        System.out.println("duplicate="+duplicate);
    }
}
