package work.work02;

/**
 *百钱百鸡
 */
public class Chicken {
    public static void hundredFowlsMoney(){
        int poult;
        for (int i=0;i<=20;i++){
            for (int j=0;j<=33;j++){
                poult=100-i-j;
                if(poult%3==0&&5*i+j*3+poult/3==100){
                    System.out.println("鸡翁："+i+"\t"+"鸡母: "+j+"\t"+"鸡雏： "+poult+"\t");
                }

            }
        }
    }

    public static void main(String[] args) {
        hundredFowlsMoney();
    }
}
