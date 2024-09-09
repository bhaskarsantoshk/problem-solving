package company.google;
import java.util.*;

public class P1166DesignFileSystem {
    class FileSystem {

        Map<String, Integer> fileSystem ;

        public FileSystem() {
            fileSystem = new HashMap<>();
        }

        public boolean createPath(String path, int value) {
            // Creates a new path and associates a value to it if possible and returns true.
            // Returns false if the path already exists or its parent path doesn't exist.
            if ( fileSystem.containsKey(path)) return false;
            int index = path.lastIndexOf("/");
            String parent = path.substring(0, index);
            if ( !fileSystem.containsKey(parent)) return false;
            fileSystem.put(path, value);
            return true;
        }

        public int get(String path) {
            // Returns the value associated with path or returns -1 if the path doesn't exist.
            return fileSystem.getOrDefault(path,-1);
        }
    }
}
