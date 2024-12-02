import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;

public class HistorianHysteria {
    private ArrayList<Integer> leftList = new ArrayList<Integer>();
    private ArrayList<Integer> rightList = new ArrayList<Integer>();

    //private int[] differenceList = new int[999];
    private int finalDistance;

    private void getListData() throws IOException {
        String filePath = "/Users/leathamg/development/adventOfCode2024/src/day_one_location_data.txt";
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            String[] lines = line.split("\\s+");
            //System.out.println("1. " + lines[0] + " 2. " + lines[1]);
            leftList.add(Integer.parseInt(lines[0]));
            rightList.add(Integer.parseInt(lines[1]));
        }
        br.close();
    }

    private void sortLists() {
        Collections.sort(leftList);
        Collections.sort(rightList);
    }

    private void calculateDistance() {
        for (int i = 0; i < leftList.size(); i++) {
            int diff = 0;
            if (leftList.get(i) > rightList.get(i)) {
                diff = (leftList.get(i) - rightList.get(i));
            } else {
                diff = (rightList.get(i) - leftList.get(i));
            }
            this.finalDistance += diff;
        }
    }

    private void calculateSimilarity() {
        System.out.println("Derp");
        int currentNumber;
        int numInLeftList = 0;
        int numInRightList = 0;
        int i = 0;

        while (!leftList.isEmpty()) {
            currentNumber = leftList.get(i);
            numInLeftList += 1;
            for (int num : leftList) {
                if (num == currentNumber) {
                    numInLeftList += 1;
                }
            }
            rightList.remove(currentNumber);
            i = 0;
        }
        System.out.println("Left: " + numInLeftList);
        //if no more of same number exist in left list rightList.remove(number)
    }

    public int run() throws IOException {
        System.out.println("Running...");
        this.getListData();
        this.sortLists();
        this.calculateDistance();
        return this.finalDistance;
    }
}
