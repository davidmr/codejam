package practice;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Rotate {

	public static void main(String[] args) throws IOException {
		String path = "files/practice/Rotate-large.bin";
		List<String> allLines = Files.readAllLines(FileSystems.getDefault().getPath(path), Charset.forName("UTF-8"));
		Iterator<String> lines = allLines.iterator();
		int testCases = toInt(lines.next());

		for (int testCase = 1; testCase <= testCases; testCase++) {
			Integer[] params = toInt(lines.next().split(" "));
			int n = params[0];
			int k = params[1];
			String[][] board = new String[n][n];
			for (int i = 0; i < n; i++) {
				String row = lines.next();
				for (int j = 0; j < n; j++) {
					board[i][j] = Character.toString(row.charAt(j));
				}
			}
			solve(board, k, testCase);
		}
	}

	private static void solve(String[][] board, int k, int testCase) {
		gravity(board);
		Set<String> winners = winners(board, k);
		if (winners.isEmpty()) {
			answer(testCase, "Neither");
		} else if (winners.size() == 1) {
			String player = winners.iterator().next();
			answer(testCase, player.equals("R") ? "Red" : "Blue");
		} else {
			answer(testCase, "Both");
		}
	}

	private static void gravity(String[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = board[i].length - 1; j >= 0; j--) {
				int k = j;
				while (k < board[i].length - 1 && !board[i][k].equals(".") && board[i][k + 1].equals(".")) {
					board[i][k + 1] = board[i][k];
					board[i][k] = ".";
					k++;
				}
			}
		}
	}

	private static Set<String> winners(String[][] board, int k) {
		Set<String> winners = new HashSet<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				String player = board[i][j];
				if (!player.equals(".")) {
					checkHorizontal(board, k, winners, i, j, player);
					checkVertical(board, k, winners, i, j, player);
					checkDiagonalLeft(board, k, winners, i, j, player);
					checkDiagonalRight(board, k, winners, i, j, player);
				}
			}
		}
		return winners;
	}

	private static void checkHorizontal(String[][] board, int k, Set<String> winners, int i, int j, String player) {
		int m = j;
		int matches = 0;
		while (m < board[i].length && board[i][m].equals(player)) {
			matches++;
			m++;
		}
		if (matches == k) {
			winners.add(player);
		}
	}

	private static void checkVertical(String[][] board, int k, Set<String> winners, int i, int j, String player) {
		int m = i;
		int matches = 0;
		while (m < board[j].length && board[m][j].equals(player)) {
			matches++;
			m++;
		}
		if (matches == k) {
			winners.add(player);
		}
	}

	private static void checkDiagonalLeft(String[][] board, int k, Set<String> winners, int i, int j, String player) {
		int m = i;
		int n = j;
		int matches = 0;
		while (m < board[j].length && n < board[i].length && board[m][n].equals(player)) {
			matches++;
			m++;
			n++;
		}
		if (matches == k) {
			winners.add(player);
		}
	}

	private static void checkDiagonalRight(String[][] board, int k, Set<String> winners, int i, int j, String player) {
		int m = i;
		int n = j;
		int matches = 0;
		while (m < board[j].length && n >= 0 && board[m][n].equals(player)) {
			matches++;
			m++;
			n--;
		}
		if (matches == k) {
			winners.add(player);
		}
	}

	private static void answer(int testCase, Object ans) {
		System.out.println("Case #" + testCase + ": " + ans);
	}

	private static Integer toInt(String string) {
		return Integer.parseInt(string);
	}

	private static Integer[] toInt(String[] strings) {
		Integer[] ints = new Integer[strings.length];
		for (int i = 0; i < strings.length; i++) {
			ints[i] = Integer.parseInt(strings[i]);
		}
		return ints;
	}
}
