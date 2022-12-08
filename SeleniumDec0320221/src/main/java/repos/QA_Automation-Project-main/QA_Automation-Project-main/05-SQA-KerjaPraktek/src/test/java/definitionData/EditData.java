package definitionData;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditData {
	WebDriver driver;
	String agent;
	String status;

	@Given("User login with username {string} and password {string}")
	public void user_login_with_username_and_password(String string, String string2) {
		String path = System.getenv("WEBDRIVER");
		System.setProperty("webdriver.chrome.driver", path);
		this.driver = new ChromeDriver();
		driver.get("https://sqa.peluangkerjaku.com/tele/");
		driver.findElement(By.id("tl_login-1-51550_text")).sendKeys(string);
		driver.findElement(By.id("tl_login-1-51551_text")).sendKeys(string2);
		driver.findElement(By.xpath("//span[normalize-space()='Sign In']")).click();
	}

	@When("User get login msg {string}")
	public void user_get_login_msg(String string) {
		try {
			Thread.sleep(1000);
			WebElement welcomeText = driver.findElement(By.xpath("//*[@id=\"nikita-form-dialog\"]/p"));
			System.out.println("Welcome validation => " + welcomeText.getText());
			Assert.assertEquals(welcomeText.getText(), string);
		} catch (Exception e) {

		}

	}

	@When("User click ok to the validate msg")
	public void user_click_ok_to_the_validate_msg() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[normalize-space()='OK']")).click();

		} catch (Exception e) {
			System.out.println("1" + e);
		}

	}

	@When("User move to table_Data")
	public void user_move_to_table_Data() {
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//h3[@id='ui-id-11']")).click();
		} catch (Exception e) {
			System.out.println("2" + e);
		}
	}

	@When("User move to table Edit Data")
	public void user_move_to_table_Edit_Data() {
		Boolean state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//span[normalize-space()='Edit Data']")).click();
				state = false;
			} catch (Exception e) {
				System.out.println("3" + e);
			}
		}
	}

	@When("User select the {string}")
	public void user_select_the_data(String string) {

		switch (string) {
		case "earliest data":
			Boolean state = true;
			while (state) {
				try {
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id=\"tl_edit_data--52536_table\"]/tbody/tr[1]")).click();
					state = false;
				} catch (Exception e) {
					System.out.println("5" + e);
				}
			}
			break;
		case "data from the latest table":
			state = true;
			while (state) {
				try {
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id=\"tl_edit_data--52536\"]/div[9]/ul/li[8]/a")).click();
					state = false;
				} catch (Exception e) {
					System.out.println("5" + e);
				}
			}

			state = true;
			while (state) {
				try {
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id=\"tl_edit_data--52536_table\"]/tbody/tr[1]")).click();
					state = false;
				} catch (Exception e) {
					System.out.println("5" + e);
				}
			}
			break;

		}

	}


	@When("User update or edit the data")
	public void user_update_or_edit_the_data() {
		// mengubah nama agent
		Boolean state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				// *[@id="tl_edit_user_activity-12-52807_text"]/option[5]
				WebElement agent = driver
						.findElement(By.xpath("//*[@id=\"tl_edit_user_activity-12-52807_text\"]/option[5]"));
				agent.click();
				System.out.println("agent dalam kotak yang dipilih " + agent.getText());
				this.agent = agent.getText();
				state = false;
			} catch (Exception e) {
				System.out.println("6" + e);
			}
		}

		// mengubah status activity
		state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//select[@id='tl_edit_user_activity-12-52786_text']")).click();
				// *[@id="tl_edit_user_activity-12-52786_text"]/option[2]
				WebElement status = driver
						.findElement(By.xpath("//*[@id=\"tl_edit_user_activity-12-52786_text\"]/option[2]"));
				status.click();
				System.out.println("status dalam kotak yang dipilih " + status.getText());
				this.status = status.getText();
				state = false;
			} catch (Exception e) {
				System.out.println("6" + e);
			}
		}
	}

	@When("User confirm or click update button")
	public void user_confirm_or_click_update_button() {
		Boolean state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//span[normalize-space()='UPDATE']")).click();
				state = false;
			} catch (Exception e) {
				System.out.println("8" + e);
			}
		}
		state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				WebElement updtMsg = driver.findElement(By.xpath("//*[@id=\"nikita-form-dialog\"]/p"));
				System.out.println(updtMsg.getText());
				driver.findElement(By.xpath("//span[normalize-space()='OK']")).click();
				state = false;
			} catch (Exception e) {
				System.out.println("7" + e);
			}
		}
	}

	@Then("User see data changed successfully")
	public void user_see_data_changed_successfully() {
		Boolean state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				WebElement agentAct = driver.findElement(By.xpath("//td[@id='tl_edit_data--52536-cell-0-10']"));
				System.out.println("agent yang dilihat setelah di update " + agentAct.getText());
				WebElement statusAct = driver.findElement(By.xpath("//*[@id=\"tl_edit_data--52536-cell-0-9\"]"));
				System.out.println("status acivity yang dilihat setelah di update " + statusAct.getText());
				Assert.assertEquals(agent, agentAct.getText());
				Assert.assertEquals(status, statusAct.getText());
				driver.close();
				state = false;
			} catch (Exception e) {
				System.out.println("9" + e);
			}
		}
	}


	@When("User not confirm or click close button")
	public void user_not_confirm_or_click_close_button() {
		// agent
		Boolean state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				WebElement agent = driver
						.findElement(By.xpath("//*[@id=\"tl_edit_user_activity-12-52807_text\"]/option[4]"));
				System.out.println("agent dalam kotak yang tidak jadi dipilih " + agent.getText());
				this.agent = agent.getText();
				state = false;
			} catch (Exception e) {
				System.out.println("6" + e);
			}
		}
		// status
		state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//select[@id='tl_edit_user_activity-12-52786_text']")).click();
				// *[@id="tl_edit_user_activity-12-52786_text"]/option[2]
				// *[@id="tl_edit_user_activity-12-52786_text"]/option[12]
				WebElement status = driver
						.findElement(By.xpath("//*[@id=\"tl_edit_user_activity-12-52786_text\"]/option[12]"));
				status.click();
				System.out.println("status dalam kotak yang tidak dipilih " + status.getText());
				this.status = status.getText();
				state = false;
			} catch (Exception e) {
				System.out.println("6" + e);
			}
		}

		// close button
		state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//span[@class='ui-button-icon-primary ui-icon ui-icon-close']")).click();
				state = false;
			} catch (Exception e) {
				System.out.println("8" + e);
			}
		}
	}

	@Then("User see data not changed")
	public void user_see_data_not_changed() {
		Boolean state = true;
		while (state) {
			try {
				Thread.sleep(1000);
				WebElement agentAct = driver.findElement(By.xpath("//td[@id='tl_edit_data--52536-cell-0-10']"));
				System.out.println("agent yang dilihat pada tabel " + agentAct.getText());
				WebElement statusAct = driver.findElement(By.xpath("//*[@id=\"tl_edit_data--52536-cell-0-9\"]"));
				System.out.println("status acivity yang dilihat setelah di update " + statusAct.getText());
				Assert.assertNotEquals(agent, agentAct.getText());
				Assert.assertNotEquals(status, statusAct.getText());
				driver.close();
				state = false;
			} catch (Exception e) {
				System.out.println("9" + e);
			}
		}
	}

}
