import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class ConnectServlet extends HttpServlet {
    int game_id;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        System.out.println(Arrays.asList(cookies));


        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("game_id")) {
                game_id = Integer.parseInt(cookie.getValue());
            }

            GameDaoImpl gameDao = new GameDaoImpl();
            Game game = gameDao.getById(game_id);

            System.out.println(game.toString());
            String name1 = game.getPlayer1();
            System.out.println(game.getPlayer1() == null);
            String name2 = request.getParameter("name2");

            game.setPlayer2(name2);
            gameDao.update(game);

            request.getSession().setAttribute("name1", name1);
            request.getSession().setAttribute("name2", name2);
            request.getSession().setAttribute("game", game);

            Cookie cookie1 = new Cookie("player", String.valueOf("O" + name2));
            response.addCookie(cookie1);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/game.jsp");
            rd.forward(request, response);
            return;


        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getQueryString());

        System.out.println(id);

        HibernateUtil.getSessionFactory().openSession();

        GameDaoImpl gameDao = new GameDaoImpl();

        System.out.println(gameDao.getById(id).getPlayer1());

        Cookie cookie1 = new Cookie("game_id", String.valueOf(id));
        response.addCookie(cookie1);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/connect.jsp");
        rd.forward(request, response);

    }

}
