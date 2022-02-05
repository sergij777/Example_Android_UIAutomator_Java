package sm.uitest.test;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import sm.uitest.lib.DefaultData;
import sm.uitest.pom.POMCheckoutPage;
import sm.uitest.pom.POMPaymentPage;
import sm.uitest.pom.POMSuccesOrderPage;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class P11_C22117 extends ITest {

    @Test
    public void succesChoosingPaymentTypeCash() {
        // Успешный заказ при оплате наличными

        //Arrange
        Preconditions preconditions = new Preconditions(mDevice);
        preconditions.succesEnterToPaymentPage();
        POMPaymentPage POMPaymentPage = new POMPaymentPage(mDevice);
        POMSuccesOrderPage POMSuccesOrderPage = new POMSuccesOrderPage(mDevice);


        DefaultData defaultData = new DefaultData();
        String expected = defaultData.textSuccesOrderNum;

        //Act
        POMPaymentPage.buttonOrderPayIdClick();

        //Actual
        String actual = POMSuccesOrderPage.textSuccesOrderNumIdGetText();

        //Assert
        Assert.assertTrue("На странице созданного заказа строка "+ expected +" не находится в строке с заказом - "+ actual, actual.contains(expected));

    }


    @BeforeClass
    public static void TestCLassInitialization() {
        testRailCaseID = "22117";
        BeforeClassInit();
    }


}