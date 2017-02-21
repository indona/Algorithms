import java.util.*;
import java.lang.*;

class Vector2D implements Iterator<Integer>
{
    List<List<Integer>> vector2D = new ArrayList<List<Integer>>();
    int row, column;

    public Vector2D(List<List<Integer>> vec2d)
    {
        this.vector2D=vec2d;
        row=0;
        column=0;
    }

    @Override
    public Integer next()
    {
        hasNext();
        return vector2D.get(row).get(column++);
    }

    @Override
    public boolean hasNext()
    {
        while(row<vector2D.size())
        {
            if(col<vector2D.get(row).size())
                return true;
            else
            {
                row++;
                col=0;
            }
        }
        return false;
    }
  }

  public class Flatten2DVector
  {
    public static void main(String args[])
    {
        List<Integer> i1 = Arrays.asList(1,2);
        List<Integer> i2 = Arrays.asList(3);
        List<Integer> i3 = new ArrayList<Integer>();
        List<Integer> i4 = new ArrayList<Integer>();
        List<Integer> i5 = Arrays.asList(4,5,6);
        List<Integer> i6 = new ArrayList<Integer>();
        List<Integer> i7 = Arrays.asList(7);

        List<List<Integer>> vec2d = new ArrayList<List<Integer>>();
        vec2d.add(i1);
        vec2d.add(i2);
        vec2d.add(i3);
        vec2d.add(i4);
        vec2d.add(i5);
        vec2d.add(i6);
        vec2d.add(i7);

        Vector2D i = new Vector2D(vec2d);
        while(i.hasNext())
        {
            System.out.println(i.next());
        }
    }
}
