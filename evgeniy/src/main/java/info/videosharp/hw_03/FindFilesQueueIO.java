package info.videosharp.hw_03;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FindFilesQueueIO extends FindFiles
{
    private String ext;
    private Queue<File> dirs;
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
        dirs = new LinkedList<>();
        dirs.add(new File (path));
        while (dirs.size() > 0)
        {
            File dir = dirs.remove();
            if (!dir.isDirectory()) continue;
            File[] files = dir.listFiles();
            if (files == null) continue;
            for (File file : files)
                if (file.isDirectory())
                    dirs.add(file);
                else if (file.getName().endsWith(ext))
                    list.add(file.getPath());
        }
    }
}
