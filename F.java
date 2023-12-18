import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DensityFieldGenerator {

    public static void main(String[] args) {
        List<String> snapshots = List.of("130");
        List<Double> radii = List.of(2.5);

        for (String snap : snapshots) {
            for (Double R : radii) {
                List<Integer> dList = new ArrayList<>();

              
                simulateDensityFieldData(R, dList);

              
                saveToFile("output/MDPL2_" + snap + "_all_spheres_" + R + "_test1.txt", dList);

            }
        }
    }

    private static void simulateDensityFieldData(double R, List<Integer> dList) {
        int totalPoints = 400 * 400 * 400;
        Random random = new Random();

        for (int i = 0; i < totalPoints; i++) {
           
            int density = (int) Math.pow(10, random.nextDouble() * 7 - 3);
            dList.add(density);
        }
    }

    private static void saveToFile(String fileName, List<Integer> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int value : data) {
                writer.write(value + "\n");
            }
            System.out.println("Data saved to: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
