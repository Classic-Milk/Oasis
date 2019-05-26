package StudentModel;

public class Student {
    private String studentName; //学生的姓名
    private long studentNumber; //学生的学号
    private float score; //学生的成绩

    //Student类的构造函数，用于在定义一个新的Student对象时，对对象进行初始化
    //`此构造函数应为public，否则在外部无法新建Student类
    public Student(String studentName, long studentNumber, float score)
    {
        //将参数分别赋给新定义的Student对象
        this.studentName=studentName;
        this.studentNumber=studentNumber;
        this.score=score;
    }

    //获取各个数据成员的值
    public String getStudentName() //获取学生的姓名
    {
        return studentName;
    }

    public long getStudentNumber() //获取学生的学号
    {
        return studentNumber;
    }

    public float getScore() //获取学生的成绩
    {
        return score;
    }

    //对Student对象进行重新设定
    public void setStudent(String studentName,long studentNumber,float score)
    {
        //将新输入的参数分别赋给已定义的Student对象
        this.studentName=studentName;
        this.studentNumber=studentNumber;
        this.score=score;
    }
}
