package com.mukaddes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * This class builds shopping basket from file
 * @author Mukaddes
 *
 */
public class ShoppingBasketReader {
	
	private List<Product> products = new ArrayList<Product>();
	
	private static final Logger log4j = LogManager
			.getLogger(TaxesCalculation.class.getName());
	
	public List<Product> read(String filename) throws IOException {
		BufferedReader reader;
		File filepath = new File(filename);
		Product pr;
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(
				filepath)));

		String line;
		StringTokenizer st;

		while ((line = reader.readLine()) != null && !line.equals("")) {
			st = new StringTokenizer(line);

			pr = new Product();

			// count
			pr.setCount(Integer.parseInt(st.nextToken()));

			// imported
			if (st.nextToken().equals("imported")) {
				pr.getPs().setImported(true);
			} else {
				pr.getPs().setImported(false);
			}
			// kind
			pr.getPs().setType(st.nextToken());

			// price
			pr.getPs().setPrice(Double.parseDouble(st.nextToken()));

			// name
			pr.getPs().setName(restOfTokens(st));

			log4j.debug("---INPUT---");
			log4j.debug(pr.getCount() + " " + pr.getPs().getName() + " : "
					+ pr.getPs().getPrice());
			products.add(pr);

		}
		reader.close();
		
		return products;

	}
	private String restOfTokens(StringTokenizer st) {
		StringBuilder sb = new StringBuilder();
		while (st.hasMoreElements()) {
			String s = (String) st.nextElement();
			sb.append(s);
			sb.append(" ");
		}
		return sb.toString();
	}

}
