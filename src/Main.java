//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HistorianHysteria hst = new HistorianHysteria();
        int totalDistance;
        try {
            totalDistance = hst.run();
            System.out.println("Total Distance: " + totalDistance);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}