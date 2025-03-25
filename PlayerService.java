package com.league.league_zone.player;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

//marks class as compenet and should be managed by spring container
@Component
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
    //Method to get all players
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }
    // Method to get all player by team
    public List<Player> getPlayersFromTeam(String team) {
        return playerRepository.findAll().stream()
                .filter(player -> Objects.equals(team, player.getTeam()))
                .collect(Collectors.toList());
    }
    //Method to get player by name
    public List<Player> getPlayersByName(String searchText){
        return playerRepository.findAll().stream()
                .filter(player -> player.getName().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByPosition(String searchText){
        return playerRepository.findAll().stream()
                .filter(player -> player.getPos().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByRegion(String searchText){
        return playerRepository.findAll().stream()
                .filter(player -> player.getRegion().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByTeamAndPosition(String team, String position){
        return playerRepository.findAll().stream()
                .filter(player -> team.equals(player.getTeam())  && position.equals(player.getPos()))
                .collect(Collectors.toList());
    }
    // function to add player to repository
    public Player addPlayer(Player player) {
        playerRepository.save(player);
        return player;
    }

    public Player updatePlayer(Player updatedPlayer) {
        Optional<Player> existingPlayer = playerRepository.findByName(updatedPlayer.getName());
        //checks to see if player already exits in database
        if (existingPlayer.isPresent()) {
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setName(updatedPlayer.getName());
            playerToUpdate.setPos(updatedPlayer.getPos());
            playerToUpdate.setRegion(updatedPlayer.getRegion());
            playerToUpdate.setTeam(updatedPlayer.getTeam());

            playerRepository.save(playerToUpdate);
            return playerToUpdate;
        }
        // If player is not found return null
        return null;
    }
    //ensures data integreity is maintained
    @Transactional
    public void deletePlayer(String playerName) {
        playerRepository.deleteByName(playerName);
    }
}
