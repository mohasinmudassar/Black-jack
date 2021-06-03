import java.util.*;
public class P1Random
{
    private long next;

    public P1Random()
    {
        next = 0;
    }

    private short nextShort()
    {
        return nextShort(Short.MAX_VALUE);
    }

    private short nextShort(short limit)
    {
        next = next * 1103515245 + 12345;
        return (short) Math.abs(((next / 65536) % limit));
    }

    private int nextInt()
    {
        return nextInt(Integer.MAX_VALUE);
    }

    public int nextInt(int limit)
    {
//        return ((((int) nextShort()) << 16) | ((int) nextShort())) % limit;
        //using default random class since the one line was only producing 5 instead of a random number!
          Random rand = new Random();
          return(rand.nextInt(limit));
    }

    private double nextDouble()
    {
        return (double) nextInt() / (double) Integer.MAX_VALUE;
    }
}
