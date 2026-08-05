class Gadget{
    int modelNumber;
    String category;
    int warrantyYears;
    double cost;
    Gadget(int modelNumber, String category, int warrantyYears, double cost){
        this.modelNumber = modelNumber;
        this.category = category;
        this.warrantyYears = warrantyYears;
        this.cost = cost;
    }
}



public class Solution1{

    public static Gadget getGadgetByCategory(Gadget[] gadgets, String category){
        for(int i=0; i<gadgets.length; i++){
            if(gadgets[i].category.equalsIgnoreCase(category)){
                return gadgets[i];
            }
        }
        return null;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Gadget[] gadgets = new Gadget[n];
        for(int i=0; i<n; i++){
            int modelNumber = sc.nextInt();
            String category = sc.next();
            int warrantyYears = sc.nextInt();
            double cost = sc.nextDouble();
            gadgets[i] = new Gadget(modelNumber, category, warrantyYears, cost);
        }
        String category = sc.next();
        Gadget result = getGadgetByCategory(gadgets, category);
        if(result != null){
            System.out.println(result.modelNumber + " " + result.category + " " + result.warrantyYears + " " + result.cost);
        } else {
            System.out.println("No gadget found with the given category");
        }
    }
}