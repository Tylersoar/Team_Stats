
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int wins = 0;
        int losses = 0;

        System.out.println("Enter a file name: ");
        String fileName = sc.nextLine();

        System.out.println("Enter a team: ");
        String team = sc.nextLine();

        int gameCount = 0;

        try (Scanner fileScanner = new Scanner(Paths.get("src", fileName))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");
                String homeTeam = parts[0];
                String visitTeam = parts[1];
                int homeScore = Integer.parseInt(parts[2]);
                int visitScore = Integer.parseInt(parts[3]);

                if (homeTeam.equals(team) || visitTeam.equals(team)) {
                    gameCount++;

                    if (homeTeam.equals(team) && homeScore > visitScore) {
                        wins++;
                    } else if (visitTeam.equals(team) && visitScore > homeScore) {
                        wins++;
                    } else {
                        losses++;
                    }
                }

            }
            System.out.println("games: " + gameCount);
            System.out.println("Wins: " + wins);
            System.out.println("Losses: " + losses);

        } catch (IOException e) {
            System.err.println("File not found or unable to read the file.");
        }
    }
}
