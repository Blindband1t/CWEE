package server;

import exceptions.DomainException;
import exceptions.PacketException;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/**
 * Created by lukas on 18-5-2017.
 */

@ApplicationScoped
@ServerEndpoint("/actions")
public class GameEndpoint
{
    public SessionHandler sessionHandler;

    public GameEndpoint()
    {
        sessionHandler = new SessionHandler();
    }

    @OnOpen
    public void open(Session session)
    {
        sessionHandler.addSession(session);
    }

    @OnClose
    public void close(Session session)
    {
        sessionHandler.removeSession(session);
    }

    @OnError
    public void error(Throwable error)
    {

    }

    @OnMessage
    public void handleMessage(String message, Session session)
    {
        try {
            sessionHandler.handleMessage(message, session);
        } catch (DomainException e) {
            e.printStackTrace();
        } catch (PacketException e) {
            e.printStackTrace();
        }
    }
}
