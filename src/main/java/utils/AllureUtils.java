package utils;

import io.qameta.allure.Allure;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class AllureUtils {

    public static void addAttachment(Path path, String nameAttach) {
        try (InputStream is = Files.newInputStream(path)) {
            Allure.addAttachment(nameAttach, is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addAttachment(String attachment, String nameAttach) {
            Allure.addAttachment(nameAttach, attachment);
    }
}
