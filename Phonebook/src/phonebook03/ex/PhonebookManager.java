package phonebook03.ex;

import java.util.Arrays;

//Controller 객체
// 어플리케이션의 동작, 데이터 처리(CRUD), (Business logic 담당)
public class PhonebookManager implements Pb {

	public static final int MAX_DATA = 3; // 최대 데이터 개수

	// 배열로 구현
	private PhonebookModel[] pbList = new PhonebookModel[MAX_DATA];

	// 몇 개의 데이터가 저장되었는지
	private int count = 0;

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

		// 특정 uid 값은 가진 데이터의 배열인덱스 찾기
		// 만약 배열이 다 차있으면, MAX_DATA 만큼 추가된 새 배열 작성
		if (count == pbList.length) {
			pbList = Arrays.copyOf(pbList, pbList.length + MAX_DATA);
		}

		pbList[count] = new PhonebookModel(name, phoneNum, memo);
		pbList[count].setUid(getMaxUid() + 1); // 기존의 최대 uid 값보다 1 증가한 값.
		// uid 와 배열 index는 다르다!
		count++;

		return 1;
	}

	@Override
	public PhonebookModel[] selectAll() {

		return Arrays.copyOfRange(pbList, 0, count);

	}

	// 특정 uid의 데이터 검색 리턴
	// 못 찾으면 null 리턴
	@Override
	public PhonebookModel selectByUid(int uid) {

		for (int index = 0; index < count; index++) {
			if (pbList[index].getUid() == uid) {
				return pbList[index];
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

		pbList[index].setName(name);
		pbList[index].setPhoneNum(phoneNum);
		pbList[index].setMemo(memo);

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
		for (int i = index, j = index + 1; j < count; i++, j++) {
			pbList[i] = pbList[j];
		}
		count--;
		

		return 1;
	}

	public int getMaxUid() {
		int maxUid = 0;

		for (int index = 0; index < count; index++) {
			if (maxUid < pbList[index].getUid()) {
				maxUid = pbList[index].getUid();
			}
		}
		return maxUid;
	}

	// 특정 uid 값은 가진 데이터의 배열인덱스 찾기
	// 못 찾으면 -1 리턴
	private int findIndexByUid(int uid) {
		for (int index = 0; index < count; index++) {
			if (pbList[index].getUid() == uid) {
				return index;
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
