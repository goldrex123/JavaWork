package phonebook06.db;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

//Controller 객체
// 어플리케이션의 동작, 데이터 처리(CRUD), (Business logic 담당)
public class PhonebookManager implements Pb, Closeable {

	//TODO : DB를 위한 변수 선언 
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Statement stmt = null;
			
	
	// singleton 적용
	private PhonebookManager() {

		//TODO : JDBC 프로그래밍
		// 클래스 로딩
		// 연결 connection
		try {
			
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static PhonebookManager instance = null;

	public static PhonebookManager getInstance() {
		if (instance == null) {
			instance = new PhonebookManager();
		}
		return instance;
	}

	// 전화번호부 생성 등록
	@Override
	public int insert(String name, String phoneNum, String memo) {

		// 매개변수 검증 - 이름 필수
		if (name == null || name.trim().length() == 0) {
			throw new PhonebookException("insert() 이름 입력 오류: ", Pb.ERR_EMPTY_STINRG);
		}
		
		int cnt = 0;
		//TODO 
		// sql_insert 사용하여 insert
		// PreparedStatement 사용
		try {
			pstmt = conn.prepareStatement(SQL_INSERT);
			
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, memo);
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cnt;
	}

	@Override
	public PhonebookModel[] selectAll() {
		//TODO
		//sql_select_all 사용
	
		try {
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
	
			List<PhonebookModel> list = new ArrayList<PhonebookModel>();
			rs = pstmt.executeQuery();
			while(rs.next()) {
//				Date d = rs.getDate(COL_LABEL_REGDATE);
//				Time t = rs.getTime(COL_LABEL_REGDATE);
//				String birthdate = new SimpleDateFormat("yyyy-MM-dd").format(d)+ " " + new SimpleDateFormat("hh:mm:ss").format(t);
//				
//				java.util.Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(birthdate);
				
				list.add(new PhonebookModel(rs.getInt(COL_LABEL_UID), rs.getString(COL_LABEL_NAME), rs.getString(COL_LABEL_PHONENUM), 
						rs.getString(COL_LABEL_MEMO), rs.getTimestamp(COL_LABEL_REGDATE)));
			}
			return list.toArray(new PhonebookModel[list.size()]);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	// 특정 uid의 데이터 검색 리턴
	// 못 찾으면 null 리턴
	@Override
	public PhonebookModel selectByUid(int uid) {
		
		try {
			pstmt = conn.prepareStatement(SQL_SELECT);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PhonebookModel pb = new PhonebookModel(rs.getInt(COL_LABEL_UID), rs.getString(COL_LABEL_NAME), rs.getString(COL_LABEL_PHONENUM), 
					rs.getString(COL_LABEL_MEMO), rs.getDate(COL_LABEL_REGDATE));
				return pb;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public int updateByUid(int uid, String name, String phoneNum, String memo) {

		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("update() uid 오류 : " + uid, Pb.ERR_UID);
		if (name == null || name.trim().length() == 0)
			throw new PhonebookException("update() 이름 입력 오류: ", Pb.ERR_EMPTY_STINRG);
		// 특정 uid 값은 가진 데이터의 배열인덱스 찾기
		
		int cnt = 0;
		
		//TODO
		//sql_update_by_uid
		try {
			pstmt = conn.prepareStatement(SQL_UPDATE_BY_UID);
			
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, memo);
			pstmt.setInt(4, uid);
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			try {
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}

	@Override
	public int deleteByUid(int uid) {

		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("delete() uid 오류 : " + uid, Pb.ERR_UID);

		int cnt = 0;
		
		//TODO
		//deletebyuid
		try {
			pstmt = conn.prepareStatement(SQL_DELETE_BY_UID);
			
			pstmt.setInt(1, uid);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return cnt;
	}

	public int getMaxUid() {
		int maxUid = 0;

		//TODO
		try {
			pstmt = conn.prepareStatement(SQL_MAX_BY_UID);
			
			maxUid = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return maxUid;
	}

	@Override
	public void close() throws IOException {

		//TODO
		//rs, stmt, conn 들 close
		try {
			if(rs != null) rs.close();
			if(conn != null) conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// 예외 클래스 정의
// 예외 발생하면 '에러코드' + '에러메세지'를 부여하여 관리하는게 좋다.
class PhonebookException extends RuntimeException {
	private int errCode = Pb.ERR_GENERIC;

	public PhonebookException() {
		super("Phonebook 예외 발생");
	}

	public PhonebookException(String msg) {
		super(msg);
	}

	public PhonebookException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}

	@Override
	public String getMessage() {
		String msg = "ERR - " + errCode + "]" + Pb.ERR_STR[errCode] + " " + super.getMessage();
		return msg;
	}
}
