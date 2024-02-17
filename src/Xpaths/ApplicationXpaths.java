package Xpaths;

public class ApplicationXpaths {

	//credentialas
	public final String Email = "alihammad@yopmail.com";
	public final String Password = "hammad@123";
	//public final String loginPassword = null;
	
	
	public final String appURL = "D:\\Appium\\omni.apk";
	public final String alreadyHaveAccountButton = "//*[contains(@text, 'I ALREADY HAVE AN ACCOUNT')]";
	
	//xpaths for login page 
	public final String loginEmail = "//*[contains(@text, 'Email')]";
	public final String loginPassword = "//*[contains(@text, 'Password')]";
	public final String loginButton = "//*[contains(@text, 'LOGIN')]";
	
	
	public final String getTextVerifyDashboard = "//*[contains(@text, 'Welcome to the Disease Classification App!')]";
	
	
	//xpaths for diabetes page
	public final String diabetesButton = "//android.view.ViewGroup[@content-desc=\"DIABETES\"]/android.view.ViewGroup/android.view.View";
	public final String pregnanciesTextField = "//android.widget.EditText[@text='Pregnancies']";
	public final String glucoseTextField = "//android.widget.EditText[@text='Glucose']";
	public final String bloodPressureTextField = "//android.widget.EditText[@text='BloodPressure']";
	public final String skinThicknessTextField = "//android.widget.EditText[@text='SkinThickness']";
	public final String InsulinTextField = "//android.widget.EditText[@text='Insulin']";
	public final String bmiTextField = "//android.widget.EditText[@text='BMI']";
	public final String diabetesPedigreeFunctionTextField = "//android.widget.EditText[@text='DiabetesPedigreeFunction']";
	public final String ageTextField = "//android.widget.EditText[@text=\"Age\"]";
	public final String diabetesSubmitButton = "//android.view.ViewGroup[@content-desc='SUBMIT']";
	
	
	public final String resultPopup = "//android.widget.TextView[@text='Result']";
	
	//android.widget.TextView[@text="Result"]
	

	

	
	
	
	
}
