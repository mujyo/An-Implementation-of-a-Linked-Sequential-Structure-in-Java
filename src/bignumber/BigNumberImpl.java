package bignumber;

/**
 * Store bigNumber as a linkedList in little-endian fashion
 * Every digit is store as a node in linkedList
 */
public class BigNumberImpl implements BigNumber {
    private Node bigNumber;

    /**
     * a constructor with no parameters that creates the number 0
     */
    public BigNumberImpl(){
        this.bigNumber = new Node(0);
    }

    /**
     * another constructor that takes a number as a string and represents it.
     * This constructor should throw an IllegalArgumentException if the string passed to it does not represent a valid number
     * @param strNum a string which can be converted to many digits
     */
    public BigNumberImpl(String strNum){
        if (strNum == null || strNum.equals("")){
            throw new IllegalArgumentException(strNum + "the string passed to it does not represent a valid number");
        }else{
            Node head = new Node(0);
            Node dummyHead = head;
            for (int i=strNum.length() - 1; i >= 0; i--){
                if (Character.isDigit(strNum.charAt(i)) == false){
                    throw new IllegalArgumentException(strNum + "the string passed to it does not represent a valid number");
                }else{
                    int val = Integer.parseInt(String.valueOf(strNum.charAt(i)));
                    Node newNode = new Node(val);
                    head.setNext(newNode);
                    head = head.getNext();
                }
            }
            this.bigNumber = dummyHead.getNext();
        }
    }

    /**
     * getter fucntion for bigNumber
     * @return this.bigNumber
     */
    @Override
    public Node getBigNumber(){
        return this.bigNumber;
    }

    /**
     * let bigNumber point to a new head node
     * @param head a new head node for a linkedList
     */
    @Override
    public void setBigNumber(Node head){
        this.bigNumber = head;
    }

    /**
     * compare whether two bigNumber are equal
     * @param bn1 bigNumber1
     * @param bn2 bigNumber2
     * @return true if equal false otherwise
     */
    @Override
    public Boolean equal(BigNumber bn1, BigNumber bn2){
        if (bn1.length() != bn2.length()){
            return false;
        }else if (bn1.getBigNumber() == null && bn2.getBigNumber() == null) {
            return true;
        }else{
            Node traverseBn1 = bn1.getBigNumber();
            Node traverseBn2 = bn2.getBigNumber();
            while (traverseBn1 != null){
                if (traverseBn1.getVal() != traverseBn2.getVal()){
                    return false;
                }
                traverseBn1 = traverseBn1.getNext();
                traverseBn2 = traverseBn2.getNext();
            }
        }
        return true;
    }

    /**
     * traverse the bigNumber and then get its length
     * @return the length of bigNumber
     */
    @Override
    public int length() {
        int counter = 0;
        Node traversePtr = this.bigNumber;

        while(traversePtr != null) {
            // increment the counter
            counter++;
            // hop to the next node
            traversePtr = traversePtr.getNext();
        }

        // when we reach here, head should pointing to null.
        return counter;
    }

    /**
     *  takes the number of shifts as an argument and shifts this number to the left by that number.
     *  A negative number of left-shifts will correspond to those many right shifts.-> pass it to this.shiftRight()
     * @param numOfShift the number of shifts as an argument and shifts this number to the left
     */
    @Override
    public void shiftLeft(int numOfShift) {
        if (this.bigNumber.getVal() == 0 && this.length() == 1){
            return;
        }
        if (numOfShift > 0){
            Node zeroHead = new Node(0);
            Node dummyHead = zeroHead;
            for (int i=0; i<numOfShift - 1;i++){
                Node newZero = new Node(0);
                zeroHead.setNext(newZero);
                zeroHead = zeroHead.getNext();
            }
            zeroHead.setNext(this.bigNumber);
            this.bigNumber = dummyHead;

        }else if (numOfShift < 0){
            this.shiftRight(-1 * numOfShift);
        }
    }

    /**
     * takes the number of shifts as an argument and shifts this number to the right by that number.
     * The number 0 can be right-shifted any positive number of times,
     * yielding the same number 0.
     * A negative number of right-shifts will correspond to those many left shifts.->pass to this.shiftLeft()
     * @param numOfShift the number of shifts as an argument and shifts this number to the left
     */
    @Override
    public void shiftRight(int numOfShift) {
        if (this.length() <= numOfShift){
            this.bigNumber = new Node(0);
        }else if (numOfShift > 0){
            int i = 0;
            Node traverseThisNum = this.bigNumber;
            while (traverseThisNum != null){
                if (i == numOfShift - 1){
                    break;
                }
                traverseThisNum = traverseThisNum.getNext();
                i++;
            }
            this.bigNumber = traverseThisNum.getNext();

        }else if (numOfShift < 0){
            this.shiftLeft(-1 * numOfShift);
        }
    }

    /**
     * add one single digit to this.bigNumber
     * @param digit the single digit being added
     */
    @Override
    public void addDigit(int digit) {
        if (!(digit >=0 && digit <=9)){
            throw new IllegalArgumentException("the digit passed to it is not a single non-negative digit");
        }else{
            int carry = 0;
            Node traverseThisNum = this.bigNumber;
            int curVal = traverseThisNum.getVal();
            int sum = curVal + digit + carry;
            int val = sum % 10;
            carry = sum / 10;
            traverseThisNum.setVal(val);

            while (carry != 0 && traverseThisNum.getNext() != null) {
                traverseThisNum = traverseThisNum.getNext();
                curVal = traverseThisNum.getVal();
                sum = curVal + carry;
                val = sum % 10;
                carry = sum / 10;
                traverseThisNum.setVal(val);
            }
            if (carry != 0){
                Node newNode = new Node(carry);
                traverseThisNum.setNext(newNode);
            }
        }
    }

    /**
     *  takes a position as an argument and returns the digit at that position.
     *  Positions start at 0 (rightmost digit).
     * @param index the position
     * @return target digit on the position of interest
     */
    @Override
    public int getDigitAt(int index) {
        if (index >= this.length() || index < 0) {
            throw new IllegalArgumentException("an invalid position is passed");
        }

        int pos = 0;
        int digit = 0;
        Node traversePtr = this.bigNumber;

        while(traversePtr != null){
            digit = traversePtr.getVal();
            if (pos == index) {
                // we're at the correct position
                break;
            }
            // hop to the next node
            traversePtr = traversePtr.getNext();
            // increment the pos
            pos++;
        }
        return digit;
    }

    /**
     *  returns an identical and independent copy of this number.
     * @return bigNumber type variable that has exactly the same value with this.bigNumber
     */
    @Override
    public BigNumber copy() {
        Node clone = new Node(0);
        Node dummyHead = clone;
        Node traversePtr = this.bigNumber;

        while(traversePtr != null){
            Node newNode = new Node(traversePtr.getVal());
            clone.setNext(newNode);
            clone = clone.getNext();
            traversePtr = traversePtr.getNext();
        }

        BigNumber bigNum = new BigNumberImpl();
        bigNum.setBigNumber(dummyHead.getNext());

        return bigNum;
    }

    /**
     * padding to the shorter bigNumber in order to conduct calculation
     * @param shortBigNum the shorter one
     * @param lenDiff number of zero to pad
     */
    private void padding(BigNumber shortBigNum, int lenDiff){
        Node traverseShort = shortBigNum.getBigNumber();
        while (traverseShort.getNext() != null){
            traverseShort = traverseShort.getNext();
        }

        for (int i=0; i<lenDiff;i++) {
            Node zeroPadding = new Node(0);
            traverseShort.setNext(zeroPadding);
            traverseShort = traverseShort.getNext();
        }
    }

    /**
     * add another bigNumber and then returns the sum of these two numbers.
     * This operation does not change either number.
     * @param bigNum the bigNumber being added to this.bigNumber
     * @return the sum in type of bigNumber
     */
    @Override
    public BigNumber add(BigNumber bigNum) {
        BigNumber bigNum1 = this.copy();
        BigNumber bigNum2 = bigNum.copy();
        BigNumber longBigNum;
        BigNumber shortBigNum;

        if (bigNum1.length() >= bigNum2.length()){
            longBigNum = bigNum1;
            shortBigNum = bigNum2;
        }else{
            longBigNum = bigNum2;
            shortBigNum = bigNum1;
        }

        int lenDiff = longBigNum.length() - shortBigNum.length();
        this.padding(shortBigNum, lenDiff);

        Node headOfSum = new Node(0);
        Node dummyHead = headOfSum;
        int carry = 0;
        int i = 0;

        Node longHead = longBigNum.getBigNumber();
        Node shortHead = shortBigNum.getBigNumber();
        while (longHead != null){
            if (i == longBigNum.length()){
                break;
            }
            int sum = longHead.getVal() + shortHead.getVal() + carry;
            int val = sum % 10;
            carry = sum / 10;

            Node newNode = new Node(val);
            headOfSum.setNext(newNode);
            headOfSum = headOfSum.getNext();

            longHead = longHead.getNext();
            shortHead = shortHead.getNext();
            i++;
        }

        if (carry != 0){
            Node newNode = new Node(carry);
            headOfSum.setNext(newNode);
        }

        BigNumber sumBigNum = new BigNumberImpl();
        sumBigNum.setBigNumber(dummyHead.getNext());

        return sumBigNum;
    }

    /**
     * compare two bigNumber for ordering
     * @param bn1 another bigNumber type instance being compared with this.bigNumber
     * @return {1, 0, -1}
     */
    @Override
    public int compareTo(BigNumber bn1) {
        if (this.length() > bn1.length()){
            return 1;
        }else if (this.length() == bn1.length()){
            int flag = 0;
            Node traverseThisNum = this.bigNumber;
            Node traverseBn1 = bn1.getBigNumber();
            while (traverseBn1 != null && traverseThisNum != null){
                if (traverseThisNum.getVal() > traverseBn1.getVal()){
                    flag = 1;
                }else if (traverseThisNum.getVal() < traverseBn1.getVal()){
                    flag = -1;
                }
                traverseBn1 = traverseBn1.getNext();
                traverseThisNum = traverseThisNum.getNext();
            }
            return flag;
        }else{
            return -1;
        }
    }

    /**
     *  returns a string representation of this number, as simply the number itself.
     *  need to reverse this.bigNumber
     * @return a string representation of this.bigNumber
     */
    @Override
    public String toString(){
        String str = "";
        Node traverseThisNum = this.bigNumber;
        while (traverseThisNum != null){
            str += "" + traverseThisNum.getVal();
            traverseThisNum = traverseThisNum.getNext();
        }
        return new StringBuilder(str).reverse().toString();
    }
}
