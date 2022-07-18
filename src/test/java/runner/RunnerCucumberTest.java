package runner;

import com.github.automatedowl.tools.AllureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import java.nio.file.Paths;

import static selen.settings.Settings.*;
import static selen.Selen.*;
import static utils.AllureUtils.addAttachment;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"definitions"}
)
public class RunnerCucumberTest extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void SetEnv() {
        AllureEnvironmentWriter.allureEnvironmentWriter(
                ImmutableMap.<String, String> builder()
                        .put("Browser", settings.get("browserName").toString())
                        .put("ENV", browser().getHostName())
                        .put("URL", settings.get("url").toString())
                        .build());
    }

    @Override
    @DataProvider
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @AfterSuite
    public void addAttach() {
        addAttachment(Paths.get("log.log"), "Log");
    }
}