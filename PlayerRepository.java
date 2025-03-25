package com.league.league_zone.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {
    //finds a player in repository by name and delets it
    void deleteByName(String playername);
    //allows us to find player by name using option where player might not be found
    Optional<Player> findByName(String name);
}
