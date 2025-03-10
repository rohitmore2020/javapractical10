    public class displaygrid{
        
       public static void DisplayGrid( String[][] layout){
        int a=0;
         for(int j =0; j<layout.length; j++){
         for(int i=0; i<layout.length; i++){
         System.out.print(" ");
         System.out.print("- -");
         }
         System.out.println();
         int b=0;
         for(int i=0; i<layout.length+1; i++){
         System.out.print("|");
         if(i < layout.length){
         System.out.print(layout[a][b]);
         b = (b+1)%layout.length;
        }
          }
         System.out.println();
         a = a+1;
         }
         for(int i=0; i<layout.length; i++){
         System.out.print(" ");
         System.out.print("- -");
         }
     }

    public static String[][] getlayout(int size){
        String[][] s = new String[size][size];
        int num=1;
        for(int a=0; a<size ; a++){ 
            int i= num;
            for(int b=0; b<size ; b++){
                s[a][b] = String.format("%3d", i);
                if(i ==size){
                    i = 1;
                }
                else{
                i++;
                }
            }
            num++;
        }
        return s;
    }

   public static String[][] createpuzzle(int size){
        String[][] s = getlayout(size);
        int target = (s.length*s.length )/3;
        int cnt = 0;

        while(cnt < target){
        int pos1 = (int)System.currentTimeMillis()%s.length;
        int pos2 = (int)System.currentTimeMillis()%s.length;
        
        if(s[pos1][pos2].matches("   ")){
            pos2 = (int)System.currentTimeMillis()%s.length;
        }
        else{
        s[pos1][pos2] = "   ";
        cnt++;
        }
    }
    return s;
    }
     public static void main(String[] args){
        DisplayGrid(createpuzzle(6));
     }
    }