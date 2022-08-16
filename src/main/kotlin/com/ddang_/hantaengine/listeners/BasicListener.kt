package com.ddang_.hantaengine.listeners

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockExpEvent
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.event.entity.ExpBottleEvent
import org.bukkit.event.entity.ItemSpawnEvent
import org.bukkit.event.inventory.CraftItemEvent
import org.bukkit.event.player.PlayerFishEvent

//게임의 기본적인 작동방식을 갖출 리스너 클래스입니다.

class BasicListener: Listener {

    //플레이어가 추가로 경험치를 얻지 못하도록 제거합니다.
    @EventHandler
    fun onBlockExp(e: BlockExpEvent){
        e.expToDrop = 0
    }

    //플레이어가 추가로 경험치를 얻지 못하도록 제거합니다.
    @EventHandler
    fun onEntityDeath(e: EntityDeathEvent){
        e.droppedExp = 0
    }

    //플레이어가 추가로 경험치를 얻지 못하도록 제거합니다.
    @EventHandler
    fun onExpBottle(e: ExpBottleEvent){
        e.experience = 0
    }

    //플레이어가 추가로 경험치를 얻지 못하도록 제거합니다.
    @EventHandler
    fun onFish(e: PlayerFishEvent){
        e.expToDrop = 0
    }

    //플레이어가 조합을 하지 못하도록 설정합니다.
    @EventHandler
    fun onCraft(e: CraftItemEvent) {
        e.isCancelled = true
    }

    //아이템이 스폰될 때 아이템의 이름을 보이게 합니다.
    @EventHandler
    fun onItemSpawn(e: ItemSpawnEvent) {
        val item = e.entity
        item.isCustomNameVisible = true
    }

}