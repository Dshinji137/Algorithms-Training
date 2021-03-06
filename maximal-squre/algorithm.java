public class Solution {
	public int maximalSquare(char[][] matrix) {
	    if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
	    int maxSide = 0;
	    int m = matrix.length;
	    int n = matrix[0].length;
	    int[][] dp = new int[m][n];
	    for(int i = 0; i < m; i++) {
	        if(matrix[i][0] == '1') {
	            dp[i][0] = 1;
	            maxSide = 1;
	        }
	    }
	    for(int i = 0; i < n; i++) {
	        if(matrix[0][i] == '1') {
	            dp[0][i] = 1;
	            maxSide = 1;
	        }
	    }
	        
	    for(int i = 1; i < m; i++) {
	        for(int j = 1; j < n; j++) {
	            if(matrix[i][j] == '1') {
	                dp[i][j] = 1;
	                if(dp[i][j] != 0) {
	                    int side = dp[i-1][j-1];
	                    int dist = 1;
	                    while(dist <= side) {
	                        if(matrix[i-dist][j] == '0' || matrix[i][j-dist] == '0') break;
	                        dist++;
	                        dp[i][j]++;
	                    }
	                    maxSide = Math.max(dp[i][j],maxSide);
	                }
	            }
	        }
	    }
	    return maxSide*maxSide;
	}
}
