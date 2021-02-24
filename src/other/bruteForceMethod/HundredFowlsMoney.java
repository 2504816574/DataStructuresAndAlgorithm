package other.bruteForceMethod;

/**
 *百鸡百钱
 *
 * 数学家张丘建提出百鸡百钱问题，今有鸡翁 一，值钱五，鸡母一，值钱三，鸡雏三，值 钱一。百钱买百鸡，问鸡翁，鸡母，鸡雏各 几何？
 */
public class HundredFowlsMoney {
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
