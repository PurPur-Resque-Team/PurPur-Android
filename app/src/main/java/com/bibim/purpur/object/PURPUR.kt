package com.bibim.purpur.`object`

import com.bibim.purpur.R

object PURPUR {

    val MISSION_IMAGE_LIST = listOf<Int>(
        R.drawable.img_card_recycle,
        R.drawable.img_card_electric,
        R.drawable.img_card_water,
        R.drawable.img_card_food,
        R.drawable.img_card_trash
    )

    val MISSION_CLEAR_QUIZ_NUMBER = listOf<String>(
        "영", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"
    )

    val MISSION_SELECT_LIST = listOf<Mission>(
        Mission(
            "부모님과 함께 분리수거 하기",
            R.drawable.img_mission_recycle,
            R.drawable.bg_mission_background_selected_recycle
        ),
        Mission(
            "집 나갈때 내 방 불끄기",
            R.drawable.img_mission_electric,
            R.drawable.bg_mission_background_selected_electric
        ),
        Mission(
            "양치할 때 물끄기",
            R.drawable.img_mission_water,
            R.drawable.bg_mission_background_selected_water
        ),
        Mission(
            "음식 남기지 않기",
            R.drawable.img_mission_food,
            R.drawable.bg_mission_background_selected_food
        ),
        Mission(
            "길에 쓰레기 버리지 않기",
            R.drawable.img_mission_trash,
            R.drawable.bg_mission_background_selected_trash
        )
    )
}

