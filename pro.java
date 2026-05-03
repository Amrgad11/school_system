import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class project {
    class student {
        int student_id;
        String name;
        double grad;

        student(String s, int n, double g) {
            name = s;
            student_id = n;
            grad = g;
        }

        void show() {
            System.out.println("the name of student is :" + name);
            System.out.println("the id of student is:" + student_id);
            System.out.println("the grad of student is " + grad);
            System.out.println("---------------------------------------------");
        }

        void addnew_sudent() {
            Scanner input = new Scanner(System.in);
            System.out.print("please enter name:");
            name = input.nextLine();
            System.out.print("please enter id :");
            student_id = Integer.parseInt(input.nextLine().trim());
            System.out.print("please enter grad of student:");
            grad = Double.parseDouble(input.nextLine().trim());

            try {
                FileWriter fw = new FileWriter("data.txt", true);
                fw.write("\n" + name + "," + student_id + "," + grad);
                fw.close();
                System.out.println("Student saved to file.");
            } catch (IOException e) {
                System.out.println("Error saving to file: " + e.getMessage());
            }
        }
    }

    student[] students = new student[100];
    int count = 0;

    void loadFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            String line;
            while ((line = br.readLine()) != null && count < students.length) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0].trim();
                    int id = Integer.parseInt(parts[1].trim());
                    double grad = Double.parseDouble(parts[2].trim());
                    students[count] = new student(name, id, grad);
                    count++;
                }
            }
            br.close();
            System.out.println("Data loaded: " + count + " students.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    void run() {
        Scanner input = new Scanner(System.in);

        loadFromFile();
        int id;
        int chosse;
        do {
            System.out.println("===============hello=============");
            System.out.println("please choose opetaion:");
            System.out.println("1---> show all student ");
            System.out.println("2---> add new student ");
            System.out.println("3---> scerh about student by using id");
            System.out.println("4---> to exit programe");
            System.out.print("please enter your opetion:");
            chosse = Integer.parseInt(input.nextLine().trim());
            if (chosse == 4) {
                System.out.println("Exiting system... Thank you");
                break;
            }
            switch (chosse) {
                case 1:
                    for (int i = 0; i < count; i++) {
                        students[i].show();
                    }
                    break;
                case 2:
                    if (count < students.length) {
                        students[count] = new student("", 0, 0.0);
                        students[count].addnew_sudent();
                        System.out.println("---------------------------------------------");
                        students[count].show();
                        count++;
                    } else {
                        System.out.println("Array is full.");
                    }
                    break;
                case 3:
                    System.out.print("please enter id of student :");
                    id = Integer.parseInt(input.nextLine().trim());
                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (students[i].student_id == id) {
                            students[i].show();
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                        System.out.println("Student not found.");
                    break;
            }
        } while (true);
    }

    public static void main(String[] args) {
        project p = new project();
        p.run();
    }
}
