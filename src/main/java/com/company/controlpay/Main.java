package com.company.controlpay;

import java.io.IOException;

/**
 * Created by yulia on 07.07.17.
 */
public class Main {

    public static void main(String[] args) {
        Parser parser = new Parser();
        try {
              parser.getAllParameters(args[0]);
           // parser.getAllParameters("5000299223017");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
