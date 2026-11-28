package com.golfclub.rest.tournament;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {

    List<Tournament> findTournamentsByStartDate(LocalDate startDate);

    List<Tournament> findTournamentsByLocation(String location);
}
