import java.io.OutputStream;
import java.util.Scanner;
// /* shift + enter
/*
 * 학생관리시스템은 학생정보를 등록, 조회, 수정, 삭제 처리를 위해 ArrayList로 구성한 시스템이다.
 * 정렬 기능 추가
 * 저장, 불러오기 기능 추가
 * StudentUI, StudentDAO, Student 클래스로 구성된다.
 * StudentUI 클래스는 사용자와 대면하는 화면을 담당하는 클래스이다.
 */
public class StudentUI {
	private Scanner scan;
	private StudentDAO dao;	//학생관리시스템에서 요구하는 기능을 처리하는 객체
	
	public StudentUI() {
		scan = new Scanner(System.in);
		dao = new StudentDAO();
	}
	
	//학생관리시스템의 기능을 보여주는 메소드
	private void showUsage() {
		boolean bFlag = true;
		
		while(bFlag) {
			System.out.println("학생관리시스템 사용 방법");
			System.out.println("1.등록, 2.조회, 3. 수정, 4.삭제");
			System.out.println("5.저장, 6.불러오기, 7.이름순정렬, 8.성적순정렬, 0.종료");
			
			String menu = scan.nextLine();
			if(menu.equals("0") == true) {
				System.out.println("종료");
				bFlag = false;
				return;
			}else {
				getInput(menu);
			}
		}
	}
	
	//사용자로부터 입력받는 부분
	private void getInput(String strMenu) {
		if(strMenu.equals("1") == true) {
			System.out.println("등록");
			
			dao.insert();
		}
		else if(strMenu.equals("2") == true) {
			System.out.println("조회");
			
			dao.inqure();
		}
		else if(strMenu.equals("3") == true) {
			System.out.println("수정");
			
			dao.update();
			
		}
		else if(strMenu.equals("4") == true) {
			System.out.println("삭제");
			
			dao.delete();
			
		}

		else if(strMenu.equals("5") == true) {
			dao.save();
			System.out.println("저장 완료!!");
		}
		
		else if(strMenu.equals("6") == true) {
			System.out.println("등록된 학생 데이터 불러오기");
			dao.invoke();
		}
		
		else if(strMenu.equals("7") == true) {
			System.out.println("이름순으로 데이터 불러오기");
			dao.name();
		}
		
		else if(strMenu.equals("8") == true) {
			System.out.println("성적순으로 데이터 불러오기");
			dao.score();
		}
	}

	public static void main(String[] args) {
		StudentUI sui = new StudentUI();
		sui.showUsage();
	}
}
