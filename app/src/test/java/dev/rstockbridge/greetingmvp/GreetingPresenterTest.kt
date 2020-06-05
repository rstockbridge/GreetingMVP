package dev.rstockbridge.greetingmvp

import dev.rstockbridge.greetingmvp.model.GreetingModel
import dev.rstockbridge.greetingmvp.presenter.GreetingPresenter
import dev.rstockbridge.greetingmvp.view.GreetingView
import io.mockk.mockk
import io.mockk.verify
import io.mockk.verifySequence
import org.junit.Test

class GreetingPresenterTest {
    @Test
    fun `One button click shows 2nd message`() {
        // arrange
        val view = mockk<GreetingView>(relaxed = true)
        val model = GreetingModel()
        val presenter = GreetingPresenter(view, model)

        // act
        presenter.onButtonClicked()

        // assert
        verify { view.showMessage(model.getMessage(1)) }
    }

    @Test
    fun `Two button clicks finishes on 3rd message`() {
        // arrange
        val view = mockk<GreetingView>(relaxed = true)
        val model = GreetingModel()
        val presenter = GreetingPresenter(view, model)

        // act
        presenter.onButtonClicked()
        presenter.onButtonClicked()

        // assert
        verifySequence {
            view.showMessage(model.getMessage(1))
            view.showMessage(model.getMessage(2))
        }
    }

    @Test
    fun `Three button clicks finishes on 4th message`() {
        // arrange
        val view = mockk<GreetingView>(relaxed = true)
        val model = GreetingModel()
        val presenter = GreetingPresenter(view, model)

        // act
        presenter.onButtonClicked()
        presenter.onButtonClicked()
        presenter.onButtonClicked()

        // assert
        verifySequence {
            view.showMessage(model.getMessage(1))
            view.showMessage(model.getMessage(2))
            view.showMessage(model.getMessage(3))
        }
    }
}
