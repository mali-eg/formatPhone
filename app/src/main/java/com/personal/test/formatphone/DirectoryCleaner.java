package com.personal.test.formatphone;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;

public class DirectoryCleaner {
    private final File mFile;

    public DirectoryCleaner(File file) {
        mFile = file;
    }

    public void clean(File file) {
        if (null == file || !file.exists() || !file.isDirectory()) return;

        for (File f : file.listFiles()) {
            delete(f);
        }
    }

    private void delete(File file) {
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                delete(child);
            }
        }
        file.delete();
    }

    public File getPrivateAlbumStorageDir(Context context, String albumName) {
        File file = new File(context.getExternalFilesDir(
                Environment.DIRECTORY_PICTURES), albumName);
        if (!file.mkdirs()) {
            Log.e("", "Directory not created");
        }
        return file;
    }

    public File createFolder(String folderName)
    {
        File dir = new File(Environment.getExternalStorageDirectory() + "/Download/");
        dir.mkdirs(); // creates needed dirs
        return dir;
    }
}
