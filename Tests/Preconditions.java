package sm.uitest.test;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.uiautomator.UiDevice;

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
import sm.uitest.pom.POMSelectAddressPopup;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class Preconditions extends ITest {

    public Preconditions(UiDevice mDevice){
        this.mDevice = mDevice;
    }

    //* Первый вход, выбор адреса доставки по умолчанию  */
    public void firstEnterConfirmAddress() {
        POMSelectAddressPopup POMSelectAddressPopup = new POMSelectAddressPopup(mDevice);
        POMSelectAddressPopup.buttonDenyUsingAppIdClick();
        POMSelectAddressPopup.buttonConfirmAdressIdClick();
    }

    //* Первый вход и авторизация  */
    public void enterAndAthorizedUser() {
        firstEnterConfirmAddress();

        POMCatalogPage POMCatalogPage = new POMCatalogPage(mDevice);
        POMProfilePage POMProfilePage = new POMProfilePage(mDevice);
        POMAthorizePage POMAthorizePage = new POMAthorizePage(mDevice);

        POMCatalogPage.buttonProfileIdClick();
        POMProfilePage.buttonAthorizeIdClick();
        POMAthorizePage.fieldEnterPhoneIdSetText();
        POMAthorizePage.buttonGetCodeIdIdClick();
        POMAthorizePage.fieldEnterSmsCodeIdSetText();
        POMAthorizePage.buttonAcceptCodeIdClick();
    }

    //* Добавление первого товара в списке и вход в корзину  */
    public void succesEnterToCart() {
        firstEnterConfirmAddress();

        POMCatalogPage POMCatalogPage = new POMCatalogPage(mDevice);
        POMCatalogPage.buttonWantProductIdClick();
        POMCatalogPage.buttonCartIdClick();
    }

    //* Вход в корзину и добавка товаров до бесплатной доставки */
    public void succesEnterToCartAddProductToFreeDelivery() {
        succesEnterToCart();

        POMCartPage POMCartPage = new POMCartPage(mDevice);
        DefaultData defaultData = new DefaultData();
        double minPrice = defaultData.minPriceForFreeDelivery;
        double priceProduct = POMCartPage.textAllProductsPriceIdGetDouble();

        while (minPrice > priceProduct) {
            POMCartPage.buttonWantProductPlusIdClick();
            priceProduct = POMCartPage.textAllProductsPriceIdGetDouble();
        }
    }

    //* Вход на страницу оформления заказа с товарами для беплатной доставки */
    public void succesEnterToCheckoutPage() {
        succesEnterToCartAddProductToFreeDelivery();
        POMCartPage POMCartPage = new POMCartPage(mDevice);
        POMCartPage.buttonGoToCheckoutPageIdClick();
    }

    //* Вход на страницу оплаты заказа (тип -доставка) */
    public void succesEnterToPaymentPage() {
        succesEnterToCheckoutPage();

        POMCheckoutPage POMCheckoutPage = new POMCheckoutPage(mDevice);
        POMCheckoutPage.fieldUserNameIdSetText();
        POMCheckoutPage.fieldUserPhoneIdSetText();
        POMCheckoutPage.fieldCommentIdSetText();
        POMCheckoutPage.buttonGoToPaymentPageIdClick();

    }

    }


