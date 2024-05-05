package sn;

/**
 * aLongpow
 */
public class aLongpow {

    int n;
    long mod = (long)1e9+7; 
    Long dp[][][] = new Long[101][101][101];

    public long bipow(long n , int pow){
        if(pow == 0)return 1;
        
        long res = bipow(n,pow/2);
        
        res = (res*res)%mod;
        
        return pow%2==1?(n*res)%mod:res;
        
     }
    
    public int sumOfPower(int[] nums, int k) {
        n = nums.length;
        return (int)fun(nums,0,k,0);
    }
    
    long fun(int nums[], int i, int k, int cnt){
        if(k<0)return 0;
        
        if(k == 0){
            return bipow(2l,n-cnt);
        }
        
        if(i == n)return 0;
        
        if(dp[i][k][cnt] != null)return dp[i][k][cnt];
        
        long take = 0;
        if(nums[i]<=k)take = fun(nums,i+1,k-nums[i],cnt+1)%mod;
        long notTake = fun(nums,i+1,k,cnt)%mod;
        
        return dp[i][k][cnt] = (take+notTake)%mod;
    }
    
    
    
}