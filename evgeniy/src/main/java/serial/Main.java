package serial;

public class Main
{
    public static void main(String[] args)
    {
        Cat cat = new Cat ("Maja", 5);
        Serial<Cat> js = new Serial<>();
        String text = js.toJSON(cat);
        System.out.println(text);

        text = text.replace("Maja", "Moja Maja");
        text = text.replace("5", "6");

        js.fromJSON(text, cat);

        System.out.println(cat);
    }
}
