package phonebook04.list;

import java.util.ArrayList;
import java.util.Date;

//Controller 객체
// 어플리케이션의 동작, 데이터 처리(CRUD), (Business logic 담당)
public class PhonebookManager implements Pb {

	private ArrayList<PhonebookModel> pbList = new ArrayList<PhonebookModel>();

	// singleton 적용
	private PhonebookManager() {
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

		pbList.add(new PhonebookModel(getMaxUid() + 1, name, phoneNum, memo, new Date()));
		
		return 1;
	}

	@Override
	public PhonebookModel[] selectAll() {
		PhonebookModel[] md = new PhonebookModel[pbList.size()];
		for(int i = 0; i<md.length ; i++) {
			md[i] = pbList.get(i);
		}
			return md;
			
//			return pbList.toArray(new PhonebookModel[pbList.size()]);
	}

	// 특정 uid의 데이터 검색 리턴
	// 못 찾으면 null 리턴
	@Override
	public PhonebookModel selectByUid(int uid) {

		for(int i = 0; i<pbList.size(); i++) {
			if(pbList.get(i).getUid() == uid) {
				return pbList.get(i);
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

		int index = findIndexByUid(uid);
		if (index < 0)
			throw new PhonebookException("update() 없는 uid : " + uid, Pb.ERR_UID);

		pbList.get(index).setName(name);
		pbList.get(index).setPhoneNum(phoneNum);
		pbList.get(index).setMemo(memo);

		return 1;
	}

	@Override
	public int deleteByUid(int uid) {

		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("update() uid 오류 : " + uid, Pb.ERR_UID);

		int index = findIndexByUid(uid);
		if (index < 0)
			throw new PhonebookException("delete() 없는 uid : " + uid, Pb.ERR_UID);

		// 배열 뒤의 원소들을 앞으로 이동
		pbList.remove(index);
		
		return 1;
	}

	public int getMaxUid() {
		int maxUid = 0;

		for (int index = 0; index < pbList.size(); index++) {
			if (maxUid < pbList.get(index).getUid()) {
				maxUid = pbList.get(index).getUid();
			}
		}
		return maxUid;
	}

	// 특정 uid 값은 가진 데이터의 배열인덱스 찾기
	// 못 찾으면 -1 리턴
	private int findIndexByUid(int uid) {
		for(int i = 0 ; i<pbList.size(); i++) {
			if(pbList.get(i).getUid() == uid) {
				return i;
			}
		}
		return -1;
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
