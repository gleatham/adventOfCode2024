import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;

public class HistorianHysteria {
    private ArrayList<Integer> leftList = new ArrayList<Integer>();
    private ArrayList<Integer> rightList = new ArrayList<Integer>();
    private int finalDistance;
    private int similarityScore = 0;

    private void getListData() throws IOException {
        System.out.println("getListData");
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
        System.out.println("calculateDistance");
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
        System.out.println("calculateSimilarity");
        //int currentNumber;
        //int numInRightList = 0;
        int i = 0;

        while (!leftList.isEmpty()) {
            int currentNumber = leftList.getFirst();
            int numInRightList = 0;
            for (int num : rightList) {
                if (num == currentNumber) {
                    numInRightList += 1;
                }
            }
            int score = currentNumber * numInRightList;
            this.similarityScore += score;
            this.leftList.removeFirst();
            i++;
            System.out.println(i);

        }
        System.out.println("SimScore: " + this.similarityScore);
    }

    public int run() throws IOException {
        System.out.println("Running...");
        this.getListData();
        this.sortLists();
        this.calculateDistance();
        this.calculateSimilarity();
        return this.finalDistance;
    }
}
