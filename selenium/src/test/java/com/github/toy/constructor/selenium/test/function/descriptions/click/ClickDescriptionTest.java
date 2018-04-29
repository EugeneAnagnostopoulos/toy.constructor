package com.github.toy.constructor.selenium.test.function.descriptions.click;

import com.github.toy.constructor.selenium.api.widget.Clickable;
import com.github.toy.constructor.selenium.api.widget.Name;
import com.github.toy.constructor.selenium.api.widget.Widget;
import com.github.toy.constructor.selenium.test.function.descriptions.DescribedWebElement;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

import static com.github.toy.constructor.selenium.functions.click.ClickActionSupplier.on;
import static com.github.toy.constructor.selenium.functions.searching.CommonConditions.shouldBeEnabled;
import static com.github.toy.constructor.selenium.functions.searching.CommonConditions.shouldBeVisible;
import static com.github.toy.constructor.selenium.functions.searching.CommonConditions.shouldHaveAttributeContains;
import static com.github.toy.constructor.selenium.functions.searching.SearchSupplier.button;
import static com.github.toy.constructor.selenium.functions.searching.SearchSupplier.link;
import static com.github.toy.constructor.selenium.functions.searching.SearchSupplier.webElement;
import static com.github.toy.constructor.selenium.functions.searching.SequentialSearchSupplier.element;
import static java.time.Duration.ofSeconds;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class ClickDescriptionTest {

    @Test
    public void clickWithSearchingForSomeClickable() {
        assertThat(on(element(button("Some button", ofSeconds(7),
                shouldBeVisible().and(shouldHaveAttributeContains("some attr", Pattern.compile("some pattern")))))
                .foundFrom(webElement(xpath(".//some/xpath"), ofSeconds(5), shouldBeEnabled())))

                .andOn(element(link())).get().toString(),
                is("Click on A single item from (Web elements located By.xpath: .//some/xpath) on condition " +
                        "Should be enabled. Time to get valuable result: 0:00:05:000 ->\n" +
                        " A single item from (Elements of type Button) on condition " +
                        "(Should have string label(s) [Some button]) AND ((Should be visible) AND (Should have attribute 'some attr' which matches regExp pattern 'some pattern')). Time to get valuable result: 0:00:07:000 ->\n" +
                        "  Click on A single item from (Elements of type Link) on condition with no other restriction. " +
                        "Time to get valuable result: 0:01:00:000"));
    }

    @Test
    public void clickWithSearchingForSomeWebElement() {
        assertThat(on(element(webElement(xpath(".//some/xpath"), ofSeconds(5), shouldBeEnabled()))
                        .foundFrom(webElement(className("someClass"))))

                        .andOn(element(webElement(id("someId")))).get().toString(),

                is("Click on A single item from (Web elements located By.className: someClass) on condition with no other restriction. " +
                        "Time to get valuable result: 0:01:00:000 ->\n" +
                        " A single item from (Web elements located By.xpath: .//some/xpath) on condition Should be enabled. " +
                        "Time to get valuable result: 0:00:05:000 ->\n" +
                        "  Click on A single item from (Web elements located By.id: someId) on condition with no other restriction. " +
                        "Time to get valuable result: 0:01:00:000"));
    }

    @Test
    public void clickOnSomeClickable() {
        assertThat(on(new SomeStubClickableWidget(new DescribedWebElement()))
                        .andOn(new SomeStubClickableWidget(new DescribedWebElement())).get().toString(),
                is("Click on Some clickable widget ->\n" +
                        " Click on Some clickable widget"));
    }

    @Test
    public void clickOnSomeWebElement() {
        assertThat(on(new DescribedWebElement())
                        .andOn(new DescribedWebElement()).get().toString(),
                is("Click on Test web element ->\n" +
                        " Click on Test web element"));
    }


    @Name("Some clickable widget")
    private static class SomeStubClickableWidget extends Widget implements Clickable {

        SomeStubClickableWidget(WebElement wrappedElement) {
            super(wrappedElement);
        }

        @Override
        public void click() {
            getWrappedElement().click();
        }

        public String toString() {
            return "Some clickable widget";
        }
    }
}