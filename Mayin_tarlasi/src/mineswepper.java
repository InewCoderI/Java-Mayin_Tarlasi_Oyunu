import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class mineswepper {
    int row;
    int col;

    mineswepper(int satir, int sutun) {
        this.row = satir;
        this.col = sutun;

    }

    String[][] board() {
        String[][] board = new String[this.row][this.col];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = " _ ";
            }
        }
        for (String[] satir : board) {
            for (String sutun : satir) {
                System.out.print(sutun);
            }
            System.out.println();
        }
        return board;
    }

    String[][] mayinli_board() {
        String[][] mayinli = new String[this.row][this.col];
        Random rand = new Random();
        int i = 0, satir, sutun;
        for (int k = 0; k < mayinli.length; k++) {
            for (int l = 0; l < mayinli[k].length; l++) {
                mayinli[k][l] = " _ ";
            }
        }
        while (i < (this.row * this.col) / 4) {
            satir = rand.nextInt(this.row);
            sutun = rand.nextInt(this.col);
            if (mayinli[satir][sutun] != " * ") {
                mayinli[satir][sutun] = " * ";
                i++;
            }
        }
        /*for (String[] m : mayinli) {
            for (String j : m) {
                System.out.print(j);
            }
            System.out.println();
        }*/

        return  mayinli;

    }

    void kontrol(String[][] mayinli,String[][] board) {
        Scanner inp = new Scanner(System.in);
        boolean isgo = false,iswin=false;
        int cnt = 0,win=1;
        do {
            System.out.print("Satır girin : ");
            int satir = inp.nextInt();
            System.out.print("Sütun girin : ");
            int sutun = inp.nextInt();

            if (satir < 0 || (satir > this.row - 1) || sutun < 0 || (sutun > this.col - 1)) {
                System.out.println("Geçersiz koordinat");
                System.out.println("Lütfen 0-0 ila " +(this.row-1)+"-"+(this.col-1)+" arasında bir değer giriniz.");
                continue;
            }
            if(mayinli[satir][sutun]!=" * " && mayinli[satir][sutun]!=" _ "){
                System.out.println("Bu koordinatları zaten girdiniz başka bir nokta seçiniz.");
                continue;
            }

            cnt = 0;
            if (mayinli[satir][sutun] == " * ") {
                System.out.println("Game over");
                isgo = true;
            } else {
                if(win==(this.row*this.col)-((this.row*this.col)/4)){
                    System.out.println("Tebrikler kazandınız");

                    iswin=true;
                }
                win++;

                if (sutun==0) {
                    if(satir==0){
                        for(int i=satir;i<=satir+1;i++){
                            for(int j=sutun;j<=sutun+1;j++){
                                if(mayinli[i][j]==" * "){
                                    cnt++;
                                }
                            }
                        }
                    }else if(satir==this.row-1){
                        for(int i=satir-1;i<=satir;i++){
                            for(int j=sutun;j<=sutun+1;j++){
                                if(mayinli[i][j]==" * "){
                                    cnt++;
                                }
                            }
                        }
                    }else{
                        for(int i=satir-1;i<=satir+1;i++){
                            for(int j=sutun;j<=sutun+1;j++){
                                if(mayinli[i][j]==" * "){
                                    cnt++;
                                }
                            }
                        }
                    }
                }else if(sutun==this.col-1){
                    if(satir==0){
                        for(int i=satir;i<=satir+1;i++){
                            for(int j=sutun-1;j<=sutun;j++){
                                if(mayinli[i][j]==" * "){
                                    cnt++;
                                }
                            }
                        }
                    }else if(satir==this.row-1){
                        for(int i=satir-1;i<=satir;i++){
                            for(int j=sutun-1;j<=sutun;j++){
                                if(mayinli[i][j]==" * "){
                                    cnt++;
                                }
                            }
                        }
                    }else{
                        for(int i=satir-1;i<=satir+1;i++){
                            for(int j=sutun-1;j<=sutun;j++){
                                if(mayinli[i][j]==" * "){
                                    cnt++;
                                }
                            }
                        }
                    }
                }else if((satir==0 && sutun!=0)||(satir==0 && sutun!=this.col-1)){
                    for(int i=satir;i<=satir+1;i++){
                        for(int j=sutun-1;j<=sutun+1;j++){
                            if(mayinli[i][j]==" * "){
                                cnt++;
                            }
                        }
                    }
                }else if((satir==this.row-1 && sutun!=0) ||(satir==this.row-1 && sutun!=this.col-1)){
                    for(int i=satir-1;i<=satir;i++){
                        for(int j=sutun-1;j<=sutun+1;j++){
                            if(mayinli[i][j]==" * "){
                                cnt++;
                            }
                        }
                    }
                }else{
                    for(int i=satir-1;i<=satir+1;i++){
                        for(int j=sutun-1;j<=sutun+1;j++){
                            if(mayinli[i][j]==" * "){
                                cnt++;
                            }
                        }
                    }
                }
                board[satir][sutun] = " "+ Integer.toString(cnt)+" ";
                mayinli[satir][sutun]=" "+ Integer.toString(cnt)+" ";
                if(iswin==false){
                    for (String[] m : board) {
                        for (String j : m) {
                            System.out.print(j);
                        }
                        System.out.println();
                    }
                }


                //System.out.println("Mayın sayısı : " + cnt);
            }
        } while (isgo == false && iswin==false);
        for (String[] m : mayinli) {
            for (String j : m) {
                System.out.print(j);
            }
            System.out.println();
        }


    }
    void run(){
        System.out.println("=======");

        kontrol(mayinli_board(),board());
    }


}



