package info.videosharp.hw_03;

public class Main
{
    public static void main(String[] args) {
        ImageDownloader id = new ImageDownloader();

        id.downloadImagesFrom(
                "http://flangex.herokuapp.com/io/load",
                "png",
                "g:\\GIT\\JavaProfessional\\img\\");
    }
}
