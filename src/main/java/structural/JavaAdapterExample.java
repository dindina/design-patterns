package structural;

import java.io.*;

public class JavaAdapterExample {
    public static void main(String[] args) {
        try {
            // Byte stream (Adaptee)
            FileInputStream fileInputStream = new FileInputStream("input.txt");

            // Character stream (Target)
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();

            //Output Stream example.
            FileOutputStream fileOutputStream = new FileOutputStream("output.txt");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            bufferedWriter.write("This is a test.");

            bufferedWriter.close();
            outputStreamWriter.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}