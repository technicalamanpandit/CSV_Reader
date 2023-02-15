package com.technicalaman.csv_reader;

import android.database.sqlite.SQLiteDatabase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CSV_Reader {


        public static boolean SetCSV(String path, String class_name, String School_id, String Class_id, SQLiteDatabase db) {


            try {




                File fileName = new File(path);

                FileReader file = null;
                try {
                    file = new FileReader(fileName);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                CSVReader reader = new CSVReader(new FileReader(fileName));
                String line = "";
                String tableName = "Student_info";
                String columns = "Reg_no,S_name, F_name, M_name, Class, Roll,Mobile,Dob,Address,Blood,other1,other2,other3,other4,other5,other6,other7,other8,other9,other10,School_id,Class_id";
                String str1 = "INSERT INTO " + tableName + " (" + columns + ") values(";
                String str2 = ");";


                int i = 0;

                db.beginTransaction();

                String[] nextLine;

                try {


                    while ((nextLine = reader.readNext()) != null) {


                        if (i == 0) {

                        } else {

                            StringBuilder sb = new StringBuilder(str1);

                            sb.append('"' + nextLine[0] + '"' + ",");
                            sb.append('"' + nextLine[1] + '"' + ",");
                            sb.append('"' + nextLine[2] + '"' + ",");
                            sb.append('"' + nextLine[3] + '"' + ",");
                            sb.append('"' + class_name + '"' + ",");
                            sb.append('"' + nextLine[5] + '"' + ",");
                            sb.append('"' + nextLine[6] + '"' + ",");
                            sb.append('"' + nextLine[7] + '"' + ",");
                            sb.append('"' + nextLine[8] + '"' + ",");
                            sb.append('"' + nextLine[9] + '"' + ",");
                            sb.append('"' + nextLine[10] + '"' + ",");
                            sb.append('"' + nextLine[11] + '"' + ",");
                            sb.append('"' + nextLine[12] + '"' + ",");
                            sb.append('"' + nextLine[13] + '"' + ",");
                            sb.append('"' + nextLine[14] + '"' + ",");
                            sb.append('"' + nextLine[15] + '"' + ",");
                            sb.append('"' + nextLine[16] + '"' + ",");
                            sb.append('"' + nextLine[17] + '"' + ",");
                            sb.append('"' + nextLine[18] + '"' + ",");
                            sb.append('"' + nextLine[19] + '"' + ",");
                            sb.append('"' + School_id + '"' + ",");
                            sb.append('"' + Class_id + '"' + " ");
                            sb.append(str2);
                            db.execSQL(sb.toString());

                        }


                        i++;

                    }

                    db.setTransactionSuccessful();
                    return true;
                }finally {
                    db.endTransaction();
                }



            } catch (Exception e) {
                e.printStackTrace();
                if (db.isOpen()) {
                    db.close();
                }
            }
            if (db.isOpen()) {
                db.close();
            }

            return false;
        }



}

