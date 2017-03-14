package info.videosharp.hw_03;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Mokytojas on 2/27/2017.
 */
public class FindFilesRecursionIO extends FindFiles
{
    private String ext;
    private ArrayList<String> list;

    @Override
    public String[] findFiles(String path, String ext)
    {
        this.ext = "." + ext;
        list = new ArrayList<>();
        File dir = new File(path);
        scanFolder(dir);
        return list.toArray(new String [0]);
    }

    private void scanFolder (File dir)
    {
        if (dir == null) return;
        if (!dir.isDirectory()) return;
        File [] files = dir.listFiles();
        for (File file : files)
            if (file.isDirectory())
                scanFolder (file);
            else if (file.getName().endsWith(ext))
                list.add(file.getPath());
    }
}
