package com.golfclub.rest.tournament;

import com.golfclub.rest.member.Member;
import com.golfclub.rest.member.MemberService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/tournaments")
@RestController
public class TournamentController {

    private final TournamentService tournamentService;
    private final MemberService memberService;

    public TournamentController(TournamentService tournamentService, MemberService memberService) {
        this.tournamentService = tournamentService;
        this.memberService = memberService;
    }

    @PostMapping
    public Tournament saveTournament(@RequestBody Tournament tournament) {
        return tournamentService.addTournament(tournament);
    }

    @GetMapping("/{id}")
    public Tournament getTournament(@PathVariable Long id) {
        return tournamentService.findTournamentById(id);
    }

    @PostMapping("/{tournamentID}/members/{memberID}")
    public Member registerMember(@PathVariable Long tournamentID, @PathVariable Long memberID) {
        return tournamentService.registerMember(tournamentID, memberID);
    }
}
