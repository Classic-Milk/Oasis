package UI;
import java.util.ArrayList; //引入动态数组ArrayList
import java.util.Scanner; //引入Scanner
import StudentModel.Student; //引入Student类

public class Main {

    public ArrayList studentList = new ArrayList(); //⭐定义一个ArrayList类的可动态变化的数组，用于存储Student对象
    public int count = 0; //用于管理系统中学生总数的计数

    public Main() //Main类的构造函数，新建Main类时会自动执行
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("——欢迎来到⭐金渴啦⭐的学生管理系统——");
        System.out.println("⭐Made by Classic·King⭐\n");
        System.out.println("输入对应数字后按回车键即可进行操作：");

        while(true)
        {
            menu();
            if(count==0)
                System.out.println("目前系统中没有学生，请添加学生！");
            int choice=scanner.nextInt();
            if(choice==5) {
                System.out.println("成功退出系统！哔哩哔哩干杯！[]~(￣▽￣)~*");
            break; //这里的break作用是跳出while循环，即程序运行结束
            }

                switch (choice) {
                    case 1:
                        addStudent();
                        break; //break表示相应操作完毕后跳出switch循环，执行下一次while循环
                    case 2:
                        deleteStudent();
                        break;
                    case 3:
                        changeStudent();
                        break;
                    case 4:
                        findStudent();
                        break;
                    default:
                        System.out.println("输入错误！\n");
                        continue; //这里的continue作用是，当输入的数字不正确时，重新执行switch语句
                }
        }

    }

    void addStudent() //添加学生
    {
        Scanner scanner = new Scanner(System.in); //定义一个Scanner对象，使用Scanner对象中的函数可以实现从键盘中获取值
        System.out.println("当前系统中共有"+count+"名学生。");
        System.out.println("请输入学生的姓名：");
        String studentName = scanner.next();
        System.out.println("请输入学生的学号：");
        long studentNumber = scanner.nextLong();
        System.out.println("请输入学生的成绩");
        int score = scanner.nextInt();
        Student student = new Student(studentName,studentNumber,score);
        studentList.add(student); //ArrayList类中的方法，可以将Student对象存储于数组中
        count++; //因为增加了一个学生，所以计数要加一
        System.out.println("学生添加成功！\n");
        printAllStudent();
    }

    void deleteStudent() //删除学生
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入通过哪种方式删除学生：");
        System.out.println("序号       …… 1");
        System.out.println("姓名       …… 2");
        System.out.println("学号       …… 3");
        System.out.println("返回主菜单 …… 4");
        int choice = scanner.nextInt(); //用choice存储用户的选择

        //为了之后能够使用break语句，这里要写while语句，条件始终为真
        while (true) {
            if (choice == 1) {
                System.out.println("请输入要删除第几个学生：");
                int orderNumber = scanner.nextInt(); //用orderNumber存储用户的选择
                orderNumber = findByOrder(orderNumber);

                if (orderNumber > -1) {
                    studentList.remove(orderNumber); //通过ArrayList中的函数删除数组中的元素
                    count--;
                    System.out.println("学生删除成功！\n");
                    printAllStudent();
                } else {
                    System.out.println("输入错误！请检查你输入的序号是否存在！");
                }
            } else if (choice == 2) {
                System.out.println("请输入你要删除的书名：");
                String studentName = scanner.next();
                int orderNumber = findByName(studentName);
                if (orderNumber > -1) {
                    studentList.remove(orderNumber);
                    count--;
                    System.out.println("学生删除成功！\n");
                    printAllStudent();
                } else {
                    System.out.println("未查找到该学生！请确认姓名输入无误！");
                }

            } else if (choice == 3) {
                System.out.println("请输入你要删除的学生的学号");
                long studentNumber = scanner.nextLong();
                int orderNumber = findByStudentNumber(studentNumber);
                if(orderNumber>-1){
                    studentList.remove(orderNumber);
                    count--;
                    System.out.println("学生删除成功！\n");
                    printAllStudent();
                } else {
                System.out.println("未查找到该学生！请确认学号输入无误！"); }}
                else if(choice==4)
                {
                    printAllStudent();
                    break;
                }
                else
                    {
                        System.out.println("输入错误！");
                        break;
                    }
            }

        }


    void changeStudent() //修改学生信息
    {
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            System.out.println("请输入通过哪种方式查找学生并修改学生信息：");
            System.out.println("序号       …… 1");
            System.out.println("姓名       …… 2");
            System.out.println("学号       …… 3");
            System.out.println("返回主菜单 …… 4");
            int choice=scanner.nextInt();
            if(choice==1)
            {
                System.out.println("请输入要修改第几个学生：");
                int orderNumber=scanner.nextInt();
                orderNumber=findByOrder(orderNumber);
                if(orderNumber>-1)
                {
                    Student student=(Student)studentList.get(orderNumber);
                    System.out.println("该学生姓名为："+student.getStudentName());
                    System.out.println("请输入修改后的姓名：");
                    String studentName=scanner.next();
                    System.out.println("请输入修改后的学号：");
                    long studentNumber=scanner.nextLong();
                    System.out.println("请输入修改后的成绩：");
                    float score=scanner.nextInt();
                    student.setStudent(studentName,studentNumber,score);
                    System.out.println("学生修改成功！");
                    printAllStudent();
                }
                else
                    {
                        System.out.println("输入错误！请确认输入的序号无误！");
                    }
            }
            else if(choice==2) {
                System.out.println("请输入要修改的学生的姓名：");
                String name = scanner.next();
                int orderNumber = findByName(name);
                if (orderNumber > -1) {
                    Student student = (Student) studentList.get(orderNumber);
                    System.out.println("该学生姓名为：" + student.getStudentName());
                    System.out.println("请输入修改后的姓名：");
                    String studentName = scanner.next();
                    System.out.println("请输入修改后的学号：");
                    long studentNumber = scanner.nextLong();
                    System.out.println("请输入修改后的成绩：");
                    float score = scanner.nextInt();
                    student.setStudent(studentName, studentNumber, score);
                    System.out.println("学生修改成功！");
                    printAllStudent();
                } else {
                    System.out.println("未找到匹配姓名的学生！请确认输入的姓名无误！");
                }
            }
            else if (choice==3)
            {
                System.out.println("请输入要修改的学生的学号：");
                long number=scanner.nextLong();
                int orderNumber=findByStudentNumber(number);
                if (orderNumber > -1) {
                    Student student = (Student) studentList.get(orderNumber);
                    System.out.println("该学生姓名为：" + student.getStudentName());
                    System.out.println("请输入修改后的姓名：");
                    String studentName = scanner.next();
                    System.out.println("请输入修改后的学号：");
                    long studentNumber = scanner.nextLong();
                    System.out.println("请输入修改后的成绩：");
                    float score = scanner.nextInt();
                    student.setStudent(studentName, studentNumber, score);
                    System.out.println("学生修改成功！");
                    printAllStudent();
                } else {
                    System.out.println("未找到匹配学号的学生！请确认输入的学号无误！");
                }
            }
            else if(choice==4)
            {
                printAllStudent();
                break;
            }
            else
                {
                    System.out.println("输入错误！");
                    break;
                }

        }

    }

    void findStudent()
    {
        Scanner scanner=new Scanner(System.in);
        while(true)
        {
            System.out.println("请输入按哪种方法查找学生：");
            System.out.println("序号       …… 1");
            System.out.println("姓名       …… 2");
            System.out.println("学号       …… 3");
            System.out.println("返回主菜单 …… 4");
            int choice=scanner.nextInt();
            if(choice==1) {
                System.out.println("请输入要查找第几个学生：");
                int orderNumber = scanner.nextInt();
                orderNumber = findByOrder(orderNumber);
                if (orderNumber > -1) {
                    Student student = (Student) studentList.get(orderNumber);
                    System.out.println("你要查找的学生姓名为：" + student.getStudentName() + " 学号：" + student.getStudentNumber() + " 成绩：" + student.getScore());
                } else {
                    System.out.println("输入错误！请检查你输入的序号是否正确！");
                }
            }
            else if(choice==2)
            {
                System.out.println("请输入要查找的学生的姓名：");
                String studentName=scanner.next();
                int orderNumber=findByName(studentName);
                if(orderNumber>-1)
                {
                    Student student=(Student)studentList.get(orderNumber);
                    System.out.println("你要查找的学生姓名为：" + student.getStudentName() + " 学号：" + student.getStudentNumber() + " 成绩：" + student.getScore());
                }
                else {
                    System.out.println("未找到匹配姓名的学生！请检查你输入的姓名是否正确！");
                }
            }
            else if(choice==3)
            {
                System.out.println("请输入要查找的学生的学号：");
                long studentNumber=scanner.nextLong();
                int orderNumber=findByStudentNumber(studentNumber);
                if(orderNumber>-1)
                {
                    Student student=(Student)studentList.get(orderNumber);
                    System.out.println("你要查找的学生姓名为：" + student.getStudentName() + " 学号：" + student.getStudentNumber() + " 成绩：" + student.getScore());
                }
                else {
                    System.out.println("未找到匹配学号的学生！请检查你输入的学号是否正确！");
                }
            }
            else if(choice==4)
            {
                printAllStudent();
                break;
            }
            else{
                System.out.println("输入错误！");
                break;
            }
        }
    }

    void printAllStudent() //显示目前存储的所有学生
    {
        System.out.println("目前系统中的学生为：");
        for(int i = 0 ; i < count ; i++) //通过for循环依次打印学生
        {
            Student student = (Student)studentList.get(i); //定义一个Student对象，并将studentList数组中的第(i+1)个Student类的元素赋给它
            //依次获取该学生的姓名、学号、成绩并输出
            System.out.println("序号 "+(i+1)+" ⭐ "+" 姓名："+student.getStudentName()+"  学号："+student.getStudentNumber()+"   成绩："+student.getScore());
        }
    }

    int findByStudentNumber(long studentNumber) //通过学号找到学生
    {
        int orderNumber=-1;
        for(int i = 0; i<count;i++)
        {
            Student student=(Student)studentList.get(i); //定义一个Student对象，并将studentList数组中的第(i+1)个Student类的元素赋给它
            if(student.getStudentNumber()==studentNumber) //通过for循环依次比较输入的学号与列表中学生的学号是否匹配
            {
                orderNumber=i;
                break;
            }
            else if(i<count)
            {continue;} //只要i小于count,都可以继续for循环，判断下一个学生的学号是否匹配
        else
            {
                System.out.println("未查找到该学生！请确认学号输入无误！"); //当i等于count时，说明列表中所有学生的学号都不匹配用户输入的学号
            break;
            }
        }
        return orderNumber;
    }

    int findByOrder(int order) //通过序号找到学生
    {
        if(order <= count)
        {
            int ordinalNumber = order - 1;
            return ordinalNumber;
        }
        else return -1 ;
    }

    int findByName(String Name) //通过姓名找到学生
    {
        int orderNumber = -1;
        for(int i = 0;i<count;i++)
        {
            Student student=(Student)studentList.get(i); //定义一个Student对象，并将studentList数组中的第(i+1)个Student类的元素赋给它
            if(student.getStudentName().equals(Name)) //通过for循环依次比较输入的姓名与列表中学生的姓名是否匹配
            {
                orderNumber=i;
                break;
            }
            else if (i<count)
            { continue; } //只要i小于count，都可以继续for循坏，判断下一个学生的姓名是否匹配
            else
            {
                System.out.println("未查找到该学生！请确认姓名输入无误！"); //当i等于count时，说明列表中所有学生的姓名都不匹配用户输入的姓名
                break;
            }

        }
        return orderNumber; //返回orderNumber的结果
    }

    void menu() //显示菜单界面
    {
        System.out.println("");
        System.out.println("添加学生     …… 1");
        System.out.println("删除学生     …… 2");
        System.out.println("修改学生信息 …… 3");
        System.out.println("查询学生信息 …… 4");
        System.out.println("退出系统     …… 5\n");
    }

    //程序主函数的入口
    public static void main(String[] args) {

        new Main(); //新建Main类，目的是执行Main类的构造函数

    }
}
