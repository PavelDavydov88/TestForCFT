import java.io.*;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WriteFile {
    private List<String> list;
    private String path;
    private boolean conditionSortA;
    private boolean conditionTypeS;
    private String outFile;
    int[] arrayInt;
    String[] arrayString;
    List listData = new ArrayList<>();

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

    if (conditionTypeS=true) {
        String [] array = new String[list.size()];
        list.toArray(array);
        if (conditionSortA=true) {
            arrayString = SortString.doSortA(array);
            listData = Arrays.asList(arrayString);
            doWriteFile(listData);
        } else {
            arrayString = SortString.doSortD(array);
            listData = Arrays.asList(arrayString);
            doWriteFile(listData);
        }
    }
        if (conditionTypeS=false) {
            int [] array = new int[list.size()];
            for (String s:list
                 ) {
                int i=0;
                array[i]=Integer.getInteger(s);
            }
            if (conditionSortA=true) {
                arrayInt = SortNumber.doSortA(array);
                listData = Arrays.asList(arrayInt);
                doWriteFile(listData);
            } else {
                arrayInt = SortNumber.doSortD(array);
                listData = Arrays.asList(arrayInt);
                doWriteFile(listData);
            }
        }

    }

    private void doWriteFile(List list){
        try {
            File file = new File(path + "/" + outFile);
            FileWriter fw = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fw);
            String lineSeparator = System.getProperty("line.separator");
            for (Object s : list) {
                String name = s.toString();
                writer.write(name + lineSeparator);
            }
            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("error for writing " + path + "/" + outFile);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }





}
