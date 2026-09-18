import java.util.ArrayList; 

 

public class Main { 

public static void main(String[] args) { ArrayList<String> tasks = new ArrayList<>(); 

 

tasks.add("Study calaulus"); tasks.add("Complete assignment"); tasks.add("gym"); 

 

StringBuffer sb = new StringBuffer(); sb.append("To-Do List:\n"); 

for (String task : tasks) { 

sb.append("- ").append(task).append("\n"); 

} 

 

System.out.println(sb); 

} 

} 
