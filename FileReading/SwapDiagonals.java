package FileReading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SwapDiagonals {
    public static final String file = "D:\\ICS4U7\\FileReading\\file.txt";
    public static final String newFile = "D:\\ICS4U7\\FileReading\\updatedFile.txt";
    public static void main(String[] args) {
        BufferedReader br;
        int n = 0;
        int[][] matrix = null;

        try {
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line;
            line = br.readLine();
            n = Integer.parseInt(line);

            matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                matrix[i] = Arrays.stream(br.readLine().split(" "))
                        .map(String::trim)
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDo you want forward or backward diagonal (f/b)? ");
        String decision = scanner.nextLine();
        if (decision.trim().equalsIgnoreCase("f")) {
            forward(n, matrix);
        } else {
            backward(n, matrix);
        }

    }

    public static void forward(int n, int[][] m) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int ni = n - j - 1, nj = n - i - 1;
                int temp = m[ni][nj];
                m[ni][nj] = m[i][j];
                m[i][j] = temp;
            }
        }
        writeToFile(n, m);
    }

    public static void backward(int n, int[][] m){
        for (int i = 1; i < n; i++){
            for (int j = 0; j < i; j++){
                int ni = j, nj = i;
                int temp = m[ni][nj];
                m[ni][nj] = m[i][j];
                m[i][j] = temp;
            }
        }

        writeToFile(n, m);
    }

    public static void writeToFile(int n, int[][] m){
        try {
            FileWriter fw = new FileWriter(newFile);
            StringBuilder data = new StringBuilder();
            data.append(n);
            for (int i = 0; i < n; i++){
                data.append("\n");
                for (int j = 0; j < n; j++) data.append(m[i][j]).append(" ");
            }
            fw.write(data.toString());
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}