package com.github.toy.constructor.selenium.api.widget.drafts;

import com.github.toy.constructor.selenium.api.widget.Clickable;
import com.github.toy.constructor.selenium.api.widget.Name;
import com.github.toy.constructor.selenium.api.widget.Widget;
import org.openqa.selenium.WebElement;

@Name("Button")
public abstract class Button extends Widget implements Clickable {

    public Button(WebElement wrappedElement) {
        super(wrappedElement);
    }
}
