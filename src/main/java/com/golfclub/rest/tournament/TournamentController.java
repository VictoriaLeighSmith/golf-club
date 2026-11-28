package com.golfclub.rest.tournament;

import com.golfclub.rest.member.Member;
import com.golfclub.rest.member.MemberService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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

    @GetMapping(value = "/search", params = "startDate")
    public List<Tournament> getTournamentByStartDate(@RequestParam("startDate") LocalDate startDate) {
        return tournamentService.findTournamentByStartDate(startDate);
    }

    @GetMapping(value = "/search", params = "location")
    public List<Tournament> getTournamentByLocation(@RequestParam("location") String location) {
        return tournamentService.findTournamentByLocation(location);
    }

    @GetMapping
    public List<Tournament> getAllTournaments() {
        return tournamentService.findAllTournaments();
    }
}
