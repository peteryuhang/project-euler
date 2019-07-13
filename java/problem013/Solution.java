import java.io.*;

public class Solution {
    private static int totalNumbers = 100;
    public static void main (String[] args) {
        String fileName = "numbers.txt";
        // This will reference one line at a time
        String line = null;

        String[] numbers = new String[totalNumbers];

        int index = 0;

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
                numbers[index++] = line;
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

        String result = numbers[0];
        for (int i = 1; i < numbers.length; ++i) {
            result = addString(result, numbers[i]);
        }

        System.out.println(result);
    }

    private static String addString(String a, String b) {
        String result = "";
        int carry = 0;

        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();

        int indexA = aArr.length - 1, indexB = bArr.length - 1;
        while (indexA >= 0 || indexB >= 0) {
            int sumDigit;
            
            if (indexB < 0) {
                sumDigit = (aArr[indexA] - '0') + carry;
            } else {
                sumDigit = (aArr[indexA] - '0') + (bArr[indexB] - '0') + carry;
            }
            
            carry = sumDigit / 10;

            sumDigit = sumDigit > 9 ? sumDigit - 10 : sumDigit;

            result = sumDigit + result;
            
            --indexA; --indexB;
        }

        if (carry > 0) {
            result = carry + result;
        }

        return result;
    }
}