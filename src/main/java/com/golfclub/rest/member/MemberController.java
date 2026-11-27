package com.golfclub.rest.member;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/members")
@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public Member saveMember(@RequestBody Member member) {
        return memberService.addMember(member);
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return memberService.findMemberById(id);
    }

    @GetMapping(value = "/search", params = "fullName")
    public List<Member> getMembersByName(@RequestParam("fullName") String fullName) {
        return memberService.findMembersByName(fullName);
    }

    @GetMapping(value = "/search", params = "membershipType")
    public List<Member> getMembersByMembershipType(@RequestParam("membershipType") String membershipType) {
        return memberService.findMembersByMembershipType(membershipType);
    }

    @GetMapping(value = "/search", params = "phoneNumber")
    public List<Member> getMembersByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber) {
        return memberService.findMembersByPhoneNumber(phoneNumber);
    }

    @GetMapping(value = "/search", params = "tournamentStartDate")
    public List<Member> getMembersByTournamentStartDate(@RequestParam("tournamentStartDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate tournamentStartDate) {
        return memberService.findMembersByTournamentStartDate(tournamentStartDate);
    }
}
