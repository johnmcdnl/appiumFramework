package appium.pageObjects.rememberTheDate.nav;

import java.util.List;

import appium.pageObjects.Page;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;

class NavElements extends Page {
	public NavElements() {
		super();
	}

	@AndroidFindBys({ @AndroidFindBy(id = "com.zendesk.rememberthedate:id/decor_content_parent"),
			@AndroidFindBy(className = "android.widget.HorizontalScrollView") })
	protected MobileElement navBar;

	@AndroidFindBys({ @AndroidFindBy(id = "com.zendesk.rememberthedate:id/decor_content_parent"),
		@AndroidFindBy(className = "android.widget.HorizontalScrollView"),
		@AndroidFindBy(className = "android.widget.TextView")
	})
	protected List<MobileElement> navBarOptions;

}
