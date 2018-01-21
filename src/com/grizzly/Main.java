package com.grizzly;
/* ************************************************************************************
*HI all, thanks for executing my code, this program find number palindrome.
* Just enter input and see result.
*
* This task was a qualifier task for the programmer olympics
* A palindrome is a word, phrase, number, or other sequence of characters which reads the same backward as forward,
* such as "madam" or "taco cat" or "race car".
*
* But the palindrome must
* 1)be minimally bigger than the input number
* 2)input should to support the 10^6 digits and less
*
* example:
* input:     output:
* 123456  -> 124421
* 1234567 -> 1235321
* i have many problems with numbers 9999 or 969969 and etc...
* so in the code a lot of if-else construction
*
* code have to 3 methods
* print - for printing initial number and palindrome
* invertO - inversion for odd numbers
* invertE - inversion for even numbers
*
* If you like it,please like it ^_^
* Created by  Rusich on 21/01/2018
* kz, Almaty city
*
* *************************************************************************************/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static int[] origIntArray;
    private static int[] intArray;
    private static int rightConst, leftConst;
    private static int midRight, midLeft;
    private static int middleConst;
    private static long startTime;
    private static long timeSpent;


    public static void main(String[] args) throws Exception {
        startTime = System.nanoTime();
        //(1)
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        //read string, check valid and push string to char array if true
        //(1)
        Pattern p = Pattern.compile("[0-9]+");
        String strInput = input.readLine();
        Matcher m = p.matcher(strInput);
        //why if i write time spent here, its printing time executing, but if in (1) time is 0?
        timeSpent = System.nanoTime() - startTime;
        char[] charArray;
        try {
            if (m.matches()) {
                charArray = strInput.toCharArray();
            } else {
                throw new NumberFormatException();
            }

        } catch (NumberFormatException invalidNumber) {
            System.out.println("    *** Wrong number format ***\n String must have only numbers without any symbols or spaces \n Restart programm.");
            return;
        }


        int size = strInput.length();
        intArray = new int[size];
        origIntArray = new int[size];

        //convert chars array at int array
        for (int i = 0; i < size; i++) {
            intArray[i] = Character.digit(charArray[i], 10);
            origIntArray[i] = intArray[i];
        }
        //_________________________logic starts here_________________________________________________________\\
        if (size % 2 == 0) {

            int flag = 0;
            int right, left;
            rightConst = size - 1;
            leftConst = 0;
            midRight = size / 2;
            midLeft = midRight - 1;

            right = size / 2;
            left = right - 1;
            //first check equality
            if (intArray[leftConst] == intArray[rightConst]) {
                for (int i = 0; i < size / 2; i++) {
                    //check if element not 9 and flag++ if its true
                    if (intArray[left] != 9 || intArray[right] != 9) {
                        flag++;
                    }
                    //so if flag !=0 we never enter in this condition, if not then we init all elemts =0 and first will be 10 last 1

                    if (i + 1 == (size / 2) && intArray[leftConst] == 9 && intArray[rightConst] == 9 && flag == 0) {

                        right = size / 2;
                        left = right - 1;
                        for (i = 0; i < size / 2; i++) {
                            intArray[left] = 0;
                            intArray[right] = 0;
                            left--;
                            right++;

                        }
                        intArray[0] = 10;
                        intArray[size - 1] = 1;
                        break;
                    }
                    left--;
                    right++;
                    //if middle elements equality and not 9 then we can ++ them
                    if (i + 1 == (size / 2) && intArray[midRight] != 9) {
                        intArray[leftConst]++;
                        intArray[rightConst]++;
                        break;
                    }
                    //if no then we find element !=9 and give to element++; and element = 9 will be 0
                    if (i + 1 == (size / 2) && intArray[midRight] == 9 && intArray[midLeft] == 9) {
                        left = midLeft;
                        right = midRight;
                        for (i = 0; i < size / 2; i++) {
                            if (intArray[left] == 9) {
                                System.out.println("asdasd");
                                intArray[left] = 0;
                            } else {
                                intArray[left]++;
                                invertE(size);
                                break;
                            }
                            left--;
                        }
                    }

                    leftConst++;
                    rightConst--;
                    //second check equality

                }
                invertE(size);

            } else {

                if (intArray[leftConst] < intArray[rightConst]) {
                    if (intArray[midLeft] != 9) {
                        intArray[midLeft]++;
                    } else {
                        left = midLeft;
                        for (int i = 0; i < size / 2; i++) {
                            if (intArray[left] == 9) {
                                intArray[left] = 0;
                                left--;
                            } else {
                                intArray[left]++;
                                break;
                            }
                        }

                    }
                    invertE(size);
                    print(size);
                    return;
                }

                if (intArray[leftConst] > intArray[rightConst]) {
                    invertE(size);
                    print(size);
                    return;
                }

            }


        } else {
            //123 4 567 size =7 (7-1)/2=middle; middle -1 = leftMid; middle+1 = rightMid;
            int right, left, flag;
            rightConst = size - 1;
            leftConst = 0;
            middleConst = (size - 1) / 2;
            midRight = middleConst + 1;
            midLeft = middleConst - 1;
            if (size == 1 && intArray[middleConst] == 9) {
                intArray[0] = 10;
            }

            if (intArray[leftConst] == intArray[rightConst]) {
                flag = 0;
                left = midLeft;
                right = midRight;
                if (intArray[middleConst] != 9) {
                    intArray[middleConst]++;
                    invertO();
                    print(size);
                    return;
                }
                if (intArray[middleConst] == 9 && intArray[left] == 9 && intArray[right] != 9) {
                    intArray[middleConst] = 0;
                    for (int i = 0; i < middleConst; i++) {
                        if (intArray[left] == 9 && flag == 0) {
                            intArray[left] = 0;
                            if (i + 1 == middleConst) {
                                flag++;
                            }
                        } else {
                            intArray[left]++;
                            flag++;
                            if (flag != 0) {
                                break;
                            }
                        }

                        left--;
                    }
                    if (flag == 0) {
                        invertO();
                        print(size);
                        return;
                    }
                }
                left = midLeft;
                right = midRight;
                if (intArray[middleConst] == 9 && intArray[left] != 9) {
                    intArray[middleConst] = 0;
                    intArray[left]++;
                    invertO();
                    print(size);
                    return;

                }

                for (int i = 0; i < middleConst; i++) {
                    //check if element not 9 and flag++ if its true
                    //System999.out.println("left " + left + "  " + right + " right ");

                    if (intArray[left] != 9 || intArray[right] != 9) {
                        flag++;
                    }
                    //so if flag !=0 we never enter in this condition, if not then we init all elemts =0 and first will be 10 last 1
                    if (i + 1 == middleConst && intArray[leftConst] == 9 && intArray[rightConst] == 9 && flag == 0) {
                        right = midRight;
                        left = midLeft;
                        for (i = 0; i < middleConst; i++) {
                            intArray[left] = 0;
                            intArray[right] = 0;
                            left--;
                            right++;

                        }
                        intArray[middleConst] = 0;
                        intArray[0] = 10;
                        intArray[size - 1] = 1;
                        break;

                    }
                }


            } else {

                if (intArray[leftConst] < intArray[rightConst]) {
                    if (intArray[middleConst] != 9) {
                        intArray[middleConst]++;
                    } else {
                        left = middleConst;
                        //intArray[middle]=0;

                        for (int i = 0; i < middleConst + 1; i++) {
                            if (intArray[left] == 9) {
                                intArray[left] = 0;
                                left--;
                            } else {
                                intArray[left]++;
                                break;
                            }
                        }

                    }
                    invertO();
                    print(size);
                    return;
                }

                if (intArray[leftConst] > intArray[rightConst]) {
                    invertO();
                    print(size);
                    return;
                }
            }
        }
        print(size);

    }

    private static void invertE(int size) {
        int right = size / 2;
        int left = right - 1;
        for (int i = 0; i < size / 2; i++) {
            intArray[right] = intArray[left];
            left--;
            right++;
        }
    }

    private static void invertO() {
        int right = midRight;
        int left = midLeft;
        for (int i = 0; i < middleConst; i++) {
            intArray[right] = intArray[left];
            left--;
            right++;
        }
    }

    private static void print(int size) {
        for (int k = 0; k < size + 18; k++) {
            System.out.print("_");
        }
        System.out.print("\n* Number     Size: " + size);
        System.out.print("\n* Your     Number: ");

        for (int i = 0; i < size; i++) {
            System.out.print(origIntArray[i]);
        }
        System.out.println("");


        System.out.print("* Your Palindrome: ");
        for (int i = 0; i < size; i++) {
            System.out.print(intArray[i]);
        }

        System.out.println("\n* Execute    Time: " + timeSpent / 1000000 + " ms.");
        for (int k = 0; k < size + 18; k++) {
            System.out.print("_");

        }
    }
}
/**/