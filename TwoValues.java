public class TwoValues {
    private int intNum;
    private double doubleNum;

    public TwoValues(int intNum){
        this.intNum = intNum;
        System.out.println("결과값: "+getIntNum());
    }
    public TwoValues(double doubleNum){
        this.doubleNum = doubleNum;
        System.out.println("결과값: "+getDoubleNum());
    }


    public int getIntNum(){
        return intNum;
    }

    public double getDoubleNum(){
        return doubleNum;
    }
}
