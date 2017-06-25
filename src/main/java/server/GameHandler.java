package server;

import model.Player;

import javax.websocket.Session;
import java.util.List;

/**
 * Created by lukas on 24-5-2017.
 */
public class GameHandler
{
    private PlayerHandler playerHandler;


    public GameHandler()
    {
        playerHandler = new PlayerHandler();
    }

    public void registerPlayer(Session session, Player player)
    {
        playerHandler.registerPlayer(session.getId(), player);
    }

    public List<Player> getPlayerList()
    {
        return playerHandler.getPlayers();
    }
}
