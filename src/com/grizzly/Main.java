package com.grizzly;
/*HI all, thanks for executing my code, this function find number polidrom.
but polidrom must be bigger then number at 1 or more
example 123456 -> 124421
1234567 -> 1235321
many exceptions with numbers 9999 or 969969 and etc

code have to 2 methods
print and invert
* */

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


    public static void main(String[] args) throws Exception {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        //read string, check valid and push string to char array if true

        Pattern p = Pattern.compile("[0-9]+");
        String strInput = input.readLine();
        Matcher m = p.matcher(strInput);

        char[] charArray;
        try {
            if (m.matches()) {
                charArray = strInput.toCharArray();
                System.out.println(m.matches());
            } else {
                throw new NumberFormatException();
            }

        } catch (NumberFormatException invalidNumber) {
            System.out.println("    *** Wrong number format ***\n String must have only numbers without any symbols or spaces \n Restart programm.");
            return;
        }


        int size = strInput.length();
        System.out.println(size);
        intArray = new int[size];
        origIntArray = new int[size];

        //convert chars array at int array
        for (int i = 0; i < size; i++) {
            intArray[i] = Character.digit(charArray[i], 10);
            origIntArray[i] = intArray[i];
            System.out.println("int " + intArray[i] + " char " + charArray[i]);
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
            //System.out.println(leftConst + " left " + rightConst + " right");
            System.out.println("in %2==0");


            //first check equality
            if (intArray[leftConst] == intArray[rightConst]) {
                System.out.println("first check equality");
                for (int i = 0; i < size / 2; i++) {
                    //check if element not 9 and flag++ if its true
                    System.out.println("left " + left + "  " + right + " right ");

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
                    //if middle elements aquality and not 9 then we can ++ them
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
                            if (intArray[right] == 9) {
                                intArray[right] = 0;
                            } else {
                                intArray[right]++;
                                invertE(size);
                                break;
                            }
                            right--;
                        }
                    }
                    if (intArray[leftConst] == intArray[rightConst]) {
                        System.out.println("Fuck");
                        System.out.println(leftConst + " left " + rightConst + " right");
                    }


                    leftConst++;
                    rightConst--;
                    //second check equality

                }

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
                System.out.println("first ceck equality");
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
                        System.out.println("A");
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
                    System.out.println("B");
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
                    System.out.println("l<r");

                    if (intArray[middleConst] != 9) {
                        intArray[middleConst]++;
                    } else {
                        left = middleConst;
                        //intArray[middle]=0;

                        for (int i = 0; i < middleConst + 1; i++) {
                            System.out.println("left   " + left);
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
                    System.out.println("l>r");

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
            System.out.println("invE left " + left + " right " + right);
            intArray[right] = intArray[left];
            left--;
            right++;
        }
    }

    private static void invertO() {
        int right = midRight;
        int left = midLeft;
        for (int i = 0; i < middleConst; i++) {
            System.out.println("invO left " + left + " right " + right);
            intArray[right] = intArray[left];
            left--;
            right++;
        }
    }

    private static void print(int size) {
        for (int k = 0; k < size + 18; k++) {
            System.out.print("_");
        }
        System.out.print("\n* Number   Size: " + size);
        System.out.print("\n* Your   Number: ");

        for (int i = 0; i < size; i++) {
            System.out.print(origIntArray[i]);
        }
        System.out.println("");


        System.out.print("* Your Polidrom: ");
        for (int i = 0; i < size; i++) {
            System.out.print(intArray[i]);
        }
        System.out.println();

        for (int k = 0; k < size + 18; k++) {
            System.out.print("_");
        }
    }
}
/*    Задача С
-------------
        Подсчитать количество символов во введенной строке.
        Если количество четное, 1
        Иначе, 2
        (1)
        Разбить на 2 части. Лев. и Прав.
        Если первый символ Прав. < послед. символ Лев.:
        Прав = инвертировать(Лев.)
        Если первый символ Прав. > послед. символ Лев.:
        инкремент(последний символ Лев. )
        Прав = инвертировать(Лев.)
        Если первый символ Прав. == послед. символ Лев.:
        сравнивать следующий символ из Прав. и предыдущий символ из Лев., пока они равны.
        При первом неравенстве:
        Если след. символ Прав. < предыдущ.. символ Лев.:
        Прав = инвертировать(Лев.)
        Если след. символ Прав. > предыдущ. символ Лев.:
        инкремент(последний символ Лев. )
        Прав = инвертировать(Лев.)
        (2)
        Разбить на 3 части. Лев., Центр (1 символ) и Прав.
        Если первый символ Прав. < послед. символ Лев.:
        Прав = инвертировать(Лев.)
        Если первый символ Прав. > послед. символ Лев.:
        инкремент(Центр)
        Прав = инвертировать(Лев.)
        Если первый символ Прав. == послед. символ Лев.:
        сравнивать следующий символ из Прав. и предыдущий символ из Лев., пока они равны.
        При первом неравенстве:
        Если след. символ Прав. < предыдущ.. символ Лев.:
        Прав = инвертировать(Лев.)
        Если след. символ Прав. > предыдущ. символ Лев.:
        инкремент(Центр)
        Прав = инвертировать(Лев.)
        Примечание: инкремент() - функция, которая увеличивает заданный разряд на единицу и при необходимости увеличивает старшие разряды (влево от заданного).*/

/*bigger smoller
        if (intArray[leftConst] > intArray[rightConst]) {
                System.out.println("l>r");
                invert(size, leftConst, rightConst);
                print(size);
                return;

                }


                if (intArray[leftConst] < intArray[rightConst]) {
        System.out.println("l<r");
        intArray[midLeft]++;
        invert(size, leftConst, rightConst);
        print(size);
        return;
        }*/


