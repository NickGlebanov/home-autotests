package ru.raiffeisen.homeautotests.market.elements

import ru.raiffeisen.homeautotests.core.base.BaseElementsFactory
import org.springframework.stereotype.Component


@Component
class MarketElementsFactory : BaseElementsFactory() {

    fun filter(filterName: String): Filter {
        return Filter(name = filterName)
    }

    fun sort(allureName: String, sortName: String): SortLink {
        return SortLink(allureName, sortName)
    }

}