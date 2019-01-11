package module1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageFactory {

	
	@FindBy(name="log") 
	WebElement username;
	
	@FindBy(how=How.XPATH, using="//*[@id='user_pass']")
	@CacheLookup
	WebElement password;
	
	@FindBy(how=How.LINK_TEXT, using="Lost your password?")
	@CacheLookup
	WebElement lostPassword;
	
	@FindBy(id="wp-submit") 
	WebElement submit_button;
	
	@FindBy (how=How.LINK_TEXT, using="Posts")
	WebElement posts;
	
	@FindBy (how=How.XPATH,using="//*[@id='menu-posts']//a[text()='Add New']")
	WebElement addPost;
	
	public void  pageLogin(String userid, String pass)
	{
		username.sendKeys(userid);
		password.sendKeys(pass);
		submit_button.click();
	}
	
	
	
	
}
