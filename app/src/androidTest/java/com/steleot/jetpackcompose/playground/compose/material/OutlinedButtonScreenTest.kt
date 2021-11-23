package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.steleot.jetpackcompose.playground.MainActivity
import com.steleot.jetpackcompose.playground.compose.theme.TestTheme
import org.junit.Rule
import org.junit.Test

class OutlinedButtonScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testNavigationRailScreen() {
        composeTestRule.setContent {
            TestTheme {
                OutlinedButtonScreen()
            }
        }
        // todo
    }
}