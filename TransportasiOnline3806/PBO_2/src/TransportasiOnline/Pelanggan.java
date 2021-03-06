/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransportasiOnline;

import Configuration.Database;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author x
 */
public class Pelanggan  extends Orang implements Serializable {

    private Pesanan[] pesanan;
    private String idPelanggan;
    private int jmlPesanan;
    private static int countPel;

    public Pelanggan(String nama, String jenKel, String noTelp) {
        super(nama, jenKel, noTelp);
        pesanan = new Pesanan[100];
        countPel++;
        try {
            this.setIdPelanggan(makeIdPelanggan());
        } catch (SQLException ex) {
            System.out.println("Make Id Failed.");
        }
    }

    public Pelanggan(String nama, String noTelp) {
        super(nama, "", noTelp);
    }

    public Pelanggan(String idPelanggan, String nama, String jenKel, String noTelp) {
        super(nama, jenKel, noTelp);
        pesanan = new Pesanan[100];
        this.idPelanggan = idPelanggan;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(String idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public Pesanan createPesanan(String jenisPesanan, String alamat,
            String tujuan, int jarak, int tarif) {
        Pesanan p = null;
        pesanan[jmlPesanan] = new Pesanan(jenisPesanan, alamat,
                tujuan, jarak, tarif, super.getJenKel());
        p = pesanan[jmlPesanan];
        jmlPesanan++;
        return p;
    }

    public void createPesanan(String idTrans, String jenisPesanan, String alamat, String tujuan, int tarif,
            int jarak, boolean status, String jk) {
        pesanan[jmlPesanan] = new Pesanan(idTrans, jenisPesanan, alamat, tujuan,
                tarif, jarak, status, jk);
        jmlPesanan++;
    }

    public void createPesanKurir(String idTrans, String jenisPesanan, String alamat,
            String tujuan, int jarak, String namaBarang, int tarif, boolean status,
            String jk) {
        pesanan[jmlPesanan] = new Kurir(idTrans, jenisPesanan,
                alamat, tujuan, jarak, namaBarang, tarif, status, jk);
        jmlPesanan++;
    }

    public Kurir createPesananKurir(String jenisPesanan, String alamat,
            String tujuan, int jarak, int tarif, String namaBarang) {
        Kurir k = null;
        pesanan[jmlPesanan] = new Kurir(jenisPesanan,
                alamat, tujuan, jarak, namaBarang, tarif, super.getJenKel());
        k = (Kurir) pesanan[jmlPesanan];
        jmlPesanan++;
        return k;
    }

    public void removePesanan(String idTrans) {
        boolean found = false;
        for (int i = 0; i < jmlPesanan; i++) {
            if (pesanan[i].getIdTrans().equals(idTrans)) {
                found = true;
                for (int j = i; j < jmlPesanan; j++) {
                    pesanan[j] = pesanan[j + 1];
                }
                jmlPesanan--;
                System.out.println("Data Berhasil Dihapus.");
                break;
            }
        }
        if (found == false) {
            System.out.println("Pesanan Tidak Ditemukan.");
        }
    }

    public Pesanan getPesanan(int n) {
        return pesanan[n];
    }

    public Pesanan getPesanan(String idTrans) {
        boolean found = false;
        Pesanan p = null;
        for (int i = 0; i < jmlPesanan; i++) {
            if (pesanan[i].getIdTrans().equals(idTrans)) {
                found = true;
                p = pesanan[i];
                break;
            }
        }
        return p;
    }

    public int getJmlPesanan() {
        return jmlPesanan;
    }

    public String makeIdPelanggan() throws SQLException {
        Database db = new Database();
        db.connect();
        int data = 0;
        String query = "select * from counter";
        ResultSet hasil = db.getData(query);
        try {
            if (hasil.next()) {
                data = hasil.getInt("countpelanggan");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        data++;
        String id = "P";
        if (data / 10 > 9) {
            id = id + data;
        } else if (data / 10 > 0) {
            id = id + "0" + data;
        } else {
            id = id + "00" + data;
        }
        String queryupdate = "update counter set countpelanggan = " + data
                + " where no = 1";
        db.manipulasiData(queryupdate);
        return id;
    }
}
