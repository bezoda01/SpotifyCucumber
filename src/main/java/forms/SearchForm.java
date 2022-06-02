package forms;

import base.driver.BaseForm;
import base.elements.TextField;
import org.openqa.selenium.By;

public class SearchForm extends BaseForm {

    private final TextField searchInput = new TextField(By.xpath("//input[@data-testid]"), "input field");
    private TextField currentTrack = null;
    final String addButtonForm = "//*[contains(text(),'%s')]//ancestor::div[@data-testid = 'tracklist-row']//button[@role]";
    final String correctTrackForm = "//*[contains(text(),'%s')]//ancestor::div[@data-testid = 'tracklist-row']";

    public SearchForm() {
        super(new TextField(By.xpath("//div[@class = 'iKwGKEfAfW7Rkx2_Ba4E Z4InHgCs2uhk0MU93y_a BtbiwMynlB4flsYu_hA2']"), "Search page"), "Search page");
    }

    public void search(String text) {
        searchInput.sendText(text);
    }

    public void playTrack(String trackName) {
        new TextField(By.xpath("//a[@title = '" + trackName + "']"), "Track").focusOnElement();
        currentTrack = new TextField(By.xpath("//a[@title = '" + trackName + "']//ancestor::div[@draggable]//button"), "play button");
        currentTrack.clickBtn();
    }

    public void addToLib(String track) {
        new TextField(By.xpath(String.format(correctTrackForm, track)), "track form").focusOnElement();
        new TextField(By.xpath(String.format(addButtonForm, track)), "Button add to lib").clickBtn();
    }
}
