package algorithms;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.google.common.collect.Lists;

import constants.Const;

/**
 * Tinh to hop chap k cua n phan tu.
 * 
 * @author Johny
 * @see http://windybook.com/algorithm-thuat-toan-quay-lui-liet-ke-to-hop-chap-k-cua-n-phan-tu/
 *      (algorithm)
 * @see http://www.cplusplus.com/forum/beginner/4442/ (create and write file)
 */
public final class ToHopCkn implements Const {
	private int k;
	private int n;

	private int lineNbr;
	private int[] a;
	private List<String> data;

	public ToHopCkn(int k, int n) {
		this.k = k;
		this.n = n;
		this.lineNbr = 0;
		this.a = new int[1000000];
		this.data = Lists.newArrayList();
	}

	private static Connection getDBConnection() {
		final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
		final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:sample";
		final String DB_USER = "c##admin";
		final String DB_PASSWORD = "123456";

		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}

	@SuppressWarnings("unused")
	private static void insertData(final List<String> strings) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSql = "INSERT INTO CD_TICKET_SLT(COM_OF_NUMBER) VALUES(?)";

		try {
			connection = getDBConnection();// JDBCExample.getOracleConnection();
			preparedStatement = connection.prepareStatement(insertSql);

			int count = 1;
			for (String ticket : strings) {
				preparedStatement.setString(1, ticket);
				// execute insert SQL Statement
				preparedStatement.executeUpdate();

				count++;
			}

			// connection.commit(); //Could not commit with auto-commit set on
			System.out.println("{" + count + "} Record is inserted into CD_TICKET_SLT table!");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	void writeFile(final List<String> strings) {
		try {
			File dir = new File(CURR_DIR + "/msgs");
			if (!dir.exists())
				dir.mkdir();

			File file = new File(dir.getAbsoluteFile() + "/Ckn.txt");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			int idx = 1;
			for (String s : strings) {
				bw.write(s);
				if (idx < strings.size()) {
					bw.newLine();
				}
				idx++;
			}
			bw.close();

			// System.out.println(String.format("Done with {%d} lines.", strings.size()));
			System.out.println(String.format("Done with {%d} lines.", getLineNbr()));
		} catch (FileAlreadyExistsException x) {
			System.err.format("File named %s" + " already exists%n", File.pathSeparator);
		} catch (IOException x) {
			System.err.format("CreateFile error: %s%n", x);
		}
	}

	void print() {
		lineNbr++;
		// String s = lineNbr + COLON;
		String s = EMPTY;

		for (int i = 1; i <= k; i++) {
			String temp = (a[i] < 10 ? (ZERO + String.valueOf(a[i])) : String.valueOf(a[i]));
			if (i < k)
				s += temp + DASH;
			else
				s += temp;
		}

		data.add(s);
	}

	void backtrack(int i) {
		for (int j = a[i - 1] + 1; j <= n - k + i; j++) {
			a[i] = j;
			if (i == k) {
				print();
			} else {
				backtrack(i + 1);
			}
		}
	}

	void generate() {
		if (k >= 0 && k <= n) {
			a[0] = 0;
			backtrack(1);
		} else {
			System.out.println("Loi: khong thoa dieu kien 0<=k<=n ");
		}
	}

	public int getLineNbr() {
		return lineNbr;
	}

	public List<String> getData() {
		return data;
	}

	public static void main(String[] args) throws SQLException {
		// TODO TESTING
		ToHopCkn cKn = new ToHopCkn(6, 45);
		long startTime = System.currentTimeMillis();

		cKn.generate();

		List<String> strings = cKn.getData();
		// write to file
		cKn.writeFile(strings);

		// for (String s : strings) {
		// System.out.println(s);
		// }

		long endTime = System.currentTimeMillis();
		System.out.println(String.format("Elapsed time to generate {%f} seconds.", (endTime - startTime) / 1000.0));
		System.out.println("----------------------------------");

		// List<String> strings = cKn.getData();
		// // write to file
		// // cKn.writeFile(strings);
		//
		// System.out.println("First ticket: " + strings.get(0));
		// // insert into oracle db
		// startTime = System.currentTimeMillis();
		//
		// insertData(strings);
		//
		// endTime = System.currentTimeMillis();
		// System.out.println("Elapsed time to insert {" + (endTime - startTime)
		// / 1000.0 + "} seconds.");
	}
}
