/*
Joseph Luo
Best: 

Runtime: 130 ms, faster than 29.79% of Java online submissions for 3Sum.
Memory Usage: 44.9 MB, less than 11.11% of Java online submissions for 3Sum.

Time: 15-20 minutes

Difficulty: 7

The brute force method didn't work, so I used the three pointer method and a set to remove duplicates. After sorting the array, basically it is going through all one by one, but having a fixed pointer, i, and have j be after i and k at the very end and some all the pointers up. If the sum is greater than 0 decrement the index of k so that the sum is lower or equal to before. If the sum is less than 0 increment the index of j so the sum can increase. If it is equal check if the set contains the triplet if not, add it to the set and answer. After that regardless of outcome decrement k and increase j. Keep on doing this while j is less than k.
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //Corner Case
        if(nums == null && nums.length == 0) return new ArrayList();
        Arrays.sort(nums);
        //Set to determine duplication
        HashSet set = new HashSet();
        //ArrayList to store answer
        ArrayList ans = new ArrayList();
        //Lenght of nums
        int N = nums.length;
        //Goes through from 0 to N-2, N-2 so as to not collide with the j and k pointers
        for(int i = 0; i < N-2; i++){
            //J should be one index after i 
            int j = i+1; 
            //K is at the end of the nums
            int k = N-1;
            //While index j is less than k
            while(j < k){
                //Add them all up
                int sum = nums[i] + nums[k] + nums[j];
                //If sum is greater than zero decrement the K index in order to try to decrease the overall sum
                if(sum > 0){
                    k--;
                //If sum is less than zero increment the j index in order to try to increase the overall sum
                }else if(sum < 0){
                    j++;
                //If equal then create a new list and try to add it to final answer list.
                }else{
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    //If the triplet is unique add to set and list
                    if(!set.contains(temp)){
                        ans.add(temp);
                        set.add(temp);
                    }
                    //Advance both pointers
                    j++;
                    k--;
                }
            }
        }
        
       
        
        return ans;
    }
}
