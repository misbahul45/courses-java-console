package services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public final class Fileservice {
    public static List<String> readAll(String filePath){
        List<String> lines=new ArrayList<>();


        try (BufferedReader br=new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                if(!line.isBlank()){
                    lines.add(line);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Gagal membaca file : "+filePath, e);
        }

        return lines;
    }

    public static void writeAll(String filePath, List<String> lines){
        try( BufferedWriter bw= new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
           throw new RuntimeException("Gagal menulis file: " + filePath, e);
        }
    }

    public static void append(String filePath, String data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(data);
            bw.newLine();
        } catch (Exception e) {
            throw new RuntimeException("Gagal append file: " + filePath, e);
        }
    }

}
