package sm.uitest.pom;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.BySelector;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;
import androidx.test.uiautomator.Until;

import java.util.List;

import sm.integration.uitest.BuildConfig;

import static sm.uitest.test.TestAppLauncher.fullResId;

public class POMCatalogPage extends IPom {
    private UiDevice mDevice;

    /** Текст в строке выбранного адреса */
    private static final String textSelectedAddressId = "tv_catalog_selected_address";

    //** Кнопка ХОЧУ */
    private static final String buttonWantProductId = "tv_category_product_want";

    //** Количество товара на кнопке ХОЧУ */
    private static final String buttonWantProductCountId = "tv_category_product_count";

    //** Кнопка МИНУС на кнопке ХОЧУ */
    private static final String buttonWantProductMinusId = "iv_category_product_minus";

    //** Кнопка ПЛЮС на кнопке ХОЧУ */
    private static final String buttonWantProductPlusId = "iv_category_product_plus";

    //** Количество товара на иконке корзина */
    private static final String buttonCartCountId = "tv_badge_count";

    //** Название товара в списке товаров */
    private static final String textProductTitleId = "tv_category_product_name";

    //** Кнопка МЕНЮ */
    private static final String buttonMenuId = "menu_catalog";

    //** Кнопка ПРОФИЛЬ */
    private static final String buttonProfileId = "menu_account";

    //** Кнопка АКЦИИ */
    private static final String buttonActionsId = "menu_bonus";

    //** Текст Акции на кнопке Акции */
    private static final String buttonActionsIdTextChildClass = "android.widget.TextView";

    //** Кнопка КОРЗИНА */
    private static final String buttonCartId = "menu_cart";

    //** Текст Корзина на кнопке Корзина */
    private static final String buttonCartIdTextChildClass = "android.widget.TextView";

    //** Блок со списком категорий */
    private static final String listCatalogTabsId = "catalog_tabs";

    //** Текст названия категории на кнопке категории */
    private static final String buttonCategoryChildClass = "android.widget.TextView";


    public POMCatalogPage(UiDevice mDevice) {
        super(mDevice);
        this.mDevice = mDevice;
    }

    /** Текст в строке выбранного адреса */
    public String textSelectedAddressGetText(){
        return GetText(textSelectedAddressId);
    }

    //** Клик кнопку ХОЧУ */
    public  void buttonWantProductIdClick() {
        String fullId = fullResId(buttonWantProductId);
        BySelector selRes = By.res(fullId);
        this.mDevice.wait(Until.hasObject(selRes),TIMEOUT);

        UiScrollable appView = new UiScrollable(new UiSelector(fullId).scrollable(true));
        appView.scrollIntoView(buttonWantProductId);
        mDevice.findObject(new UiSelector().text(APP_TITLE)).clickAndWaitForNewWindow();

        List<UiObject2> buttons = mDevice.findObjects(selRes);

        int count = buttons.size();
        for (UiObject2 item: buttons
             ) {
            boolean attr = item.isEnabled();
            if(attr) {
                item.click();
                break;
            }
        }

    }

    //** Возвращает количество товара на кнопке ХОЧУ */
    public String buttonWantProductCountIdGetText() {
        return GetText(buttonWantProductCountId);
    }

    //** Возвращает количество товара на иконке корзина */
    public String buttonCartCountIdGetText() {
        return GetText(buttonCartCountId);
    }

    //** Клик кнопку ПЛЮС */
    public void buttonWantProductPlusIdClick() {
        Click(buttonWantProductPlusId);
    }

    //** Клик кнопку МИНУС */
    public void buttonWantProductMinusIdClick() {
        Click(buttonWantProductMinusId);
    }

    //** Клик на текст названия товара */
    public void textProductTitleIdClick() {
        Click(textProductTitleId);
    }

    //** Возвращает название товара в списке */
    public String textProductTitleIdGetText() {
        return GetText(textProductTitleId);
    }

    //** Клик на кнопку Акции */
    public void buttonActionsIdClick() {
        Click(buttonActionsId);
    }

    //** Возвращает название из кнопки Акции */
    public String buttonActionsIdGetText() {
        return GetTextByChild(buttonActionsId, buttonActionsIdTextChildClass);
    }

    //** Клик на кнопку Корзина */
    public void buttonCartIdClick() {
        Click(buttonCartId);
    }

    //** Возвращает название из кнопки Корзина */
    public String buttonCartIdGetText() {
        return GetTextByChild(buttonCartId, buttonCartIdTextChildClass);
    }

    //** Клик на кнопку категории */
    public void buttonCategoryChildClassClick() {
        ClickByChild(listCatalogTabsId, buttonCategoryChildClass);
    }

    //** Возвращает название категории */
    public String buttonCategoryChildClassGetText() {
        return GetTextByChild(listCatalogTabsId, buttonCategoryChildClass);
    }

    //** Клик на кнопку Профиль */
    public void buttonProfileIdClick() {
        Click(buttonProfileId);
    }

}
