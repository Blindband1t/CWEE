package packets.decodedPackages;

import model.Player;
import server.GameHandler;
import server.SessionHandler;

import javax.websocket.SendHandler;
import javax.websocket.Session;

/**
 * Created by lukas on 27-5-2017.
 */
public class PlayerRegisterPacket extends DecodedPackage
{
    private Player player;

    public PlayerRegisterPacket() {}

    public PlayerRegisterPacket(Session origin, Player player)
    {
        super(origin);
        setPlayer(player);
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }

    public Player getPlayer()
    {
        return player;
    }

    @Override
    public void executeTask(SessionHandler sessionHandler)
    {
        sessionHandler.getGameHandler().registerPlayer(getOrigin(), player);
    }
}
