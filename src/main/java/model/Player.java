package model;

import exceptions.DomainException;

/**
 * Created by Cedric on 7/04/2017.
 */
public class Player
{
    private String name;
    private String fname;
    private int totalScore;
    private int currentScore;
    private String email;
    private String password;


public Player(String name, String fname, String email, String password) throws DomainException
{
 setFname(fname);
 setName(name);
 setEmail(email);
 setPassword(password);
}

private void setEmail(String email) throws DomainException
{
    if(email.isEmpty() || email == null)
    {
        throw new DomainException("enter an email address");
    }
    this.email = email;
}

private void setName(String name) throws DomainException
{
    if(name.isEmpty() || name == null)
    {
        throw new DomainException("enter your name");
    }
    this.name = name;
}

private void setFname(String fname) throws DomainException{
    if(fname.isEmpty() || fname == null)
    {
        throw new DomainException("Enter your first name");
    }
    this.fname = fname;
}

private void setTotalScore(int totalScore){
    this.totalScore = totalScore;
}

private void setPassword(String password) throws DomainException
{
    if (password.isEmpty() || password == null)
    {
        throw new DomainException("Enter a password please");
    }
}

public String getName()
{
    return this.name;
}

public String getFname(){
    return this.fname;
}

public String getEmail()
{
    return this.email;
}

public String getPassword()
{
    return this.password;
}

public boolean authenticate (String email, String password) throws DomainException{

    if(email.isEmpty() || email == null){
        throw new DomainException("Enter your email address please");
    }


    if (password.isEmpty()|| password == null){
        throw new DomainException("Enter your password please");
    }

    if(password.equals(this.password) && email.equals(this.email)){
        return true;
    }

    return false;
}

public void addScore(int score){
    this.currentScore += score;
}

public void resetScore()
{
    this.totalScore += this.currentScore;
    this.currentScore = 0;
}
}

