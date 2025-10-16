import java.util.Scanner;

public class ArrayExercise {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.println("How many students are in the class?");
        int numofstu = input.nextInt();
        float grade[] = new float[numofstu];
        int i = 0;

        for (i=0; i < numofstu; i++) {
            System.out.println("Insira a nota do(a) " + (i + 1) + "° aluno(a): ");
            grade[i] = input.nextFloat();
        }
            float lowGrade = grade[0];
            float bigGrade = grade[0];
            float allGrade = 0;

            for(i=0; i < numofstu; i++){
            if (grade[i]>bigGrade){
                bigGrade = grade[i];
            } else if (grade[i]<lowGrade) {
                lowGrade = grade[i];
            }
           allGrade = grade[i]+allGrade;
        }
        float averageGrade = allGrade/numofstu;
            System.out.println("The biggest grade in the classroom is: "+bigGrade+
                    "\nThe Lowest grade in the classroom is: "+lowGrade+
                    "\nThe average grade of the classroom is: "+averageGrade);
    }
}
