package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Random;

public class Universe {
	char[][] curr_gen;
	char[][] next_gen;
	int size;
	int alive;
	int gen;

	public Universe(int size) {
		this.size = size;
		gen = 1;
		curr_gen = init_universe();
		alive = count(curr_gen);
		next_gen = designNextGen(curr_gen);
	}

	private int count(char[][] curr_gen) {
		int count = 0;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (curr_gen[i][j] == 'O') count++;
			}
		}
		return count;
	}

	public int getGen() {
		return gen;
	}

	public int getSize() {
		return size;
	}

	public int getAlive() {
		return alive;
	}

	public char[][] getUniverse() { return curr_gen; }

	public void printUniverse() {
		String output = "Generation #" + gen + "\n" + "Alive: " + alive + "\n";
//		System.out.println("Generation #" + gen);
//		System.out.println("Alive: " + alive + "\n");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				output += curr_gen[i][j];
//				System.out.print(curr_gen[i][j]);
			}
			output += "\n";
//			System.out.print("\n");
		}
//		System.out.println(output);
		output += "\n______________________________________________\n";

		File file = new File("univ_output.txt");
		try {
			if (!file.exists()) file.createNewFile();
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			writer.write(output);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void changeGen() {
		curr_gen = next_gen;
		alive = count(curr_gen);
		next_gen = designNextGen(curr_gen);
		gen++;
	}

	private char[][]	init_universe() {
		char[][] map = new char[size][size];
		Random rand = new Random();

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				map[i][j] = rand.nextBoolean() ? 'O' : ' ';
			}
		}
		return map;
	}

	private char[][] designNextGen(char[][] curr) {
		char[][] next = new char[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				next[i][j] = isSurvive(curr, i, j) ? 'O' : ' ';
			}
		}
		return next;
	}

	public JPanel printMapOnPanel() {
		return new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
//				for (int i = 0; i < 20; i++) {
//                    for (int k = 0; k < 20; k++) {
//                            g.drawRect((i+1) * 30, (k+1) * 30, 30, 30);
//                    }
//                }
				this.setBackground(Color.BLACK);
				for (int i = 0; i < size; i++) {
					for (int k = 0; k < size; k++) {
						if (curr_gen[i][k] == 'O') {
							if (isSurvive(curr_gen, i, k))
								g.setColor(Color.MAGENTA);
							else
								g.setColor(Color.RED);
							g.fill3DRect((i) * 930/size, (k) * 930/size, 930/size, 930/size, true);
//							g.setColor(Color.BLACK);
						}
//						else if (isSurvive(curr_gen, i, k)) {
//							g.setColor(Color.BLUE);
//							g.fill3DRect((i) * 5, (k) * 5, 5, 5, false);
//						}
//						else
//							g.fill3DRect((i) * 3 + 10, (k) * 3, 3, 3, true);
					}
				}
			}
		};
	}

	private boolean isSurvive(char[][] curr, int i, int j) {
		int neighbors = 0;

		for (int i1 = i - 1; i1 <= i + 1; i1++) {
			for (int j1 = j - 1; j1 <= j + 1; j1++) {
				if (i1 == i && j1 == j) continue;
				int buf_i1 = i1 < 0 ? size - 1 : i1 > size - 1 ? 0 : i1;
				int buf_j1 = j1 < 0 ? size - 1 : j1 > size - 1 ? 0 : j1;
				neighbors = curr[buf_i1][buf_j1] == 'O' ? neighbors + 1 : neighbors;
			}
		}
		if (curr[i][j] == ' ' && neighbors == 3) return true;
		else if (curr[i][j] == 'O' && (neighbors == 2 || neighbors == 3)) return true;
		else return false;
	}


}
