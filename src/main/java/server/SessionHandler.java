package server;

import exceptions.DomainException;
import exceptions.PacketException;
import packets.PacketDecryptor;
import packets.PacketFactory;
import packets.PacketType;

import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonObject;
import javax.websocket.Session;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by lukas on 18-5-2017.
 */

@ApplicationScoped
public class SessionHandler
{
    private final Set<Session> sessions = new HashSet<>();
    private GameHandler gameHandler = new GameHandler();

    public void addSession(Session session)
    {
        sessions.add(session);
    }

    public void removeSession(Session session)
    {
        sessions.remove(session);
    }

    public void sendToAllConnectedSessions(Byte[] message)
    {
        for(Session session : sessions)
        {
            sendToSession(session, message);
        }
    }

    public void sendToSession(Session session, Byte[] message)
    {
        try
        {
            session.getBasicRemote().sendText(message.toString());
        }
        catch(IOException e)
        {
            sessions.remove(session);
            Logger.getLogger(SessionHandler.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void handleMessage(String message, Session session) throws DomainException, PacketException
    {
        Byte type = PacketDecryptor.getPacketType(message.getBytes());
        switch (type)
        {
            case PacketType.REGISTER_PLAYER:
                PacketFactory.registerPlayer(session, message);
                gameHandler.registerPlayer();
                break;
            default:
                return;
        }
    }

}
