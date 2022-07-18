package forms;

import org.openqa.selenium.By;
import selen.base.BaseForm;
import selen.base.elements.Button;
import selen.base.elements.TextField;
import selen.waits.TypeWait;

public class MyMediaLibForm extends BaseForm {

    private Button deleteTrackBtn = new Button(By.xpath("//div[@class='HcMOFLaukKJdK5LfdHh0']//button[@role='switch']"), "add or delete track in user media lib");

    public MyMediaLibForm() {
        super(new TextField(By.xpath("//div[@class='contentSpacing']"), "User media lib", TypeWait.PRESENCE_OF_ELEMENT_LOCATED));
    }

    public void deleteTrack() {
        deleteTrackBtn.click();
    }
}
