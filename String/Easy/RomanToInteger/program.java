package Easy;
/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

 

Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].
*/
public class Q1 {
	//solution 1: Time Complexity O(N)
	public int romanValue(String s) {
		switch(s) {
		case "I": return 1;
		//	break; not needed
		case "V": return 5;
		case "X": return 10;
		case "L": return 50;
		case "C": return 100;
		case "D": return 500;
		case "M": return 1000;
		default : return 0;
		}
	}
	public int romanToInt(String s) {
		String[] c = s.split("");
		int res=0,val1=0,val2=0;
		Q1 obj = new Q1(); 
		for(int i=0;i<c.length;i++) {
			val1=obj.romanValue(c[i]);
			if(i+1 < c.length) {
				val2=obj.romanValue(c[i+1]);
				if(val1<val2) {
					res+=(val2-val1);
					i++; //Skip the next character
					continue;
				}
			}
			res+=val1;
		}
		//System.out.println("res="+res);
		return res;
    }
	public static void main(String[] args) {
		String rnum="III";
		String rnum2="LVIII";
		String rnum3="MCMXCIV";
		Q1 obj = new Q1();
		System.out.println(rnum+"="+obj.romanToInt(rnum));
		System.out.println(rnum2+"="+obj.romanToInt(rnum2));
		System.out.println(rnum3+"="+obj.romanToInt(rnum3));
	}
}
/*
 * switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
 * Roman numeral "LVIII"
logic :
i=0
val1=L
if (i+1 < s.length)
val2=V
if(val1<val2) {
res+=(val2-val1)
	i++;
	continue;
}
res+=val1
50

i=1
val1=V
if (i+1 < s.length)
val2=I
if(val1<val2) {
res+=(val2-val1)
	i++;
	continue;
}
res+=val1
50
5

i=2
val1=I
if (i+1 < s.length)
val2=I
if(val1<val2) {
res+=(val2-val1)
	i++;
	continue;
}
res+=val1
50
5
1

i=3
val1=I
if (i+1 < s.length)
val2=
if(val1<val2) {
res+=(val2-val1)
	i++;
	continue;
}
res+=val1
50
5
1
1

i=4
val1=I
if (i+1 < s.length)
val2=
if(val1<val2) {
res+=(val2-val1)
	i++;
	continue;
}
res+=val1
50
5
1
1
1

                 0 1 2 3 4 5 6
Roman numeral = "M C M X C I V" s.lenght=7

i=0
val1=M=1000
	if(i+1<s.lenght){
	val2=C=100
	if(val1<val2){(1000<100)
		res+=val2-val1
		i++//skip next char
		continue
	}
	res+=val1
1000

i=1
val1=C=100
	if(i+1<s.lenght){
	val2=M=1000
	if(val1<val2){(100<1000)
		res+=val2-val1(1000-100)
		i++//skip next char(2)
		continue
	}
	res+=val1
1000
900

i=2 skip 

i=3
val1=X=10
	if(i+1<s.lenght){
	val2=C=100
	if(val1<val2){(10<100)
		res+=val2-val1(100-10)
		i++//skip next char(4)
		continue
	}
	res+=val1
1000
900
90

i=4 skip

i=5
val1=I=1
	if(i+1<s.lenght){
	val2=V=5
	if(val1<val2){(1<5)
		res+=val2-val1(5-1)
		i++//skip next char(6)
		continue
	}
	res+=val1
1000
900
90
4

i=6 skip

ans = 1994

 * */
