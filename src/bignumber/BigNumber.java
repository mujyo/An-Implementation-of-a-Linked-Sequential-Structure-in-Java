package bignumber;

public interface BigNumber {
    int length();
    void shiftLeft(int numOfShift);
    void shiftRight(int numOfShift);
    void addDigit(int digit);
    int getDigitAt(int index);
    BigNumber copy();
    BigNumber add(BigNumber bigNum);
    int compareTo(BigNumber bn1);
    Node getBigNumber();
    void setBigNumber(Node head);
    Boolean equal(BigNumber bn1, BigNumber bn2);
}
