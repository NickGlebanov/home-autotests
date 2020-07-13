package ru.raiffeisen.homeautotests.core.hooks

import com.codeborne.selenide.WebDriverRunner
import ru.raiffeisen.homeautotests.core.context.ThreadContext
import io.cucumber.java.After
import io.cucumber.java.Before
import io.qameta.allure.Allure
import org.springframework.beans.factory.annotation.Autowired

class CucumberHooks {

    @Autowired
    private lateinit var threadContext: ThreadContext

    @Before
    fun beforeScenario() {
        threadContext.refreshThreadContext()
        threadContext.getBrowserMobService().start()
    }

    @After
    fun afterScenario() {
        //threadContext.getBrowserMobService().getHar().log.entries.forEach {
        //    Allure.addAttachment("request", "${it.request.method} ${it.request.url}")
        //    Allure.addAttachment("response", "${it.response.status}")
        //}
        threadContext.getBrowserMobService().stop()
        WebDriverRunner.closeWebDriver()
    }

}