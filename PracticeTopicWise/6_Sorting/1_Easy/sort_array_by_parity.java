// https://leetcode.com/problems/sort-array-by-parity/

class Solution {
    public int[] sortArrayByParity(int[] A) {
        List<Integer> evens = new ArrayList<Integer>();
		List<Integer> odds = new ArrayList<Integer>();

		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 == 0) {
				evens.add(A[i]);
			} else {
				odds.add(A[i]);
			}
		}

		// Collections.sort(evens);
		// Collections.sort(odds, Collections.reverseOrder());

		int[] ans = new int[evens.size() + odds.size()];
		int i = -1;
		for (int e : evens) {
			ans[++i] = e;
		}

		for (int e : odds) {
			ans[++i] = e;
		}
        
        return ans;
    }
}

// Efficient solution:
/*
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int even = 0 ;
        int odd = nums.length-1;
        
        while(even <= odd) {

            if(nums[even] % 2 == 0) {

                // found even (keep the even as it is and do nothing)
                even++;
            }
            
            // even pointer found an odd (we have to do something)
            else if(nums[odd] % 2 != 0 && nums[odd] != 0) {
                
                //found odd (keep the odd as it is and do nothing)
                odd--;
            }

            else {

                //both even pointer found an odd and odd pointer found an even (swap them)
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;
                even++;
                odd--;
            }
            
            
        }
        return nums;
    }
}
*/

// One more efficient one:
/*
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int pointer = 0;
        for(int i=0; i < nums.length; i++){
            if(nums[i]%2 == 0){
                int even = nums[i];
                nums[i] = nums[pointer];
                nums[pointer] = even;
                pointer++;
            }
        }
        return nums;
    }
}
*/