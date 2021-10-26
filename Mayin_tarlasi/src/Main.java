import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int row, col;
        System.out.println("Mayın Tarlası Oyununa Hoş Geldiniz!!!");
        System.out.println("Lütfen tarlanın boyutunu belirleyiniz");
        boolean isTrue=true;
        do{
            System.out.print("Satır boyutunu giriniz :");
            row=inp.nextInt();
            System.out.print("Sütun boyutunu giriniz :");
            col=inp.nextInt();
            if(row<2 || col<2){
                System.out.println("Satır ve sütun  2'den küçük olamaz.");
                isTrue=false;
            }else {
                isTrue=true;
            }

        }while(isTrue==false);

        mineswepper mine= new mineswepper(row,col);
        mine.run();
    }
}
