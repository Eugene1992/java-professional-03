package info.videosharp.hw_03;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FindFilesRecursionNIO extends FindFiles
{
    private String ext;
    private ArrayList<String> list;

    @Override
    public String[] findFiles(String path, String ext)
    {
        this.ext = "." + ext;
        list = new ArrayList<>();
        Path dir = Paths.get(path);
        scanFolder(dir);
        return list.toArray(new String [0]);
    }

    private void scanFolder (Path dir)
    {
        if (dir == null) return;
        try {
            DirectoryStream<Path> stream = Files.newDirectoryStream(dir);
            for (Path file : stream)
                if (Files.isDirectory(file))
                    scanFolder (file);
                else if (file.toString().endsWith(ext))
                    list.add(file.toString());
            stream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
