package com.league.league_zone.player;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//makes every method returns a domain object instead of a view
@RestController
@RequestMapping(path = "api/players")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getPlayers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String team,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String region) {
        if (team != null && position!= null){
            return playerService.getPlayersByTeamAndPosition(team, position);
        }
        else if(name != null){
            return playerService.getPlayersByName(name);
        }
        else if(region != null){
            return playerService.getPlayersByRegion(region);
        }
        else if(team != null){
            return playerService.getPlayersFromTeam(team);
        }
        else if(position != null){
            return playerService.getPlayersByPosition(position);
        }
        else{
            return playerService.getPlayers();
        }

    }
    //creates a player
    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player createdPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    //updates a player
    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
        Player resultPlayer = playerService.updatePlayer(player);
        if (resultPlayer != null) {
            return new ResponseEntity<>(resultPlayer, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //deletes players by name
    @DeleteMapping("/{playerName}")
    public ResponseEntity<String> deletePlayer(@PathVariable String playerName) {
        playerService.deletePlayer(playerName);
        return new ResponseEntity<>("PLayer deleted successfully",HttpStatus.OK);
    }

}
