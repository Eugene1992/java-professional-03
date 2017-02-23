package info.videosharp.jp2;

public class Main
{
    public static void main(String[] args)
    {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("Monday");
        list.add("Tuesday");
        list.add("Wednesday");
        list.add("Thursday");
        list.add("Friday");
        list.add("Saturday");
        list.add("Sunday");
        for (String day : list)
            System.out.println(day);
        System.out.println("-------");
        list.remove(0);
        list.remove(3);
        for (String day : list)
            System.out.println(day);
        System.out.println("-------");
        list.add(4, "Weekend");
        for (String day : list)
            System.out.println(day);
        System.out.println("-------");
    }
}
