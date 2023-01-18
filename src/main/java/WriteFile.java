import java.io.*;
import java.util.List;

/**
 * Класс осуществляет запись выходного файла с отсортированными данными,
 */

public class WriteFile {
    private List<String> list;
    private String path;
    private boolean conditionSortA;
    private boolean conditionTypeS;
    private String outFile;
    int[] arrayInt;
    String[] arrayString;

    public WriteFile(List<String> list, String path, String outFile, boolean conditionSortA, boolean conditionTypeS) {
        this.list = list;
        this.path = path;
        this.conditionSortA = conditionSortA;
        this.conditionTypeS = conditionTypeS;
        this.outFile = outFile;
    }

    void doWrite(){
        if (list.isEmpty()) {
            System.out.println("error reading all files");
            return;
        }

    if (conditionTypeS==true) {
        String [] array = new String[list.size()];
        list.toArray(array);
        if (conditionSortA==true) {
            arrayString = SortString.doSortA(array);
            doWriteFile(arrayString);
        } else {
            arrayString = SortString.doSortD(array);
            doWriteFile(arrayString);
        }
    }
        if (conditionTypeS==false) {
            int [] array = new int[list.size()];

            int i=0;
            for (String s:list
                 ) {
                array[i]=Integer.parseInt(s);
                i++;
            }
            if (conditionSortA==true) {
                arrayInt = SortNumber.doSortA(array);
                doWriteFile(arrayInt);
            } else {
                arrayInt = SortNumber.doSortD(array);
                doWriteFile(arrayInt);
            }
        }

    }

    private void doWriteFile(String [] arrayString){
        try {
            File file = new File(path + "/" + outFile);
            FileWriter fw = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fw);
            String lineSeparator = System.getProperty("line.separator");
            for (String s : arrayString) {
                String line = s;
                writer.write(line + lineSeparator);
            }
            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("error for writing " + path + "/" + outFile);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void doWriteFile(int [] arrayInt){
        try {
            File file = new File(path + "/" + outFile);
            FileWriter fw = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fw);
            String lineSeparator = System.getProperty("line.separator");
            for (Integer s : arrayInt) {
                String line = s.toString();
                writer.write(line + lineSeparator);
            }
            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("error for writing " + path + "/" + outFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
