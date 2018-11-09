package pageObject;

import org.openqa.selenium.WebElement;

public abstract class BaseReproducedSection {
	protected WebElement rootElement;
	
	public BaseReproducedSection(WebElement rootElement) {
		this.rootElement = rootElement;
	}

}
