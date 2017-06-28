package packets.decodedPackages;

import server.GameHandler;
import server.SessionHandler;

import javax.websocket.Session;

/**
 * Created by lukas on 27-5-2017.
 */
public class DecodedPackage
{
    protected Session origin;
    protected String message;

    public DecodedPackage() {}

    public DecodedPackage(Session origin)
    {
        setOrigin(origin);
    }

    public void setOrigin(Session origin)
    {
        this.origin = origin;
    }

    public Session getOrigin()
    {
        return origin;
    }

    public void executeTask(SessionHandler sessionHandler)
    {

    }
}
