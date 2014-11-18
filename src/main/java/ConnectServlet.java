import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ConnectServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int game_id = 0;
        Cookie[] cookies = request.getCookies();

        for (Cookie c : cookies) {
            if (c.getName().equals("game_id")) {
                game_id = Integer.parseInt(c.getValue());
            }

            GameDaoImpl gameDao = new GameDaoImpl();
            Game game = gameDao.getById(game_id);

            String name1 = game.getPlayer1();
            String name2 = request.getParameter("name2");

            game.setPlayer2(name2);
            gameDao.update(game);

            request.getSession().setAttribute("name1", name1);
            request.getSession().setAttribute("name2", name2);
            request.getSession().setAttribute("game", game);

            Cookie cookie = new Cookie("player", String.valueOf("O" + name2));
            response.addCookie(cookie);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/game.jsp");
            rd.forward(request, response);

            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int game_id = Integer.parseInt(request.getQueryString());
        GameDaoImpl gameDao = new GameDaoImpl();

        Cookie cookie = new Cookie("game_id", String.valueOf(game_id));
        response.addCookie(cookie);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/connect.jsp");
        rd.forward(request, response);
    }
}
