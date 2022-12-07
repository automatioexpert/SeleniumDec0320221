package Page;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CaribFarm_Post_Page extends PageObjectManager {

    private String emailBox = "community.farmer.caribfarm:id/username";
    private String passwordBox = "community.farmer.caribfarm:id/password";
    private String logIn = "community.farmer.caribfarm:id/login_button";
    private String profileImage = "(//android.widget.ImageView)[2]";
    private String date_time = "(//android.widget.TextView)[3]";
    private String post_text = "(//android.widget.TextView)[4]";
    private String post_image = "(//android.widget.ImageView)[3]";
    private String like_button = "community.farmer.caribfarm:id/likeIv";
    private String like_count = "community.farmer.caribfarm:id/likeCountTv";
    private String comment_button = "community.farmer.caribfarm:id/commentIv";
    private String comment_Box = "community.farmer.caribfarm:id/commentEt";
    private String comment_send_button = "community.farmer.caribfarm:id/sendBtn";
    private String act_comments = "community.farmer.caribfarm:id/commentTv";
    private String comment_count = "community.farmer.caribfarm:id/commentCountTv";
    private String share_button = "community.farmer.caribfarm:id/shareIv";
    private String share_count = "community.farmer.caribfarm:id/shareCountTv";


    public CaribFarm_Post_Page(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        isElementDisplayed("id", emailBox);
        SendKeysToInputField("id", emailBox, email);
    }

    public void enterPassword(String password) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        isElementDisplayed("id", passwordBox);
        SendKeysToInputField("id", passwordBox, password);
    }

    public void clickLogIn() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getElement("id", logIn).isEnabled();
        clickElement("id", logIn);
    }

    public void profileImage() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        isElementDisplayed("xpath", profileImage);
    }

    public void dateTime() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        isElementDisplayed("xpath", date_time);
        System.out.println(getTextString("xpath", date_time));
    }

    public void postText() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        isElementDisplayed("xpath", post_text);
    }

    public void postImage() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        isElementDisplayed("xpath", post_image);
    }

    public void clickLike() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        isElementDisplayed("id", like_button);
        clickElement("id", like_button);
        Thread.sleep(2000);
    }

    public void likeCount() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        isElementDisplayed("id", like_count);
        System.out.println(getTextString("id", like_count));
    }

    public void doComment(String comment) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        isElementDisplayed("id", comment_button);
        clickElement("id", comment_button);
        isElementDisplayed("id", comment_Box);
        SendKeysToInputField("id", comment_Box, comment);
        isElementDisplayed("id", comment_send_button);
        Assert.assertTrue(getElement("id", comment_send_button).isEnabled());
        clickElement("id", comment_send_button);

        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(100000)"));
        Thread.sleep(2000);

        List<MobileElement> Elements = getListOfElements("id", act_comments);
        for (int i=1; i< Elements.size(); i++){
            //System.out.println("value of element "+ Elements.get(i).getText());
            if (Elements.get(i).getText().equals(comment)){
                System.out.println(Elements.get(i).getText());
                break;
            }
        }
    }

    public void commentCount() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().back();
        isElementDisplayed("id", comment_count);
        System.out.println(getTextString("id", comment_count));
    }

    public void clickShare() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        isElementDisplayed("id", share_button);
        clickElement("id", share_button);
        driver.navigate().back();
    }

    public void shareCount(){
        isElementDisplayed("id", share_count);
        System.out.println(getTextString("id", share_count));
    }
}



