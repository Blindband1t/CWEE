package server;

import model.Device;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import sun.util.logging.PlatformLogger;

import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonObject;
import javax.websocket.Session;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by lukas on 18-5-2017.
 */

@ApplicationScoped
public class SessionHandler
{
    private int deviceId = 0;
    private final Set<Session> sessions = new HashSet<Session>();
    private final Set<Device> devices = new HashSet<Device>();

    public void addSession(Session session)
    {
        sessions.add(session);
    }

    public void removeSession(Session session)
    {
        sessions.remove(session);
    }

    public List<Device> getDevices()
    {
        return new ArrayList<Device>(devices);
    }

    public void addDevice(Device device)
    {
//        device.setId(deviceId++);
//        devices.add(device);
//        JsonObject addMessage = createAddMessage(device);
//        sendToAllConnectedSessions(addMessage);
        throw new NotImplementedException();
    }

    public void removeDevice(int id)
    {
        throw new NotImplementedException();
    }

    public void toggleDevice(int id)
    {
        throw new NotImplementedException();
    }

    public Device getDeviceById(int id)
    {
        throw new NotImplementedException();
    }

    private JsonObject createAddMessage(Device device)
    {
        throw new NotImplementedException();
    }

    private void sendToAllConnectedSessions(JsonObject message)
    {
        for(Session session : sessions)
        {
            sendToSession(session, message);
        }
    }

    private void sendToSession(Session session, JsonObject message)
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
}
