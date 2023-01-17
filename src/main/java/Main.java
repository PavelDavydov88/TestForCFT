import java.util.List;

public class Main {
    public static void main(String[] args) {
        List listData;
        ParseArgs parseArgs = new ParseArgs(args);
        parseArgs.doParse();
        if (parseArgs.isiType()==false & parseArgs.issType()==false) {
            System.out.println("parameters are not enough");
            return;
        }
        ReadFile readFile = new ReadFile(parseArgs.getListInputFile(), parseArgs.getLocalPath(), parseArgs.issType());
        listData = readFile.doRead();
        WriteFile writeFile = new WriteFile(listData, parseArgs.getLocalPath(), parseArgs.getOutFile(), parseArgs.isaSort(), parseArgs.issType());
        writeFile.doWrite();
    }
}
