package com.zilker.delegates;

import java.util.*;

public class Schedule {
	public ArrayList<String> convert(ArrayList<String> al, int teamSize, ArrayList<String> teamList) {
		for (int i = 0; i < al.size(); i++) {
			String s = al.get(i);
			s=s.trim();
			String arr[] = s.split("v");
			arr[0] = arr[0].trim();
			arr[1] = arr[1].trim();
			int check=0;
			s="";
			for (int j = 1; j <=teamSize; j++) {
				if ((arr[0]).equals(String.valueOf(j)) || (arr[1]).equals(String.valueOf(j))) {
					if(check==0) {
						check=1;
						s+=teamList.get(j-1)+" v ";
					}
					else {
						s+=teamList.get(j-1);
					}
				}
					
			}
			al.set(i, s);
		}
		return al;
	}

	public ArrayList<String> scheduleMatches(ArrayList<String> teamList) {
		ArrayList<String> al = new ArrayList<String>();
		int teams = teamList.size();
		boolean ghost = false;
		if (teams % 2 == 1) {
			teams++;
			ghost = true;
		}
		int totalRounds = teams - 1;
		int matchesPerRound = teams / 2;
		String[][] rounds = new String[totalRounds][matchesPerRound];

		for (int round = 0; round < totalRounds; round++) {
			for (int match = 0; match < matchesPerRound; match++) {
				int home = (round + match) % (teams - 1);
				int away = (teams - 1 - match + round) % (teams - 1);
				if (match == 0) {
					away = teams - 1;
				}
				rounds[round][match] = (home + 1) + " v " + (away + 1);
			}
		}
		String[][] interleaved = new String[totalRounds][matchesPerRound];

		int evn = 0;
		int odd = (teams / 2);
		for (int i = 0; i < rounds.length; i++) {
			if (i % 2 == 0) {
				interleaved[i] = rounds[evn++];
			} else {
				interleaved[i] = rounds[odd++];
			}
		}

		rounds = interleaved;
		for (int round = 0; round < rounds.length; round++) {
			if (round % 2 == 1) {
				rounds[round][0] = flip(rounds[round][0]);
			}
		}
		for (int i = 0; i < rounds.length; i++) {
			for (String s : Arrays.asList(rounds[i]))
				al.add(s);
			System.out.println();
		}
		System.out.println(al);
		al = convert(al, teamList.size(), teamList);
		if (ghost) {
			System.out.println("Matches against team " + teams + " are byes.");
		}
		System.out.println(al);
		return al;
	}

	private String flip(String match) {
		String[] components = match.split(" v ");
		return components[1] + " v " + components[0];

	}
}
