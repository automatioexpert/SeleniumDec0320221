/* Max feels lonely after shifting to a new locality, as he does not have any friend there. So his parents bought him a new number from the Integers SuperMarket! Every child in the locality has bought a number from the same market.

He takes the number to go play with other children in the locality. But to his surprise, there is a rule in the locality, two people A and B can only be considered friends if numbers with A and B are not Coprime, i.e they have a common factor other than 1.

You are given the number that Max bought and the numbers of other children in the locality. Can you find how many friends he can have?

Input:
First line contains an integer A, the number that Max has.
Second line contains N, the count of children in the locality.
Third line contains N space-separated integers, where Xi is the integer with the ith child.

Output:
Output the maximum number of friends that Max can make.

Constraints:
1 ≤ A ≤ 103
1 ≤ N ≤ 103
1 ≤ Xi ≤ 103

SAMPLE INPUT 
6
3
4 7 12
SAMPLE OUTPUT 
2
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        String[] ip = br.readLine().split(" ");
        int[] friends = new int[n];
        for (int i = 0; i < n; i++){
            friends[i] = Integer.parseInt(ip[i]);
        }
        int count = 0;
        for (int i: friends){
            if(!(coprime(N, i))) count++;
        }
    System.out.println(count);
    }

    static int __gcd(int a, int b) 
    {  
        if (a == 0 || b == 0) 
            return 0; 
        if (a == b) 
            return a; 
        if (a > b) 
            return __gcd(a-b, b);              
        return __gcd(a, b-a); 
    } 
    static boolean coprime(int a, int b) {       
        return __gcd(a, b) == 1? true : false;     
    } 
      
}
