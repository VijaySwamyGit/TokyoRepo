//PACKAGE
package com.tokiyo.project.TestScripts;
//******************************************************************

//Imported packages
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tokiyo.project.PAGES.HomePage;
import com.tokiyo.project.TESTBASE.TestBase;
import com.tokiyo.project.UTIL.ReadFromDataProvider;

//****************************************************************************

//TEST CASES
public class OrderItemTestCase extends TestBase {
	
	//INSTANCE VARIABLES
	HomePage homePage;
	String FilePath = "E:\\TokyoProject\\TokiyoProject\\src\\main\\java\\com\\tokiyo\\project\\TESTDATA\\TokyoTestDataUsingDP.xlsx";
	String SheetName = "MailPayment";
			
	//CONSTRUCTOR
	public OrderItemTestCase()
	{
		PageFactory.initElements(driver, this);
	}
	
	//******************************************************************************
	//DATA PROVIDER FROM EXCEL
	@DataProvider(name="getTestDataFromExcel")
	public String[][] getTestData() throws Exception
	{  
		 System.out.println("Before data provider reading---------------");
		 String [][] testObjArray = ReadFromDataProvider.getTableArray(FilePath,SheetName);
		 System.out.println("after data provider reading---------------testObjArray--"+testObjArray);

		 return (testObjArray);
		 
	}
	//*********************************************************************
	
	//********************************************************************
	//DATA PROVIDER USING BELOW METHOD
	@DataProvider(name="getTestDataFromBelowMethod")
	public static Object[][] myDataProvider() {
		return new Object[][] { { "suchjapan@gmail.com", "Test@12345","7894561238" ,"123" },
				{ "suchjapan@gmail.com", "Test@12345","7894561238", "456"  }};
		 
	}
	//******************************************
	@Test(dataProvider="getTestDataFromExcel")
	public void orderItemUsingmailPayment(String mailId, String passWord,String phoneNumber, String cvv, String xpathOfProdCategory,String xpathOfProd, String temp)
	{
		
		System.out.println(" mailId----- - "+mailId + " "+ " passWord ----- "+passWord + "cvv----"+cvv);
		homePage=new HomePage();
		homePage.orderItemUsingmailPayment(mailId, passWord, phoneNumber,cvv,xpathOfProdCategory,xpathOfProd,temp);
	}
	//***************************************************************
	
}
