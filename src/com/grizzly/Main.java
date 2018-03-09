package com.grizzly;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class Main {

    static int n;

    static BigInteger make_p(BigInteger p) {
        return new BigInteger((p.toString().substring(0, n / 2 + n % 2)) + (new StringBuffer(p.toString()).reverse().toString().substring(n / 2 + n % 2, n)));
    }

    static BigInteger least_p(BigInteger p) {
        p = p.add(new BigInteger("1"));
        n = p.toString().length();
        if (p.compareTo(make_p(p)) == 1)
            p = p.add(new BigInteger("10").pow(n / 2));
        return make_p(p);
    }

    public static void main(String[] args) throws IOException {
        String test;
        String inp;
        int cnt;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<BigInteger> listInp = new ArrayList();
        cnt = Integer.parseInt(test = br.readLine());


        for (int i = 0; i < cnt; i++) {
            inp = br.readLine();
            listInp.add(new BigInteger(inp));
        }


        for (BigInteger i : listInp)
            System.out.println(least_p(i));
    }
}