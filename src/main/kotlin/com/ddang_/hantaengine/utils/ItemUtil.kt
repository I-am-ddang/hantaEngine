package com.ddang_.hantaengine.utils

import org.bukkit.Material
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

//아이템 관련 간단한 메소드를 포함하는 클래스입니다.

class ItemUtil {
    companion object {

        //GUI 에 담기는 커스텀 아이템스텍을 만드는데 주로 사용됩니다.
        fun toItem(name: String, lore: List<String>, material: Material, amount: Int): ItemStack {
            val i = ItemStack(material, amount)
            val meta = i.itemMeta.apply {
                displayName = name
                setLore(lore)
                isUnbreakable = true
                addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE)
            }
            i.itemMeta = meta
            return i
        }
    }
}