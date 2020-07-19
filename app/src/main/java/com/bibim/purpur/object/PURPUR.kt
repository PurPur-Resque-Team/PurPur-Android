package com.bibim.purpur.`object`

import com.bibim.purpur.R

object PURPUR {

    var USER_TOKEN = ""

    val ANIMAL_SMALL_HEAD = listOf(
        R.drawable.img_gauge_rabbit_head,
        R.drawable.img_gauge_bear_head,
        R.drawable.img_gauge_fox_head,
        R.drawable.img_gauge_mole_head,
        R.drawable.img_gauge_plant_head,
        R.drawable.img_gauge_duck_head
    )

    val ANIMAL_DESC = listOf(
        listOf(
            R.drawable.img_rabbit_one,
            R.drawable.img_rabbit_two,
            R.drawable.img_rabbit_three,
            R.drawable.img_rabbit_clear
        ),
        listOf(
            R.drawable.img_bear_one,
            R.drawable.img_bear_two,
            R.drawable.img_bear_three,
            R.drawable.img_bear_clear
        ),
        listOf(
            R.drawable.img_fox_one,
            R.drawable.img_fox_two,
            R.drawable.img_fox_three,
            R.drawable.img_fox_clear
        ),
        listOf(
            R.drawable.img_mole_one,
            R.drawable.img_mole_two,
            R.drawable.img_mole_three,
            R.drawable.img_mole_clear
        ),
        listOf(
            R.drawable.img_plant_one,
            R.drawable.img_plant_one,
            R.drawable.img_plant_three,
            R.drawable.img_plant_clear
        ),
        listOf(
            R.drawable.img_duck_one,
            R.drawable.img_duck_two,
            R.drawable.img_duck_three,
            R.drawable.img_duck_clear
        )
    )

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

    val ANIMAL_STATE_LIST = listOf(
        listOf(
            R.drawable.btn_rabbit_one,
            R.drawable.btn_rabbit_two,
            R.drawable.btn_rabbit_three,
            R.drawable.btn_rabbit
        ),
        listOf(
            R.drawable.btn_bear_one,
            R.drawable.btn_bear_two,
            R.drawable.btn_bear_three,
            R.drawable.btn_bear
        ),
        listOf(
            R.drawable.btn_fox_one,
            R.drawable.btn_fox_two,
            R.drawable.btn_fox_three,
            R.drawable.btn_fox
        ),
        listOf(
            R.drawable.btn_mole_one,
            R.drawable.btn_mole_two,
            R.drawable.btn_mole_three,
            R.drawable.btn_mole
        ),
        listOf(
            R.drawable.btn_duck_one,
            R.drawable.btn_duck_two,
            R.drawable.btn_duck_three,
            R.drawable.btn_duck
        ),
        listOf(
            R.drawable.btn_plant_one,
            R.drawable.btn_plant_two,
            R.drawable.btn_plant_three,
            R.drawable.btn_plant
        )
    )

    val Island_STATE_LIST = listOf(
        R.drawable.img_bg_island_one,
        R.drawable.img_bg_island_two,
        R.drawable.img_bg_island
    )

    val IslandBg_STATE_LIST = listOf(
        R.drawable.img_bg_one,
        R.drawable.img_bg_two,
        R.drawable.img_bg
    )
}

