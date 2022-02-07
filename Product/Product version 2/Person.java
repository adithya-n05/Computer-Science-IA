package effortgradepredictor.computerscienceia;

import java.util.*;

public class Person {
    private int id;
    private String firstName;
    private String lastName;

    public Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }    

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public int calculateID(ArrayList<Integer> idnumbers){
        if (idnumbers.isEmpty() == true){
        int lastid = 1;
        idnumbers.add(1);
        return lastid;
        }
        int size = idnumbers.size();
        sort(idnumbers, 0, idnumbers.size()-1);
        int lastid = idnumbers.get(size-1);
        return lastid+1;
    }
    
    int partition(ArrayList<Integer> arrayinput, int low, int high)
    {
        int pivot = arrayinput.get(high); 
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (arrayinput.get(j) <= pivot)
            {
                i++;
                int temp = arrayinput.get(i);
                arrayinput.set(i, arrayinput.get(j));
                arrayinput.set(j, temp);
            }
        }

        int temp = arrayinput.get(i+1);
        arrayinput.set(i+1, arrayinput.get(high));
        arrayinput.set(high, temp);
  
        return i+1;
    }
  
    public void sort(ArrayList<Integer> arrayinput, int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arrayinput, low, high);
  
            sort(arrayinput, low, pi-1);
            sort(arrayinput, pi+1, high);
        }
    }
    
    public void changeID(ArrayList<Integer> idnumbers, int id){
        int temp = id;
        sort(idnumbers, 0, idnumbers.size()-1);
        Scanner sc = new Scanner(System.in);
        boolean searchfound = false;
        while (searchfound == false){
        for (int i =0; i<idnumbers.size(); i++){
            if (idnumbers.get(i) == temp){
                searchfound = true;
                System.out.println("ID matched. Please input new ID for this student. Please only enter an integer.");
                String inputString = sc.nextLine();
                boolean inputerror = true;
                int input = 0;
                while (inputerror==true){
                    try {
                    input = Integer.parseInt(inputString); 
                    System.out.println("Thank you for the valid input.");
                    inputerror=false;
                    }catch(NumberFormatException e) {
                    System.out.println("The input id is not an integer. Please enter an integer value for the ID."); 
                    }
                }
                System.out.println("Changing ID...");
                idnumbers.set(i, input);
                System.out.println("The ID was changed successfully.");
                return;
            }
        }
        System.out.println("The ID you have searched for was not found. Please enter another ID.");
        String inputString = sc.nextLine();
        boolean inputerror2 = true;
        temp = 0;
        while (inputerror2==true){
            try {
            temp = Integer.parseInt(inputString); 
            System.out.println("Thank you for the valid input.");
            inputerror2=false;
            }catch(NumberFormatException e) {
            System.out.println("The input id is not an integer. Please enter an integer value for the ID."); 
            }
        }
        }
                    
        }
    }
