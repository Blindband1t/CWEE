package model;

import exceptions.DomainException;

/**
 * Created by Cedric on 7/04/2017.
 */
public class Player
{
    private String name;
    private int totalScore;
    private int currentScore;
    private Game game;

    public Player(String name) throws DomainException
    {
        setName(name);
    }

    private void setName(String name) throws DomainException
    {
        if(name.isEmpty() || name == null)
        {
            throw new DomainException("enter your name");
        }
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    private void setTotalScore(int totalScore){
        this.totalScore = totalScore;
    }

    public void setGame(Game game)
    {
        if(game != null)
            this.game = game;
    }

    public void leaveGame()
    {
        game = null;
    }

//    public boolean authenticate (String email, String password) throws DomainException{
//
//        if(email.isEmpty() || email == null){
//            throw new DomainException("Enter your email address please");
//        }
//
//
//        if (password.isEmpty()|| password == null){
//            throw new DomainException("Enter your password please");
//        }
//
//        if(password.equals(this.password) && email.equals(this.email)){
//            return true;
//        }
//
//        return false;
//    }

    public void addScore(int score){
        this.currentScore += score;
    }

    public void resetScore()
    {
        this.totalScore += this.currentScore;
        this.currentScore = 0;
    }
}

