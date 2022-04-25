import java.io.Serializable;

/*
 * Student Ŭ����
 * �л� ������ ������ �ϳ��� Student �������� ��ü�� �ȴ�.
 */
public class Student implements Comparable<Student>, Serializable{
	private String id;		//�й�
	private String name;	//�̸�
	private int score;		//�ڹ� ����

	public Student(String id, String name, int score) {
		this.id = id;
		this.name = name;
		this.score = score;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String toString() {
		return id+":"+name+":"+score;
	}
	
	public boolean equals(Student stu) {
		boolean result = false;
		if(id.equals(stu.id))
			return true;
		
		return result;
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return name.compareTo(o.name);
	}


}
