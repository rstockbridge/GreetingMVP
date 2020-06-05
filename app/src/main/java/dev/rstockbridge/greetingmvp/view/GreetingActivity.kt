package dev.rstockbridge.greetingmvp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.rstockbridge.greetingmvp.databinding.ActivityMainBinding
import dev.rstockbridge.greetingmvp.model.GreetingModel
import dev.rstockbridge.greetingmvp.presenter.GreetingPresenter

// This activity is not rotation safe
class GreetingActivity : AppCompatActivity(), GreetingView {
    private lateinit var binding: ActivityMainBinding

    private val model = GreetingModel()
    private lateinit var presenter: GreetingPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener { presenter.onButtonClicked() }

        presenter = GreetingPresenter(this, model)
        presenter.onCreate()
    }

    override fun showMessage(text: String) {
        binding.label.text = text
    }
}
