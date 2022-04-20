package com.suthar.jay;

import com.bethecoder.ascii_table.ASCIITable;

public class StaticProperties {
    static final String MANAGER_PASSWORD = "123";

    static final String[] HEADERS_BASIC = {"Employee ID","Full Name","Mobile No.","Wage/Hours","Worked Hours","Is Student","Total Wage","Tax Slot","Tax Amount","Net Pay"};
    static ASCIITable TABLE = ASCIITable.getInstance();

    //=== Bonus Slot Settings ===
    static final int BONUS_SLOT_5000 = 5000;
    static final double BONUS_FOR_5000 = 0.5;
    static final int BONUS_SLOT_10000 = 10000;
    static final double BONUS_FOR_10000 = 0.10;
    static final int BONUS_SLOT_15000 = 15000;
    static final double BONUS_FOR_15000 = 0.15;

    //=== Tax Slot Settings ===
    static final int TAX_SLOT_12500 = 12500;
    static final double TAX_FOR_12500 = 0.45;
    static final int TAX_SLOT_4190 = 4190;
    static final double TAX_FOR_4190 = 0.40;
    static final int TAX_SLOT_1050 = 1050;
    static final double TAX_FOR_1050 = 0.20;

}
