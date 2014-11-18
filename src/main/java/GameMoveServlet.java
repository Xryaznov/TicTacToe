import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GameMoveServlet extends HttpServlet {
    private String player;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Game game = (Game) request.getSession().getAttribute("game");
        System.out.println("GameMoveServlet");
        int game_id = game.getGame_id();

        String result = "in progress";

        GameDaoImpl gameDao = new GameDaoImpl();
        Game game1 = gameDao.getById(game_id);

        System.out.println(game1 == null);

        if (game1.hasWon("X")) {
            result = game1.getPlayer1() + " won!";
        }

        if (game1.hasWon("O")) {
            result = game1.getPlayer2() + " won!";
        }

        game1.setResult(result);

        gameDao.update(game1);

        request.getSession().setAttribute("game", game1);
        request.getSession().setAttribute("gameStatus", game1.getGameStatus());
        request.getSession().setAttribute("result", result);

        System.out.println(game.getGameStatus());

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/game.jsp");
        rd.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        int game_id = 0;

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("game_id")) {
                game_id = Integer.parseInt(cookie.getValue());
            }

            if (cookie.getName().equals("player")) {
                player = cookie.getValue();
            }
        }

        System.out.println(game_id);
        System.out.println(player);

        GameDaoImpl gameDao = new GameDaoImpl();
        Game game = gameDao.getAll().get(game_id - 1);

        int cell = Integer.parseInt(request.getParameter("cell"));
        System.out.println(cell);

        if (player.substring(0, 1).equals("X") && (game.isTurnX(game.getGameStatus()))) {
            game.drawX(cell);
        }

        if (player.substring(0, 1).equals("O") && (game.isTurnO(game.getGameStatus()))) {
                game.drawO(cell);
        }

        gameDao.update(game);

        System.out.println("test");

    }
}
