package bg.pragmatic.lambda;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class DemoWithLambdaExpression {

    public static void main(String[] args) {
        FileFilter fileFilter = (File pathname) -> pathname.getName().endsWith("java");

        File dir = new File("e:/tmp");
        File[] allJavaFiles = dir.listFiles(fileFilter);

        System.out.println(Arrays.toString(allJavaFiles));

    }
}
