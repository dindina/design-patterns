package structural;

import java.io.*;

public class JavaDecoratorExample {
    public static void main(String[] args) {
        try {
            // Original component (FileInputStream)
            FileInputStream fileInputStream = new FileInputStream("input.txt");

            // Decorator 1: BufferedInputStream (adds buffering)
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            // Decorator 2: DataInputStream (adds reading primitive data types)
            DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);

            // Read some data
            int byteRead = dataInputStream.readInt(); //Example, reading an int.
            System.out.println("Read integer: " + byteRead);

            // Close the streams (important!)
            dataInputStream.close();
            bufferedInputStream.close();
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}