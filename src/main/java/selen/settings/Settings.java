package selen.settings;

import org.json.simple.JSONObject;

import static utils.FileUtils.read;
import static utils.JsonUtils.readJson;

public class Settings {
    public static JSONObject settings = readJson(read("src/main/resources/settings.json"));
    public static JSONObject timeouts = (JSONObject) readJson(read("src/main/resources/settings.json")).get("timeouts");
    public static JSONObject chrome = readJson(read("src/main/resources/browsersArg/chrome.json"));
    public static JSONObject firefox = readJson(read("src/main/resources/browsersArg/firefox.json"));
    public static JSONObject testData = readJson(read("src/main/resources/testData.json"));
}