package FileReading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Jokes {
    public static void main(String[] args){
        BufferedReader br;
        String path = "D:\\ICS4U7\\FileReading\\jokes.txt";

        ArrayList<String> jokes = new ArrayList<>();

        try {
            FileReader fr = new FileReader(path);
            br = new BufferedReader(fr);

            String s;
            while ((s = br.readLine()) != null) {
                jokes.add(s);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        int sz = jokes.size();
        for (int i = 0; i < sz; i++){
            int first = (int) Math.random() * sz;
            int second = (int) Math.random() * sz;
            String temp = jokes.get(first);
            jokes.set(first, jokes.get(second));
            jokes.set(second, temp);
        }

        try {
            FileWriter fw = new FileWriter(path);
            StringBuilder data = new StringBuilder();
            for (int i = 0; i < sz; i++){
                data.append(jokes.get(i) + "\n");
            }
            fw.write(data.toString());
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
