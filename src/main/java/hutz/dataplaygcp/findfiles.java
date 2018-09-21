package hutz.dataplaygcp;

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;


public class findfiles {
    public static List databuckets() throws IOException {
        List<Blob> objectlist = new ArrayList<Blob>();
        Storage storageclient = StorageOptions.getDefaultInstance().getService();
        String bucketname = getPropertyvalues().getProperty("BUCKET_NAME");
        Page<Blob> rootobjects = storageclient.list(bucketname);
        Iterator<Blob> rootobjectsiterator = (Iterator<Blob>) rootobjects.iterateAll();
        while (rootobjectsiterator.hasNext()) {
            Blob rootobject = rootobjectsiterator.next();
            objectlist.add(rootobject);
        }
        return objectlist;
    }

    private static Properties getPropertyvalues() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("app.properties"));
        return prop;
    }
}
