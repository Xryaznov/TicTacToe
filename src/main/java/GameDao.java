import java.util.List;

public interface GameDao {

    void save(Game obj);

    List<Game> getAll();

    void update(Game game);

    void delete(Game game);
}