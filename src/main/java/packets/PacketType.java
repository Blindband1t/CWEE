package packets;

/**
 * Created by lukas on 18-5-2017.
 */
public class PacketType
{
    public static final Byte REGISTER_PLAYER = 0x01;
    public static final Byte DISCONNECT_PLAYER = 0x02;
    public static final Byte PLAYER_LIST = 0x03;

    public static final Byte[] actions =
    {
        REGISTER_PLAYER,
        DISCONNECT_PLAYER,
        PLAYER_LIST
    };
}
