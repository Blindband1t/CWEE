package packets.decodedPackages;

import javax.websocket.Session;

/**
 * Created by lukas on 27-5-2017.
 */
public class DecodedPackage
{
    private Session origin;

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
}
