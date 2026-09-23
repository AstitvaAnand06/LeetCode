class Solution {
    public int maximumWealth(int[][] accounts) {
        
        int update = 0;
        int n = accounts.length;
        for(int i = 0 ; i < n ; i++){
            int sum = 0;
            for(int j = 0 ; j < accounts[i].length ; j++){
                sum = sum + accounts[i][j];
                if(sum>update){
                    update = sum;
                }
            }
        }
        return update;
    }
}