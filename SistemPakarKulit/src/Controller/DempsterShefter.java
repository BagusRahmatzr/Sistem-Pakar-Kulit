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
 * @author malianzikri
 */
public class DempsterShefter {

    ArrayList<String> hasil = new ArrayList<>();
    ArrayList<String> penjelasan = new ArrayList<>();
    ArrayList<Double> bobot = new ArrayList<>();
    ArrayList<String> penyakit = new ArrayList<>();
    Excel ex = new Excel();

    public ArrayList<String> get_hasil() {
        return hasil;
    }

    public ArrayList<String> get_penjelasan() {
        return penjelasan;
    }

    public ArrayList<Double> get_bobot() {
        return bobot;
    }

    public ArrayList<String> get_penyakit() {
        return penyakit;
    }

    public void do_dempster(ArrayList<ArrayList> data_uji) {

        String file_bobot = System.getProperty("user.dir") + "/Data/data dempster.xlsx";
        ArrayList<ArrayList> bobot_kondisi_kulit = ex.load_excel(file_bobot);

        hasil = new ArrayList<>();
        penjelasan = new ArrayList<>();
        bobot = new ArrayList<>();
        penyakit = new ArrayList<>();

        for (int i = 0; i < data_uji.size(); i++) {
            ArrayList<String> hasil_temp = new ArrayList<>();
            ArrayList<Double> nilai_temp = new ArrayList<>();
            for (int j = 0; j < data_uji.get(i).size() - 1; j++) {
                ArrayList<String> temp = new ArrayList<>();
                ArrayList<Double> temps = new ArrayList<>();

                if (hasil_temp.isEmpty() && Double.parseDouble(data_uji.get(i).get(j).toString()) == 1.0) {
                    hasil_temp.add(bobot_kondisi_kulit.get(j).get(1).toString());
                    hasil_temp.add("k0");

                    nilai_temp.add(Double.parseDouble(bobot_kondisi_kulit.get(j).get(2).toString()));
                    nilai_temp.add(Double.parseDouble(bobot_kondisi_kulit.get(j).get(3).toString()));
                } else if (Double.parseDouble(data_uji.get(i).get(j).toString()) == 1.0) {

                    temp.add(bobot_kondisi_kulit.get(j).get(1).toString());
                    temp.add("k0");
                    temps.add(Double.parseDouble(bobot_kondisi_kulit.get(j).get(2).toString()));
                    temps.add(Double.parseDouble(bobot_kondisi_kulit.get(j).get(3).toString()));

                    ArrayList<String> hasils = new ArrayList<>();
                    ArrayList<Double> nilais = new ArrayList<>();
                    double teta = 0.0;
                    for (int k = 0; k < hasil_temp.size(); k++) {
                        for (int l = 0; l < temp.size(); l++) {
                            if (hasil_temp.get(k).equals(temp.get(l))) {
                                boolean check = false;
                                int index = 0;
                                for (int m = 0; m < hasils.size(); m++) {
                                    if (hasils.get(m).equals(hasil_temp.get(k))) {
                                        check = true;
                                        index = m;
                                        break;
                                    } else if (hasils.get(m).equals(temp.get(l))) {
                                        check = true;
                                        index = m;
                                        break;
                                    }
                                }

                                if (check == false) {
                                    hasils.add(hasil_temp.get(k));
                                    nilais.add(nilai_temp.get(k) * temps.get(l) / (1 - teta));
                                } else {
                                    double penampung = nilais.get(index);
                                    nilais.set(index, penampung + (nilai_temp.get(k) * temps.get(l)) / (1 - teta));

                                }
                                System.out.println("hasil");
                                System.out.println(hasils);

                            } else if (hasil_temp.get(k).equals("k0") && temp.get(l).equals("k0")) {
                                boolean check = false;
                                int index = 0;
                                for (int m = 0; m < hasils.size(); m++) {
                                    if (hasils.get(m).equals(hasil_temp.get(i))) {
                                        check = true;
                                        index = m;
                                        break;
                                    }
                                }

                                if (check == false) {
                                    hasils.add(hasil_temp.get(k));
                                    nilais.add(nilai_temp.get(k) * temps.get(l) / (1 - teta));
                                } else {
                                    double penampung = nilais.get(index);
                                    nilais.set(index, penampung + (nilai_temp.get(k) * temps.get(l)) / (1 - teta));

                                }
                                System.out.println("hasil");
                                System.out.println(hasils);
                            } else if (hasil_temp.get(k).contains(temp.get(l))) {
                                boolean check = false;
                                int index = 0;
                                for (int m = 0; m < hasils.size(); m++) {
                                    if (hasils.get(m).equals(hasil_temp.get(k))) {
                                        check = true;
                                        index = m;
                                        break;
                                    } else if (hasils.get(m).equals(temp.get(l))) {
                                        check = true;
                                        index = m;
                                        break;
                                    }
                                }

                                if (check == false) {
                                    hasils.add(temp.get(l));
                                    nilais.add(nilai_temp.get(k) * temps.get(l) / (1 - teta));
                                } else {
                                    double penampung = nilais.get(index);
                                    nilais.set(index, penampung + (nilai_temp.get(k) * temps.get(l)) / (1 - teta));

                                }
                                System.out.println("hasil");
                                System.out.println(hasils);
                            } else if (temp.get(l).contains(hasil_temp.get(k))) {
                                boolean check = false;
                                int index = 0;
                                for (int m = 0; m < hasils.size(); m++) {
                                    if (hasils.get(m).equals(hasil_temp.get(k))) {
                                        check = true;
                                        index = m;
                                        break;
                                    } else if (hasils.get(m).equals(temp.get(l))) {
                                        check = true;
                                        index = m;
                                        break;
                                    }
                                }

                                if (check == false) {
                                    hasils.add(hasil_temp.get(k));
                                    nilais.add(nilai_temp.get(k) * temps.get(l) / (1 - teta));
                                } else {
                                    double penampung = nilais.get(index);
                                    nilais.set(index, penampung + (nilai_temp.get(k) * temps.get(l)) / (1 - teta));

                                }
                                System.out.println("hasil");
                                System.out.println(hasils);
                            } else {
                                boolean check = false;
                                int index = 0;
                                for (int m = 0; m < hasils.size(); m++) {
                                    if (hasils.get(m).equals(hasil_temp.get(k))) {
                                        check = true;
                                        index = m;
                                        break;
                                    } else if (hasils.get(m).equals(temp.get(l))) {
                                        check = true;
                                        index = m;
                                        break;
                                    }
                                }

                                if (check == false) {
                                    if (hasil_temp.get(k).equals("k0") && !temp.get(l).equals("k0")) {
                                        hasils.add(temp.get(l));
                                        nilais.add(nilai_temp.get(k) * temps.get(l) / (1 - teta));
                                    } else if (temp.get(l).equals("k0") && !hasil_temp.get(k).equals("k0")) {
                                        hasils.add(hasil_temp.get(k));
                                        nilais.add(nilai_temp.get(k) * temps.get(l) / (1 - teta));
                                    } else {
                                        teta = (nilai_temp.get(k) * temps.get(l)) + teta;

                                    }

                                } else {
                                    double penampung = nilais.get(index);
                                    nilais.set(index, penampung + (nilai_temp.get(k) * temps.get(l)) / (1 - teta));

                                }

                            }

                        }
                    }

                    hasil_temp = new ArrayList<>(hasils);
                    nilai_temp = new ArrayList<>(nilais);

                }

            }
            ArrayList<Double> nilai_urut = new ArrayList<>(nilai_temp);
            int index_terbaik = nilai_temp.indexOf(nilai_urut.get(0));

            int max_num = nilai_temp.indexOf(nilai_urut.get(0));
            for (int j = 0; j < nilai_urut.size(); j++) {
                if (nilai_urut.get(j) > max_num) {
                    max_num = nilai_temp.indexOf(nilai_urut.get(j));
                }
            }

            if (nilai_temp.get(index_terbaik) > nilai_temp.get(max_num)) {
                hasil.add(hasil_temp.get(index_terbaik));
                bobot.add(nilai_temp.get(index_terbaik));
            } else {
                hasil.add(hasil_temp.get(max_num));
                bobot.add(nilai_temp.get(max_num));
            }

        }
        System.out.println("dempster");
        System.out.println("hasil ");
        System.out.println(hasil);
        System.out.println("bobot ");
        System.out.println(bobot);

        for (int i = 0; i < hasil.size(); i++) {
            if (hasil.get(i).equals("K1")) {
                penyakit.add("Kulit Normal");
            } else if (hasil.get(i).equals("K2")) {
                penyakit.add("Kulit Kering");
            } else if (hasil.get(i).equals("K3")) {
                penyakit.add("Kulit Berminyak");
            } else if (hasil.get(i).equals("K4")) {
                penyakit.add("Kulit Kombinasi");
            } else if (hasil.get(i).equals("K5")) {
                penyakit.add("Kulit Sensitif");
            } else if (hasil.get(i).equals("K1,K2")) {
                penyakit.add("Kulit Normal/Kering");
            } else if (hasil.get(i).equals("K2,K1")) {
                penyakit.add("Kulit Normal/Kering");
            } else if (hasil.get(i).equals("K3,K4")) {
                penyakit.add("Kulit Berminyak/Kombinasi");
            } else if (hasil.get(i).equals("K2,K4")) {
                penyakit.add("Kulit Kering/Kombinasi");
            } else if (hasil.get(i).equals("K4,K3")) {
                penyakit.add("Kulit Kombinasi/Berminyak");
            } else if (hasil.get(i).equals("K3,K5")) {
                penyakit.add("Kulit Berminyak/Sensitif");
            } else if (hasil.get(i).equals("K4,K5")) {
                penyakit.add("Kulit Kombinasi/Sensitif");
            } else if (hasil.get(i).equals("K3,K4,K5")) {
                penyakit.add("Kulit Berminyak/Kombinasi/Sensitif");
            } else if (hasil.get(i).equals("K2,K3,K4,K5")) {
                penyakit.add("Kulit Kering/Berminyak/Kombinasi/Sensitif");
            } else if (hasil.get(i).equals("K4,K3,K5")) {
                penyakit.add("Kulit Berminyak/Kombinasi/Sensitif");
            }
        }

        for (int i = 0; i < hasil.size(); i++) {
            if (hasil.get(i).contains("K1")) {
                penjelasan.add("Jenis kulit normal adalah jenis kulit yang terlihat segar dan sehat,  memiliki pori pori kecil, tidak memiliki minyak berlebih dan tampak halus.  Pada kulit normal kotoran dikeluar dengan baik dan zat zat yang berguna  diserap dengan baik sehingga jarang mengalami masalah kulit seperti jerawat.");
            } else if (hasil.get(i).contains("K2")) {
                penjelasan.add("Pada jenis kulit kering jumlah minyak yang dikeluarkan oleh kelenjar  minyak cenderung sedikit, sehingga wajah kehilangan kelembaban dengan  cepat. Akibat dari minyak yang sedikit maka kulit wajah juga mudah timbul  keriput, kering, dan kusam. Pada kulit kering lubang pori pori cenderung  kecil sehingga jarang mengalami masalah jerawat.");
            } else if (hasil.get(i).contains("K3")) {
                penjelasan.add("Jenis kulit berminyak terjadi karerna kelenjar minyak pada wajah bekerja  berlebihan sehingga kulit terlihat mengkilat, pori pori besar, dan sering  mengalami masalah jerawat, namun tidak mudah mendapatkan kerutan pada  wajah berminyak");
            } else if (hasil.get(i).contains("K4")) {
                penjelasan.add("Jenis kulit wajah kombinasi adalah jenis kulit wajah gabungan dari  beberapa jenis kulit contohnya seperti gabungan antara kulit normal, kering  dan berminyak dimana pada daerah tertentu kulit cenderung berminyak  seperti pada daerah dagu, hidung, dan dahi yang sering disebut T-zone atau  daerah T dan kulit kering atau normal pada bagian lainnya.");
            } else if (hasil.get(i).contains("K5")) {
                penjelasan.add("Jenis kulit wajah sensitif adalah jenis kulit wajah yang mudah mengalami  iritasi, alergi, ataupun kemerahan yang disebabkan oleh beberapa factor  seperti penggunaan produk kosmetik, lingkungan serta makanan tertentu.  Dalam merawat jenis kulit sensitf membutuhkan perawatan yang ekstra dalam  merawatnya.");
            }
        }
    }
}
