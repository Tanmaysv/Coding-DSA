package algorithms.dp.knapsack.UnBoundedKnapsack;

public class CoinMaxNumberofWays {
    public static void main(String[] args) {
        int coins[]={1,2,3};
        int sum=5;
        int maxWays=findMaxNumberOfWays(coins,sum);
        System.out.println(maxWays);
    }

    private static int findMaxNumberOfWays(int[] coins, int sum) {
        int dp[][]=new int[coins.length+1][sum+1];
        for (int i=0;i<coins.length+1;i++){
            for (int j=0;j<sum+1;j++){
                if(i==0)
                    dp[i][j]=0;
                if(j==0)
                    dp[i][j]=1;
            }
        }

        for (int i=1;i<coins.length+1;i++){
            for (int j=1;j<sum+1;j++) {

                if (coins[i-1]<= j){
                    dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }

            }
            }

        return dp[coins.length][sum];
    }
}
