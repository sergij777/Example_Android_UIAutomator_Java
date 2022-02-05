package sm.uitest.test;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import sm.uitest.pom.POMCartPage;
import sm.uitest.pom.POMCatalogPage;
import sm.uitest.pom.POMSelectAddressPopup;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class P11_C22018 extends ITest {


    @Test
    public void succesPlusCountProductInCartCheckingCount() {
        // Успешное добавление количества товара в корзине, проверка количества на кнопке ХОЧУ

        //Arrange;
        POMCatalogPage POMCatalogPage = new POMCatalogPage(mDevice);
        POMCartPage POMCartPage = new POMCartPage(mDevice);

        Preconditions preconditions = new Preconditions(mDevice);
        preconditions.firstEnterConfirmAddress();

        POMCatalogPage.buttonWantProductIdClick();
        POMCatalogPage.buttonWantProductPlusIdClick();
        POMCatalogPage.buttonCartIdClick();
        int initial = Integer.parseInt(POMCartPage.buttonWantProductCountIdGetText()); // начальное количество в корзине
        String expected = Integer.toString(initial + 1); // учет добавления товара в корзине +1

        //Act
        POMCartPage.buttonWantProductPlusIdClick();

        //Actual
        String actual = POMCartPage.buttonWantProductCountIdGetText();

        //Assert
        Assert.assertEquals("Начальное количество товара в корзине (и +1)  - "+ expected +" не соответствует конечному количеству в корзине - "+ actual, expected, actual);
    }


    @Test
    public void succesMinusCountProductInCartCheckingCount() {
        // Успешное уменьшение количества товара в корзине, проверка количества на кнопке ХОЧУ

        //Arrange
        POMCatalogPage POMCatalogPage = new POMCatalogPage(mDevice);
        POMCartPage POMCartPage = new POMCartPage(mDevice);

        Preconditions preconditions = new Preconditions(mDevice);
        preconditions.firstEnterConfirmAddress();

        POMCatalogPage.buttonWantProductIdClick();
        POMCatalogPage.buttonWantProductPlusIdClick();
        POMCatalogPage.buttonCartIdClick();
        int initial = Integer.parseInt(POMCartPage.buttonWantProductCountIdGetText()); // начальное количество в корзине
        String expected = Integer.toString(initial - 1); // учет добавления товара в корзине -1

        //Act
        POMCartPage.buttonWantProductMinusIdClick();

        //Actual
        String actual = POMCartPage.buttonWantProductCountIdGetText();

        //Assert
        Assert.assertEquals("Начальное количество товара в корзине (и -1)  - "+ expected +" не соответствует конечному количеству в корзине - "+ actual, expected, actual);
    }


    @BeforeClass
    public static void TestCLassInitialization() {
        testRailCaseID = "22018";
        BeforeClassInit();
    }


}