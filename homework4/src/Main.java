import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private String name;
    private String group;
    private int course;
    private Map<String, Integer> grades;

    public Student(String name, String group, int course) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public void addGrade(String subject, int grade) {
        grades.put(subject, grade);
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (int grade : grades.values()) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public void nextCourse() {
        this.course++;
    }

    public static void removeFailingStudents(List<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3);
        students.forEach(student -> {
            if (student.getAverageGrade() >= 3) {
                student.nextCourse();
            }
        });
    }

    public static void printStudents(List<Student> students, int course) {
        System.out.println("Студенты на курсе " + course + ":");
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }

    public static void main(String[] args) {
        // Создаем коллекцию студентов
        List<Student> students = new ArrayList<>();

        // Добавляем студентов в коллекцию
        students.add(new Student("Иван Иванов", "ИТ-123", 1));
        students.add(new Student("Мария Петрова", "ИТ-123", 2));
        students.add(new Student("Петр Сидоров", "ИТ-123", 1));

        // Добавляем оценки для студентов
        students.get(0).addGrade("Математика", 4);
        students.get(0).addGrade("Физика", 3);
        students.get(1).addGrade("Математика", 5);
        students.get(1).addGrade("Физика", 2);
        students.get(2).addGrade("Математика", 3);
        students.get(2).addGrade("Физика", 3);

        // Печатаем список студентов до обработки
        System.out.println("Список студентов до обработки:");
        for (Student student : students) {
            System.out.println(student.getName() + ", курс: " + student.getCourse() + ", средний балл: " + student.getAverageGrade());
        }

        // Обрабатываем студентов
        removeFailingStudents(students);

        // Печатаем список студентов после обработки
        System.out.println("\nСписок студентов после обработки:");
        for (Student student : students) {
            System.out.println(student.getName() + ", курс: " + student.getCourse() + ", средний балл: " + student.getAverageGrade());
        }

        // Печатаем студентов на 2 курсе
        printStudents(students, 2);
    }
}
