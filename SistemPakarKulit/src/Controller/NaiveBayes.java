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
public class NaiveBayes {
    ArrayList<String> hasil = new ArrayList<>();
    ArrayList<String> penyakit = new ArrayList<>();
    ArrayList<Double> bobot = new ArrayList<>();
    ArrayList<String> penjelasan = new ArrayList<>();
    Excel ex = new Excel();
    
    public ArrayList<String> get_hasil(){
        return hasil;
    }
    
     public ArrayList<String> get_penyakit(){
        return penyakit;
    }
    
    public ArrayList<String> get_penjelasan(){
        return penjelasan;
    }
    
    
    public ArrayList<Double> get_bobot(){
        return bobot;
    }
    public void do_naive_bayes(ArrayList<ArrayList> data_uji){
        hasil = new ArrayList<>();
        penyakit = new ArrayList<>();
        bobot = new ArrayList<>();
        penjelasan = new ArrayList<>();
        String file_latih = System.getProperty("user.dir") + "/Data/data latih.xlsx";
        //String file_latih2 = System.getProperty("user.dir") + "/Data/data latih2.xlsx";
        //String file_latih3 = System.getProperty("user.dir") + "/Data/data latih.xlsx";
         //buat di atribut
        ArrayList<ArrayList> data_latih = ex.load_excel(file_latih);
      
        
        double kulit_normal = 0;
        double kulit_kering = 0;
        double kulit_berminyak = 0;
        double kulit_kombinasi = 0;
        double kulit_sensitif = 0;
        
        for (int i = 0; i < data_latih.size(); i++) {
            if (data_latih.get(i).get(18).toString().equals("K1")) {
                kulit_normal++;
            } else if (data_latih.get(i).get(18).toString().equals("K2")) {
                kulit_kering++;
            } else if (data_latih.get(i).get(18).toString().equals("K3")) {
                kulit_berminyak++;
            } else if (data_latih.get(i).get(18).toString().equals("K4")) {
                kulit_kombinasi++;
            } else if (data_latih.get(i).get(18).toString().equals("K5")) {
                kulit_sensitif++;
            }
        }

        double peluang_kulit_normal = (kulit_normal * 1.0) / (1.0 * data_latih.size());
        double peluang_kulit_kering = (kulit_kering * 1.0) / (1.0 * data_latih.size());
        double peluang_kulit_berminyak = (kulit_berminyak * 1.0) / (1.0 * data_latih.size());
        double peluang_kulit_kombinasi = (kulit_kombinasi * 1.0) / (1.0 * data_latih.size());
        double peluang_kulit_sensitif = (kulit_sensitif * 1.0) / (1.0 * data_latih.size());

        
        for (int i = 0; i < data_uji.size(); i++) {
            double gejala_1_normal = 0;
            double gejala_1_kering = 0;
            double gejala_1_berminyak = 0;
            double gejala_1_kombinasi = 0;
            double gejala_1_sensitif = 0;

            if (Double.parseDouble(data_uji.get(i).get(0).toString()) == 1.0) {//data uji ke i gejala ke 0
                for (int j = 0; j < data_latih.size(); j++) {
                    if (data_latih.get(j).get(18).toString().equals("K1") && Double.parseDouble(data_latih.get(j).get(0).toString()) == 1.0) {
                        gejala_1_normal++;
                    } else if (data_latih.get(j).get(18).toString().equals("K2") && Double.parseDouble(data_latih.get(j).get(0).toString()) == 1.0) {
                        gejala_1_kering++;
                    } else if (data_latih.get(j).get(18).toString().equals("K3") && Double.parseDouble(data_latih.get(j).get(0).toString()) == 1.0) {
                        gejala_1_berminyak++;
                    } else if (data_latih.get(j).get(18).toString().equals("K4") && Double.parseDouble(data_latih.get(j).get(0).toString()) == 1.0) {
                        gejala_1_kombinasi++;
                    } else if (data_latih.get(j).get(18).toString().equals("K5") && Double.parseDouble(data_latih.get(j).get(0).toString()) == 1.0) {
                        gejala_1_sensitif++;
                    }
                }
            }
            gejala_1_normal = gejala_1_normal / kulit_normal;
            gejala_1_kering = gejala_1_kering / kulit_kering;
            gejala_1_berminyak = gejala_1_berminyak / kulit_berminyak;
            gejala_1_kombinasi = gejala_1_kombinasi / kulit_kombinasi;
            gejala_1_sensitif = gejala_1_sensitif / kulit_sensitif;

            double gejala_2_normal = 0;
            double gejala_2_kering = 0;
            double gejala_2_berminyak = 0;
            double gejala_2_kombinasi = 0;
            double gejala_2_sensitif = 0;
            if (Double.parseDouble(data_uji.get(i).get(1).toString()) == 1.0) {
                for (int j = 0; j < data_latih.size(); j++) {

                    if (data_latih.get(j).get(18).toString().equals("K1") && Double.parseDouble(data_latih.get(j).get(1).toString()) == 1.0) {
                        gejala_2_normal++;
                    } else if (data_latih.get(j).get(18).toString().equals("K2") && Double.parseDouble(data_latih.get(j).get(1).toString()) == 1.0) {
                        gejala_2_kering++;
                    } else if (data_latih.get(j).get(18).toString().equals("K3") && Double.parseDouble(data_latih.get(j).get(1).toString()) == 1.0) {
                        gejala_2_berminyak++;
                    } else if (data_latih.get(j).get(18).toString().equals("K4") && Double.parseDouble(data_latih.get(j).get(1).toString()) == 1.0) {
                        gejala_2_kombinasi++;
                    } else if (data_latih.get(j).get(18).toString().equals("K5") && Double.parseDouble(data_latih.get(j).get(1).toString()) == 1.0) {
                        gejala_2_sensitif++;
                    }
                }

            }

            gejala_2_normal = gejala_2_normal / kulit_normal;
            gejala_2_kering = gejala_2_kering / kulit_kering;
            gejala_2_berminyak = gejala_2_berminyak / kulit_berminyak;
            gejala_2_kombinasi = gejala_2_kombinasi / kulit_kombinasi;
            gejala_2_sensitif = gejala_2_sensitif / kulit_sensitif;

            double gejala_3_normal = 0;
            double gejala_3_kering = 0;
            double gejala_3_berminyak = 0;
            double gejala_3_kombinasi = 0;
            double gejala_3_sensitif = 0;
           
            if (Double.parseDouble(data_uji.get(i).get(2).toString()) == 1.0) {
                for (int j = 0; j < data_latih.size(); j++) {
                   
                    if (data_latih.get(j).get(18).toString().equals("K1") && Double.parseDouble(data_latih.get(j).get(2).toString()) == 1.0) {
                        gejala_3_normal++;
                    } else if (data_latih.get(j).get(18).toString().equals("K2") && Double.parseDouble(data_latih.get(j).get(2).toString()) == 1.0) {
                        gejala_3_kering++;
                    } else if (data_latih.get(j).get(18).toString().equals("K3") && Double.parseDouble(data_latih.get(j).get(2).toString()) == 1.0) {
                        gejala_3_berminyak++;
                    } else if (data_latih.get(j).get(18).toString().equals("K4") && Double.parseDouble(data_latih.get(j).get(2).toString()) == 1.0) {
                        gejala_3_kombinasi++;
                    } else if (data_latih.get(j).get(18).toString().equals("K5") && Double.parseDouble(data_latih.get(j).get(2).toString()) == 1.0) {
                        gejala_3_sensitif++;
                    }
                }
            }
      
            gejala_3_normal = gejala_3_normal / kulit_normal;
            gejala_3_kering = gejala_3_kering / kulit_kering;
            gejala_3_berminyak = gejala_3_berminyak / kulit_berminyak;
            gejala_3_kombinasi = gejala_3_kombinasi / kulit_kombinasi;
            gejala_3_sensitif = gejala_3_sensitif / kulit_sensitif;

            double gejala_4_normal = 0;
            double gejala_4_kering = 0;
            double gejala_4_berminyak = 0;
            double gejala_4_kombinasi = 0;
            double gejala_4_sensitif = 0;
            if (Double.parseDouble(data_uji.get(i).get(3).toString()) == 1.0) {
                for (int j = 0; j < data_latih.size(); j++) {
                    if (data_latih.get(j).get(18).toString().equals("K1") && Double.parseDouble(data_latih.get(j).get(3).toString()) == 1.0) {
                        gejala_4_normal++;
                    } else if (data_latih.get(j).get(18).toString().equals("K2") && Double.parseDouble(data_latih.get(j).get(3).toString()) == 1.0) {
                        gejala_4_kering++;
                    } else if (data_latih.get(j).get(18).toString().equals("K3") && Double.parseDouble(data_latih.get(j).get(3).toString()) == 1.0) {
                        gejala_4_berminyak++;
                    } else if (data_latih.get(j).get(18).toString().equals("K4") && Double.parseDouble(data_latih.get(j).get(3).toString()) == 1.0) {
                        gejala_4_kombinasi++;
                    } else if (data_latih.get(j).get(18).toString().equals("K5") && Double.parseDouble(data_latih.get(j).get(3).toString()) == 1.0) {
                        gejala_4_sensitif++;
                    }
                }
            }

            gejala_4_normal = gejala_4_normal / kulit_normal;
            gejala_4_kering = gejala_4_kering / kulit_kering;
            gejala_4_berminyak = gejala_4_berminyak / kulit_berminyak;
            gejala_4_kombinasi = gejala_4_kombinasi / kulit_kombinasi;
            gejala_4_sensitif = gejala_4_sensitif / kulit_sensitif;

            double gejala_5_normal = 0;
            double gejala_5_kering = 0;
            double gejala_5_berminyak = 0;
            double gejala_5_kombinasi = 0;
            double gejala_5_sensitif = 0;
            if (Double.parseDouble(data_uji.get(i).get(4).toString()) == 1.0) {
                for (int j = 0; j < data_latih.size(); j++) {
                    if (data_latih.get(j).get(18).toString().equals("K1") && Double.parseDouble(data_latih.get(j).get(4).toString()) == 1.0) {
                        gejala_5_normal++;
                    } else if (data_latih.get(j).get(18).toString().equals("K2") && Double.parseDouble(data_latih.get(j).get(4).toString()) == 1.0) {
                        gejala_5_kering++;
                    } else if (data_latih.get(j).get(18).toString().equals("K3") && Double.parseDouble(data_latih.get(j).get(4).toString()) == 1.0) {
                        gejala_5_berminyak++;
                    } else if (data_latih.get(j).get(18).toString().equals("K4") && Double.parseDouble(data_latih.get(j).get(4).toString()) == 1.0) {
                        gejala_5_kombinasi++;
                    } else if (data_latih.get(j).get(18).toString().equals("K5") && Double.parseDouble(data_latih.get(j).get(4).toString()) == 1.0) {
                        gejala_5_sensitif++;
                    }
                }
            }

            gejala_5_normal = gejala_5_normal / kulit_normal;
            gejala_5_kering = gejala_5_kering / kulit_kering;
            gejala_5_berminyak = gejala_5_berminyak / kulit_berminyak;
            gejala_5_kombinasi = gejala_5_kombinasi / kulit_kombinasi;
            gejala_5_sensitif = gejala_5_sensitif / kulit_sensitif;

            double gejala_6_normal = 0;
            double gejala_6_kering = 0;
            double gejala_6_berminyak = 0;
            double gejala_6_kombinasi = 0;
            double gejala_6_sensitif = 0;
            if (Double.parseDouble(data_uji.get(i).get(5).toString()) == 1.0) {
                for (int j = 0; j < data_latih.size(); j++) {
                    if (data_latih.get(j).get(18).toString().equals("K1") && Double.parseDouble(data_latih.get(j).get(5).toString()) == 1.0) {
                        gejala_6_normal++;
                    } else if (data_latih.get(j).get(18).toString().equals("K2") && Double.parseDouble(data_latih.get(j).get(5).toString()) == 1.0) {
                        gejala_6_kering++;
                    } else if (data_latih.get(j).get(18).toString().equals("K3") && Double.parseDouble(data_latih.get(j).get(5).toString()) == 1.0) {
                        gejala_6_berminyak++;
                    } else if (data_latih.get(j).get(18).toString().equals("K4") && Double.parseDouble(data_latih.get(j).get(5).toString()) == 1.0) {
                        gejala_6_kombinasi++;
                    } else if (data_latih.get(j).get(18).toString().equals("K5") && Double.parseDouble(data_latih.get(j).get(5).toString()) == 1.0) {
                        gejala_6_sensitif++;
                    }
                }
            }

            gejala_6_normal = gejala_6_normal / kulit_normal;
            gejala_6_kering = gejala_6_kering / kulit_kering;
            gejala_6_berminyak = gejala_6_berminyak / kulit_berminyak;
            gejala_6_kombinasi = gejala_6_kombinasi / kulit_kombinasi;
            gejala_6_sensitif = gejala_6_sensitif / kulit_sensitif;

            double gejala_7_normal = 0;
            double gejala_7_kering = 0;
            double gejala_7_berminyak = 0;
            double gejala_7_kombinasi = 0;
            double gejala_7_sensitif = 0;
            if (Double.parseDouble(data_uji.get(i).get(6).toString()) == 1.0) {
                for (int j = 0; j < data_latih.size(); j++) {
                    if (data_latih.get(j).get(18).toString().equals("K1") && Double.parseDouble(data_latih.get(j).get(6).toString()) == 1.0) {
                        gejala_7_normal++;
                    } else if (data_latih.get(j).get(18).toString().equals("K2") && Double.parseDouble(data_latih.get(j).get(6).toString()) == 1.0) {
                        gejala_7_kering++;
                    } else if (data_latih.get(j).get(18).toString().equals("K3") && Double.parseDouble(data_latih.get(j).get(6).toString()) == 1.0) {
                        gejala_7_berminyak++;
                    } else if (data_latih.get(j).get(18).toString().equals("K4") && Double.parseDouble(data_latih.get(j).get(6).toString()) == 1.0) {
                        gejala_7_kombinasi++;
                    } else if (data_latih.get(j).get(18).toString().equals("K5") && Double.parseDouble(data_latih.get(j).get(6).toString()) == 1.0) {
                        gejala_7_sensitif++;
                    }
                }
            }

            gejala_7_normal = gejala_7_normal / kulit_normal;
            gejala_7_kering = gejala_7_kering / kulit_kering;
            gejala_7_berminyak = gejala_7_berminyak / kulit_berminyak;
            gejala_7_kombinasi = gejala_7_kombinasi / kulit_kombinasi;
            gejala_7_sensitif = gejala_7_sensitif / kulit_sensitif;

            double gejala_8_normal = 0;
            double gejala_8_kering = 0;
            double gejala_8_berminyak = 0;
            double gejala_8_kombinasi = 0;
            double gejala_8_sensitif = 0;
            if (Double.parseDouble(data_uji.get(i).get(7).toString()) == 1.0) {
                for (int j = 0; j < data_latih.size(); j++) {
                    if (data_latih.get(j).get(18).toString().equals("K1") && Double.parseDouble(data_latih.get(j).get(7).toString()) == 1.0) {
                        gejala_8_normal++;
                    } else if (data_latih.get(j).get(18).toString().equals("K2") && Double.parseDouble(data_latih.get(j).get(7).toString()) == 1.0) {
                        gejala_8_kering++;
                    } else if (data_latih.get(j).get(18).toString().equals("K3") && Double.parseDouble(data_latih.get(j).get(7).toString()) == 1.0) {
                        gejala_8_berminyak++;
                    } else if (data_latih.get(j).get(18).toString().equals("K4") && Double.parseDouble(data_latih.get(j).get(7).toString()) == 1.0) {
                        gejala_8_kombinasi++;
                    } else if (data_latih.get(j).get(18).toString().equals("K5") && Double.parseDouble(data_latih.get(j).get(7).toString()) == 1.0) {
                        gejala_8_sensitif++;
                    }
                }
            }

            gejala_8_normal = gejala_8_normal / kulit_normal;
            gejala_8_kering = gejala_8_kering / kulit_kering;
            gejala_8_berminyak = gejala_8_berminyak / kulit_berminyak;
            gejala_8_kombinasi = gejala_8_kombinasi / kulit_kombinasi;
            gejala_8_sensitif = gejala_8_sensitif / kulit_sensitif;

            double gejala_9_normal = 0;
            double gejala_9_kering = 0;
            double gejala_9_berminyak = 0;
            double gejala_9_kombinasi = 0;
            double gejala_9_sensitif = 0;
            if (Double.parseDouble(data_uji.get(i).get(8).toString()) == 1.0) {
                for (int j = 0; j < data_latih.size(); j++) {
                    if (data_latih.get(j).get(18).toString().equals("K1") && Double.parseDouble(data_latih.get(j).get(8).toString()) == 1.0) {
                        gejala_9_normal++;
                    } else if (data_latih.get(j).get(18).toString().equals("K2") && Double.parseDouble(data_latih.get(j).get(8).toString()) == 1.0) {
                        gejala_9_kering++;
                    } else if (data_latih.get(j).get(18).toString().equals("K3") && Double.parseDouble(data_latih.get(j).get(8).toString()) == 1.0) {
                        gejala_9_berminyak++;
                    } else if (data_latih.get(j).get(18).toString().equals("K4") && Double.parseDouble(data_latih.get(j).get(8).toString()) == 1.0) {
                        gejala_9_kombinasi++;
                    } else if (data_latih.get(j).get(18).toString().equals("K5") && Double.parseDouble(data_latih.get(j).get(8).toString()) == 1.0) {
                        gejala_9_sensitif++;
                    }
                }
            }

            gejala_9_normal = gejala_9_normal / kulit_normal;
            gejala_9_kering = gejala_9_kering / kulit_kering;
            gejala_9_berminyak = gejala_9_berminyak / kulit_berminyak;
            gejala_9_kombinasi = gejala_9_kombinasi / kulit_kombinasi;
            gejala_9_sensitif = gejala_9_sensitif / kulit_sensitif;

            double gejala_10_normal = 0;
            double gejala_10_kering = 0;
            double gejala_10_berminyak = 0;
            double gejala_10_kombinasi = 0;
            double gejala_10_sensitif = 0;
            if (Double.parseDouble(data_uji.get(i).get(9).toString()) == 1.0) {
                for (int j = 0; j < data_latih.size(); j++) {
                    if (data_latih.get(j).get(18).toString().equals("K1") && Double.parseDouble(data_latih.get(j).get(9).toString()) == 1.0) {
                        gejala_10_normal++;
                    } else if (data_latih.get(j).get(18).toString().equals("K2") && Double.parseDouble(data_latih.get(j).get(9).toString()) == 1.0) {
                        gejala_10_kering++;
                    } else if (data_latih.get(j).get(18).toString().equals("K3") && Double.parseDouble(data_latih.get(j).get(9).toString()) == 1.0) {
                        gejala_10_berminyak++;
                    } else if (data_latih.get(j).get(18).toString().equals("K4") && Double.parseDouble(data_latih.get(j).get(9).toString()) == 1.0) {
                        gejala_10_kombinasi++;
                    } else if (data_latih.get(j).get(18).toString().equals("K5") && Double.parseDouble(data_latih.get(j).get(9).toString()) == 1.0) {
                        gejala_10_sensitif++;
                    }
                }
            }

            gejala_10_normal = gejala_10_normal / kulit_normal;
            gejala_10_kering = gejala_10_kering / kulit_kering;
            gejala_10_berminyak = gejala_10_berminyak / kulit_berminyak;
            gejala_10_kombinasi = gejala_10_kombinasi / kulit_kombinasi;
            gejala_10_sensitif = gejala_10_sensitif / kulit_sensitif;

            double gejala_11_normal = 0;
            double gejala_11_kering = 0;
            double gejala_11_berminyak = 0;
            double gejala_11_kombinasi = 0;
            double gejala_11_sensitif = 0;
            if (Double.parseDouble(data_uji.get(i).get(10).toString()) == 1.0) {
                for (int j = 0; j < data_latih.size(); j++) {
                    if (data_latih.get(j).get(18).toString().equals("K1") && Double.parseDouble(data_latih.get(j).get(10).toString()) == 1.0) {
                        gejala_11_normal++;
                    } else if (data_latih.get(j).get(18).toString().equals("K2") && Double.parseDouble(data_latih.get(j).get(10).toString()) == 1.0) {
                        gejala_11_kering++;
                    } else if (data_latih.get(j).get(18).toString().equals("K3") && Double.parseDouble(data_latih.get(j).get(10).toString()) == 1.0) {
                        gejala_11_berminyak++;
                    } else if (data_latih.get(j).get(18).toString().equals("K4") && Double.parseDouble(data_latih.get(j).get(10).toString()) == 1.0) {
                        gejala_11_kombinasi++;
                    } else if (data_latih.get(j).get(18).toString().equals("K5") && Double.parseDouble(data_latih.get(j).get(10).toString()) == 1.0) {
                        gejala_11_sensitif++;
                    }
                }
            }

            gejala_11_normal = gejala_11_normal / kulit_normal;
            gejala_11_kering = gejala_11_kering / kulit_kering;
            gejala_11_berminyak = gejala_11_berminyak / kulit_berminyak;
            gejala_11_kombinasi = gejala_11_kombinasi / kulit_kombinasi;
            gejala_11_sensitif = gejala_11_sensitif / kulit_sensitif;

            double gejala_12_normal = 0;
            double gejala_12_kering = 0;
            double gejala_12_berminyak = 0;
            double gejala_12_kombinasi = 0;
            double gejala_12_sensitif = 0;
            if (Double.parseDouble(data_uji.get(i).get(11).toString()) == 1.0) {
                for (int j = 0; j < data_latih.size(); j++) {
                    if (data_latih.get(j).get(18).toString().equals("K1") && Double.parseDouble(data_latih.get(j).get(11).toString()) == 1.0) {
                        gejala_12_normal++;
                    } else if (data_latih.get(j).get(18).toString().equals("K2") && Double.parseDouble(data_latih.get(j).get(11).toString()) == 1.0) {
                        gejala_12_kering++;
                    } else if (data_latih.get(j).get(18).toString().equals("K3") && Double.parseDouble(data_latih.get(j).get(11).toString()) == 1.0) {
                        gejala_12_berminyak++;
                    } else if (data_latih.get(j).get(18).toString().equals("K4") && Double.parseDouble(data_latih.get(j).get(11).toString()) == 1.0) {
                        gejala_12_kombinasi++;
                    } else if (data_latih.get(j).get(18).toString().equals("K5") && Double.parseDouble(data_latih.get(j).get(11).toString()) == 1.0) {
                        gejala_12_sensitif++;
                    }
                }
            }

            gejala_12_normal = gejala_12_normal / kulit_normal;
            gejala_12_kering = gejala_12_kering / kulit_kering;
            gejala_12_berminyak = gejala_12_berminyak / kulit_berminyak;
            gejala_12_kombinasi = gejala_12_kombinasi / kulit_kombinasi;
            gejala_12_sensitif = gejala_12_sensitif / kulit_sensitif;

            double gejala_13_normal = 0;
            double gejala_13_kering = 0;
            double gejala_13_berminyak = 0;
            double gejala_13_kombinasi = 0;
            double gejala_13_sensitif = 0;
            if (Double.parseDouble(data_uji.get(i).get(12).toString()) == 1.0) {
                for (int j = 0; j < data_latih.size(); j++) {
                    if (data_latih.get(j).get(18).toString().equals("K1") && Double.parseDouble(data_latih.get(j).get(12).toString()) == 1.0) {
                        gejala_13_normal++;
                    } else if (data_latih.get(j).get(18).toString().equals("K2") && Double.parseDouble(data_latih.get(j).get(12).toString()) == 1.0) {
                        gejala_13_kering++;
                    } else if (data_latih.get(j).get(18).toString().equals("K3") && Double.parseDouble(data_latih.get(j).get(12).toString()) == 1.0) {
                        gejala_13_berminyak++;
                    } else if (data_latih.get(j).get(18).toString().equals("K4") && Double.parseDouble(data_latih.get(j).get(12).toString()) == 1.0) {
                        gejala_13_kombinasi++;
                    } else if (data_latih.get(j).get(18).toString().equals("K5") && Double.parseDouble(data_latih.get(j).get(12).toString()) == 1.0) {
                        gejala_13_sensitif++;
                    }
                }
            }

            gejala_13_normal = gejala_13_normal / kulit_normal;
            gejala_13_kering = gejala_13_kering / kulit_kering;
            gejala_13_berminyak = gejala_13_berminyak / kulit_berminyak;
            gejala_13_kombinasi = gejala_13_kombinasi / kulit_kombinasi;
            gejala_13_sensitif = gejala_13_sensitif / kulit_sensitif;

            double gejala_14_normal = 0;
            double gejala_14_kering = 0;
            double gejala_14_berminyak = 0;
            double gejala_14_kombinasi = 0;
            double gejala_14_sensitif = 0;
            if (Double.parseDouble(data_uji.get(i).get(13).toString()) == 1.0) {
                for (int j = 0; j < data_latih.size(); j++) {
                    if (data_latih.get(j).get(18).toString().equals("K1") && Double.parseDouble(data_latih.get(j).get(13).toString()) == 1.0) {
                        gejala_14_normal++;
                    } else if (data_latih.get(j).get(18).toString().equals("K2") && Double.parseDouble(data_latih.get(j).get(13).toString()) == 1.0) {
                        gejala_14_kering++;
                    } else if (data_latih.get(j).get(18).toString().equals("K3") && Double.parseDouble(data_latih.get(j).get(13).toString()) == 1.0) {
                        gejala_14_berminyak++;
                    } else if (data_latih.get(j).get(18).toString().equals("K4") && Double.parseDouble(data_latih.get(j).get(13).toString()) == 1.0) {
                        gejala_14_kombinasi++;
                    } else if (data_latih.get(j).get(18).toString().equals("K5") && Double.parseDouble(data_latih.get(j).get(13).toString()) == 1.0) {
                        gejala_14_sensitif++;
                    }
                }
            }

            gejala_14_normal = gejala_14_normal / kulit_normal;
            gejala_14_kering = gejala_14_kering / kulit_kering;
            gejala_14_berminyak = gejala_14_berminyak / kulit_berminyak;
            gejala_14_kombinasi = gejala_14_kombinasi / kulit_kombinasi;
            gejala_14_sensitif = gejala_14_sensitif / kulit_sensitif;

            double gejala_15_normal = 0;
            double gejala_15_kering = 0;
            double gejala_15_berminyak = 0;
            double gejala_15_kombinasi = 0;
            double gejala_15_sensitif = 0;
            if (Double.parseDouble(data_uji.get(i).get(14).toString()) == 1.0) {
                for (int j = 0; j < data_latih.size(); j++) {
                    if (data_latih.get(j).get(18).toString().equals("K1") && Double.parseDouble(data_latih.get(j).get(14).toString()) == 1.0) {
                        gejala_15_normal++;
                    } else if (data_latih.get(j).get(18).toString().equals("K2") && Double.parseDouble(data_latih.get(j).get(14).toString()) == 1.0) {
                        gejala_15_kering++;
                    } else if (data_latih.get(j).get(18).toString().equals("K3") && Double.parseDouble(data_latih.get(j).get(14).toString()) == 1.0) {
                        gejala_15_berminyak++;
                    } else if (data_latih.get(j).get(18).toString().equals("K4") && Double.parseDouble(data_latih.get(j).get(14).toString()) == 1.0) {
                        gejala_15_kombinasi++;
                    } else if (data_latih.get(j).get(18).toString().equals("K5") && Double.parseDouble(data_latih.get(j).get(14).toString()) == 1.0) {
                        gejala_15_sensitif++;
                    }
                }
            }

            gejala_15_normal = gejala_15_normal / kulit_normal;
            gejala_15_kering = gejala_15_kering / kulit_kering;
            gejala_15_berminyak = gejala_15_berminyak / kulit_berminyak;
            gejala_15_kombinasi = gejala_15_kombinasi / kulit_kombinasi;
            gejala_15_sensitif = gejala_15_sensitif / kulit_sensitif;

            double gejala_16_normal = 0;
            double gejala_16_kering = 0;
            double gejala_16_berminyak = 0;
            double gejala_16_kombinasi = 0;
            double gejala_16_sensitif = 0;
            if (Double.parseDouble(data_uji.get(i).get(15).toString()) == 1.0) {
                for (int j = 0; j < data_latih.size(); j++) {
                    if (data_latih.get(j).get(18).toString().equals("K1") && Double.parseDouble(data_latih.get(j).get(15).toString()) == 1.0) {
                        gejala_16_normal++;
                    } else if (data_latih.get(j).get(18).toString().equals("K2") && Double.parseDouble(data_latih.get(j).get(15).toString()) == 1.0) {
                        gejala_16_kering++;
                    } else if (data_latih.get(j).get(18).toString().equals("K3") && Double.parseDouble(data_latih.get(j).get(15).toString()) == 1.0) {
                        gejala_16_berminyak++;
                    } else if (data_latih.get(j).get(18).toString().equals("K4") && Double.parseDouble(data_latih.get(j).get(15).toString()) == 1.0) {
                        gejala_16_kombinasi++;
                    } else if (data_latih.get(j).get(18).toString().equals("K5") && Double.parseDouble(data_latih.get(j).get(15).toString()) == 1.0) {
                        gejala_16_sensitif++;
                    }
                }
            }

            gejala_16_normal = gejala_16_normal / kulit_normal;
            gejala_16_kering = gejala_16_kering / kulit_kering;
            gejala_16_berminyak = gejala_16_berminyak / kulit_berminyak;
            gejala_16_kombinasi = gejala_16_kombinasi / kulit_kombinasi;
            gejala_16_sensitif = gejala_16_sensitif / kulit_sensitif;

            double gejala_17_normal = 0;
            double gejala_17_kering = 0;
            double gejala_17_berminyak = 0;
            double gejala_17_kombinasi = 0;
            double gejala_17_sensitif = 0;
            if (Double.parseDouble(data_uji.get(i).get(16).toString()) == 1.0) {
                for (int j = 0; j < data_latih.size(); j++) {
                    if (data_latih.get(j).get(18).toString().equals("K1") && Double.parseDouble(data_latih.get(j).get(16).toString()) == 1.0) {
                        gejala_17_normal++;
                    } else if (data_latih.get(j).get(18).toString().equals("K2") && Double.parseDouble(data_latih.get(j).get(16).toString()) == 1.0) {
                        gejala_17_kering++;
                    } else if (data_latih.get(j).get(18).toString().equals("K3") && Double.parseDouble(data_latih.get(j).get(16).toString()) == 1.0) {
                        gejala_17_berminyak++;
                    } else if (data_latih.get(j).get(18).toString().equals("K4") && Double.parseDouble(data_latih.get(j).get(16).toString()) == 1.0) {
                        gejala_17_kombinasi++;
                    } else if (data_latih.get(j).get(18).toString().equals("K5") && Double.parseDouble(data_latih.get(j).get(16).toString()) == 1.0) {
                        gejala_17_sensitif++;
                    }
                }
            }

            gejala_17_normal = gejala_17_normal / kulit_normal;
            gejala_17_kering = gejala_17_kering / kulit_kering;
            gejala_17_berminyak = gejala_17_berminyak / kulit_berminyak;
            gejala_17_kombinasi = gejala_17_kombinasi / kulit_kombinasi;
            gejala_17_sensitif = gejala_17_sensitif / kulit_sensitif;

            double gejala_18_normal = 0;
            double gejala_18_kering = 0;
            double gejala_18_berminyak = 0;
            double gejala_18_kombinasi = 0;
            double gejala_18_sensitif = 0;
            if (Double.parseDouble(data_uji.get(i).get(17).toString()) == 1.0) {
                for (int j = 0; j < data_latih.size(); j++) {
                    if (data_latih.get(j).get(18).toString().equals("K1") && Double.parseDouble(data_latih.get(j).get(17).toString()) == 1.0) {
                        gejala_18_normal++;
                    } else if (data_latih.get(j).get(18).toString().equals("K2") && Double.parseDouble(data_latih.get(j).get(17).toString()) == 1.0) {
                        gejala_18_kering++;
                    } else if (data_latih.get(j).get(18).toString().equals("K3") && Double.parseDouble(data_latih.get(j).get(17).toString()) == 1.0) {
                        gejala_18_berminyak++;
                    } else if (data_latih.get(j).get(18).toString().equals("K4") && Double.parseDouble(data_latih.get(j).get(17).toString()) == 1.0) {
                        gejala_18_kombinasi++;
                    } else if (data_latih.get(j).get(18).toString().equals("K5") && Double.parseDouble(data_latih.get(j).get(17).toString()) == 1.0) {
                        gejala_18_sensitif++;
                    }
                }
            }

            gejala_18_normal = gejala_18_normal / kulit_normal;
            gejala_18_kering = gejala_18_kering / kulit_kering;
            gejala_18_berminyak = gejala_18_berminyak / kulit_berminyak;
            gejala_18_kombinasi = gejala_18_kombinasi / kulit_kombinasi;
            gejala_18_sensitif = gejala_18_sensitif / kulit_sensitif;

            double temp_normal = peluang_kulit_normal;
            double temp_kering = peluang_kulit_kering;
            double temp_berminyak = peluang_kulit_berminyak;
            double temp_kombinasi = peluang_kulit_kombinasi;
            double temp_sensitif = peluang_kulit_sensitif;
            double bobot_nol = 0;
            System.out.println("i "+i);
             System.out.println(data_uji.get(i));
            if (Double.parseDouble(data_uji.get(i).get(0).toString()) == 1.0) {
                temp_normal = temp_normal * gejala_1_normal;
                temp_kering = temp_normal * gejala_1_kering;
                temp_berminyak = temp_normal * gejala_1_berminyak;
                temp_kombinasi = temp_normal * gejala_1_kombinasi;
                temp_sensitif = temp_normal * gejala_1_sensitif;
            }
           
            if (Double.parseDouble(data_uji.get(i).get(1).toString()) == 1.0) {
                temp_normal = temp_normal * gejala_2_normal;
                temp_kering = temp_kering * gejala_2_kering;
                temp_berminyak = temp_berminyak * gejala_2_berminyak;
                temp_kombinasi = temp_kombinasi * gejala_2_kombinasi;
                temp_sensitif = temp_sensitif * gejala_2_sensitif;
            }
            if (Double.parseDouble(data_uji.get(i).get(2).toString()) == 1.0) {
                temp_normal = temp_normal * gejala_3_normal;
                temp_kering = temp_kering * gejala_3_kering;
                temp_berminyak = temp_berminyak * gejala_3_berminyak;
                temp_kombinasi = temp_kombinasi * gejala_3_kombinasi;
                temp_sensitif = temp_sensitif * gejala_3_sensitif;
            }
            if (Double.parseDouble(data_uji.get(i).get(3).toString()) == 1.0) {
                temp_normal = temp_normal * gejala_4_normal;
                temp_kering = temp_kering * gejala_4_kering;
                temp_berminyak = temp_berminyak * gejala_4_berminyak;
                temp_kombinasi = temp_kombinasi * gejala_4_kombinasi;
                temp_sensitif = temp_sensitif * gejala_4_sensitif;
            }
            if (Double.parseDouble(data_uji.get(i).get(4).toString()) == 1.0) {
                temp_normal = temp_normal * gejala_5_normal;
                temp_kering = temp_kering * gejala_5_kering;
                temp_berminyak = temp_berminyak * gejala_5_berminyak;
                temp_kombinasi = temp_kombinasi * gejala_5_kombinasi;
                temp_sensitif = temp_sensitif * gejala_5_sensitif;
            }
            if (Double.parseDouble(data_uji.get(i).get(5).toString()) == 1.0) {
                temp_normal = temp_normal * gejala_6_normal;
                temp_kering = temp_kering * gejala_6_kering;
                temp_berminyak = temp_berminyak * gejala_6_berminyak;
                temp_kombinasi = temp_kombinasi * gejala_6_kombinasi;
                temp_sensitif = temp_sensitif * gejala_6_sensitif;
            }
            if (Double.parseDouble(data_uji.get(i).get(6).toString()) == 1.0) {
                temp_normal = temp_normal * gejala_7_normal;
                temp_kering = temp_kering * gejala_7_kering;
                temp_berminyak = temp_berminyak * gejala_7_berminyak;
                temp_kombinasi = temp_kombinasi * gejala_7_kombinasi;
                temp_sensitif = temp_sensitif * gejala_7_sensitif;
            }
            if (Double.parseDouble(data_uji.get(i).get(7).toString()) == 1.0) {
                temp_normal = temp_normal * gejala_8_normal;
                temp_kering = temp_kering * gejala_8_kering;
                temp_berminyak = temp_berminyak * gejala_8_berminyak;
                temp_kombinasi = temp_kombinasi * gejala_8_kombinasi;
                temp_sensitif = temp_sensitif * gejala_8_sensitif;
            }
            if (Double.parseDouble(data_uji.get(i).get(8).toString()) == 1.0) {
                temp_normal = temp_normal * gejala_9_normal;
                temp_kering = temp_kering * gejala_9_kering;
                temp_berminyak = temp_berminyak * gejala_9_berminyak;
                temp_kombinasi = temp_kombinasi * gejala_9_kombinasi;
                temp_sensitif = temp_sensitif * gejala_9_sensitif;
            }
            if (Double.parseDouble(data_uji.get(i).get(9).toString()) == 1.0) {
                temp_normal = temp_normal * gejala_10_normal;
                temp_kering = temp_kering * gejala_10_kering;
                temp_berminyak = temp_berminyak * gejala_10_berminyak;
                temp_kombinasi = temp_kombinasi * gejala_10_kombinasi;
                temp_sensitif = temp_sensitif * gejala_10_sensitif;
            }
            if (Double.parseDouble(data_uji.get(i).get(10).toString()) == 1.0) {
                temp_normal = temp_normal * gejala_11_normal;
                temp_kering = temp_kering * gejala_11_kering;
                temp_berminyak = temp_berminyak * gejala_11_berminyak;
                temp_kombinasi = temp_kombinasi * gejala_11_kombinasi;
                temp_sensitif = temp_sensitif * gejala_11_sensitif;
            }
            if (Double.parseDouble(data_uji.get(i).get(11).toString()) == 1.0) {
                temp_normal = temp_normal * gejala_12_normal;
                temp_kering = temp_kering * gejala_12_kering;
                temp_berminyak = temp_berminyak * gejala_12_berminyak;
                temp_kombinasi = temp_kombinasi * gejala_12_kombinasi;
                temp_sensitif = temp_sensitif * gejala_12_sensitif;
            }
            if (Double.parseDouble(data_uji.get(i).get(12).toString()) == 1.0) {
                temp_normal = temp_normal * gejala_13_normal;
                temp_kering = temp_kering * gejala_13_kering;
                temp_berminyak = temp_berminyak * gejala_13_berminyak;
                temp_kombinasi = temp_kombinasi * gejala_13_kombinasi;
                temp_sensitif = temp_sensitif * gejala_13_sensitif;
            }
            if (Double.parseDouble(data_uji.get(i).get(13).toString()) == 1.0) {
                temp_normal = temp_normal * gejala_14_normal;
                temp_kering = temp_kering * gejala_14_kering;
                temp_berminyak = temp_berminyak * gejala_14_berminyak;
                temp_kombinasi = temp_kombinasi * gejala_14_kombinasi;
                temp_sensitif = temp_sensitif * gejala_14_sensitif;
            }
            if (Double.parseDouble(data_uji.get(i).get(14).toString()) == 1.0) {
                temp_normal = temp_normal * gejala_15_normal;
                temp_kering = temp_kering * gejala_15_kering;
                temp_berminyak = temp_berminyak * gejala_15_berminyak;
                temp_kombinasi = temp_kombinasi * gejala_15_kombinasi;
                temp_sensitif = temp_sensitif * gejala_15_sensitif;
            }
            if (Double.parseDouble(data_uji.get(i).get(15).toString()) == 1.0) {
                temp_normal = temp_normal * gejala_16_normal;
                temp_kering = temp_kering * gejala_16_kering;
                temp_berminyak = temp_berminyak * gejala_16_berminyak;
                temp_kombinasi = temp_kombinasi * gejala_16_kombinasi;
                temp_sensitif = temp_sensitif * gejala_16_sensitif;
            }
            if (Double.parseDouble(data_uji.get(i).get(16).toString()) == 1.0) {
                temp_normal = temp_normal * gejala_17_normal;
                temp_kering = temp_kering * gejala_17_kering;
                temp_berminyak = temp_berminyak * gejala_17_berminyak;
                temp_kombinasi = temp_kombinasi * gejala_17_kombinasi;
                temp_sensitif = temp_sensitif * gejala_17_sensitif;
            }
            if (Double.parseDouble(data_uji.get(i).get(17).toString()) == 1.0) {
                temp_normal = temp_normal * gejala_18_normal;
                temp_kering = temp_kering * gejala_18_kering;
                temp_berminyak = temp_berminyak * gejala_18_berminyak;
                temp_kombinasi = temp_kombinasi * gejala_18_kombinasi;
                temp_sensitif = temp_sensitif * gejala_18_sensitif;
            }                                
            
            

            
            ArrayList<Double> akhir = new ArrayList<>();
            akhir.add(temp_normal);
            akhir.add(temp_kering);
            akhir.add(temp_berminyak);
            akhir.add(temp_kombinasi);
            akhir.add(temp_sensitif);

            ArrayList<Double> nilai_urut = new ArrayList<>(akhir);
            int max = akhir.indexOf(nilai_urut.get(0));
            int index = 0;
            
            for (int j = 0; j < akhir.size(); j++) {
                if (nilai_urut.get(j) > max) {
                    max = akhir.indexOf(nilai_urut.get(j));
                    index = j;
                }
            }   
            bobot.add(akhir.get(max));
                if(index == 0){
                    hasil.add("K1");
                }else if(index == 1){
                    hasil.add("K2");
                }else if(index == 2){
                    hasil.add("K3");
                }else if (index == 3) {
                    hasil.add("K4");
                } else if(index == 4){
                    hasil.add("K5");
                }else{
                    hasil.add("K0");
                }

        }
        
        for (int i = 0; i< hasil.size(); i++){
            if(hasil.get(i).equals("K1")){
                penyakit.add("Kulit Normal");
            } else if(hasil.get(i).equals("K2")){
                penyakit.add("Kulit Kering");
            } else if(hasil.get(i).equals("K3")){
                penyakit.add("Kulit Berminyak");
            } else if(hasil.get(i).equals("K4")){
                penyakit.add("Kulit Kombinasi");
            } else if(hasil.get(i).equals("K5")){
                penyakit.add("Kulit Sensitif");
            }else if(hasil.get(i).equals("K0")){
                penyakit.add("Kulit tidak terdiagnosis");
            }else if(hasil.isEmpty()){
                penyakit.add("tidak terdiagnosis");
            }
        }
        
        for (int i = 0; i< hasil.size(); i++){
            if(hasil.get(i).equals("K1")){
                penjelasan.add("Jenis kulit normal adalah jenis kulit yang terlihat segar dan sehat,  memiliki pori pori kecil, tidak memiliki minyak berlebih dan tampak halus.  Pada kulit normal kotoran dikeluar dengan baik dan zat zat yang berguna  diserap dengan baik sehingga jarang mengalami masalah kulit seperti jerawat.");
            } else if(hasil.get(i).equals("K2")){
                penjelasan.add("Pada jenis kulit kering jumlah minyak yang dikeluarkan oleh kelenjar  minyak cenderung sedikit, sehingga wajah kehilangan kelembaban dengan  cepat. Akibat dari minyak yang sedikit maka kulit wajah juga mudah timbul  keriput, kering, dan kusam. Pada kulit kering lubang pori pori cenderung  kecil sehingga jarang mengalami masalah jerawat.");
            } else if(hasil.get(i).equals("K3")){
                penjelasan.add("Jenis kulit berminyak terjadi karerna kelenjar minyak pada wajah bekerja  berlebihan sehingga kulit terlihat mengkilat, pori pori besar, dan sering  mengalami masalah jerawat, namun tidak mudah mendapatkan kerutan pada  wajah berminyak");
            } else if(hasil.get(i).equals("K4")){
                penjelasan.add("Jenis kulit wajah kombinasi adalah jenis kulit wajah gabungan dari  beberapa jenis kulit contohnya seperti gabungan antara kulit normal, kering  dan berminyak dimana pada daerah tertentu kulit cenderung berminyak  seperti pada daerah dagu, hidung, dan dahi yang sering disebut T-zone atau  daerah T dan kulit kering atau normal pada bagian lainnya.");
            } else if(hasil.get(i).equals("K5")){
                penjelasan.add("Jenis kulit wajah sensitif adalah jenis kulit wajah yang mudah mengalami  iritasi, alergi, ataupun kemerahan yang disebabkan oleh beberapa factor  seperti penggunaan produk kosmetik, lingkungan serta makanan tertentu.  Dalam merawat jenis kulit sensitf membutuhkan perawatan yang ekstra dalam  merawatnya.");
            } else if(hasil.get(i).equals("K0")){
                penjelasan.add("bobot 0 tidak dapat memberi solusi");
            }
        }
    }
}
