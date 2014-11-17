import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class GameMoveServlet extends HttpServlet {
    private int game_id;
    private String player;
    private String result;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GameDaoImpl gameDao = new GameDaoImpl();
        Game game = gameDao.getAll().get(game_id - 1);
        String gameStatus = game.getGameStatus();

        request.getSession().setAttribute("gameStatus", gameStatus);
        request.getSession().setAttribute("game", game);


        switch (gameStatus) {
            case "XXXOOOOOO":
                result = "X has won";
                break;
        }


        game.setResult(result);
        gameDao.update(game);




        request.getSession().setAttribute("game", game);
        request.getSession().setAttribute("result", result);

        System.out.println("post test");
        System.out.println(game.getGameStatus());
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/game.jsp");
        rd.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();

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
        if (player.substring(0, 1).equals("X")) {
            game.drawX(cell);
        } else if (player.substring(0, 1).equals("O")) {
            game.drawO(cell);
        }

        gameDao.update(game);

        System.out.println("test");

    }
}
