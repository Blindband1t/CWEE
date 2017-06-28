package util;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by lukas on 27-6-2017.
 */
public class Util
{
    private static Gson gson = new Gson();

    public static String convertToJson(Object o)
    {
        return gson.toJson(o);
    }

}
