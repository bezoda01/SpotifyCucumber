package forms;

import base.driver.BaseForm;
import base.elements.Button;
import base.elements.TextField;
import org.openqa.selenium.By;

public class MyMediaLibForm extends BaseForm {

    private Button deleteTrackBtn = new Button(By.xpath("//div[@class='HcMOFLaukKJdK5LfdHh0']//button[@role='switch']"), "add or delete track in user media lib");

    public MyMediaLibForm() {
        super(new TextField(By.xpath("//div[@class='contentSpacing']"), "User media lib"), "User media lib");
    }

    public void deleteTrack() {
        deleteTrackBtn.clickBtn();
    }
}
