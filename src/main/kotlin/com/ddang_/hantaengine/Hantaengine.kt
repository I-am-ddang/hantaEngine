package com.ddang_.hantaengine

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.ProtocolLibrary
import com.comphenix.protocol.ProtocolManager
import com.comphenix.protocol.events.ListenerPriority
import com.comphenix.protocol.events.PacketAdapter
import com.comphenix.protocol.events.PacketEvent
import com.comphenix.protocol.wrappers.EnumWrappers
import com.ddang_.hantaengine.listeners.BasicListener
import org.bukkit.Bukkit
import org.bukkit.Sound
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

    //제거할 상위버전 소리를 담은 set 변수입니다.
    private val soundLimit = setOf(
        Sound.ENTITY_PLAYER_ATTACK_KNOCKBACK,
        Sound.ENTITY_PLAYER_ATTACK_SWEEP,
        Sound.ENTITY_PLAYER_ATTACK_NODAMAGE,
        Sound.ENTITY_PLAYER_ATTACK_WEAK,
        Sound.ENTITY_PLAYER_ATTACK_STRONG, Sound.ENTITY_PLAYER_ATTACK_CRIT)

    //프로토콜립을 이용해 소리와 이펙트를 지웁니다.
    private fun setEffectAndSound() {
        protocolManager.addPacketListener(
            object : PacketAdapter(this, ListenerPriority.NORMAL, PacketType.Play.Server.NAMED_SOUND_EFFECT, PacketType.Play.Server.WORLD_PARTICLES) {
                override fun onPacketSending(event: PacketEvent?) {
                    if (event?.packetType === PacketType.Play.Server.WORLD_PARTICLES) {
                        val effect = event?.packet?.particles?.read(0)
                        if (effect == EnumWrappers.Particle.SWEEP_ATTACK) {
                            event.isCancelled = true
                        }
                    } else {
                        val sound = event?.packet?.soundEffects?.read(0)
                        if (soundLimit.contains(sound)) {
                            event?.isCancelled = true
                        }
                    }
                }
            }
        )
    }

    //이벤트 리스너 목록입니다.
    private val events = arrayOf(

        BasicListener()

    )

    override fun onEnable() {

        //인스턴스 변수를 잡습니다.
        players = server.onlinePlayers
        instance = this
        scheduler = server.scheduler
        protocolManager = ProtocolLibrary.getProtocolManager()

        //이벤트 리스너를 서버에 등록합니다.
        server.pluginManager.apply {
            events.forEach {
                registerEvents(it, this@Hantaengine)
            }
        }

        setEffectAndSound()

    }

    override fun onDisable() {

    }

}