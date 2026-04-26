import java.util.Scanner;

class pro {
    public class student {
        int student_id;
        String name;
        double grad;
        student(String s,int n,double g){
            name=s;
            student_id=n;
            grad=g;
        }
        void show(){
            System.out.println("the name of student is :"+name);
            System.out.println("the id of student is:"+student_id);
            System.out.println("the grad of student is "+grad);
            System.out.println("---------------------------------------------ٍ");

        }
        void addnew_sudent(){
            Scanner input=new Scanner(System.in);
            System.out.print("please enter name:");
            name=input.nextLine();
            System.out.print("please enter id :");
            student_id=input.nextInt();
            System.out.print("please enter grad of student:");
            grad=input.nextDouble();

        }
        void string_opertion(){
            Scanner input=new Scanner(System.in);
            System.out.println("Uppercase : " + name.toUpperCase());
            System.out.println("Lowercase : " + name.toLowerCase());
            System.out.println("Length    : " + name.length());
            System.out.print("Enter a letter to check if name starts with it: ");
            String letter = input.nextLine();
            System.out.println("Starts with '" + letter + "' : " + name.startsWith(letter));
            System.out.print("Enter a substring to check if name contains it: ");
            String sub = input.nextLine();
            System.out.println("Contains '" + sub + "' : " + name.contains(sub));
        }
    }

    public   void main(String[] args) {
        Scanner input=new Scanner(System.in);
student s1=new student("amr gad",1,85.5);
student s2=new student("omer ahmed",2,80);
student s3=new student("ahmed gamel",3,74.5);
student s4=new student("seed ahmed",4,77.8);
student s5=new student("michel isek",5,90.5);
s1.string_opertion();
System.out.println("---------------------------------------------ٍ");
        int result = s1.name.compareTo(s2.name);
        if (result == 0)
            System.out.println("Names are EQUAL.");
        else if (result < 0)
            System.out.println("\"" + s1.name + "\" comes BEFORE \"" + s2.name + "\" alphabetically.");
        else
            System.out.println("\"" + s1.name + "\" comes AFTER \"" + s2.name + "\" alphabetically.");
        System.out.println("---------------------------------------------ٍ");
        int id; int chosse;
        do{
            System.out.println("===============hello=============");
            System.out.println("please choose opetaion:");
            System.out.println("1---> show all student ");
            System.out.println("2---> add new student ");
            System.out.println("3---> scerh about student by using id");
            System.out.println("4---> to exit programe");
            System.out.print("please enter your opetion:");
            chosse=input.nextInt();
            if (chosse==4){
                System.out.println("Exiting system... Thank you");
                break;}
            switch (chosse){
                case 1:
                    s1.show();
                    s2.show();
                    s3.show();
                    s4.show();
                    s5.show();
                    break;
                case 2:
                    student s6=new student("",0,0.0);
                    s6.addnew_sudent();
                    System.out.println("---------------------------------------------ٍ");
                    s6.show();
                    break;
                case 3:
                    System.out.print("please enter id of student :");
                    id=input.nextInt();
                    switch (id){
                        case 1:
                            s1.show();
                            break;
                        case  2:
                            s2.show();
                            break;
                        case  3:
                            s3.show();
                            break;
                        case 4:
                            s4.show();
                            break;
                        case 5:
                            s5.show();
                            break;
                    }break;
            }
        }while (true);
    }
}
