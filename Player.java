package com.league.league_zone.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//maps player to database
@Entity
//gets our info from postgres table
@Table(name="league_data")
public class Player {

    @Id
    @Column(name = "name", unique = true)
    private String name;

    private String region;

    private String pos;

    private Integer Wins;

    private Integer Loses;

    private Double winRate;

    private Double KDA;

    private Double Kills;

    private Double Deaths;

    private Double Assists;

    private Double firstBloodPercentage;

    private Double firstTurretPercentage;

    private Double DmgPM;

    private Double GoldPM;

    private Double CsPM;

    private Double Wards;

    private String team;

    public Player() {
    }

    public Player(String name, String region, String pos, Integer wins, Integer loses, Double winRate, Double KDA, Double kills, Double deaths, Double assists, Double firstBloodPercentage, Double firstTurretPercentage, Double dmgPM, Double goldPM, Double csPM, Double wards, String team) {
        this.name = name;
        this.region = region;
        this.pos = pos;
        Wins = wins;
        Loses = loses;
        this.winRate = winRate;
        this.KDA = KDA;
        Kills = kills;
        Deaths = deaths;
        Assists = assists;
        this.firstBloodPercentage = firstBloodPercentage;
        this.firstTurretPercentage = firstTurretPercentage;
        DmgPM = dmgPM;
        GoldPM = goldPM;
        CsPM = csPM;
        Wards = wards;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        pos = pos;
    }

    public Integer getWins() {
        return Wins;
    }

    public void setWins(Integer wins) {
        Wins = wins;
    }

    public Integer getLoses() {
        return Loses;
    }

    public void setLoses(Integer loses) {
        Loses = loses;
    }

    public Double getWinRate() {
        return winRate;
    }

    public void setWinRate(Double winRate) {
        this.winRate = winRate;
    }

    public Double getKDA() {
        return KDA;
    }

    public void setKDA(Double KDA) {
        this.KDA = KDA;
    }

    public Double getKills() {
        return Kills;
    }

    public void setKills(Double kills) {
        Kills = kills;
    }

    public Double getDeaths() {
        return Deaths;
    }

    public void setDeaths(Double deaths) {
        Deaths = deaths;
    }

    public Double getAssists() {
        return Assists;
    }

    public void setAssists(Double assists) {
        Assists = assists;
    }

    public Double getFirstBloodPercentage() {
        return firstBloodPercentage;
    }

    public void setFirstBloodPercentage(Double firstBloodPercentage) {
        this.firstBloodPercentage = firstBloodPercentage;
    }

    public Double getFirstTurretPercentage() {
        return firstTurretPercentage;
    }

    public void setFirstTurretPercentage(Double firstTurretPercentage) {
        this.firstTurretPercentage = firstTurretPercentage;
    }

    public Double getDmgPM() {
        return DmgPM;
    }

    public void setDmgPM(Double dmgPM) {
        DmgPM = dmgPM;
    }

    public Double getGoldPM() {
        return GoldPM;
    }

    public void setGoldPM(Double goldPM) {
        GoldPM = goldPM;
    }

    public Double getCsPM() {
        return CsPM;
    }

    public void setCsPM(Double csPM) {
        CsPM = csPM;
    }

    public Double getWards() {
        return Wards;
    }

    public void setWards(Double wards) {
        Wards = wards;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
