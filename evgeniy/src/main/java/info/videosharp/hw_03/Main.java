package info.videosharp.hw_03;

public class Main
{
    public static void main(String[] args)
    {
        //testImageDownloader();
        testFindFiles ();
    }

    private static void testImageDownloader ()
    {
        ImageDownloader id = new ImageDownloader();

        id.downloadImagesFrom(
                "http://flangex.herokuapp.com/io/load",
                "png",
                "");
    }

    private static void testFindFiles ()
    {
        FindFiles ff = new FindFilesQueueNIO();
        String files [] = ff.findFiles(".", "java");
        for (String name : files)
            System.out.println(name);
    }
}
