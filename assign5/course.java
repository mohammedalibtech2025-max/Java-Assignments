import java.util.ArrayList; import java.util.Scanner; 

 

public class course { 

public static void main(String[] args) { ArrayList<String> courses = new ArrayList<>(); Scanner sc = new Scanner(System.in); 

 

courses.add("Java"); courses.add("DBMS"); courses.add("Operating System"); 

 

courses.remove("DBMS"); 

 

StringBuffer sb = new StringBuffer(); sb.append("Registered Courses:\n"); 

 for (String course : courses) { sb.append(course).append("\n"); 

} 

 

System.out.println(sb); 

 

sc.close(); 

} 

} 