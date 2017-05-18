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
 * CumuneNascita.java
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ComuneNascita {

	private String comune = "";
	private String[] parts;
	private String code = "";

	public ComuneNascita(String comune) {
		this.comune = comune = comune.substring(0, 1).toUpperCase()
				.concat(comune.substring(1, comune.length()));
	}

	public String comuneNascita() {

		InputStream is = getClass().getResourceAsStream(
				"/resources/listacomuni.txt");
		InputStreamReader isr = new InputStreamReader(is);

		BufferedReader reader = new BufferedReader(isr);
		String line = null;

		try {
			line = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (line != null) {
			parts = line.split(";");
			if (parts[0].trim().equals(comune))
				code = parts[1].trim();
			try {
				line = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return code;
	}
}
