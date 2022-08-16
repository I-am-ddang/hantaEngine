package com.ddang_.hantaengine.utils

import org.bukkit.Material
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

class ItemUtil {
    companion object {
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