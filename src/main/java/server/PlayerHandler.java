package server;

import model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lukas on 27-5-2017.
 */
public class PlayerHandler
{
    //sessionID, player
    private HashMap<String, Player> players;

    public PlayerHandler()
    {
        players = new HashMap<>();
    }

    public void registerPlayer(String sessionID, Player player)
    {
        if(sessionID != null && player != null)
            players.put(sessionID, player);
    }

    public void unRegisterPlayer(String sessionID)
    {
        players.remove(sessionID);
    }

    public Player getPlayer(String sessionID)
    {
        return players.get(sessionID);
    }

    public List<Player> getPlayers()
    {
        return new ArrayList<>(players.values());
    }
}
