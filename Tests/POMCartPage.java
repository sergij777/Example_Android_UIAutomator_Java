package sm.uitest.pom;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.BySelector;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;
import androidx.test.uiautomator.Until;
import androidx.test.uiautomator.UiSelector;

import java.util.LinkedList;
import java.util.List;

import sm.uitest.lib.DefaultData;
import sm.uitest.lib.UsefulActions;

import static sm.uitest.test.TestAppLauncher.fullResId;

public class POMCartPage extends IPom {
    private UiDevice mDevice;


    //** Количество товара на кнопке ХОЧУ */
    private static final String buttonWantProductCountId = "tv_cart_regular_count";

    //** Кнопка МИНУС на кнопке ХОЧУ */
    private static final String buttonWantProductMinusId = "iv_cart_regular_item_remove";

    //** Кнопка ПЛЮС на кнопке ХОЧУ */
    private static final String buttonWantProductPlusId = "iv_cart_regular_item_add";

    //** Количество товара на иконке корзина */
    private static final String buttonCartCountId = "tv_badge_count";

    //** Название товара в списке товаров */
    private static final String textProductTitleId = "tv_cart_regular_item_title";

    //** Кнопка МЕНЮ */
    private static final String buttonMenuId = "menu_catalog";

    //** Кнопка ПРОФИЛЬ */
    private static final String buttonProfileId = "menu_account";

    //** Кнопка АКЦИИ */
    private static final String buttonActionsId = "menu_bonus";

    //** Текст Акции на кнопке Акции */
    private static final String buttonActionsIdTextChildClass = "android.widget.TextView";

    //** Название дополнительного товара в списке товаров в корзине */
    private static final String textDopProductTitleId = "tv_cart_payed_addons_item_title";

    //** Кнопка ХОЧУ дополнительного товара */
    private static final String buttonWantDopProductId = "iv_payed_addons_cart";

    //** Количество на кнопке ХОЧУ дополнительного товара */
    private static final String buttonWantDopProductCountId = "tv_payed_addons_count";

    //** Кнопка В Каталог после очистки корзины */
    private static final String buttonGoToCatalogId = "b_check_go_to_catalog";

    //** Текст цены всех товаров в блоке рассчета */
    private static final String textAllProductsPriceId = "tv_check_price_items";

    //** Текст в блоке информации о бесплатной доставке */
    private static final String textDeliveryInformationId = "tv_cart_free_delivery_text";

    //** Текст цены товара  */
    private static final String textProductPriceId = "tv_cart_regular_item_price";

    //** Кнопка перехода на страницу оформления заказа */
    private static final String buttonGoToCheckoutPageId = "btn_check_go_to_order";


    public POMCartPage(UiDevice mDevice) {
        super(mDevice);
        this.mDevice = mDevice;
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

    //** Клик кнопку ХОЧУ дополнительного товара */
    public void buttonWantDopProductIdClick() {
        Click(buttonWantDopProductId);
    }

    //** Возвращает количество товара на кнопке ХОЧУ дополнительного товара */
    public String buttonWantDopProductCountIdGetText() {
        return GetText(buttonWantDopProductCountId);
    }

    //** Возвращает название кнопки "В каталог" в пустой корзине  */
    public String buttonGoToCatalogIdGetText() {
        return GetText(buttonGoToCatalogId);
    }

    //** Клик кнопку МЕНЮ */
    public void buttonMenuIdClick() {
        Click(buttonMenuId);
    }

    //** Возвращает текст в блоке информации о бесплатной доставке */
    public String textDeliveryInformationIdGetText() {
        return GetText(textDeliveryInformationId);
    }

    //** Возвращает цену всех товаров из блока рассчёта */
    public double textAllProductsPriceIdGetDouble() {
        DefaultData defaultData = new DefaultData();
        ScrollToText(defaultData.priceAllProducts);
        String text = GetText(textAllProductsPriceId);
        UsefulActions use = new UsefulActions();
        return use.convertStringToDouble(text);
    }

    //** Возвращает суму цен всех товаров в корзине  */
    public double allProductPriceIdGetDouble()  {
        UsefulActions actions = new UsefulActions();
        double sumPrices = 0;
        Pause(5);
        List<String> listString = GetListText(textProductPriceId);
        for (String item:listString
             ) {
            double pr = actions.convertStringToDouble(item);
            sumPrices += pr;
        }
        return sumPrices;
    }

    //** Клик кнопку перехода на страницу оформления заказа */
    public void buttonGoToCheckoutPageIdClick() {
        Pause(5);
        Click(buttonGoToCheckoutPageId);
    }

    //** Возвращает название кнопки перехода на страницу оформления заказа */
    public String buttonGoToCheckoutPageIdGetText() {
        return GetText(buttonGoToCheckoutPageId);
    }


}
