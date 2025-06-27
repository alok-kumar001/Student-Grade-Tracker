import java.util.ArrayList;
import java.util.Scanner;

public class ScoreCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> scores = new ArrayList<>();

        System.out.println("Enter scores (type -1 to finish):");

        while (true) {
            System.out.print("Enter score: ");
            int score = scanner.nextInt();

            if (score == -1) break; // Stop when -1 is entered
            if (score < 0 || score > 100) {
                System.out.println("Please enter a valid score between 0 and 100.");
                continue;
            }

            scores.add(score);
        }

        if (scores.isEmpty()) {
            System.out.println("No scores entered.");
        } else {
            double average = calculateAverage(scores);
            int highest = findHighestScore(scores);
            int lowest = findLowestScore(scores);

            System.out.println("\nResults:");
            System.out.println("Average Score: " + average);
            System.out.println("Highest Score: " + highest);
            System.out.println("Lowest Score: " + lowest);
        }

        scanner.close();
    }

    private static double calculateAverage(ArrayList<Integer> scores) {
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return total / (double) scores.size();
    }

    private static int findHighestScore(ArrayList<Integer> scores) {
        int highest = scores.get(0);
        for (int score : scores) {
            if (score > highest) {
                highest = score;
            }
        }
        return highest;
    }

    private static int findLowestScore(ArrayList<Integer> scores) {
        int lowest = scores.get(0);
        for (int score : scores) {
            if (score < lowest) {
                lowest = score;
            }
        }
        return lowest;
    }
}
