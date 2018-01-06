package com.grizzly;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/*
polidrom
input example 1234 -> 4334
example 2 12345 -> 54345
 */
public class Main {
    static int intInput;
    static String strInput;
    static char[] charArray;
    static int[] intArray;
    static int lenghtStr;
    static int rightConst, leftConst;

public void inverse(int array[]){}
public static void printOut(int size){
        for (int i = 0; i < size; i++) {
        System.out.print(intArray[i]);
}}


    public static void main(String[] args) throws Exception {

printOut(lenghtStr);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        //read and push string to char array
        strInput = input.readLine();
        charArray = strInput.toCharArray();

        int size = strInput.length();
        lenghtStr=size;
        System.out.println(size);
        intArray = new int[size];

        //convert chars array at int array
        int[] num = new int[strInput.length()];

        for (int i = 0; i < size; i++) {
            intArray[i] = Character.digit(charArray[i], 10);
            System.out.println("inxed: "+i +" int " + intArray[i] + " char " + charArray[i]);
        }

        int right, left, middle;

        rightConst = size - 1;
        leftConst = 0;

        //__________________________________________________\\
        if (size % 2 == 0) {

            System.out.println(leftConst + " left " + rightConst + " right");
            System.out.println("in %2==0");

            if (intArray[leftConst] > intArray[rightConst]) {
                right = size / 2;
                left = right - 1;

                for (int i = 0; i < size / 2; i++) {
                    intArray[right] = intArray[left];
                    left--;
                    right++;
                }

            }


            if (intArray[leftConst] < intArray[rightConst]) {
                right = size / 2;
                left = right - 1;
                intArray[left]++;
                for (int i = 0; i < size / 2; i++) {
                    intArray[right] = intArray[left];
                    left--;
                    right++;
                }
            }
            right = size / 2;
            left = right - 1;

            if (intArray[leftConst] == intArray[rightConst]) {
                for (int i = 0; i < size / 2; i++) {
                    if (intArray[right]==intArray[left]&& intArray[right]==9)
                    {
                        for (int m = 0; m < size / 2; m++) {
                            intArray[left]=0;
                            intArray[right]=0;
                            left--;
                            right++;
                        }
                        intArray[leftConst]=intArray[leftConst]+10;
                        intArray[rightConst]=1;
                        break;
                    }

                    if (intArray[rightConst--] == intArray[leftConst++]) {
                        System.out.println(leftConst + " left " + rightConst + " right");

                       //??? if (intArray[(size-1)/2]==intArray[size/2]){intArray[size/2]++;intArray[(size-1)/2]++;break;}
                        continue;
                    } else {
                        if (intArray[leftConst] < intArray[rightConst]) {
                            right = size / 2;
                            left = right - 1;
                            intArray[left]++;

                            for (int j = 0; j < size / 2; j++) {
                                intArray[right] = intArray[left];
                                left--;
                                right++;
                            }
                            break;
                        }

                        if (intArray[leftConst] > intArray[rightConst]) {
                            right = size / 2;
                            left = right - 1;

                            for (int j = 0; j < size / 2; j++) {
                                intArray[right] = intArray[left];
                                left--;
                                right++;
                            }
                            break;
                        }
                    }
                }
            }
//___________________________________________________************************
        } else {
            right = (size+1) / 2;
            middle=(size-1)/2;
            left = right - 2;

            if (intArray[leftConst] == intArray[rightConst]) {
                right = (size+1) / 2;
                middle=(size-1)/2;
                left = right - 2;
                for (int i = 0; i < (size -1)/ 2; i++) {
                    System.out.println(leftConst + " left " + rightConst + " right");
                    if (intArray[left] == intArray[right] && intArray[left]==9)
                    { for (int k = 0; k < (size -1)/ 2; k++) {
                        intArray[right]=0;
                        intArray[left]=0;
                        left--;
                        right++;
                    }
                        intArray[middle]=0;
                        intArray[leftConst]=intArray[leftConst]+10;
                        intArray[rightConst]=1;
                        break;
                        //99999 -> 100001}
                    }
                    if (intArray[left] == intArray[right]){intArray[middle]++;
                        for (int j = 0; j < (size-1) / 2; j++) {
                            intArray[right] = intArray[left];
                            left--;
                            right++;
                        }break;}

                    if (intArray[rightConst] == intArray[leftConst]) {
                        System.out.println(leftConst + " leftconst " + rightConst + " rightconst");
                        continue;
                    } else {
                        if (intArray[leftConst] < intArray[rightConst]) {
                            right = (size+1) / 2;
                            middle=(size-1)/2;
                            left = right - 2;

                            for (int j = 0; j < (size-1) / 2; j++) {
                                intArray[right] = intArray[left];
                                left--;
                                right++;
                            }
                            break;
                        }

                        if (intArray[leftConst--] > intArray[rightConst++]) {
                            System.out.println(size/2+" size/2 ");
                            right = (size+1) / 2;
                            middle=(size-1)/2;
                            left = right - 2;

                            for (int j = 0; j < size / 2; j++) {
                                intArray[right] = intArray[left];
                                left--;
                                right++;
                            }
                            break;
                        }
                    }
                }
            }



            if (intArray[leftConst] > intArray[rightConst]) {
                for (int i = 0; i <(size -1)/2; i++) {
                    intArray[right] = intArray[left];
                    left--;
                    right++;
                }
            }
            if(intArray[leftConst] < intArray[rightConst]) {
//!!!
                intArray[middle]++;
                for (int i = 0; i <(size -1)/2; i++) {
                    intArray[right] = intArray[left];
                    left--;
                    right++;
                }
            }

        }
        for (int i = 0; i < size; i++) {
            System.out.print(intArray[i]);
        }
    }
}




