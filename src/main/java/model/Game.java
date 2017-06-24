package model;

import exceptions.DomainException;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lukas on 8-4-2017.
 */
public class Game {
    private static final int PLAYERS_PER_GAME = 4;
    private Date startDate;
    private ArrayList<Player> players;
    private int activePlayerIndex;
    private boolean started = false;

    public Game() {
        startDate = new Date(System.currentTimeMillis());
        players = new ArrayList<>();
        activePlayerIndex = 0;
    }

    public List<Player> getPlayers()
    {
        return players;
    }

    public Player getActivePlayer() throws DomainException
    {
        if(started)
            return players.get(activePlayerIndex);
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
