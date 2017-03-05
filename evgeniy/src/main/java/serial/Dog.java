package serial;

/**
 * Created by Wiktorina on 2017-03-05.
 */

public class Dog
{
    @SerialField("cat")
    private String name;

    @SerialField
    private int age;

    public Dog (String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String toString()
    {
        return "Dog " + name + ", " + age + " years";
    }
}
