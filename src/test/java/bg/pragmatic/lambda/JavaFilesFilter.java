package bg.pragmatic.lambda;

import java.io.File;
import java.io.FileFilter;

public class JavaFilesFilter implements FileFilter {

    @Override
    public boolean accept(File pathname) {
        return pathname.getName().endsWith(".java");
    }

}
