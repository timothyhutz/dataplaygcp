package hutz.dataplaygcp;

import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class findbuckets {
    public static List databuckets() {
        List<String> objectlist = new ArrayList<String>();
        Storage storageclient = StorageOptions.getDefaultInstance().getService();
        return objectlist;
    }

    private static Properties getPropertyvalues() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("app.properties"));
        return prop;
    }
}
