package com.golfclub.rest.member;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    public Member findMemberById(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found."));
    }

    public List<Member> findMembersByName(String fullName) {
        return memberRepository.findByFullNameIgnoreCase(fullName);
    }

    public List<Member> findMembersByMembershipType(String membershipType) {
        return memberRepository.findByMembershipTypeIgnoreCase(membershipType);
    }

    public List<Member> findMembersByPhoneNumber(String phoneNumber) {
        return memberRepository.findMemberByPhoneNumber(phoneNumber);
    }

    public List<Member> findMembersByTournamentStartDate(LocalDate startDate) {
        return memberRepository.findDistinctMembersByTournamentsStartDate(startDate);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
}
