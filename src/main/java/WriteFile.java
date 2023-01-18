import java.io.*;
import java.util.List;

/**
 * Класс осуществляет запись выходного файла с отсортированными данными
 */
public class WriteFile {

    private List<String> inputData;
    private String path;
    private boolean conditionSortA;
    private boolean conditionTypeS;
    private String outFile;
    private int[] arrayInt;
    private String[] arrayString;

    public WriteFile(List<String> inputData, String path, String outFile, boolean conditionSortA, boolean conditionTypeS) {
        this.inputData = inputData;
        this.path = path;
        this.conditionSortA = conditionSortA;
        this.conditionTypeS = conditionTypeS;
        this.outFile = outFile;
    }

    void doWrite() {

        if (inputData.isEmpty()) {
            System.out.println("error reading all files");
            return;
        }

        if (conditionTypeS) {
            String[] array = new String[inputData.size()];
            inputData.toArray(array);
            if (conditionSortA) {
                arrayString = SortString.doSortA(array);
            } else {
                arrayString = SortString.doSortD(array);
            }
            doWriteFile(arrayString);
        }

        if (!conditionTypeS) {
            int[] array = new int[inputData.size()];

            int i = 0;
            for (String s : inputData) {
                array[i] = Integer.parseInt(s);
                i++;
            }
            if (conditionSortA) {
                arrayInt = SortNumber.doSortA(array);
            } else {
                arrayInt = SortNumber.doSortD(array);
            }

            doWriteFile(arrayInt);
        }

    }

    private void doWriteFile(String[] arrayString) {
        try {
            File file = new File(path + "/" + outFile);
            FileWriter fw = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fw);
            String lineSeparator = System.getProperty("line.separator");
            for (String s : arrayString) {
                writer.write(s + lineSeparator);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("error for writing " + path + "/" + outFile);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void doWriteFile(int[] arrayInt) {
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
