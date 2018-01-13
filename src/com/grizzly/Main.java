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
    static String strInput;
    static char[] charArray;
    static int[] intArray;
    static int rightConst, leftConst;
    static int midRight, midLeft;
    static int middle;

    public static void main(String[] args) throws Exception {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        //read string, check valid and push string to char array if true
        Pattern p = Pattern.compile("[0-9]+");
        strInput = input.readLine();
        Matcher m = p.matcher(strInput);

        try {
            if (m.matches()) {
                charArray = strInput.toCharArray();
                System.out.println(m.matches());
            } else {
                throw new NumberFormatException();
            }

        } catch (NumberFormatException invalidNumber) {
            System.out.println(" *** Wrong number format ***\n String must have only numbers without any symbols or spaces ");
            return;
        }


        int size = strInput.length();
        System.out.println(size);
        intArray = new int[size];

        //convert chars array at int array
        for (int i = 0; i < size; i++) {
            intArray[i] = Character.digit(charArray[i], 10);
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
                    if (intArray[leftConst++] == intArray[rightConst--]) {
                        System.out.println(leftConst + " left " + rightConst + " right");
                        continue;
                    }

                    //second check equality

                }

            } else {
                if (intArray[leftConst] < intArray[rightConst]) {
                    intArray[midLeft]++;
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
            int right, left;
            rightConst = size - 1;
            leftConst = 0;
            middle = (size - 1) / 2;
            midRight = middle + 1;
            midLeft = middle - 1;

            if (intArray[leftConst] == intArray[rightConst]) {
                System.out.println("size % 2 != 0");
            } else {

                if (intArray[leftConst] < intArray[rightConst]) {
                    System.out.println("l<r");


                    intArray[middle]++;
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

    public static void invertE(int size) {
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
        for (int i = 0; i < middle; i++) {
            System.out.println("invO left " + left + " right " + right);
            intArray[right] = intArray[left];
            left--;
            right++;
        }

    }

    private static void print(int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(intArray[i]);
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


