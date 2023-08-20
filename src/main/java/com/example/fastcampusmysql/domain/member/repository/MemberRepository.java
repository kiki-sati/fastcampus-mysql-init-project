package com.example.fastcampusmysql.domain.member.repository;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.fastcampusmysql.domain.member.entity.Member;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class MemberRepository {
	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private static final String TABLE = "member";

	public Optional<Member> findById(Long id) {
		/*
			select * from Member where id = id
		 */

		var sql = String.format("SELECT * FROM %s WHERE id = :id", TABLE);
		var param = new MapSqlParameterSource()
			.addValue("id", id);

		RowMapper<Member> rowMapper = (ResultSet resultSet, int rowNum) -> Member
			.builder()
			.id(resultSet.getLong("id"))
			.email(resultSet.getString("email"))
			.nickname(resultSet.getString("nickname"))
			.birthDay(resultSet.getObject("birthday", LocalDate.class))
			.createdAt(resultSet.getObject("createdAt", LocalDateTime.class))
			.build();
		var member = namedParameterJdbcTemplate.queryForObject(sql, param, rowMapper);
		return Optional.ofNullable(member);
	}

	public Member save(Member member) {
		/**
		 * member의 id를 보고 갱신 또는 삽입을 정함.
		 * 반환값은 id를 담아서 반환한다.
		 */

		return null;
	}

}