package util;

/**
 * Created by Lukas on 15-4-2017.
 */
public class Logger
{
    public static void print_ln(String m)
    {
        System.out.println(m);
    }

    public static void print_err(String m)
    {
        System.err.println(m);
    }

    public static void print_err(Exception e)
    {
        System.err.println(e.getMessage());
    }
}
