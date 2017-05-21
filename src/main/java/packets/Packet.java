package packets;

/**
 * Created by lukas on 18-5-2017.
 */
public class Packet
{
    private Byte type;
    private Byte[] data;

    public Packet(Byte type, Byte[] data)
    {
        setType(type);
        setData(data);
    }

    public Byte getType()
    {
        return type;
    }

    public void setType(Byte type)
    {
        this.type = type;
    }

    public Byte[] getData()
    {
        return data;
    }

    public void setData(Byte[] data)
    {
        this.data = data;
    }
}
