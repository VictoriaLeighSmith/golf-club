package com.golfclub.rest.member;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return memberService.findMemberById(id);
    }
}
