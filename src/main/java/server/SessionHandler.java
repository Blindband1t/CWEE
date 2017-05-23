package server;

import exceptions.PacketException;
import packets.Packet;
import packets.PacketDecryptor;

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

    public void addSession(Session session)
    {
        sessions.add(session);
    }

    public void removeSession(Session session)
    {
        sessions.remove(session);
    }

    public void sendToAllConnectedSessions(byte[] message)
    {
        for(Session session : sessions)
        {
            sendToSession(session, message);
        }
    }

    public void sendToSession(Session session, byte[] message)
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

    public void handleMessage(String message, Session session) throws PacketException
    {
        Packet packet = PacketDecryptor.decrypt( message.getBytes());

    }
}
