import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

/*
 * StudentDAO Ŭ����
 * �л������ý��ۿ��� �䱸�ϴ� ����� ó���ϴ� ��ü�� ����� Ŭ����
 * ArrayList �ݷ��� �̿�
 */
public class StudentDAO {
   private Scanner scan;
   private ArrayList<Student> al;      // �л�����Ʈ
   
   private String id;         // �л� id
   private String name;      // �л� �̸�
   private int score;         // �л� ����
   
   public StudentDAO() {
      scan = new Scanner(System.in);
      al = new ArrayList<Student>();
   }
   
   //1. ���
   public void insert() {
      System.out.println("�й��� �Է�");
      id = scan.nextLine();
      
      for(int i = 0; i < al.size(); i++) {
         Student stu = al.get(i);
         if(id.equals(stu.getId())) {
            System.out.println("�̹� �����ϴ� id�Դϴ�.");
            return;
         }
      }
      
      System.out.println("�̸� �Է�");
      name = scan.nextLine();
      
      System.out.println("������ �Է�");
      score = Integer.parseInt(scan.nextLine());
      
      Student stu = new Student(id, name, score);
      
      al.add(stu);
   }

   //2. ��ȸ
   public void inqure() {
      for(int i = 0; i <al.size(); i++) {
         System.out.println("ID : " + al.get(i).getId() + " �̸� : " + al.get(i).getName() 
               + " ���� : " + al.get(i).getScore());
      }
   }

   //3. ����
   public void update() {
      System.out.println("������ ID�� �Է�");
      id = scan.nextLine().trim();
      
      for(int i = 0; i < al.size(); i++) {
         Student stu = al.get(i);
         if(id.equals(stu.getId())) {
            al.remove(i);
         }else {
            System.out.println("������ ID�� �����ϴ�.");
            return;
         }
      }
      
      insert();
   }

   //4. ����
   public void delete() {
      System.out.println("������ �л� ID�� �Է�");
      id = scan.nextLine();
      
      boolean found = false;
      int tempIndex = 0;
      
      for(int i = 0; i < al.size(); i++) {
         Student stu = al.get(i);
         if(id.equals(stu.getId())) {
            found = true;
            tempIndex = i;
         }
      }
      if(found) {
         al.remove(tempIndex);
         System.out.println("ID�� ������.");
      }else {
         System.out.println("������ ID�� ����");
      }
   }
   //5. ����
   public void save() {
      OutputStream out = null;
      ObjectOutputStream oos = null;
      
      try {
         out = new FileOutputStream("member.txt");
         oos = new ObjectOutputStream(out);
         oos.writeObject(al);
      }catch(FileNotFoundException e) {
         e.printStackTrace();
      }catch(IOException e) {
         e.printStackTrace();
      }finally {
         if(out != null) {
            try {
               out.close();
            }catch(Exception e) {}
         }
         
         if(oos != null) {
            try {
               oos.close();
            }catch(Exception e) {}
         }
      }
   }

   //6. �ҷ�����
   public void invoke() {
      InputStream in = null;
      ObjectInputStream ois = null;
      ArrayList<Student> list = null;
      
      try {
         in = new FileInputStream("member.txt");
         ois = new ObjectInputStream(in);
         list = (ArrayList<Student>) ois.readObject();
         
         Iterator it = list.iterator();
         while(it.hasNext()) {
            System.out.println(it.next());
         }
         
      }catch(FileNotFoundException e) {
         e.printStackTrace();
      }catch(ClassNotFoundException e) {
         e.printStackTrace();
      }catch(IOException e) {
         e.printStackTrace();
      }finally {
         if(in != null) {
            try {
               in.close();
            }catch(Exception e) {}
         }
         
         if(ois != null) {
            try {
               ois.close();
            }catch(Exception e) {}
         }
      }
   }
    //7.�̸�������
   public void name() {
      // TODO Auto-generated method stub

      Collections.sort(al,new UserComparator2());

   for(int i=0;i<=al.size();i++){
         System.out.println("ID : " + al.get(i).getId() + " �̸� : " + al.get(i).getName() 
               + " ���� : " + al.get(i).getScore());
   }
   }
    //8.����������
   public void score() {
      // TODO Auto-generated method stub
   Collections.sort(al,new UserComparator());
   for(int i=0;i<=al.size();i++){
         System.out.println("ID : " + al.get(i).getId() + " �̸� : " + al.get(i).getName() 
               + " ���� : " + al.get(i).getScore());
   }
   }
}

// ���� Ŭ����
class UserComparator implements Comparator<al>{
   @Override
   public int compare(al a,al b){
      if(a.score>b.score) return 1;
      if(a.score<b.score) return -1;
      return 0;
   }
}

class UserComparator2 implements Comparator<al>{
   @Override
   public int compare(al a,al b){
      if(a.name>b.name) return 1;
      if(a.name<b.name) return -1;
      return 0;
   }
}