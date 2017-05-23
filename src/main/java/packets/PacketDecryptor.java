package packets;

import exceptions.PacketException;

/**
 * Created by lukas on 24-5-2017.
 */
public class PacketDecryptor
{
    public static Packet decrypt(byte[] packetString) throws PacketException
    {
        Packet packet = new Packet();

        if(isValidType(packetString[0]))
            packet.setType(packetString[0]);
        else
            throw new PacketException(packetString[0] + " is not a valid packet type");

        packet.setData(removeType(packetString));

        return packet;
    }

    private static boolean isValidType(byte type)
    {
        for(byte action : PacketType.actions)
            if(type == action)
                return true;
        return false;
    }

    private static byte[] removeType(byte[] packetString)
    {
        byte[] data = new byte[packetString.length - 1];
        for(int i = 1; i < packetString.length; i++)
            data[i - 1] = packetString[i];
        return data;
    }
}
