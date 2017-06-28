package packets.decodedPackages;

import server.GameHandler;
import server.SessionHandler;
import util.Util;

/**
 * Created by lukas on 25-6-2017.
 */
public class PlayerListPacket extends DecodedPackage
{

    public PlayerListPacket()
    {
    }

    @Override
    public void executeTask(SessionHandler sessionHandler)
    {
        String jsonList = Util.convertToJson(sessionHandler.getGameHandler().getPlayerList());
        sessionHandler.sendToSession(origin, jsonList.getBytes());
    }
}
