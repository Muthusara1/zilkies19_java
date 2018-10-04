package io.zilker.fantasy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import io.zilker.fantasy.bean.Match;
import io.zilker.fantasy.bean.Player;
import io.zilker.fantasy.bean.User;
import io.zilker.fantasy.constants.SqlConstants;
import io.zilker.fantasy.utility.CustomException;

public class AdminDAO {
	//AdminService adminService = new AdminService();
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	DbConfig dbConfig = new DbConfig();

	public AdminDAO() {
		connection = null;
		preparedStatement = null;
		resultSet = null;
	}

	// checks if the entered values are valid
	public User validateLogin(String userName, String password) {
		User newUser = new User();
		try {
			connection = dbConfig.getConnection();
			preparedStatement = connection.prepareStatement(SqlConstants.LOGIN_SELECT);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				newUser.setUser(resultSet.getString("user_name"), resultSet.getString("email"),
						resultSet.getString("password"), resultSet.getInt("type"));
				newUser.setUserId(resultSet.getInt("user_id"));
			}

		} catch (SQLException e) {
			e.getStackTrace();
		} catch (Exception e) {

			e.getStackTrace();
		} finally {
			dbConfig.closeConnection(connection, preparedStatement, resultSet);
		}
		return newUser;
	}

	public boolean addUser(User newUser) {
		// TODO Auto-generated method stub
		boolean isValid = false;
		try {
			connection = dbConfig.getConnection();
			preparedStatement = connection.prepareStatement(SqlConstants.SIGNUP_INSERT);
			preparedStatement.setString(1, newUser.getUserName());
			preparedStatement.setString(2, newUser.getEmail());
			preparedStatement.setString(3, newUser.getPassword());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			dbConfig.closeConnection(connection, preparedStatement, resultSet);
		}
		return isValid;
	}

	public void setNewMatch(Match newMatch) {
		// TODO Auto-generated method stub
		try {
			connection = dbConfig.getConnection();
			preparedStatement = connection.prepareStatement(SqlConstants.MATCH_INSERT);
			preparedStatement.setString(1, newMatch.getTeamOne());
			preparedStatement.setString(2, newMatch.getTeamTwo());
			preparedStatement.setString(3, newMatch.getScheduledDate());
			preparedStatement.setString(4, newMatch.getStartTime());
			preparedStatement.setString(5, newMatch.getEndTime());
			preparedStatement.setInt(6, newMatch.getMatchCredits());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			new CustomException("Exception Caught");
			e.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			dbConfig.closeConnection(connection, preparedStatement, resultSet);
		}
	}

	// insert into match status table
	public void setNewMatchStatus(Match newMatch) {
		// TODO Auto-generated method stub
		try {
			connection = dbConfig.getConnection();
			preparedStatement = connection.prepareStatement(SqlConstants.MATCH_STATUS_INSERT);
			preparedStatement.setInt(1, newMatch.getMatchId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			dbConfig.closeConnection(connection, preparedStatement, resultSet);
		}

	}

	// gets the id of last inserted match
	public int getLastInsertedMatchId() {
		// TODO Auto-generated method stub
		int lastInsertedId = 0;
		try {
			connection = dbConfig.getConnection();
			preparedStatement = connection.prepareStatement(SqlConstants.SELECT_LAST_INSERTED_ID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				lastInsertedId = resultSet.getInt("match_id");
			}
		} catch (SQLException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			dbConfig.closeConnection(connection, preparedStatement, resultSet);
		}
		return lastInsertedId;
	}

	// list active matches
	public ArrayList<Match> listActiveMatches() {
		// TODO Auto-generated method stub
		ArrayList<Match> matchList = new ArrayList<Match>();
		try {
			connection = dbConfig.getConnection();
			preparedStatement = connection.prepareStatement(SqlConstants.SELECT_ACTIVE_MATCHES);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Match match = new Match();
				match.setMatchTable(resultSet.getString("team1"), resultSet.getString("team2"), "scheduledDate",
						"startTime", "endTime", 0);
				match.setStatusTable(resultSet.getInt("match_status.match_id"), 1, 1);
				// adminService.printMatches(resultSet.getInt("match_status.match_id"),
				// resultSet.getString("team1"),
				// resultSet.getString("team2"));
				// (resultSet.getInt("match_status.match_id"), resultSet.getString("team1"),
				// resultSet.getString("team2"), resultSet.getString("scheduled_date"),
				// resultSet.getString("start_time"), resultSet.getString("end_time"),
				// resultSet.getInt("match_credits"), resultSet.getInt("isactive"),
				// resultSet.getInt("isupcomming"));
				matchList.add(match);
			}
		} catch (SQLException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			dbConfig.closeConnection(connection, preparedStatement, resultSet);
		}
		return matchList;
	}

	// disable an active match
	public void disableParticularMatch(int matchId) {
		// TODO Auto-generated method stub
		try {
			connection = dbConfig.getConnection();
			preparedStatement = connection.prepareStatement(SqlConstants.UPDATE_ACTIVE_MATCH);
			preparedStatement.setInt(1, matchId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			dbConfig.closeConnection(connection, preparedStatement, resultSet);
		}

	}

	// insert into player
	public void setPlayer(Player newPlayer) {
		try {
			connection = dbConfig.getConnection();
			preparedStatement = connection.prepareStatement(SqlConstants.INSERT_INTO_PLAYER);
			preparedStatement.setString(1, newPlayer.getplayerName());
			preparedStatement.setString(2, newPlayer.getplayerType());
			preparedStatement.setLong(3, newPlayer.getplayerRating());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			dbConfig.closeConnection(connection, preparedStatement, resultSet);
		}

	}

	// insert into team table
	public void insertIntoTeam(String teamName) {
		try {
			connection = dbConfig.getConnection();
			preparedStatement = connection.prepareStatement(SqlConstants.INSERT_INTO_TEAM);
			preparedStatement.setString(1, teamName);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			dbConfig.closeConnection(connection, preparedStatement, resultSet);
		}

	}

	// insert into team table
	public int getTeamId(String teamName) {
		int teamId = 0;
		try {
			connection = dbConfig.getConnection();
			preparedStatement = connection.prepareStatement(SqlConstants.SELECT_TEAM_TABLE);
			preparedStatement.setString(1, teamName);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				teamId = resultSet.getInt("team_id");
			}
		} catch (SQLException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			dbConfig.closeConnection(connection, preparedStatement, resultSet);
		}
		return teamId;

	}

	// list the players available
	public ArrayList<Player> listPlayers() {
		ArrayList<Player> playerList = new ArrayList<Player>();
		try {
			connection = dbConfig.getConnection();
			preparedStatement = connection.prepareStatement(SqlConstants.SELECT_PLAYERS);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Player player = new Player();
				player.setPlayer(resultSet.getString("player_name"), "team", resultSet.getString("type"),
						resultSet.getInt("rating"));
				player.setPlayerId(resultSet.getInt("player_id"));
				/*
				 * adminService.printPlayers(resultSet.getInt("player_id"),
				 * resultSet.getString("player_name"), resultSet.getString("type"),
				 * resultSet.getInt("rating"));
				 */
				playerList.add(player);
			}
		} catch (SQLException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			dbConfig.closeConnection(connection, preparedStatement, resultSet);
		}
		return playerList;
	}

	// insert into team and player table
	public void setTeamAndPlayers(int teamId, int playerId) {
		// TODO Auto-generated method stub
		try {
			connection = dbConfig.getConnection();
			preparedStatement = connection.prepareStatement(SqlConstants.INSERT_INTO_TEAM_AND_PLAYER);
			preparedStatement.setInt(1, teamId);
			preparedStatement.setInt(2, playerId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			dbConfig.closeConnection(connection, preparedStatement, resultSet);
		}

	}

	// get last inserted Player Id
	public int getLastPlayerId() {
		// TODO Auto-generated method stub
		int playerId = 0;
		try {
			connection = dbConfig.getConnection();
			preparedStatement = connection.prepareStatement(SqlConstants.SELECT_LAST_PLAYER);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				playerId = resultSet.getInt("player_id");
			}
		} catch (SQLException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			dbConfig.closeConnection(connection, preparedStatement, resultSet);
		}
		return playerId;
	}

	public boolean modifyPlayerRating(int playerId, int modifiedRating) {
		// TODO Auto-generated method stub
		try {
			connection = dbConfig.getConnection();
			preparedStatement = connection.prepareStatement(SqlConstants.UPDATE_PLAYER_RATING);
			preparedStatement.setInt(1, modifiedRating);
			preparedStatement.setInt(2, playerId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		} finally {
			dbConfig.closeConnection(connection, preparedStatement, resultSet);
		}
		return true;
	}

	public ArrayList<Match> displayOngoingMatches() {
		// TODO Auto-generated method stub
		ArrayList<Match> matchList = new ArrayList<Match>();
		try {
			connection = dbConfig.getConnection();
			preparedStatement = connection.prepareStatement(SqlConstants.SELECT_UPCOMMING_MATCHES);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Match match = new Match();
				match.setMatchTable(resultSet.getString("team1"), resultSet.getString("team2"), "scheduledDate",
						"startTime", "endTime", 0);
				/*
				 * adminService.printMatches(resultSet.getInt("match_id"),
				 * resultSet.getString("team1"), resultSet.getString("team2"));
				 */
				match.setStatusTable(resultSet.getInt("match_id"), 0, 1);
				matchList.add(match);
			}
		} catch (SQLException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			dbConfig.closeConnection(connection, preparedStatement, resultSet);
		}
		return matchList;

	}

	// disable upcomming match
	public void disableUpcomingMatch(int matchId) {
		try {
			connection = dbConfig.getConnection();
			preparedStatement = connection.prepareStatement(SqlConstants.DISABLE_UPCOMMING);
			preparedStatement.setInt(1, matchId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			dbConfig.closeConnection(connection, preparedStatement, resultSet);
		}
	}

	public void setPlayingTeam(int matchId, int playerId, int points) {
		// TODO Auto-generated method stub
		try {
			connection = dbConfig.getConnection();
			preparedStatement = connection.prepareStatement(SqlConstants.INSERT_INTO_PLAYING_TEAM);
			preparedStatement.setInt(1, matchId);
			preparedStatement.setInt(2, playerId);
			preparedStatement.setInt(3, points);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			dbConfig.closeConnection(connection, preparedStatement, resultSet);
		}

	}

	public ArrayList<Integer> getUsersOfParticularMatch(int matchId) {
		// TODO Auto-generated method stub
		ArrayList<Integer> users = new ArrayList<Integer>();
		try {
			connection = dbConfig.getConnection();
			preparedStatement = connection.prepareStatement(SqlConstants.SELECT_PARTICULAR_MATCH_USERS);
			preparedStatement.setInt(1, matchId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				users.add(resultSet.getInt("user_id"));
			}
		} catch (SQLException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			dbConfig.closeConnection(connection, preparedStatement, resultSet);
		}
		return users;
	}

	public int getTotalPointsOfUser(int userId, int matchId) {
		// TODO Auto-generated method stub
		int points = 0;
		try {
			connection = dbConfig.getConnection();
			preparedStatement = connection.prepareStatement(SqlConstants.PARTICULAR_USER_TOTAL_POINTS);
			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, matchId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				points = resultSet.getInt("total");
			}
		} catch (SQLException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			dbConfig.closeConnection(connection, preparedStatement, resultSet);
		}
		return points;
	}

	public void setResultBoard(int userId, int matchId, int points) {
		// TODO Auto-generated method stub
		try {
			connection = dbConfig.getConnection();
			preparedStatement = connection.prepareStatement(SqlConstants.INSERT_INTO_RESULT_BOARD);
			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, matchId);
			preparedStatement.setInt(3, points);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			dbConfig.closeConnection(connection, preparedStatement, resultSet);
		}

	}

	public ArrayList<Integer> getTopPicks(int matchId) {
		// TODO Auto-generated method stub
		ArrayList<Integer> players = new ArrayList<Integer>();
		int count = 0;
		try {
			connection = dbConfig.getConnection();
			preparedStatement = connection.prepareStatement(SqlConstants.GET_TOP_PICKS);
			preparedStatement.setInt(1, matchId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next() && count < 3) {
				players.add(resultSet.getInt("player_id"));
				count++;
			}
		} catch (SQLException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			dbConfig.closeConnection(connection, preparedStatement, resultSet);
		}
		return players;
	}

	public void setMostPickedPlayers(int playerId, int matchId) {
		// TODO Auto-generated method stub
		try {
			connection = dbConfig.getConnection();
			preparedStatement = connection.prepareStatement(SqlConstants.INSERT_INTO_MOSTLY_PICKED_PLAYERS);
			preparedStatement.setInt(1, playerId);
			preparedStatement.setInt(2, matchId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			dbConfig.closeConnection(connection, preparedStatement, resultSet);
		}

	}

	public int viewCurrentRating(int playerId) {
		int rating = 0;
		try {
			connection = dbConfig.getConnection();
			preparedStatement = connection.prepareStatement(SqlConstants.SELECT_PLAYER_WITH_ID);
			preparedStatement.setInt(1, playerId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				rating = resultSet.getInt("rating");
			}
		} catch (SQLException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			dbConfig.closeConnection(connection, preparedStatement, resultSet);
		}
		return rating;
	}

	//get team names from DB
	public ArrayList<String> getTeamNames() {
		ArrayList<String> names = new ArrayList<String> ();
		try {
			connection = dbConfig.getConnection();
			preparedStatement = connection.prepareStatement(SqlConstants.SELECT_TEAM_NAMES);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				names.add(resultSet.getString("team_name"));
			}
		} catch (SQLException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			dbConfig.closeConnection(connection, preparedStatement, resultSet);
		}
		return names;
	}

	public ArrayList<String> getPlayerNames() {
		ArrayList<String> names = new ArrayList<String> ();
		try {
			connection = dbConfig.getConnection();
			preparedStatement = connection.prepareStatement(SqlConstants.SELECT_PLAYER_NAMES);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				names.add(resultSet.getString("player_name"));
			}
		} catch (SQLException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			dbConfig.closeConnection(connection, preparedStatement, resultSet);
		}
		return names;
	}

	public ArrayList<String> getPlayerIds() {
		ArrayList<String> names = new ArrayList<String> ();
		try {
			connection = dbConfig.getConnection();
			preparedStatement = connection.prepareStatement(SqlConstants.SELECT_PLAYER_IDS);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				names.add(resultSet.getString("player_id"));
			}
		} catch (SQLException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			dbConfig.closeConnection(connection, preparedStatement, resultSet);
		}
		return names;
	}

}
