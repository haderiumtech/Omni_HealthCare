package Pages;

import org.testng.annotations.BeforeTest;

import Base.BaseClass;

public class OmniTestClass {

	BaseClass base = new BaseClass();
	
	@BeforeTest
	public void startChrome() 
	{
		
		base.sendKeys(home.LFEmailFieldLocator, home.LFEmailValue);
		base.sendKeys(home.LFPasswordFIeldLocator, home.LFPasswordValue);
		base.forClick(home.LFLoginButtonLocator);
		
	}
	
}
