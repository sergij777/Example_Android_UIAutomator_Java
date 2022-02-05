package sm.uitest.test;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import sm.uitest.lib.DefaultData;
import sm.uitest.pom.POMAthorizePage;
import sm.uitest.pom.POMCartPage;
import sm.uitest.pom.POMCatalogPage;
import sm.uitest.pom.POMCheckoutPage;
import sm.uitest.pom.POMProfilePage;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class P11_C22131 extends ITest {

    @Test
    public void succesAthorizedUser() {
        // Успешная авторизация пользователя, проверка номера телефона на странице профиля

        //Arrange
        Preconditions preconditions = new Preconditions(mDevice);
        preconditions.firstEnterConfirmAddress();
        
        POMCatalogPage POMCatalogPage = new POMCatalogPage(mDevice);
        POMProfilePage POMProfilePage = new POMProfilePage(mDevice);
        POMAthorizePage POMAthorizePage = new POMAthorizePage(mDevice);

        DefaultData defaultData = new DefaultData();
        String expected = defaultData.textUserPhoneChecking;

        //Act
        POMCatalogPage.buttonProfileIdClick();
        POMProfilePage.buttonAthorizeIdClick();
        POMAthorizePage.fieldEnterPhoneIdSetText();
        POMAthorizePage.buttonGetCodeIdIdClick();
        POMAthorizePage.fieldEnterSmsCodeIdSetText();
        POMAthorizePage.buttonAcceptCodeIdClick();

        //Actual
        String actual = POMProfilePage.textAthoriezedUserPhoneGetText();

        //Assert
        Assert.assertEquals("После авторизации ожидаемый номер телефона "+ expected +" а на странице профиля отображается - "+ actual, expected, actual);

    }



    @BeforeClass
    public static void TestCLassInitialization() {
        testRailCaseID = "22131";
        BeforeClassInit();
    }


}