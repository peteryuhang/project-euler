import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String fileName = "p022_names.txt";
        // This will reference one line at a time
        String line = null;

        String allNameString = "";

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
                allNameString = line;
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

        String[] names = allNameString.replaceAll("^\"|\"+", "").split(",");
        Arrays.sort(names);

        System.out.println(calculatesNameScores(names));
    }

    private static long calculatesNameScores(String[] names) {
        long result = 0;

        long th = 1;
        for (String name : names) {
            long worth = 0;
            
            for (char c : name.toCharArray()) {
                worth += c - 'A' + 1;
            }
            
            result += worth * th;
            
            th++;
        }

        return result;
    }
}