/**
 * Класс осуществляет чтение входных,
 * проверяет корректность входных файлов,
 * проверяет корректность данных файла,
 * и формирует коллекцию данных
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    private List<String> list;
    private String path;
    private boolean conditionType;
    private List<String> listData;
    public ReadFile(List<String> list, String path, boolean conditionType) {
        this.list = list;
        this.path = path;
        this.conditionType = conditionType;
    }
    List<String> doRead(){
        listData = new ArrayList<>();
        if (list.size()<=1) {
            System.out.println("error reading files");
            return listData;
        }
        for (String nameFile: list
             ) {
            try {
                File file = new File(path + "/" + nameFile);
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);
                String line = reader.readLine();
                while (line != null) {
                    if (!line.contains(" ") & !line.isEmpty() & !line.isBlank()) {
                        if (conditionType){
                            if (isDigit(line)==null){
                            listData.add(line);}}
                        else if (isDigit(line)!=null) {
                            listData.add(line);
                        } else
                            System.out.println("the line in the file " + path + "/" + nameFile + " does not consist of digits");
                    }
                    line = reader.readLine();
                }
            } catch (FileNotFoundException e) {
                System.out.println("file not fained " + path + "/" + nameFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    return listData;
    }

    private static String isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return s;
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
