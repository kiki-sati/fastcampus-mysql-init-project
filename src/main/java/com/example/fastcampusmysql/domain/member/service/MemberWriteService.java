package com.example.fastcampusmysql.domain.member.service;

import org.springframework.stereotype.Service;

import com.example.fastcampusmysql.domain.member.dto.RegisterMemberCommand;
import com.example.fastcampusmysql.domain.member.entity.Member;
import com.example.fastcampusmysql.domain.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberWriteService {

	private final MemberRepository memberRepository;

	// 초기부터 reade와 write를 구분해서 작업하기 -> 나중에 가면 서로 기능이 달라진다.
	public Member register(RegisterMemberCommand command) {
/*
   목표 - 회원정보(이메일,닉네임, 생년월일)을 등록한다.
   	    - 닉네임은 10자를 넘길 수 없다.
   파라미터 - memberRegisterCommand
   val member - Member.of(memberRegisterCommand)
   memberRepository.save()
 */

		var member = Member.builder()
			.nickname(command.nickname())
			.email(command.email())
			.birthDay(command.birthDay())
			.build();

		return memberRepository.save(member);
	}

}
