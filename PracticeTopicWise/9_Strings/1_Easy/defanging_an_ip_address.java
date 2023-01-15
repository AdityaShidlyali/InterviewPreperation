// https://leetcode.com/problems/defanging-an-ip-address/

class Solution {
    public String defangIPaddr(String address) {
        address = address.replace(".", "[.]");
		
		return address;
    }
}