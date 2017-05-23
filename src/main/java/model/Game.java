package model;

import exceptions.DomainException;

import javax.websocket.Session;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Lukas on 8-4-2017.
 */
public class Game
{
    private static final int PLAYERS_PER_GAME = 4;
    private Date startDate;
    private HashMap<Session, Player> players;
    private ArrayList<Session> playerOrder;
    private int activePlayerIndex;
    private boolean started = false;

    public Game()
    {
        startDate = new Date(System.currentTimeMillis());
        players = new HashMap<>();
        playerOrder = new ArrayList<>();
        activePlayerIndex = 0;
    }

    public Player getActivePlayer() throws DomainException
    {
        if(started)
            return players.get(playerOrder.get(activePlayerIndex));
        else
            throw new DomainException("Cannot get the player if the game has not been started");
    }

    public void startGame()throws DomainException
    {
        if(players.size() == PLAYERS_PER_GAME)
            started = true;
        else
            throw new DomainException("Game cannot start: not enough players.");
    }

    public void nextPlayer() throws DomainException
    {
        if(!started)
            throw new DomainException("The game has not been started yet!");
        else
        {
            activePlayerIndex++;
            if(activePlayerIndex == PLAYERS_PER_GAME)
                activePlayerIndex = 0;
        }
    }

    public Date getStartDate()
    {
        return startDate;
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public int getActivePlayerIndex()
    {
        return activePlayerIndex;
    }

    public void setActivePlayerIndex(int activePlayerIndex)
    {
        this.activePlayerIndex = activePlayerIndex;
    }
}
