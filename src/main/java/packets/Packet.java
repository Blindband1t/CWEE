package packets;

/**
 * Created by lukas on 18-5-2017.
 */
public class Packet
{
    private byte type;
    private byte[] data;

    public Packet() {}

    public Packet(byte type, byte[] data)
    {
        setType(type);
        setData(data);
    }

    public byte getType()
    {
        return type;
    }

    public void setType(byte type)
    {
        this.type = type;
    }

    public byte[] getData()
    {
        return data;
    }

    public void setData(byte[] data)
    {
        this.data = data;
    }
}
