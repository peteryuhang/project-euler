import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String fileName = "triangle.txt";
        // This will reference one line at a time
        String line = null;

        List<String> levelContent = new ArrayList<>();

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                // System.out.println(line);
                line.trim();
                levelContent.add(line);
            }   

            // Always close files.
            bufferedReader.close();         
        } catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        } catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }

        int[][] triangle = new int[levelContent.size()][levelContent.size()];

        int level = 0;
        for (String l : levelContent) {
            String[] elements = l.split(" ");
            
            int index = 0;

            for (String e : elements) {
                triangle[level][index++] = Integer.parseInt(e);
            }
            
            level++;
        }

        System.out.println(maximumPathSum(triangle));
    }

    private static int maximumPathSum(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];

        dp[0][0] = triangle[0][0];

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp[n - 1].length; ++i) {
            res = Math.max(res, dp[n - 1][i]);
        }

        return res;
    }
}