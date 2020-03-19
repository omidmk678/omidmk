public class Run {
    public static void main(String[] args) {
        Lab karga = new Lab(3,"Saturday");
        Student[] students = new Student[3];
        students[0] = new Student("Omid","Mohkamkar","9831056");
        students[0].setGrade(19);
        students[1] = new Student("Seyed","Mirkazemi","9831064");
        students[1].setGrade(18);
        students[2] = new Student("Erfan","Mahvash","9831061");
        students[2].setGrade(20);

        int average = (students[0].getGrade() + students[1].getGrade() + students[2].getGrade())/3;
        karga.setAvg(average);

        for (int i = 0; i < 3;i++){
            karga.enrollStudent(students[i]);
        }
        karga.print();
    }
}
