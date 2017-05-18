/* ===========================================================
 * Codice fiscale 
 * ===========================================================
 *
 * Project Info:  navicolt@gmail.com
 *
 * Copyright (C) 2016 Ivan Guerreschi
 * 
 * This program is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABI-
 * LITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see http://www.gnu.org/licenses/.
 *
 * [Oracle and Java are registered trademarks of Oracle and/or its affiliates. 
 * Other names may be trademarks of their respective owners.]
 * 
 * --------------------
 * CarattereControllo.java
 * --------------------
 * Copyright (C) 2016 Ivan Guerreschi
 *
 * Original Author:  Ivan Guerreschi;
 * Contributor(s): 
 * 
 * Changes
 * -------
 */

package it.ivan.codiceFiscale;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CarattereControllo {

	private String controllo = "";
	private String[] pari = new String[15];
	private String[] dispari = new String[15];
	private int[] sommaPari = new int[7];
	private int[] sommaDispari = new int[8];
	private int totale = 0;
	private Map<String, Integer> mapPari = new HashMap<String, Integer>(36);
	private Map<String, Integer> mapDispari = new HashMap<String, Integer>(36);
	private Map<Integer, String> resto = new HashMap<Integer, String>(26);
	private ArrayList<String> pariTMP = new ArrayList<String>();
	private ArrayList<String> dispariTMP = new ArrayList<String>();

	public CarattereControllo(String controllo) {
		this.controllo = controllo;
	}

	public String carattereControllo() {

		for (int i = 1; i < controllo.length(); i = i + 2)
			pari[i] = controllo.substring(i, i + 1);

		for (int j = 0; j < controllo.length(); j = j + 2)
			dispari[j] = controllo.substring(j, j + 1);
		
		mapPari.put("0", 0);
		mapPari.put("1", 1);
		mapPari.put("2", 2);
		mapPari.put("3", 3);
		mapPari.put("4", 4);
		mapPari.put("5", 5);
		mapPari.put("6", 6);
		mapPari.put("7", 7);
		mapPari.put("8", 8);
		mapPari.put("9", 9);
		mapPari.put("A", 0);
		mapPari.put("B", 1);
		mapPari.put("C", 2);
		mapPari.put("D", 3);
		mapPari.put("E", 4);
		mapPari.put("F", 5);
		mapPari.put("G", 6);
		mapPari.put("H", 7);
		mapPari.put("I", 8);
		mapPari.put("J", 9);
		mapPari.put("K", 10);
		mapPari.put("L", 11);
		mapPari.put("M", 12);
		mapPari.put("N", 13);
		mapPari.put("O", 14);
		mapPari.put("P", 15);
		mapPari.put("Q", 16);
		mapPari.put("R", 17);
		mapPari.put("S", 18);
		mapPari.put("T", 19);
		mapPari.put("U", 20);
		mapPari.put("V", 21);
		mapPari.put("W", 22);
		mapPari.put("X", 23);
		mapPari.put("Y", 24);
		mapPari.put("Z", 25);
		
		mapDispari.put("0", 1);
		mapDispari.put("1", 0);
		mapDispari.put("2", 5);
		mapDispari.put("3", 7);
		mapDispari.put("4", 9);
		mapDispari.put("5", 13);
		mapDispari.put("6", 15);
		mapDispari.put("7", 17);
		mapDispari.put("8", 19);
		mapDispari.put("9", 21);
		mapDispari.put("A", 1);
		mapDispari.put("B", 0);
		mapDispari.put("C", 5);
		mapDispari.put("D", 7);
		mapDispari.put("E", 9);
		mapDispari.put("F", 13);
		mapDispari.put("G", 15);
		mapDispari.put("H", 17);
		mapDispari.put("I", 19);
		mapDispari.put("J", 21);
		mapDispari.put("K", 2);
		mapDispari.put("L", 4);
		mapDispari.put("M", 18);
		mapDispari.put("N", 20);
		mapDispari.put("O", 11);
		mapDispari.put("P", 3);
		mapDispari.put("Q", 6);
		mapDispari.put("R", 8);
		mapDispari.put("S", 12);
		mapDispari.put("T", 14);
		mapDispari.put("U", 16);
		mapDispari.put("V", 10);
		mapDispari.put("W", 22);
		mapDispari.put("X", 25);
		mapDispari.put("Y", 24);
		mapDispari.put("Z", 23);
	
		resto.put(0, "A");
		resto.put(1, "B");
		resto.put(2, "C");
		resto.put(3, "D");
		resto.put(4, "E");
		resto.put(5, "F");
		resto.put(6, "G");
		resto.put(7, "H");
		resto.put(8, "I");
		resto.put(9, "J");
		resto.put(10, "K");
		resto.put(11, "L");
		resto.put(12, "M");
		resto.put(13, "N");
		resto.put(14, "O");
		resto.put(15, "P");
		resto.put(16, "Q");
		resto.put(17, "R");
		resto.put(18, "S");
		resto.put(19, "T");
		resto.put(20, "U");
		resto.put(21, "V");
		resto.put(22, "W");
		resto.put(23, "X");
		resto.put(24, "Y");
		resto.put(25, "Z");

		for (String x : pari) {
			if (x != null)
				pariTMP.add(x);
		}
		pari = pariTMP.toArray(new String[pariTMP.size()]);

		for (String x : dispari) {
			if (x != null)
				dispariTMP.add(x);
		}
		dispari = dispariTMP.toArray(new String[dispariTMP.size()]);

		for (int i = 0; i < pari.length; i++) {
			sommaPari[i] = mapPari.get(pari[i]);
			totale += sommaPari[i];
		}

		for (int i = 0; i < dispari.length; i++) {
			sommaDispari[i] = mapDispari.get(dispari[i]);
			totale += sommaDispari[i];
		}

		totale = totale % 26;
		controllo = resto.get(totale);

		return controllo;
	}
}
