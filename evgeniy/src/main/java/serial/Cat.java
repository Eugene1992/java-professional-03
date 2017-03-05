package serial;

/**
 * Created by Wiktorina on 2017-03-05.
 */
@Serialable
public class Cat
{
    @SerialField("dog")
    private String name;

    private int age;

    public Cat (String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String toString()
    {
        return "Cat " + name + ", " + age + " years";
    }
}
