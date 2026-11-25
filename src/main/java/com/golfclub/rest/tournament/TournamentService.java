package com.golfclub.rest.tournament;

import com.golfclub.rest.member.Member;
import com.golfclub.rest.member.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TournamentService {

    private final TournamentRepository tournamentRepository;
    private final MemberRepository memberRepository;

    public TournamentService(TournamentRepository tournamentRepository, MemberRepository memberRepository) {
        this.tournamentRepository = tournamentRepository;
        this.memberRepository = memberRepository;
    }

    public Tournament addTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public Tournament findTournamentById(Long id) {
        return tournamentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tournament not found."));
    }

    public Member registerMember(Long tournamentID, Long memberID) {
        Tournament tournament = findTournamentById(tournamentID);
        Member member = memberRepository.findById(memberID).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found."));

        tournament.getMembers().add(member);
        tournamentRepository.save(tournament);

        return member;
    }
}
