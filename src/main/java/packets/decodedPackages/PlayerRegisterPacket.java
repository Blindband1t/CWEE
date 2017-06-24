package packets.decodedPackages;

import model.Player;

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
}
