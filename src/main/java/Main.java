import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List listData;
        ParseArgs parseArgs = new ParseArgs(args);
        parseArgs.doParse();
        ReadFile readFile = new ReadFile(parseArgs.getListInputFile(), parseArgs.getLocalPath(), parseArgs.issType());
        listData = readFile.doRead();

        WriteFile writeFile = new WriteFile(listData, parseArgs.getLocalPath(), parseArgs.getOutFile(), parseArgs.isaSort(), parseArgs.issType());
        writeFile.doWrite();

//        System.out.println(parseArgs.getOutFile());
//        System.out.println(parseArgs.getLocalPath());
//        System.out.println("aSort=" + parseArgs.isaSort());
//        System.out.println("dSort=" + parseArgs.isdSort());
//        System.out.println("iType=" + parseArgs.isiType());
//        System.out.println("sType=" + parseArgs.issType());
//        for (String s : parseArgs.getListInputFile()
//        ) {
//            System.out.print(s + " ");
//        }
//        System.out.println();
//        System.out.println(listData);
    }
}
