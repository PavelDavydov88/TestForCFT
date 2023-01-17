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
                            listData.add(line);}
                        else if (isDigit(line)!=null) {
                            listData.add(line);
                        }
                    }
                    line = reader.readLine();
                }
            } catch (FileNotFoundException e) {
                System.out.println("file not fained " + path + "/" + nameFile);
                e.printStackTrace();
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
