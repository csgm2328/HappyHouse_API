package com.ssafy.happyHouse.util;

import java.io.*;
import java.nio.charset.Charset;
import java.sql.*;
import java.util.StringTokenizer;

//public class CSV_Parser {
//
//	File file;
//	FileReader fr;
//	BufferedReader in;
//	String[] attrName;
//	String[] columnsContent;
//
//	public static void main(String[] args) throws IOException {
//
//		CSV_Parser eamCsvLoad = new CSV_Parser();
//		String Location = "";
//		if ("J".equals(args[0])) {
//			Location = "파일경로";
//		} else if ("B".equals(args[0])) {
//			Location = "파일경로";
//		} else if ("L".equals(args[0])) {
//			Location = "파일경로";
//		}
//		eamCsvLoad.loadFile(Location);
//		eamCsvLoad.getConn();
//		eamCsvLoad.excute(args[0]);
//
//	}
//
//	public void loadFile(String Location) throws IOException {
//		file = new File(Location);
//		fr = new FileReader(file);
//		in = new BufferedReader(fr);
//		// TXT 파일을 불러와서 FileReader 객체에 넣은 후 버퍼에 넣는다.
//	}
//
//	public Connection getConn() {
//		Connection conn = null;
//
//		String URL = "jdbc:mysql://localhost:3306/happyhouse?useUniCode=yes&characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
//		String id = "ssafy";
//		String pw = "ssafy";
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.getMessage();
//			System.out.println("연결되지 않았습니다.");
//		} // 드라이버 연결
//
//		try {
//			conn = DriverManager.getConnection(URL, id, pw);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return conn;
//	}
//
//	public void excute(String attrCode) throws IOException {
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//
//		StringTokenizer st = null;
//
//		String query = "INSERT INTO store_info (CID, BTNID, ATTRCODE, KIND) values (?, ?, ?, ?)";
//		String chkValue = "";
//		if (attrCode.equals("J") || attrCode.equals("B")) {
//			chkValue = "Y";
//		} else {
//			chkValue = "N";
//		}
//
//		int countToken = 0;
//		int index = 0;
//
//		try {
//			conn = getConn();
//
//			// 1. 같은 속성의 DATA 삭제
//			pstmt = conn.prepareStatement("DELETE FROM store_info WHERE KIND = ?");
//			pstmt.setString(1, attrCode);
//			pstmt.executeUpdate();
//
//			pstmt = conn.prepareStatement(query);
//
//			String temp = "";
//			temp = in.readLine();
//
//			if (temp != null) {
//				st = new StringTokenizer(temp, ",");
//				countToken = st.countTokens();
//				attrName = new String[countToken];
//
//				attrName = temp.split(",", countToken);
//				columnsContent = new String[countToken];
//
//				// 2. 선택된 속성을 INSERT 한다.
//				while ((temp = in.readLine()) != null) {
//					columnsContent = temp.split(",", countToken);
//					for (index = 0; index < countToken; index++) {
//						if (chkValue.equals(columnsContent[index])) {
//
//							// System.out.println("CID " + columnsContent[0].trim());
//							// System.out.println("BTNID " + columnsContent[1].trim());
//
//							pstmt.setString(1, columnsContent[0].trim());
//							pstmt.setString(2, columnsContent[1].trim());
//							pstmt.setString(3, attrName[index].trim());
//							pstmt.setString(4, attrCode);
//
//							pstmt.executeUpdate();
//						}
//					}
//				}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if (pstmt != null)
//				try {
//					pstmt.close();
//				} catch (SQLException e) {
//				}
//			if (conn != null)
//				try {
//					conn.close();
//				} catch (SQLException e) {
//				}
//		} // DB 연결에 사용한 객체와 Query수행을 위해 사용한 객체를 닫는다.
//	}
//}
public class CSV_Parser {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/happyhouse?useUniCode=yes&characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
		String username = "ssafy";
		String password = "ssafy";

		String csvFilePath = "C:\\Users\\default.DESKTOP-FVT3076\\Desktop\\상가업소정보_서울_202103.csv";
		
		try {
			csvFilePath = java.net.URLDecoder.decode(csvFilePath, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int batchSize = 20;

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(jdbcURL, username, password);
			connection.setAutoCommit(false);

			String sql = "INSERT INTO store_info (no, name, type, industry, gugun, dong, address, lat, lng) VALUES (?, ?, ?, ?, ?,?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);

			BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
			Charset.forName("UTF-8");
			String lineText = null;

			int count = 0;

			String[] col = lineReader.readLine().split(","); // skip header line
			int no_i = 0;
			int name_i = 0;
			int type_i = 0;
			int industry_i = 0;
			int gugun_i = 0;
			int dong_i = 0;
			int address_i = 0;
			int lat_i = 0;
			int lng_i = 0;;
			for (int i = 0; i < col.length; i++) {
				System.out.println(col[i]);
				if (col[i].equals("상가업소번호")) {
					no_i = i;
				} else if (col[i].equals("상호명")) {
					name_i = i;
				} else if (col[i].equals("상권업종대분류명")) {
					type_i = i;
				} else if (col[i].equals("표준산업분류명")) {
					industry_i = i;
				} else if (col[i].equals("시군구명")) {
					gugun_i = i;
				} else if (col[i].equals("법정동명")) {
					dong_i = i;
				} else if (col[i].equals("지번주소")) {
					address_i = i;
				} else if (col[i].equals("경도")) {
					lat_i = i;
				} else if (col[i].equals("위도")) {
					lng_i = i;
				}
			}
			int batchCnt =0;
			while ((lineText = lineReader.readLine()) != null) {
				String[] data = lineText.split(",");
				String no = data[no_i];
				String name = data[name_i];
				String type = data[type_i];
				String industry = data[industry_i];
				String gugun = data[gugun_i];
				String dong = data[dong_i];
				String address = data[address_i];
				String lat = data[lat_i];
				String lng = data[lng_i];
				
//				System.out.println(name);
				statement.setString(1, no);
				statement.setString(2, name);
				statement.setString(3, type);
				statement.setString(4, industry);
				statement.setString(5, gugun);
				statement.setString(6, dong);
				statement.setString(7, address);
				statement.setString(8, lat);
				statement.setString(9, lng);
				statement.addBatch();
				count++;
				if (count % batchSize == 0) {
					statement.executeBatch();
					count =0;
					batchCnt++;
					if(batchCnt > 5000)//다 넣으면 터진다 시간 얼마나 걸릴지 모르니 10000개만
						break;
				}
			}
			lineReader.close();

			// execute the remaining queries
			statement.executeBatch();

			connection.commit();
			connection.close();

		} catch (IOException ex) {
			System.err.println(ex);
		} catch (SQLException ex) {
			ex.printStackTrace();

			try {
				connection.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
