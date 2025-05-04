package Easy;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.lang.Integer;

/*
Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a == c and b == d), or (a == d and b == c) - that is, one domino can be rotated to be equal to another domino.

Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].

 

Example 1:

Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
Output: 1
Example 2:

Input: dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]]
Output: 3
 

Constraints:

1 <= dominoes.length <= 4 * 104
dominoes[i].length == 2
1 <= dominoes[i][j] <= 9
*/
public class Q3 {
	//solution 1: Time limit Exceeded
//	public int numEquivDominoPairs(int[][] dominoes) {
//	    int cnt = 0;
//	    for(int i=0;i<dominoes.length;i++) { //external array length
//	    	for(int j=i+1;j<dominoes.length;j++) { //external array length
//	    		if(dominoes[i][0]==dominoes[j][0] && dominoes[i][1]==dominoes[j][1] ||
//	    		   dominoes[i][0]==dominoes[j][1] && dominoes[i][1]==dominoes[j][0]	) {
//	    			cnt++;
//	    		}
//	    	}
//	    }
//	    return cnt;
//	}
	
	public int numEquivDominoPairs(int[][] dominoes) { 
	    int cnt = 0;
	    int[] temp;
	    	for(int i=1;i<dominoes.length;i++) {
	    		temp=dominoes[i-1];
	    		List<int[]> Temp = Arrays.asList(temp);
	    		List<int[]> list = Arrays.asList();
	    		if(temp==dominoes[i] || Temp==) {
	    			cnt++;
	    		}
	    	}
	    return cnt;
	}
	
	public static void main(String[] args) {
		Q3 m = new Q3();
		//2d array
		int[][] dominoes = {{1,2},{2,1},{1,1},{1,2}};
		int[][] dominoes1 = {{1,2},{2,1},{3,4},{5,6}};
		System.out.println(m.numEquivDominoPairs(dominoes));
		System.out.println(m.numEquivDominoPairs(dominoes1));
	}
}
