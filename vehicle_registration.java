import java.util.Scanner;
import java.lang.Math;

/*to do:
put working display functions in classes rather than empty
Please send help I am in misery right now
*/

interface details {
    void display();
    String city = "Manipal";
    String code ="KA20"; 
    Scanner dis = new Scanner(System.in);
    int max = 15;
    User[] list = new User[max];

}
class User implements details {
    char[] arr = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    static int a = -1;
    static int b = 0;
 
    int agency;
    String insurancenumplate;
    String name;
    int idno=1;
    String vehiclemodel;
    String vehicletype;
    int numberplate;
    String finalnumberplate;
    int price;
    int tax;
    int pay;
    User() {
        a++;
        b++;
        idno++;
    }
    void form_filling() { 
        System.out.println("\nEnter your name: ");
        name = dis.next();
        System.out.println("\nEnter the name of the agency:\n1. AUTONOMOUS BODY\n2. CENTRAL GOVERNMENT\n3. CHARITABLE TRUST\n4. DRIVING TRAINING SCHOOL\n5. DIVYANGJAN\n6. EDUCATIONAL INSTITUTE\n7. FIRM\n8. GOVERNMENT UNDERTAKING\n9. INDIVIDUAL\n10. LOCAL AUTHORITY\n11. MULTIPLE OWNER\n12. OTHERS\n13. POLICE DEPARTMENT\n14. STATE GOVERNMENT\n15. STATE TRANSPORT CORPORATION OR DEPARTMENT] ");
        agency = dis.nextInt();
        System.out.println("\nEnter the vehicle model: ");
        vehiclemodel = dis.next();
        System.out.println("\nEnter the type of the vehicle: \nLMV (Light Motor Vehicle)\nMCWG (Motor Cycle With Gear) \nMCWOG (Motor Cycle Without Gear/ Scooter) \nHMV (Heavy Motor Vehicle) ");
        vehicletype = dis.next();
        System.out.println("\nEnter the off-road price of your vehicle: ");
        price = dis.nextInt();
        tax = (int)(0.12*price);
        numberplate = (int)(Math.random() * 10000);
        String str = Integer.toString(numberplate);
        finalnumberplate = code + arr[a] + arr[b] + numberplate;
        if(a==24 || b==24) {
            a=0;
            b=-1;
        }
        payment_details();
        System.out.println("\nYour Number Plate is "+finalnumberplate);
        
    }
    void payment_details() {
        System.out.println("\nEnter the method of Payment - 1. UPI, 2. Bank Transfer ");
        pay = dis.nextInt();
        System.out.println("\nTotal amount due for registration is Rs."+tax);
        if(pay==1) {
           System.out.println("\nPay the amount to - UPI ID: manipalrto@upi");
            
        }
        else if(pay==2) {
            System.out.println("\nPay the amount to -\nCANARA BANK, GROUND FLOOR,\nPAVITHRA RESIDENCY OPP:MIT MANIPAL KARKALA MAIN ROAD,\nMANIPAL-576104 KA\nIFSC Code CNRB0003085");
        }
        else {
            System.out.println("\nInvalid Input!");
        }
        
    }

    
        

    
    int insurance(User ob[], int total){
        String type=" ";
        System.out.println("Enter your Insurance Agency: ");
        System.out.println("1)New India Assurance\n2)National Insurance\n3)Bajaj Allianz");
        agency = dis.nextInt();
        switch(agency){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
            System.out.println("Invalid Agency");
                return 0;
        }
        System.out.println("Enter License Plate number:");
        insurancenumplate=dis.next();
        for(int i=0; i<total; i++){
            if(ob[i].finalnumberplate.equalsIgnoreCase(insurancenumplate)){
                type = ob[i].vehicletype;
            }
        }

            switch(type){
                case "LMV":
                    System.out.println("Annual Payment: Rs.20000");
                    break;
                case "MCWG":
                    System.out.println("Annual Payment: Rs.15000");
                    break;
                case "MCWOG":
                    System.out.println("Annual Payment: Rs. 10000");
                    break;    
                case "HMV":
                    System.out.println("Annual Payment: Rs. 50000");
                    break;
                case " ":
                    System.out.println("Number plate not found");
                    break;
            }
            return 1;

    }
    void contact_us(){
        System.out.println("Call the Toll-Free Number 0124-458458 or Email us at karanata_rto@gov.in");
    }
    
    public void display() {
        return;
    }
    }



class admin implements details{

    User[] obj = new User[max];
    int i, j, total=0, ch=0;
    public void display(){return;}

    admin(User ob[], int totalobj){
        for(i=0; i<totalobj; i++){
            obj[i]=ob[i];
        }
        total = totalobj;
    }
    

    void display(User ob){
        System.out.println("Name: "+ob.name+"\nVehicle Type: "+ob.vehicletype+"\nNumber Plate: "+ob.finalnumberplate+"\noffroad price: "+ob.price+"\n");
    }

    void ask(){
        while(ch!=4){
            System.out.println("enter 1 for variable search \nenter 2 for data analysis \nenter 3 to delete application \nenter 4 to exit");
            ch = dis.nextInt();
            if(ch==1){
                asksearch();
            }
            else if(ch==2){
                data();
            }
            else if(ch==3){
                findEntry();
            }
        }
    }

    void data(){
        System.out.println("\nregistered users:");
        for(i=0; i<total; i++){
            display(obj[i]);
        }
        
        User max = new User();
        max = obj[0];
        for(i=0; i<total; i++){
            if(max.price<obj[i].price) max = obj[i];
        }
        System.out.println("\nmaximum offroad price: \n");
        display(max);
    }
    
    void asksearch(){

        while(ch!=3){
        
            System.out.println("enter 1 to search car types \nenter 2 to search number plate \nenter 3 to enter to previous menu");
            String t;
            String n;
            ch = dis.nextInt();
            if(ch==1){
                System.out.println("enter type to be searched: ");
                t = dis.next();
                types(t);
            } 
            else if(ch==2){
                System.out.println("enter number to be searched: ");
                n = dis.next();
                number(n);               
            }
            else if(ch!=3) System.out.println("invalid choice");
        }
    }

    void types(String type){
        for(i=0; i<total; i++){
            if(obj[i].vehicletype.equalsIgnoreCase(type)) display(obj[i]);
        }
    }

    void number(String number){
        int i;
        for(i=0; i<total; i++){
            if(number.equalsIgnoreCase(obj[i].finalnumberplate)) display(obj[i]);
        }
    }

    void findEntry(){
        System.out.println("enter numberplate of entry to be deleted: ");
        String number;
        number = dis.next();
        for(i=0; i<total; i++){
            if(obj[i].finalnumberplate.equalsIgnoreCase(number)) deleteEntry(obj[i]);
        }
    } 

    void deleteEntry(User ob){
        if(obj[total-1]==ob) total--;
        else{
            for(i=0; i<total-1; i++){
                if(obj[i]==ob){
                    for(j=i; j<total-2; j++){
                        obj[j] = obj[j+1];
                    }
                }
            }
            total--;
        }
    }
}
public class vehicle_registration {
    public static void main(String args[]) {

        String password = "password";
        String enteredpass = " ";

        Scanner sc = new Scanner(System.in);
        int inp;
        int index=0;
        User[] obj1 = new User[15];
        User obj3 = new User();

        do {
            System.out.println("1.User\n2.Admin\n3.Exit");
            inp = sc.nextInt();
                if(inp==1) {
                int ch=0;
                while(ch!=4){
                    System.out.println("\n1. Register your vehicle\n2. Contact Us\n3. Insurance\n4. Exit");
                    ch = sc.nextInt();
                    if(ch==1){
                        obj1[index] = new User();
                        obj1[index].form_filling();
                        index++;
                    }
                    if(ch==2){
                        obj3.contact_us();
                    }
                    if(ch==3){
                        obj3.insurance(obj1, index);
                    }
                }
            }
            else if(inp==2){
                System.out.println("enter password for admin: ");
                enteredpass = sc.next();
                if(enteredpass.equals(password)){
                    admin obj2 = new admin(obj1, index);
                    obj2.ask();
                }
            }
            else if(inp==3) {
                System.out.println("Thanks for visiting! Have a great day!");
                break;
            }
            else {
                System.out.println("Invalid Input!");
            }
        }while(inp!=3);
    }
}
