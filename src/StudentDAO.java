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
 * StudentDAO 클래스
 * 학생관리시스템에서 요구하는 기능을 처리하는 객체를 만드는 클래스
 * ArrayList 콜렉션 이용
 */
public class StudentDAO {
   private Scanner scan;
   private ArrayList<Student> al;      // 학생리스트
   
   private String id;         // 학생 id
   private String name;      // 학생 이름
   private int score;         // 학생 성적
   
   public StudentDAO() {
      scan = new Scanner(System.in);
      al = new ArrayList<Student>();
   }
   
   //1. 등록
   public void insert() {
      System.out.println("학번을 입력");
      id = scan.nextLine();
      
      for(int i = 0; i < al.size(); i++) {
         Student stu = al.get(i);
         if(id.equals(stu.getId())) {
            System.out.println("이미 존재하는 id입니다.");
            return;
         }
      }
      
      System.out.println("이름 입력");
      name = scan.nextLine();
      
      System.out.println("성적을 입력");
      score = Integer.parseInt(scan.nextLine());
      
      Student stu = new Student(id, name, score);
      
      al.add(stu);
   }

   //2. 조회
   public void inqure() {
      for(int i = 0; i <al.size(); i++) {
         System.out.println("ID : " + al.get(i).getId() + " 이름 : " + al.get(i).getName() 
               + " 성적 : " + al.get(i).getScore());
      }
   }

   //3. 수정
   public void update() {
      System.out.println("수정할 ID를 입력");
      id = scan.nextLine().trim();
      
      for(int i = 0; i < al.size(); i++) {
         Student stu = al.get(i);
         if(id.equals(stu.getId())) {
            al.remove(i);
         }else {
            System.out.println("수정할 ID가 없습니다.");
            return;
         }
      }
      
      insert();
   }

   //4. 삭제
   public void delete() {
      System.out.println("삭제할 학생 ID를 입력");
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
         System.out.println("ID가 삭제됨.");
      }else {
         System.out.println("삭제할 ID가 없음");
      }
   }
   //5. 저장
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

   //6. 불러오기
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
    //7.이름순정렬
   public void name() {
      // TODO Auto-generated method stub

      Collections.sort(al,new UserComparator2());

   for(int i=0;i<=al.size();i++){
         System.out.println("ID : " + al.get(i).getId() + " 이름 : " + al.get(i).getName() 
               + " 성적 : " + al.get(i).getScore());
   }
   }
    //8.성적순정력
   public void score() {
      // TODO Auto-generated method stub
   Collections.sort(al,new UserComparator());
   for(int i=0;i<=al.size();i++){
         System.out.println("ID : " + al.get(i).getId() + " 이름 : " + al.get(i).getName() 
               + " 성적 : " + al.get(i).getScore());
   }
   }
}

// 정렬 클래스
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