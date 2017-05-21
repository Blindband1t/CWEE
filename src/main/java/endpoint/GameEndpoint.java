package endpoint;

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
    @OnOpen
    public void open(Session session)
    {

    }

    @OnClose
    public void close(Session session)
    {

    }

    @OnError
    public void error(Throwable error)
    {

    }

    @OnMessage
    public void handleMessage(String message, Session session)
    {

    }
}
