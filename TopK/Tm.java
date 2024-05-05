import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class Tm {
    // https://leetcode.com/contest/weekly-contest-390/problems/longest-common-suffix-queries/


    // https://www.javatpoint.com/java-treemap


      public long[] mostFrequentIDs(int[] nums, int[] freq) {
        int n=nums.length;
        long res[]=new long[n];
        TreeMap<Long,Set<Integer> > tm=new TreeMap<>();
        HashMap<Integer,Long> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            int num=nums[i];
            long f=freq[i];
            long prevFreq=mp.getOrDefault(num,0l);
            mp.put(num,f+prevFreq);
            if(prevFreq!=0){
                tm.get(prevFreq).remove(num);
                if(tm.get(prevFreq).size()==0){
                    tm.remove(prevFreq);
                }

            }
            tm.putIfAbsent(f+prevFreq, new HashSet<>());
            tm.get(f+prevFreq).add(num);
            res[i]=tm.lastKey();

        }
        return res;
    }
}
