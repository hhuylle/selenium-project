package com.cydeo.tests.sunday_reviews.week4;

import com.cydeo.tests.Utilities.BrowserUtils;
import com.cydeo.tests.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Guru99UploadTest {

    @Test
    public void guru99_upload_test(){

        //// TC: Guru99 Upload Test
        //  //1. Go to  “https://demo.guru99.com/test/upload”
        Driver.getDriver().get("https://demo.guru99.com/test/upload");

        //  //2. Upload file into Choose File
        String path = "C:\\Users\\hhuyl\\OneDrive\\Desktop\\some-file.txt";

        WebElement chooseFileUpload = Driver.getDriver().findElement(By.id("uploadfile_0"));
        chooseFileUpload.sendKeys(path);

        //  //3. Click terms of service check box
        Driver.getDriver().findElement(By.id("terms")).click();


        //  //4. Click Submit File button
        Driver.getDriver().findElement(By.id("submitbutton")).click();

        //  //5. Verify expected message appeared.
        //  // Expected: "1 file
        //   has been successfully uploaded.
        WebElement resultMsg = Driver.getDriver().findElement(By.xpath("//center[.='1 file has been successfully uploaded.']"));

        //String expectedMsg = "1 file\nhas been successfully uploaded.";
        //String actualMsg = resultMsg.getText();

        BrowserUtils.sleep(2);
        Assert.assertTrue(resultMsg.getText().equals("1 file\nhas been successfully uploaded."));

    }
}
