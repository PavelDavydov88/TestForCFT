import java.util.ArrayList;
import java.util.List;

/**
 * Класс осуществляет разбор входных параметров для выполнения программы
 */

public class ParseArgs {

    private String[] args;
    private String localPath = System.getProperty("user.dir");
    private boolean aSort = false, dSort = false, sType = false, iType = false;
    private List<String> listInputFile = new ArrayList();
    private String outFile;

    public ParseArgs(String[] args) {
        this.args = args;
    }

    public List<String> getListInputFile() {
        return listInputFile;
    }

    public String getLocalPath() {
        return localPath;
    }

    public boolean isaSort() {
        return aSort;
    }

    public boolean isdSort() {
        return dSort;
    }

    public boolean issType() {
        return sType;
    }

    public boolean isiType() {
        return iType;
    }

    public String getOutFile() {
        return outFile;
    }

    void doParse() {
            for (String s : args) {
                if ("-s".equalsIgnoreCase(s)) {
                    sType = true;
                }
                if ("-i".equalsIgnoreCase(s)) {
                    iType = true;
                }
                if ("-a".equalsIgnoreCase(s)) {
                    aSort = true;
                }
                if ("-d".equalsIgnoreCase(s)) {
                    dSort = true;
                }
                if (s.length() > 4) {
                    listInputFile.add(s);
                }
            }
            if ((aSort == false) & (dSort == false)) {
                aSort = true;
            }
            outFile = listInputFile.get(0);
            listInputFile.remove(0);
        }
}
