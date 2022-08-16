package com.ddang_.hantaengine

import com.comphenix.protocol.ProtocolManager
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitScheduler

class Hantaengine : JavaPlugin() {
    companion object{

        //버킷에 정보를 띄우기 위한 리시버입니다.
        fun String.info() = Bukkit.getLogger().info(this)

        //버킷에 경고를 띄우기 위한 리시버입니다.
        fun String.warn() = Bukkit.getLogger().warning(this)

        //서버 전체 메시지 출력을 위한 리시버입니다.
        fun String.broad() = Bukkit.broadcastMessage(this)

        //Long 틱마다 반복을 위한 리시버입니다.
        fun Long.rt(delay: Long = 1, run: Runnable) = scheduler.runTaskTimer(instance, run, delay, this)

        //Long 틱 뒤에 작동을 위한 리시버입니다.
        fun Long.rl(run: Runnable) = scheduler.runTaskLater(instance, run, this)


        //인스턴스 변수 모음
        lateinit var instance: Plugin
        lateinit var scheduler: BukkitScheduler
            private set
        lateinit var players: MutableCollection<out Player>
            private set
        lateinit var protocolManager: ProtocolManager
            private set
    }


}