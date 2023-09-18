package com.campusdual.ejercicio5.files;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    public static void writeLine(String filePath, String content) {
        try(FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
        {
            bufferedWriter.write(content);
            bufferedWriter.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readLine(){

    }

//        // Leer todo el archivo y devolver una lista de líneas
//        public List<String> readFile(String filePath) throws IOException {
//            List<String> lines = new ArrayList<>();
//            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//                String line;
//                while ((line = br.readLine()) != null) {
//                    lines.add(line);
//                }
//            }
//            return lines;
//        }
//
//        // Escribir líneas en el archivo (sobrescribe el contenido actual)
//        public void writeFile(String filePath, List<String> lines) throws IOException {
//            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
//                for (String line : lines) {
//                    bw.write(line);
//                    bw.newLine();
//                }
//            }
//        }
//
//        // Añadir una línea al final del archivo
//        public void appendLine(String filePath, String line) throws IOException {
//            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
//                bw.write(line);
//                bw.newLine();
//            }
//        }
//    }
//    public static void writeLine(String filePath, String content) {
//        try {
//            // Configura el FileWriter para añadir contenido al final del fichero (el segundo parámetro 'true')
//            FileWriter fileWriter = new FileWriter(filePath, true);
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//
//            bufferedWriter.write(content);
//            bufferedWriter.newLine();  // Añade una nueva línea al final
//
//            bufferedWriter.close();  // Siempre cierra tus streams
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        // Prueba el método writeLine
//        writeLine("miFichero.txt", "Esta es una línea de prueba.");
//    }
}
