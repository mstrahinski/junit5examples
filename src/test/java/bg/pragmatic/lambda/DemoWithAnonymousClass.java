package bg.pragmatic.lambda;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class DemoWithAnonymousClass {
    public static void main(String[] args) {
        FileFilter filesFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };

        File dir = new File("e:/tmp");
        File[] javaFiles = dir.listFiles(filesFilter);

        System.out.println(Arrays.toString(javaFiles));
    }
}
