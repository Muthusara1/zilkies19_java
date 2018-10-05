package io.zilker.fantasy.delegate;

import java.util.ArrayList;
import io.zilker.fantasy.bean.Match;
import io.zilker.fantasy.bean.Message;
import io.zilker.fantasy.bean.Player;
import io.zilker.fantasy.bean.ResultBoard;
import io.zilker.fantasy.bean.User;
import io.zilker.fantasy.bean.UserPickedTeam;
import io.zilker.fantasy.constants.DisplayConstants;
import io.zilker.fantasy.dao.AdminDAO;
import io.zilker.fantasy.dao.UserDAO;

public class UserOperations {
	private int choice, playerId, numberOfBatsmen = 0, numberOfBowler = 0, numberOfAllrounder = 0, numberOfKeeper = 0,
			totalCredits, matchId, userId, creditsCompleted = 0, playerCredits, matchCredits, index;
	private boolean isValid = false;
	private String role, message;
	ArrayList<Integer> players = new ArrayList<Integer>();
	ArrayList<Integer> credits = new ArrayList<Integer>();
	UserDAO userDAO = new UserDAO();
	//UserService userService = new UserService();
	Match match = new Match();
	ResultBoard resultBoard = new ResultBoard();
	UserPickedTeam userPickedTeam = new UserPickedTeam();

	// deduce the roles of each players
	public void deduceRoleCount(String role) {
		try {
			if (role.equals("Batsman")) {
				numberOfBatsmen++;
			} else if (role.equals("Bowler")) {
				numberOfBowler++;
			} else if (role.equals("Wicket Keeper")) {
				numberOfKeeper++;
			} else if (role.equals("All Rounder")) {
				numberOfAllrounder++;
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	// deduce the roles of each players
	public void addRoleCount(String role) {
		try {
			if (role.equals("Batsman")) {
				numberOfBatsmen--;
			} else if (role.equals("Bowler")) {
				numberOfBowler--;
			} else if (role.equals("Wicket Keeper")) {
				numberOfKeeper--;
			} else if (role.equals("All Rounder")) {
				numberOfAllrounder--;
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	// check for adding to valid list
	public boolean validatePlayer(int playerId) {
		try {
			for (int i = 0; i < players.size(); i++) {
				if (players.get(i) == playerId) {
			//		userService.callDisplayAlert(DisplayConstants.ALREADY_PRESENT);
				//	userService.callDisplayAlert(DisplayConstants.INVALID_SELECTION);
					return false;
				}
			}
			role = userDAO.getRole(playerId);
			playerCredits = userDAO.getPlayerCredits(playerId);
			if (matchCredits < (creditsCompleted + playerCredits)) {
			//	userService.callDisplayAlert(Integer.toString(matchCredits));
				//userService.callDisplayAlert(DisplayConstants.CREDITS_COMPLETED);
			//	userService.callDisplayAlert(DisplayConstants.INVALID_SELECTION);
				return false;
			}
			players.add(playerId);
			credits.add(playerCredits);
			creditsCompleted += playerCredits;
			totalCredits -= playerCredits;
			deduceRoleCount(role);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return true;

	}
	
	
	//get player rating
	public int getMatchCredits(int matchId) {
		match = userDAO.setMatch(matchId);
		return match.getMatchCredits();
	}	

	// pick a team of 11 players
	public ArrayList<Player> pickTeam(User user) {
		ArrayList<Player> playersList = new ArrayList<Player>();
		try {
			//userDAO.displayActiveMatches();
			//matchId = userService.callIntegerInputs();
//			match = userDAO.setMatch(matchId);
//			totalCredits = match.getMatchCredits();
			//matchCredits = totalCredits;
			//displayTeams(match);
//			int count = 0;
//			while (count < 11) {
//				userService.callDisplayAlert(Integer.toString(totalCredits) + DisplayConstants.REMAINING_CREDITS);
//				userService.callDisplayAlert(DisplayConstants.DISPLAY_REMAINING + Integer.toString(4 - numberOfBatsmen)
//						+ DisplayConstants.DISPLAY_BATSMEN + Integer.toString(3 - numberOfBowler)
//						+ DisplayConstants.DISPLAY_BOWLER + Integer.toString(3 - numberOfAllrounder)
//						+ DisplayConstants.DISPLAY_ALLROUNDER + Integer.toString(1 - numberOfKeeper)
//						+ DisplayConstants.DISPLAY_KEEPER);
//				isValid = false;
//				playerId = userService.callIntegerInputs();
//				isValid = validatePlayer(playerId);
//				if (isValid == true) {
//					count++;
//				}
//			}
//			userId = user.getUserId();
			//addTeam(userId, matchId, players);
			playersList = userDAO.displaySelectedTeam(matchId, user.getUserId());
		} catch (Exception e) {
			e.getStackTrace();
		}
		return playersList;
	}

	public void displayTeams(Match match) {
		// TODO Auto-generated method stub
		ArrayList<Player> playersList = new ArrayList<Player>();
		try {
			playersList = userDAO.displayTeam(match.getTeamOne());
			//userService.displayPlayerNamesList(playersList);
			playersList = userDAO.displayTeam(match.getTeamTwo());
			//userService.displayPlayerNamesList(playersList);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public boolean addTeam(int userId, int matchId, ArrayList<Integer> players , ArrayList<Integer> credits) {
		// TODO Auto-generated method stub
		boolean isDone = false;
		try {
			for (int index = 0; index < players.size(); index++) {
				userDAO.addPlayerToTeam(userId, matchId, players.get(index), credits.get(index));
			}
			isDone = true;
		} catch (Exception e) {
			e.getStackTrace();
		}
		return isDone;
	}

/*	public ArrayList<Player> viewTeam(User user, int matchId) {
		// TODO Auto-generated method stub
		ArrayList<Player> playersList = new ArrayList<Player>();
		try {
			System.out.println("ssss");
			userId = user.getUserId();
			playersList = userDAO.displaySelectedTeam(matchId, userId);
			System.out.println(playersList.size());
			for(int i=0;i<playersList.size();i++) {
				System.out.println(playersList.get(i).getplayerName());
			}
			//userService.displayPlayerNamesList(playersList);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return playersList;
	}
*/
	public ArrayList<Player> viewTeam(int userId, int matchId) {
		ArrayList<Player> playersList = new ArrayList<Player>();
		try {
			//userDAO.displayActiveMatches();
			//matchId = userService.callIntegerInputs();
			playersList = userDAO.displaySelectedTeam(matchId, userId);
			//userService.displayPlayerNamesList(playersList);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return playersList;
	}
	
	
	public ArrayList<Message> displayMessages(){
		return userDAO.displayMessages();
	}
	
	public boolean updateChat(int userId , String message) {
		return userDAO.addChat(userId, message);
		
	}

	// chat options
	public boolean chat(User user) {
		// TODO Auto-generated method stub
		try {
			do {
				ArrayList<Message> messages = new ArrayList<Message>();
				messages = userDAO.displayMessages();
				//userService.callDisplayMessages(messages);
				////userService.callDisplayAlert(DisplayConstants.CHAT_OPTIONS);
			//	choice = userService.callIntegerInputs();
				if (choice == 2) {
					break;
				}
			//	userService.callDisplayAlert(DisplayConstants.ENTER_MESSAGE);
			//	message = userService.callStringInputs();
			//	userId = user.getUserId();
				
			} while (choice != 2);
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
		return true;
	}

	// calculates the credits completed for a particular match
	public void calculateCreditsCompleted(ArrayList<Integer> credits, ArrayList<Integer> players) {
		try {
			int creditCount = 0;
			numberOfBatsmen = numberOfBowler = numberOfKeeper = numberOfAllrounder = 0;

			for (index = 0; index < credits.size(); index++) {
				role = userDAO.getRole(players.get(index));
				deduceRoleCount(role);
				creditCount += credits.get(index);
			}
			creditsCompleted = creditCount;
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	// make the deletion and addition
/*	public void makeUpdation(User user, UserPickedTeam userPickedTeam, int matchCredits, int matchId) {
		try {
			//int count = 0;
			//viewTeam(user, matchId);
			//players = userPickedTeam.getPlayerId();
			//credits = userPickedTeam.getCredits();
			//calculateCreditsCompleted(credits, players);
			//this.matchCredits = matchCredits;
			do {
				userService.callDisplayAlert(DisplayConstants.DELETE_PLAYER_OPTIONS);
				choice = userService.callIntegerInputs();
				if (choice == 1) {
					userService.callDisplayAlert(DisplayConstants.DELETE_PLAYER_ID);
					playerId = userService.callIntegerInputs();
					role = userDAO.getRole(playerId);
					addRoleCount(role);
					index = players.indexOf(playerId);
					creditsCompleted -= credits.get(index);
					players.remove(index);
					credits.remove(index);
					count++;
				}
			} while (choice == 1);
			while (count > 0) {
				count -= 1;
				userService.callDisplayAlert(DisplayConstants.ENTER_PLAYER_ID);
				playerId = userService.callIntegerInputs();
				validatePlayer(playerId);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		// userService.displayAlert("exiting");
	}*/

	// view result
	public ResultBoard viewLeaderBoard(int userId , int matchId) {
		try {
			/*userService.callDisplayAlert(DisplayConstants.ENTER_MATCH_ID);
			userDAO.displayCompletedMatches();
			matchId = userService.callIntegerInputs();*/
			/*
			 * totalCredits = userDAO.checkResultTable(user.getUserId(),matchId);
			 * if(totalCredits==0) { totalCredits = userDAO.
			 * calculateMatchScore(matchId,user.getUserId()); }
			 * userService.displayAlert(Integer.toString(totalCredits));
			 */
			resultBoard = userDAO.setResultBoard(matchId);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return resultBoard;
	}

	// view Top picked players of a match

	// modify the selected team
	public boolean modifyTeam(int userId, int matchId, ArrayList<Integer> players , ArrayList<Integer> credits) {
		// TODO Auto-generated method stub
		try {
			//userDAO.displayActiveMatches();
			//matchId = userService.callIntegerInputs();
			//match = userDAO.setMatch(matchId);
			//matchCredits = match.getMatchCredits();
			// userService.displayAlert(Integer.toString(matchCredits));
			//userPickedTeam = userDAO.setUserTeam(user.getUserId(), matchId);
			//makeUpdation(user, userPickedTeam, matchCredits, matchId);
			userDAO.deleteOldTeam(matchId, userId);
			addTeam(userId, matchId, players ,credits);
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
		return true;
	}

	// see most picked
	public ArrayList<String> viewMostPicked(int matchId) {
		ArrayList<String> playerNames = new ArrayList<String>();
		try {
			//userService.callDisplayAlert(DisplayConstants.ENTER_MATCH_ID);
			//userDAO.displayCompletedMatches();
			//matchId = userService.callIntegerInputs();
			playerNames = userDAO.getPlayersName(matchId);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return playerNames;

	}
	//get upcoming matches
	public ArrayList<Match> getUpcomingMatches(){
		ArrayList<Match> matchList = new ArrayList<Match>();
		matchList = userDAO.getUpcomingMatches();
		return matchList;
	}

	// view previous results
	public ResultBoard viewPreviousResults(User user) {
		// TODO Auto-generated method stub
		resultBoard = userDAO.getPreviousResult(user.getUserId());
		return resultBoard;
	}
	//display completed matches
	public ArrayList<Match> displayCompletedMatches() {
		return userDAO.displayCompletedMatches();
		
	}
	
	//is team taken by user for a particular match
	
	public boolean isTeamTaken(int matchId , int userId) {
		return userDAO.isTeamTaken(matchId, userId);
		
	}
	
	public  ArrayList<Match> displayActiveMatches() {
		return new AdminDAO().listActiveMatches();
	}

}
