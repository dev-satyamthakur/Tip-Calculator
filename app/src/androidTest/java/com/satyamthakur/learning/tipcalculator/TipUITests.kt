package com.satyamthakur.learning.tipcalculator

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.satyamthakur.learning.tipcalculator.ui.theme.TipCalculatorTheme
import org.junit.Rule
import org.junit.Test

class TipUITests {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            TipCalculatorTheme {
                TipTimeLayout()
            }
        }
        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("10")

        composeTestRule.onNodeWithText("Tip Percentage").performTextInput("20")
        composeTestRule.onNodeWithText("Tip Amount: $2.00").assertExists(
            "No node with this text was found."
        )
    }
}