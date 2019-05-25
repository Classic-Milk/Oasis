/*package Tool;
import java.io.*;
import java.util.ArrayList;

import StudentModel.Student;
import UI.Main;
import java.io.IOException;
public class IO {
    public void load(Main main) //读取文件
    {
        try
        {
            String fileName = "E:\\Java Studying\\StudentDatabase.txt";
            File file=new File(fileName);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String temp;
            while((temp=reader.readLine())!=null)
            {
                String studentName=temp.split(",")[0];
                String studentNumberString = temp.split(",")[1];
                String scoreString=temp.split(",")[2];
                long studentNumber=Long.parseLong(studentNumberString);
                float score =Float.parseFloat(scoreString);
                Student student = new Student(studentName,studentNumber,score);
                Main.studentList.add(student);
                Main.studentList.count++;
            }
            reader.close();
        }
    }
}*/
