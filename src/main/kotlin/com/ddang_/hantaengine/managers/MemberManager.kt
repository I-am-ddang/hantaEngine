package com.ddang_.hantaengine.managers

import com.ddang_.hantaengine.Hantaengine
import com.ddang_.hantaengine.objects.Member
import com.ddang_.hantaengine.objects.box.CooldownBox
import com.ddang_.hantaengine.objects.box.LocationBox
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.entity.Player
import java.io.File

//Member 클래스를 다루는 매니저 클래스입니다.

class MemberManager {
    companion object {

        //Member 객체가 초기화되면 담길 전체 멤버 목록입니다.
        val memberList = arrayListOf<Member>()

        //memberList 에서 원하는 멤버를 찾습니다.
        fun getMember(name: String) = memberList.find { it.name == name }

        //디스크 (yml) 에서 플레이어의 데이터를 읽고 와 Member 객체를 생성합니다.
        fun set(p: Player) {

            val file = File(
                Hantaengine.instance.dataFolder,
                "${File.separator}PlayerData${File.separator}${p.uniqueId}.yml"
            )
            val userData = YamlConfiguration.loadConfiguration(file)

            val healCooldown = userData.getLong("CooldownBox.Heal")

            Member(
                p.name,

                CooldownBox(
                    healCooldown
                ),
                LocationBox()
            )

        }

        //멤버 객체에서 플레이어의 데이터를 뽑아 디스크 (yml) 에 집어넣습니다.
        fun remove(p: Player) {

            val m = getMember(p.name) ?: return

            val file = File(
                Hantaengine.instance.dataFolder,
                "${File.separator}PlayerData${File.separator}${p.uniqueId}.yml"
            )
            val userData = YamlConfiguration.loadConfiguration(file)

            val healCooldown = m.cooldownBox.heal

            userData["CooldownBox.Heal"] = healCooldown

            userData.save(file)

            memberList.remove(m)
        }
    }
}