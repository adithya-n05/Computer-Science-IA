package effortgradepredictor.computerscienceia;

import java.util.Scanner;

public class SubjectController{
    public static String GenerateSubjectName(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Subject Name");
            String subjectNameTemp = sc.nextLine();
            System.out.println("The name you have entered is: " + subjectNameTemp);
            return subjectNameTemp;
        }

    public static Boolean CheckHL(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Is the Subject HL? (Enter \"True\" or \"False\")");
        String isHLTempString = sc.nextLine();
        while (isHLTempString!="True" || isHLTempString=="False"){
            System.out.println("Please enter either \"True\" or \"False\"");
            isHLTempString = sc.nextLine();
        }
        if (isHLTempString=="True"){
            boolean isHL = true;
        }else if(isHLTempString=="False"){
            boolean isHL = false;
        }
        System.out.println("The subject you have entered is: " + isHLTempString);
        return isHL;
        }
}
