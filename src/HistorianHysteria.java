import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


public class HistorianHysteria {
    private int[] leftList = new int[999];
    private int[] rightList = new int[999];
    private int[] differenceList = new int[999];
    private int finalDistance;

    public void getListData() throws IOException {
        String filePath = "/Users/leathamg/development/adventOfCode2024/src/day_one_location_data.txt";
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    public int run() throws IOException {
        System.out.println("Running...");
        getListData();
        return 6;
    }
}
