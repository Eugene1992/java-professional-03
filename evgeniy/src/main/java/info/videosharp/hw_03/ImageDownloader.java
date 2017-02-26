package info.videosharp.hw_03;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

/**
 * Image Down Loader
 */
public class ImageDownloader
{
    private String web;
    private String host;
    private String path;
    private String ext;
    private String html;
    private ArrayList<String> listImages;

    public void downloadImagesFrom (String web, String ext, String path)
    {
        this.web = web;
        this.ext = ext;
        this.path = path;
        getHTML();
        findAllImages();
        saveAllImages();
    }

    private void getHTML ()
    {
        try
        {
            html = "";
            URL url = new URL(web);
            host = url.getProtocol() + "://" + url.getHost();
            InputStream is = url.openStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            while (true)
            {
                String line = br.readLine();
                if (line == null) break;
                sb.append(line);
            }
            html = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findAllImages()
    {
        listImages = new ArrayList<>();
        String [] items = html.split("\"|\'");
        for (String name : items)
            if (isImageName(name))
                listImages.add(name);
    }

    private boolean isImageName (String name)
    {
        return name.matches("[-a-zA-Z0-9/._]+\\." + ext);
    }

    private void saveAllImages()
    {
        int j = 0;
        for (String name : listImages)
            saveImage(name, (++j) + "." + ext);
    }

    private void saveImage (String name, String file)
    {
        System.out.println("Saving " + name);
        try
        {
            URL url = new URL(host + name);
            InputStream is = url.openStream();

            OutputStream os = new FileOutputStream(path + file);

            byte [] b = new byte [1024];
            int length;

            while (-1 != (length = is.read(b)))
                os.write(b, 0, length);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
