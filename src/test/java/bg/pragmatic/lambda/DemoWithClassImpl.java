package bg.pragmatic.lambda;

import java.io.File;
import java.util.Arrays;

public class DemoWithClassImpl {
    public static void main(String[] args) {
        JavaFilesFilter filesFilter = new JavaFilesFilter();
        File directory = new File("e:/tmp");

        File[] javaFiles = directory.listFiles(filesFilter);

        System.out.println(Arrays.toString(javaFiles));

    }

}
