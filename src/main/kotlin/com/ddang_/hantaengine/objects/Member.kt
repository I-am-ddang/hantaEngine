package com.ddang_.hantaengine.objects

import com.ddang_.hantaengine.managers.MemberManager

//플레이어 관련 필드를 담아두는 객체입니다.

class Member {

    init {
        //멤버 객체가 초기화될 때 멤버 매니저의 전체 멤버 리스트에 넣어줍니다.
        MemberManager.memberList.add(this)
    }
}