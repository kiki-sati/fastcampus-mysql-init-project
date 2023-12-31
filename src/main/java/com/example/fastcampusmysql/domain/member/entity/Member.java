package com.example.fastcampusmysql.domain.member.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.util.Assert;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Member {
	private final Long id;
	private String nickname;
	private final String email;
	private final LocalDate birthDay;
	private final LocalDateTime createdAt;

	private static final Long NAME_MAX_LENGTH = 10L;

	@Builder
	public Member(Long id, String nickname, String email, LocalDate birthDay, LocalDateTime createdAt) {
		this.id = id;
		this.email = Objects.requireNonNull(email);
		this.birthDay = Objects.requireNonNull(birthDay);

		validateNickname(nickname);
		this.nickname = Objects.requireNonNull(nickname);

		this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
	}

	void validateNickname(String nickname) {
		Assert.isTrue(nickname.length() <= NAME_MAX_LENGTH, "최대 길이를 초과했습니다.");
	}
}
