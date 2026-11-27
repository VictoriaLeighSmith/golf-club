package com.golfclub.rest.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByFullNameIgnoreCase(String fullName);

    List<Member> findByMembershipTypeIgnoreCase(String membershipType);

    List<Member> findMemberByPhoneNumber(String phoneNumber);

    List<Member> findDistinctMembersByTournamentsStartDate(LocalDate startDate);
}
