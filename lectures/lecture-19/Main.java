import pairpackage.Pair;

class Game {
    private int playerScore;
    private int level;
    Game(int playerScore, int level) {
        this.playerScore = playerScore;
        this.level = level;
    }

    void updateScore(int amount) {
        this.playerScore += amount;
        if (this.playerScore < 0) {
            this.playerScore = 0;
        }
    }

    int getPlayerScore() {
        return this.playerScore;
    }
}

public class Main {
    public static void main(String[] args) {
        Pair p = new Pair(4, 5);
        //System.out.println(p.a);
        System.out.println(p.addComponents());
    }
}
