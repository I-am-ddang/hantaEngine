package com.ddang_.hantaengine.guis

import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder

//인벤토리 홀더를 이용해 GUI 를 특정하기 위한 추상 클래스입니다.

abstract class CustomGUIHolder: InventoryHolder {
    override fun getInventory(): Inventory? {
        return null
    }

    abstract fun process(e: InventoryClickEvent)

    abstract fun process(e: InventoryCloseEvent)

}