package com.ddang_.hantaengine.managers

import com.ddang_.hantaengine.objects.Member

//Member 클래스를 다루는 매니저 클래스입니다.

class MemberManager {
    companion object {

        //Member 객체가 초기화되면 담길 전체 멤버 목록입니다.
        val memberList = arrayListOf<Member>()
    }
}