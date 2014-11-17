import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Cookie[] cookies = request.getCookies();

        String name1 = request.getParameter("name");


        GameDaoImpl gameDao = new GameDaoImpl();
        Game game = new Game(name1);

        gameDao.save(game);

        String gameStatus = game.getGameStatus();

        Cookie cookie1 = new Cookie("game_id", String.valueOf(gameDao.getLastId()));
        Cookie cookie2 = new Cookie("player", "X" + name1);

        cookie1.setMaxAge(60 * 60);
        response.addCookie(cookie1);

        cookie2.setMaxAge(60 * 60);
        response.addCookie(cookie2);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/game.jsp");
        request.getSession().setAttribute("name1", name1);
        request.getSession().setAttribute("game", game);
        request.getSession().setAttribute("gameStatus", gameStatus);
        rd.forward(request, response);
        }
    }

