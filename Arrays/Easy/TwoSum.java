package Easy;

/*
1. Two Sum
Easy
Topics
Companies
Hint
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
 

Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?

*/


//Online Java Compiler
//Use this editor to write, compile and run your Java code online
import java.util.Arrays;
class Q1 {
	//solution 1:
// public int[] twoSum(int[] nums, int target) {
//     int ret[] = new int[2];
//     for(int i=0;i<nums.length;i++){
//    	 if(i+1!=nums.length) {
//    		 int sum=nums[i]+nums[i+1];
//        	 System.out.println("i="+i);
//        	 System.out.println("i+1="+(i+1));
//        	 System.out.println("sum="+sum);
//             if(target==sum){
//                 ret[0]=i;
//                 ret[1]=i+1;
//             } 
//    	 }
//         //System.out.println(nums[i]);
//     }
//     System.out.println("target="+target);
//     
//     return ret;
// }

//solution 1: error case nums = [3,2,3]
//Big O = O(n)	
	
//solution 2:
/*
Your current implementation of twoSum only checks adjacent pairs (nums[i] + nums[i + 1]), 
which works only if the correct answer is in consecutive elements. 
But the general Two Sum problem asks to find any two indices i and j such that:

nums[i] + nums[j] == target and i != j
*/
 public int[] twoSum(int[] nums, int target) {
     int ret[] = new int[2];
     for(int i=0;i<nums.length;i++){
    	for(int j=0;j<nums.length;j++) {
    		if(target == nums[i]+nums[j] && i!=j) { //i!=j checks that indices are not same.
    			ret[0]=i;
    			ret[1]=j;
    		}
    	} 
     }
     return ret;
 }
 //Big O = O(n^2)
 
 public static void main(String[] args) {
     Q1 m = new Q1();
     //array declaration static
     //int [] nums = new int[]{3,2,4};
     int[] nums={3,2,4};
     // dynamic array
     //int[] nums= new int[3];
     //nums[0]=3;
     //nums[1]=2;
     //nums[2]=4;
     int res[]=m.twoSum(nums,6);
     System.out.println(Arrays.toString(res));
 }
}
