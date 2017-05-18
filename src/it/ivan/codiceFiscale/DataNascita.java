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
 * DataNascita.java
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

import java.util.HashMap;
import java.util.Map;

public class DataNascita {

	private String data = "";
	private String giorno = "";
	private String mese = "";
	private String anno = "";
	private boolean sesso = false;
	private static Map<String, String> map;

	public DataNascita(String data, boolean sesso) {
		this.giorno = data.substring(0, 2);
		this.mese = data.substring(3, 5);
		this.anno = data.substring(8, 10);
		this.sesso = sesso;
		map = new HashMap<String, String>(12);
		map.put("01", "a");
		map.put("02", "b");
		map.put("03", "c");
		map.put("04", "d");
		map.put("05", "e");
		map.put("06", "h");
		map.put("07", "l");
		map.put("08", "m");
		map.put("09", "p");
		map.put("10", "r");
		map.put("11", "s");
		map.put("12", "t");
		mese = map.get(mese);

	}

	public String elaboraData() {
		if (sesso) {
			int giornoF = Integer.parseInt(giorno);
			giornoF = giornoF + 40;
			giorno = String.valueOf(giornoF);
		}
		data = anno + mese + giorno;
		return data;
	}

}
