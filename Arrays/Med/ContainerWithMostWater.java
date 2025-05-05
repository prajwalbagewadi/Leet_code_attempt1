package Med;
import java.lang.Math;
/*
11. Container With Most Water
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

 

Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
 

Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104
*/
public class Q1 {
	//solution 1: Big O = O(n^2)
//	public int maxArea(int[] height) {
//		//Area = (distance between lines) × (height of shorter line)
//		/* 
//		 	distance between lines = Distance = |j - i|
//			To find the distance between two vertical lines in the 
//			"Container With Most Water" problem, 
//			you simply subtract their indices.
//		*/
//		/*
//		 To find the shorter line between two vertical lines in the array,
//		  you simply use the min() function to compare their heights.
//		 */
//		int maxArea=0;
//		for(int i=0;i<height.length;i++) {
//			for(int j=i+1;j<height.length;j++) {
//				int dist = j-i;
//				int shrt = Math.min(height[i],height[j]);
//				System.out.println("dist="+dist);
//				System.out.println("shrt="+shrt);
//				int area = dist * shrt;
//				System.out.println("area="+area);
//				maxArea=Math.max(maxArea, area);
//			}
//		}
//		System.out.println("maxArea="+maxArea);
//		return 0;
//    }
	//solution 2:
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	public int maxArea(int[] height) {
		//Area = (distance between lines) × (height of shorter line)
		/* 
		 	distance between lines = Distance = |j - i|
			To find the distance between two vertical lines in the 
			"Container With Most Water" problem, 
			you simply subtract their indices.
		*/
		/*
		 To find the shorter line between two vertical lines in the array,
		  you simply use the min() function to compare their heights.
		 */
		  int left=0,right=height.length-1; //one at the beginning (left) and one at the end (right) of the array.
		  int maxArea=0; //stores max area found;
		  int ind1=0,ind2=0; //stores indices formed maxArea;
		  while(left<right) {
			  //You keep shrinking the window until the two pointers meet.
			  //This loop ensures all necessary pairs are checked in an efficient way.
			  int dist = right - left ;
			  int shortline = Math.min(height[left], height[right]);
			  int area = dist * shortline;
			  if(area>maxArea) {
				  maxArea=area;
				  ind1=left;
				  ind2=right;
				  //If this area is the largest so far, update maxArea and store the indices.
			  }
			  if(height[left]<height[right]) {
				  left++; 
			  } else {
				  right--;
			  }
			  /*
			  Move the pointer pointing to the shorter line, because:
			  The area depends on the shorter line.
			  Moving the taller line won’t help unless the shorter line is improved.
			  This is the key optimization: reduce comparisons while maximizing the result.
			  */
		  }
		  return maxArea;
    }
	
	public static void main(String[] args) {
		Q1 m = new Q1();
		int[] arr= {1,8,6,2,5,4,8,3,7};
		//m.maxArea(arr);
		System.out.println("Max area: " + m.maxArea(arr));
	}
}
/*
You're very close to the correct logic! The code you've written correctly:

* Loops through **all pairs of lines** in the array
* Calculates the **distance** between them (`j - i`)
* Calculates the **shorter height**
* Computes the **area = distance × shorter height**
* Tracks the **maximum area**

But there are two things to fix and one thing to clarify:

---

### ❗ Fix: You're returning `0` at the end

```java
return 0;
```

This should be:

```java
return maxArea;
```

Otherwise, the method always returns 0, even though it calculates the correct area.

---

### ✅ Let's walk through your code visually using array:

```java
int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
```

---

### 🧮 Example Pair Calculations:

| i | j | height\[i] | height\[j] | dist (j-i) | shorter | area = dist × shorter |
| - | - | ---------- | ---------- | ---------- | ------- | --------------------- |
| 1 | 8 | 8          | 7          | 7          | 7       | 49 ✅ (max area)       |
| 0 | 1 | 1          | 8          | 1          | 1       | 1                     |
| 2 | 6 | 6          | 8          | 4          | 6       | 24                    |
| 4 | 8 | 5          | 7          | 4          | 5       | 20                    |

🔺 Your code prints each of these values.

---

### 📊 Visual Explanation of Best Pair (1, 8)

* height\[1] = 8
* height\[8] = 7
* Distance = 8 - 1 = 7
* Shorter line = 7
* Area = 7 × 7 = **49** ✅ (this is the largest possible)

```
Y-Axis (height)
 ↑
8 |      |                   |
7 |      |                   |       *
6 |      |       *           |       *
5 |      |       *     *     |       *
4 |      |       *     *     |       *
3 |      |       *     *     |       *
2 |      |       *     *     |       *
1 |  *   *       *     *     *       *
0 +------------------------------------→ X-Axis (indices)
    0   1       2     4     6       8
```

The two tallest far-apart lines are at index 1 and 8, enclosing the most water.

---

### ✅ Final Fixed Code

```java
public class Q1 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for(int i = 0; i < height.length; i++) {
            for(int j = i + 1; j < height.length; j++) {
                int dist = j - i;
                int shrt = Math.min(height[i], height[j]);
                int area = dist * shrt;
                System.out.println("i=" + i + " j=" + j);
                System.out.println("dist=" + dist);
                System.out.println("shrt=" + shrt);
                System.out.println("area=" + area);
                maxArea = Math.max(maxArea, area);
            }
        }
        System.out.println("maxArea=" + maxArea);
        return maxArea; // ← FIXED
    }
}
```

Would you like a visual chart or bar graph to represent how this looks?

*/

/*
solution 2: logic
  0 1 2 3 4 5 6 7 8
 {1,8,6,2,5,4,8,3,7};

left 0
right 8
dist = 8-0=8
shortline =min(height[left], height[right]=min(1,7)=1
area = dist * shortline = 8*1=8
maxArea = 8
if(height[0]<height[8])=true left ++

left 1
right 8
dist = 8-1=7
shortline =min(height[left], height[right]=min(8,7)=7
area = dist * shortline = 7*7=49
maxArea = 49 *UPDATED*
if(height[1]<height[8])=false right --


left 1
right 7
dist = 7-1=6
shortline =min(height[left], height[right]=min(8,3)=3
area = dist * shortline = 6*3=18
maxArea = 49
if(height[1]<height[7])=false right --

left 1
right 6
dist = 6-1=5
shortline =min(height[left], height[right]=min(8,8)=8
area = dist * shortline = 5*8=40
maxArea = 49
if(height[1]<height[6])=false right --

left 1
right 5
dist = 5-1=4
shortline =min(height[left], height[right]=min(8,4)=4
area = dist * shortline = 4*4=16
maxArea = 49
if(height[1]<height[5])=false right --


left 1
right 4
dist = 4-1=3
shortline =min(height[left], height[right]=min(8,2)=2
area = dist * shortline = 3*5=15
maxArea = 49
if(height[1]<height[4])=false right --

left 1
right 3
dist = 3-1=2
shortline =min(height[left], height[right]=min(8,2)=2
area = dist * shortline = 2*2=4
maxArea = 49
if(height[1]<height[3])=false right --

left 1
right 2
dist = 2-1=1
shortline =min(height[left], height[right]=min(8,6)=6
area = dist * shortline = 1*6=6
maxArea = 49
if(height[1]<height[3])=false right --

while(left<right) left == right exit loop
left 1
right 1
dist = 1-1=0
shortline =min(height[left], height[right]=min(8,8)=8
area = dist * shortline = 0*8=0
maxArea = 49
if(height[1]<height[1])=false right --

*/
 */
