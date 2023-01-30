/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Excel;
import java.util.ArrayList;

/**
 *
 * @author acer
 */
public class ExcelManager {
    public ArrayList<ArrayList> get_excel(String file_uji){
        Excel ex = new Excel();
        ArrayList<ArrayList> data_uji = ex.load_excel(file_uji);
        return data_uji;
    }
}
