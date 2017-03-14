package info.videosharp.hw_03;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FindFilesQueueNIO extends FindFiles
{
    private String ext;
    private Queue<Path> dirs;
    private ArrayList<String> list;

    @Override
    public String[] findFiles(String path, String ext)
    {
        this.ext = "." + ext;
        list = new ArrayList<>();
        scanFolder(path);
        return list.toArray(new String [0]);
    }

    private void scanFolder (String path)
    {
        try
        {
            dirs = new LinkedList<>();
            dirs.add(Paths.get(path));
            while (dirs.size() > 0)
            {
                Path dir = dirs.remove();
                if (!Files.isDirectory(dir)) continue;
                DirectoryStream<Path> stream = Files.newDirectoryStream(dir);
                for (Path file : stream)
                    if (Files.isDirectory(file))
                        dirs.add(file);
                    else if (file.toString().endsWith(ext))
                        list.add(file.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
