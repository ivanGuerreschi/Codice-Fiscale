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
 * Nome.java
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

public class Nome {

	private String nome = "";
	private ArrayList<String> listaNomi = new ArrayList<>(20);
	private String valLista = "";

	public Nome(String nome) {
		this.nome = nome.toLowerCase();
	}

	public String elaboraNome() {
		for (int i = 0; i < nome.length(); i++) {
			if (!(nome.charAt(i) == 'a') && !(nome.charAt(i) == 'e')
					&& !(nome.charAt(i) == 'i') && !(nome.charAt(i) == 'o')
					&& !(nome.charAt(i) == 'u')) {
				listaNomi.add(nome.substring(i, i + 1));
				valLista += listaNomi.get(i);
				if (valLista.length() == 3)
					break;
			} else
				listaNomi.add("");

		}

		while (valLista.length() < 3) {
			for (int i = 0; i < nome.length(); i++) {
				if (nome.charAt(i) == 'a' || nome.charAt(i) == 'e'
						|| nome.charAt(i) == 'i' || nome.charAt(i) == 'o'
						|| nome.charAt(i) == 'u') {
					listaNomi.add(listaNomi.size(), nome.substring(i, i + 1));
					valLista += listaNomi.get(listaNomi.size() - 1);
					if (valLista.length() == 3)
						break;
				} else
					listaNomi.add("");
			}
		}

		return valLista;

	}

}
