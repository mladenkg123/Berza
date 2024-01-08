package rs.raf.pds.v5.z2;

import rs.raf.pds.v5.z2.gRPC.StockData;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InitialData {
	
	
	
	static String[][] stockData = {
			{"TMUS", "T-Mobile US Inc. Common Stock", "$162.92", "0.62", "1704490796"},
			{"GE", "General Electric Company Common Stock", "$125.975", "1.315", "1704490796"},			
			{"MLNK", "MeridianLink Inc. Common Stock", "$22.671", "-0.079", "1704490796"},
			{"HCI", "HCI Group Inc. Common Stock", "$90.77", "1.13", "1704490796"},
			{"TSLA", "Tesla Inc. Common Stock", "$238.28", "0.35", "1704490796"},
			{"AAPL", "Apple Inc. Common Stock", "$181.10", "-0.81", "1704490796"},
			{"ZBH", "Zimmer Biomet Holdings Inc. Common Stock", "$120.54", "0.34", "1704490796"},
			{"TSM", "Taiwan Semiconductor Manufacturing Company Ltd.", "$99.47", "0.34", "1704490796"},
			{"PSO", "Pearson Plc Common Stock", "$12.39", "-0.02", "1704490796"},
			};

	/*
	 {"MAR", "Marriott International Class A Common Stock", "$222.78", "2.76", "1704490796"},
			{"WDS", "Woodside Energy Group Limited American Depositary Shares each representing one Ordinary Share", "$21.185", "0.095", "1704490796"},
			{"LMT", "Lockheed Martin Corporation Common Stock", "$455.9322", "-1.9378", "1704490796"},
			{"GOOGL", "Alphabet Inc. Class A Common Stock", "$135.73", "-0.66", "1704490796"},
			{"BDX", "Becton Dickinson and Company Common Stock", "$243.13", "0.22", "1704490796"},
			{"EPD", "Enterprise Products Partners L.P. Common Stock", "$26.685", "-0.095", "1704490796"},
			{"LIN", "Linde plc Ordinary Shares", "$407.39", "-1.2", "1704490796"},
			{"RPRX", "Royalty Pharma plc Class A Ordinary Shares ", "$27.59", "-0.21", "1704490796"},
			{"JPM", "JP Morgan Chase & Co. Common Stock", "$172.55", "1.14", "1704490796"},
			{"AEIS", "Advanced Energy Industries Inc. Common Stock", "$100.98", "-0.29", "1704490796"},
			{"APO", "Apollo Global Management Inc. (New) Common Stock", "$95.125", "0.325", "1704490796"},
			{"ACN", "Accenture plc Class A Ordinary Shares (Ireland)", "$337.4521", "0.3621", "1704490796"},
			{"CRM", "Salesforce Inc. Common Stock", "$251.73", "0.49", "1704490796"},
			{"FSLR", "First Solar Inc. Common Stock", "$168.135", "1.825", "1704490796"},
			{"UBS", "UBS Group AG Registered Ordinary Shares", "$29.94", "0.37", "1704490796"},
			{"NVO", "Novo Nordisk A/S Common Stock", "$106.0422", "-1.5878", "1704490796"},
			{"JPM", "JP Morgan Chase & Co. Common Stock", "$172.55", "1.14", "1704490796"},
			{"BKNG", "Booking Holdings Inc. Common Stock", "$3407.30", "-12.64", "1704490796"},
			{"CASY", "Casey's General Stores Inc. Common Stock", "$280.945", "2.045", "1704490796"},
			{"DTG", "DTE Energy Company 2021 Series E 4.375% Junior Subordinated Debentures", "$20.50", "-0.11", "1704490796"},
			{"TBB", "AT&T Inc. 5.350% Global Notes due 2066", "$24.01", "0.03", "1704490796"},
			{"ORCL", "Oracle Corporation Common Stock", "$102.80", "0.21", "1704490796"},
			{"NVO", "Novo Nordisk A/S Common Stock", "$106.0422", "-1.5878", "1704490796"},
			{"GOOG", "Alphabet Inc. Class C Capital Stock", "$137.45", "-0.59", "1704490796"},
			{"GPC", "Genuine Parts Company Common Stock", "$136.61", "0.45", "1704490796"},
			{"DTM", "DT Midstream Inc. Common Stock ", "$54.475", "-0.555", "1704490796"},
			{"ADP", "Automatic Data Processing Inc. Common Stock", "$234.765", "1.105", "1704490796"},
			{"WHD", "Cactus Inc. Class A Common Stock", "$43.35", "0.28", "1704490796"},
			{"AXP", "American Express Company Common Stock", "$189.10", "1.96", "1704490796"},
			{"CL", "Colgate-Palmolive Company Common Stock", "$79.85", "-0.49", "1704490796"},
	 
	
	 
	  */
	
	
		 
	public static StockData[] initStocks() {
        StockData[] stocks = new StockData[stockData.length];
        int i = 0;
        for (String[] data : stockData) {
        	 StockData stockData = StockData.newBuilder()
                     .setSymbol(data[0])
                     .setCompanyName(data[1])
                     .setPrice(Double.parseDouble(data[2].substring(1)))
                     .setChange(Double.parseDouble(data[3]))
                     .setDate(convertUnixTimestampToDate(Long.parseLong(data[4])))
                     .build();
    
            stocks[i++] = stockData;
        }
        return stocks;
    }
	
	
	 private static String convertUnixTimestampToDate(long timestamp) {
	        Date date = new Date(timestamp * 1000L);  
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        return dateFormat.format(date);
	    }
}
