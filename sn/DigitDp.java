
import java.util.*;
public class Main {
    static int[][][] dp = new int[20][200][2];
    static String r;

    static int f(String num, int n, int x, int tight) {
        if(x < 0) return 0;
        // Base case
        if (n == 1) {
            int digit = num.charAt(num.length() - n) - '0';
            if (tight == 1 && x >= 0 && x <= digit) return 1;
            else if (tight == 0 && x >= 0 && x <= 9) return 1;
            else return 0;
        }

        if (dp[n][x][tight] != -1) return dp[n][x][tight];

        int ans = 0;
        int ub = (tight == 1) ? (num.charAt(num.length() - n) - '0') : 9;

        for (int dig = 0; dig <= ub; dig++) {
            ans += f(num, n - 1, x - dig, (tight == 1 && dig == ub) ? 1 : 0);
        }

        return dp[n][x][tight] = ans;
    }
  
      public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
          String r=sc.next();
          // Initialize dp with -1
          for(int it[][]:dp){
            for(int it2[]:it){
              Arrays.fill(it2,-1);
            }
          }
  
          System.out.println(f(r,r.length(),30,1));
      }
  }
  
  
  
  
  // #include <iostream>
  // #include <cstring>
  // using namespace std;
  
  // string r;
  // int dp[20][200][2];
  
  // int f(string& num, int n, int x, bool tight){
  //     //base cases
  //     if(n==1){
  //         if(tight and x>=0 and x<=(num[num.size()-n]-'0')) return 1;
  //         else if(!tight and x>=0 and x<=9) return 1;
  //         else return 0;
  //     }
  
  //     int &ans=dp[n][x][tight];
  //     if(ans!=-1) return ans;
  
  //     ans=0;
  //     int ub=tight?(num[num.size()-n]-'0'):9;
//     for(int dig=0; dig<=ub; dig++){
//         ans+=f(num,n-1,x-dig,(tight&(dig==ub)));
//     }

//     return ans;
// }

// void solve(){
//     //code goes here
//     cin>>r;
//     memset(dp,-1,sizeof(dp));
//     cout<<f(r,r.size(),30,1);
// }

// int main() 
// {
//     cout << "Hello, World!";
//     solve();
//     return 0;
// }
