package packets;

import exceptions.DomainException;
import exceptions.PacketException;
import model.Player;
import packets.decodedPackages.DecodedPackage;
import packets.decodedPackages.PlayerRegisterPacket;

import javax.websocket.Session;

/**
 * Created by lukas on 27-5-2017.
 */
public class PacketFactory
{
    public static DecodedPackage getPackage(Session session, String message) throws DomainException, PacketException
    {
        Byte type = PacketDecryptor.getPacketType(message.getBytes());

        if(type.equals(PacketType.REGISTER_PLAYER))
            return registerPlayer(session, message);

        return null;
    }

    public static PlayerRegisterPacket registerPlayer(Session session, String message) throws PacketException, DomainException
    {
        Packet packet = PacketDecryptor.decrypt( message.getBytes());
        PlayerRegisterPacket decodedPackage = new PlayerRegisterPacket();
        decodedPackage.setOrigin(session);
        Player player = new Player(new String(packet.getData()));
        decodedPackage.setPlayer(player);
        return decodedPackage;
    }

}
