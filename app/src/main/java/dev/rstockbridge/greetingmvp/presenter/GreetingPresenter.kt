package dev.rstockbridge.greetingmvp.presenter

import dev.rstockbridge.greetingmvp.model.GreetingModel
import dev.rstockbridge.greetingmvp.view.GreetingView

class GreetingPresenter(private val view: GreetingView, private val model: GreetingModel) {
    private var clickCount = 0

    fun onCreate() {
        view.showMessage(model.getMessage(clickCount))
    }

    fun onButtonClicked() {
        clickCount++
        view.showMessage(model.getMessage(clickCount))
    }
}
