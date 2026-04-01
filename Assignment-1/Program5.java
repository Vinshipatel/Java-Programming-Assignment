import java.util.Scanner;

class Cricket {
    String teamName;
    int score;
    int overs;

    void getData(Scanner sc, int teamNumber) {
        System.out.print("Enter Team " + teamNumber + " Name: ");
        teamName = sc.nextLine();

        System.out.print("Enter Score of Team " + teamNumber + ": ");
        score = sc.nextInt();

        System.out.print("Enter Overs of Team " + teamNumber + ": ");
        overs = sc.nextInt();
        sc.nextLine();
    }
}

class Match extends Cricket {
    void displayWinner(Cricket t1, Cricket t2) {
        System.out.println("\nMatch Between " + t1.teamName + " and " + t2.teamName);

        System.out.println(t1.teamName + " Score: " + t1.score);
        System.out.println(t2.teamName + " Score: " + t2.score);

        if (t1.score > t2.score) {
            System.out.println("Winner: " + t1.teamName);
        } else if (t2.score > t1.score) {
            System.out.println("Winner: " + t2.teamName);
        } else {
            System.out.println("Match Draw");
        }
    }
}

public class Program5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Cricket team1 = new Cricket();
        Cricket team2 = new Cricket();
        Match match = new Match();

        team1.getData(sc, 1);
        team2.getData(sc, 2);

        match.displayWinner(team1, team2);

        sc.close();
    }
}