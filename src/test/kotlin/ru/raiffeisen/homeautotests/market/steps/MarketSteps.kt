package ru.raiffeisen.homeautotests.market.steps

import com.codeborne.selenide.Selenide
import ru.raiffeisen.homeautotests.core.ashot.AshotService
import ru.raiffeisen.homeautotests.core.base.BaseSteps
import ru.raiffeisen.homeautotests.core.context.ThreadContext
import ru.raiffeisen.homeautotests.market.elements.MarketElementsFactory
import ru.raiffeisen.homeautotests.market.uipage.MarketNotebooksPage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

class MarketSteps : BaseSteps() {

    @Autowired
    lateinit var marketNotebooksPage: MarketNotebooksPage

    @Autowired
    lateinit var marketelms: MarketElementsFactory

    @Autowired
    private lateinit var context: ThreadContext

    @Autowired
    private lateinit var ashotService: AshotService

    init {

        And("^открываем страницу ноутбуков маркета$") {
            Selenide.open(marketNotebooksPage.url)
            ashotService.hideScrollbar()
            ashotService.takeEtalonScreenshotAndSave("notebooks")
        }

        And("^сортируем ноутбуки по (новизне|отзывам|популярности|размеру скидки|рейтингу|цене)$") { sortRule: String ->
            when (sortRule) {
                "новизне" -> marketNotebooksPage.Sorts().поНовизне.click()
                "отзывам" -> marketNotebooksPage.Sorts().поОтзывам.click()
                "популярности" -> marketNotebooksPage.Sorts().поПопулярности.click()
                "размеру скидки" -> marketNotebooksPage.Sorts().поРазмеруСкидки.click()
                "рейтингу" -> marketNotebooksPage.Sorts().поРейтингу.click()
                "цене" -> marketNotebooksPage.Sorts().поЦене.click()
            }
        }
    }
}