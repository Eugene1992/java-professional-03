package info.videosharp.jp2;

import org.junit.Assert;
import org.junit.Before;

/**
 * Created by Jevgenij Volosatov on 2/24/2017.
 * Testing MyArrayList
 */
public class MyArrayListTest
{
    private MyArrayList<String> list;

    @Before
    public void setUp() throws Exception
    {
        list = new MyArrayList<>();
    }

    @org.junit.Test
    public void add() throws Exception {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Welcome");
        String item = list.get(0);
        Assert.assertEquals("Welcome", item);
    }

    @org.junit.Test
    public void add1() throws Exception {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Welcome");
        list.add(0, "Brother");
        Assert.assertEquals("Brother", list.get(0));
        Assert.assertEquals("Welcome", list.get(1));
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void add1Exception() throws Exception {
        list.add(0, "Brother");
    }


    @org.junit.Test
    public void get() throws Exception {
        list.add("Zerost");
        list.add("First");
        list.add("Second");
        Assert.assertEquals("Zerost", list.get(0));
        Assert.assertEquals("First", list.get(1));
        Assert.assertEquals("Second", list.get(2));
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void getException() throws Exception {
        list.get(0);
    }

    @org.junit.Test
    public void contains() throws Exception {
        list.add("Zerost");
        list.add("First");
        list.add("Second");
        Assert.assertEquals(false, list.contains("Zero"));
        Assert.assertEquals(false, list.contains(null));
        Assert.assertEquals(true, list.contains("Zerost"));
        Assert.assertEquals(true, list.contains("Second"));
    }

    @org.junit.Test
    public void remove() throws Exception {
        list.add("First");
        Assert.assertEquals(1, list.size());
        list.remove(0);
        Assert.assertEquals(0, list.size());
        Assert.assertEquals(false, list.contains("Zero"));
    }

    @org.junit.Test
    public void set() throws Exception {
        list.add("Zerost");
        Assert.assertEquals(false, list.contains("Zero"));
        String zerost = list.set(0, "Zero");
        Assert.assertEquals(true, list.contains("Zero"));
        Assert.assertEquals("Zerost", zerost);
    }

    @org.junit.Test
    public void size() throws Exception {
        Assert.assertEquals(0, list.size());
        list.add("Zerost");
        Assert.assertEquals(1, list.size());
        list.add("First");
        Assert.assertEquals(2, list.size());
        list.add("Second");
        Assert.assertEquals(3, list.size());
    }

}