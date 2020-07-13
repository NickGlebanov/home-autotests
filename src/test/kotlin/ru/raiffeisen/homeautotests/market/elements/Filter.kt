package ru.raiffeisen.homeautotests.market.elements

import com.codeborne.selenide.SelenideElement
import ru.raiffeisen.homeautotests.core.base.BaseElementsFactory
import ru.raiffeisen.homeautotests.core.base.UiElement

class Filter(name: String) : UiElement {

    private val baseXpath = "//div[@class='search-layout']//*[text()='$name']/.."

    fun numberFieldFrom(): SelenideElement {
        return BaseElementsFactory.SX("$baseXpath//input[contains(@id,'from')]")
    }

    fun numberFieldTo(): SelenideElement {
        return BaseElementsFactory.SX("$baseXpath//input[contains(@id,'to')]")
    }

    fun radio(text: String): SelenideElement {
        return BaseElementsFactory.SX("$baseXpath//span[text()='$text']/..")
    }

    fun checkbox(text: String): SelenideElement {
        return BaseElementsFactory.SX("$baseXpath//span[text()='$text']/..")
    }

    fun color(text: String): SelenideElement {
        return BaseElementsFactory.SX("$baseXpath//span[text()='$text']/..")
    }
}