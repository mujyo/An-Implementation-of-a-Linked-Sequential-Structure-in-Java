import bignumber.BigNumber;
import bignumber.BigNumberImpl;
import bignumber.Node;
import org.junit.Before;
import org.junit.Test;

public class TestBigNumber {
    private BigNumber bigNum1;
    private BigNumber bigNum2;

    @Before
    public void setUp(){
        this.bigNum1 = new BigNumberImpl();
        this.bigNum2 = new BigNumberImpl("32411");
    }

    @Test
    public void testCompareTo(){
        assert(this.bigNum1.compareTo(this.bigNum2) == -1);
        assert(this.bigNum1.compareTo(this.bigNum2) == -1);
    }

    @Test
    public void testAdd(){
        BigNumber bn1 = new BigNumberImpl("32417");
        BigNumber bn2 = new BigNumberImpl("9997");

        BigNumber bn3 = bn1.add(bn2);
        assert (bn3.toString().equals("42414"));
    }

    @Test
    public void testCopy(){
        BigNumber bigNum2Copy = this.bigNum2.copy();
        assert (bigNum2Copy.toString().equals(this.bigNum2.toString()));

        bigNum2Copy.shiftLeft(1);
        assert (!bigNum2Copy.toString().equals(this.bigNum2.toString()));
    }

    @Test
    public void testGetDigitAt(){
        assert(this.bigNum2.getDigitAt(3) == 2);
        try{
            BigNumber bigNum6 = new BigNumberImpl("32417");
            bigNum6.getDigitAt(10);
        }catch(IllegalArgumentException err){
            System.out.println(err.toString());}
    }

    @Test
    public void testAddDigit(){
        BigNumber bigNum5 = new BigNumberImpl("32417");
        bigNum5.addDigit(3);
        System.out.println(bigNum5);
        assert (bigNum5.toString().equals("32420"));

        try{
            BigNumber bigNum6 = new BigNumberImpl("32417");
            bigNum5.addDigit(30);
        }catch(IllegalArgumentException err){
            System.out.println(err.toString());}
    }
    @Test
    public void testShiftRight(){
        BigNumber bigNum4 = new BigNumberImpl("3241100");
        System.out.println(bigNum4.toString());

        bigNum4.shiftRight(2);
        assert (bigNum4.toString().equals("32411"));
        System.out.println(bigNum4.toString());

        bigNum4.shiftRight(-2);
        assert (bigNum4.toString().equals("3241100"));
        System.out.println(bigNum4.toString());

        bigNum4.shiftRight(8);
        assert (bigNum4.toString().equals("0"));
        System.out.println(bigNum4.toString());
    }

    @Test
    public void testShiftLeft(){
        BigNumber bigNum3 = new BigNumberImpl("32411");

        System.out.println(bigNum3.toString());
        bigNum3.shiftLeft(2);
        assert (bigNum3.toString().equals("3241100"));
        System.out.println(bigNum3.toString());
    }

    @Test
    public void testLen(){
        assert (this.bigNum2.length() == 5);
    }

    @Test
    public void testEqual(){
        BigNumber bn1 = new BigNumberImpl("10");
        BigNumber bn2 = new BigNumberImpl("11");
        assert (bn1.equal(bn1, bn2) == false);

        BigNumber bn11 = new BigNumberImpl("110");
        BigNumber bn12 = new BigNumberImpl("110");
        assert (bn1.equal(bn11, bn12) == true);
    }

    @Test
    public void testReversedToString(){
        assert(this.bigNum1.toString().equals("0"));
        assert(this.bigNum2.toString().equals("32411"));
    }

    @Test
    public void testInvalidStrNum(){
        try{
            BigNumber bigNumExcept = new BigNumberImpl("439218807E20714900076");
        }catch(IllegalArgumentException err){
            System.out.println(err.toString());
        }

        try{
            BigNumber bigNumExcept = new BigNumberImpl("011");
        }catch(IllegalArgumentException err){
            System.out.println(err.toString());
        }

        try{
            BigNumber bigNumExcept = new BigNumberImpl("-32411");
        }catch(IllegalArgumentException err){
            System.out.println(err.toString());
        }

        try{
            BigNumber bigNumExcept = new BigNumberImpl("3241.1");
        }catch(IllegalArgumentException err){
            System.out.println(err.toString());
        }

        try{
            BigNumber bigNumExcept = new BigNumberImpl("3241E1");
        }catch(IllegalArgumentException err){
            System.out.println(err.toString());
        }

    }

}
