package com.dow.cmcompose.presentation.navigation

import com.dow.cmcompose.R

enum class BottomMenus(val label: String, val route: String, val icon: Int, val selectedIcon: Int) {
    HOME(
        "home",
        "home",
        R.drawable.outline_home_24,
        R.drawable.baseline_home_24
    ),
    FREE(
        "free",
        "free",
        R.drawable.outline_card_gift_24,
        R.drawable.twotone_card_gift_24
    ),
    HISTORY(
        "history",
        "history",
        R.drawable.outline_fact_check_24,
        R.drawable.twotone_fact_check_24
    ),
    MY(
        "my",
        "my",
        R.drawable.outline_person_24,
        R.drawable.baseline_person_24
    )

}