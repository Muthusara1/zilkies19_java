package com.zilker.beans;

public class Player {
	String playerName, playerRole,playerLastName;
	int teamId, playerId;

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerName() {
		return this.playerName;
	}
	
	public void setPlayerLastName(String playerLastName) {
		this.playerLastName = playerLastName;
	}

	public String getPlayerLastName() {
		return this.playerLastName;
	}

	public void setPlayerRole(String playerRole) {
		this.playerRole = playerRole;
	}

	public String getPlayerRole() {
		return playerRole;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public int getTeamId() {
		return this.teamId;
	}
}
