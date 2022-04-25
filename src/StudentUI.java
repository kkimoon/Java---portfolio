import java.io.OutputStream;
import java.util.Scanner;
// /* shift + enter
/*
 * �л������ý����� �л������� ���, ��ȸ, ����, ���� ó���� ���� ArrayList�� ������ �ý����̴�.
 * ���� ��� �߰�
 * ����, �ҷ����� ��� �߰�
 * StudentUI, StudentDAO, Student Ŭ������ �����ȴ�.
 * StudentUI Ŭ������ ����ڿ� ����ϴ� ȭ���� ����ϴ� Ŭ�����̴�.
 */
public class StudentUI {
	private Scanner scan;
	private StudentDAO dao;	//�л������ý��ۿ��� �䱸�ϴ� ����� ó���ϴ� ��ü
	
	public StudentUI() {
		scan = new Scanner(System.in);
		dao = new StudentDAO();
	}
	
	//�л������ý����� ����� �����ִ� �޼ҵ�
	private void showUsage() {
		boolean bFlag = true;
		
		while(bFlag) {
			System.out.println("�л������ý��� ��� ���");
			System.out.println("1.���, 2.��ȸ, 3. ����, 4.����");
			System.out.println("5.����, 6.�ҷ�����, 7.�̸�������, 8.����������, 0.����");
			
			String menu = scan.nextLine();
			if(menu.equals("0") == true) {
				System.out.println("����");
				bFlag = false;
				return;
			}else {
				getInput(menu);
			}
		}
	}
	
	//����ڷκ��� �Է¹޴� �κ�
	private void getInput(String strMenu) {
		if(strMenu.equals("1") == true) {
			System.out.println("���");
			
			dao.insert();
		}
		else if(strMenu.equals("2") == true) {
			System.out.println("��ȸ");
			
			dao.inqure();
		}
		else if(strMenu.equals("3") == true) {
			System.out.println("����");
			
			dao.update();
			
		}
		else if(strMenu.equals("4") == true) {
			System.out.println("����");
			
			dao.delete();
			
		}

		else if(strMenu.equals("5") == true) {
			dao.save();
			System.out.println("���� �Ϸ�!!");
		}
		
		else if(strMenu.equals("6") == true) {
			System.out.println("��ϵ� �л� ������ �ҷ�����");
			dao.invoke();
		}
		
		else if(strMenu.equals("7") == true) {
			System.out.println("�̸������� ������ �ҷ�����");
			dao.name();
		}
		
		else if(strMenu.equals("8") == true) {
			System.out.println("���������� ������ �ҷ�����");
			dao.score();
		}
	}

	public static void main(String[] args) {
		StudentUI sui = new StudentUI();
		sui.showUsage();
	}
}
