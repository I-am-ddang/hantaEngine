package com.ddang_.hantaengine.managers

import com.ddang_.hantaengine.enums.InventoryName
import org.bukkit.inventory.Inventory

//커스텀 GUI 를 구성하기 위한 매니저 클래스입니다.

class GUIManager {
    companion object {

        //InventoryName 을 구분해 커스텀 GUI 를 반환하는 메소드입니다.
        fun getInventory(name: InventoryName): Inventory? {
            when (name) {
                else -> return null
            }
        }
    }
}