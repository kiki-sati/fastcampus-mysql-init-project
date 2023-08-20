package com.example.fastcampusmysql.domain.member.dto;

import java.time.LocalDate;

public record RegisterMemberCommand(
// 게터세터를 자동으로 만들어줌 -> 자바 14부터 생김 , 단순히 데이터만 담고있다. 
	String email,
	String nickname,
	LocalDate birthDay
) {
}
