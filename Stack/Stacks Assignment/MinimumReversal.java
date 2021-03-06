/*

For a given expression in the form of a string, find the minimum number of brackets 
that can be reversed in order to make the expression balanced. 
The expression will only contain curly brackets.
If the expression can't be balanced, return -1.
Example:
Expression: {{{{
If we reverse the second and the fourth opening brackets, the whole expression will get 
balanced. Since we have to reverse two brackets to make the expression balanced, the expected 
output will be 2.

Expression: {{{
In this example, even if we reverse the last opening bracket, we would be left with the first 
opening bracket and hence will not be able to make the expression balanced and the output will be -1.

Constraints:
0 <= N <= 10^6
Where N is the length of the expression.

Time Limit: 1sec
Sample Input 1:
{{{
Sample Output 1:
-1
Sample Input 2:
{{{{}}
Sample Output 2:
1

*/

import java.util.*;
public class MinimumReversal {
    public static int countBracketReversals(String input) {
		int l = input.length();
        if((l&1) == 1) return -1; // odd number of brackets can't be balanced
        Stack <Character> bracket = new Stack<>();
        for(int i=0;i<l;i++){
            char c = input.charAt(i);
            if(c=='{') bracket.push(c);
            
            else{
                if(!bracket.isEmpty() && bracket.peek()=='{') bracket.pop();
                else bracket.push(c);
            }
        }
        // now the input expression is simplified.. all the balanced part is removed
        int k=0;
        while(!bracket.isEmpty()){
            char c1 = bracket.pop(), c2 = bracket.pop();
            if(c1==c2) k++;
            else k+=2;
        }
        return k;
	}
}
