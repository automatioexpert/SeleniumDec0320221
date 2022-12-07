package Test;
import Base.Base;
import Page.CaribFarm_Post_Page;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

public class CaribFarm_Post_Test extends Base{
    Base base = new Base();
    CaribFarm_Post_Page post;

    public CaribFarm_Post_Test() throws MalformedURLException {
        base.setDriver();
        post = new CaribFarm_Post_Page(Base.driver);
    }

    @Test(priority = 1)
    public void verifyLogin() throws MalformedURLException, InterruptedException {
        post.enterEmail("mehew76780@xegge.com");
        post.enterPassword("1@2#3$4%");
        post.clickLogIn();
    }

    @Test(priority = 2)
    public void verifyProfileImage() throws InterruptedException {
        post.profileImage();
    }

    @Test(priority = 3)
    public void verifyPostDateTime() throws InterruptedException {
        post.dateTime();
    }

    @Test(priority = 4)
    public void verifyPostText() throws InterruptedException {
        post.postText();
    }

    @Test(priority = 5)
    public void verifyPostImage() throws InterruptedException {
        post.postImage();
    }

    @Test(priority = 6)
    public void verifyLikeIcon() throws InterruptedException {
        post.clickLike();
    }

    @Test(priority = 7)
    public void verifyLikeCount() throws InterruptedException {
        post.likeCount();
    }

    @Test(priority = 8)
    public void verifyComment() throws InterruptedException {
        post.doComment("Farming is a good work");
    }

    @Test(priority = 9)
    public void verifyCommentCount() throws InterruptedException {
        post.commentCount();
    }

    @Test(priority = 10)
    public void verifyShareIcon() throws InterruptedException {
        post.clickShare();
    }

    @Test(priority = 11)
    public void verifyShareCount() throws InterruptedException {
        post.shareCount();
    }
}




