import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "GAMES")
public class Game {
    @Id
    @GeneratedValue
    @Column(name = "GAME_ID")
    private int game_id;
    @Column(name = "GAME_STATUS")
    private String gameStatus;
    @Column(name = "PLAYER_1")
    private String player1;
    @Column(name = "PLAYER_2")
    private String player2;
    @Column(name = "RESULT")
    private String result;

    public Game() {
        gameStatus = "         ";
    }

    public Game(String player1) {
        gameStatus = "         ";
        this.player1 = player1;
    }

    public void drawX(int index) {
        StringBuilder sb = new StringBuilder(gameStatus);
        sb.setCharAt(index, 'X');
        gameStatus = sb.toString();
    }

    public void drawO(int index) {
        StringBuilder sb = new StringBuilder(gameStatus);
        sb.setCharAt(index, 'O');
        gameStatus = sb.toString();
    }

    public int getGame_id() {
        return game_id;
    }

    public String getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Game{");
        sb.append("game_id=").append(game_id);
        sb.append(", gameStatus='").append(gameStatus).append('\'');
        sb.append(", player1='").append(player1).append('\'');
        sb.append(", player2='").append(player2).append('\'');
        sb.append(", result='").append(result).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public boolean hasWon(String player) {
        int[][] results = Results.ARRAY.getArray();
        int count = 0;
        int len = results.length;
        String[] array = gameStatus.split("");

        for (int i = 0; i < len; i++) {
            for (int j : results[i]) {
                if (array[j].equals(player)) {
                    count++;
                    if (count == 3)
                        return true;
                }
            }
            count = 0;
        }
        return false;
    }

    public boolean isTurnX(String gameStatus) {
        int count = 0;

        for (String s : gameStatus.split("")) {
            if (s.equals(" "))
                count++;
        }

        if (count % 2 == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isTurnO(String gameStatus) {
        int count = 0;

        for (String s : gameStatus.split("")) {
            if (s.equals(" "))
                count++;
        }

        if (count % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasEnded() {
        if (!gameStatus.contains(" "))
            return true;
        return false;
    }
}
