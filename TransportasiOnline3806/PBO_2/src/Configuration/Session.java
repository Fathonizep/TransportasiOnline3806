/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuration;

/**
 *
 * @author x
 */
public class Session {

    private static String id_ss;
    private static String nama_ss;
    private static String jenkel_ss;
    private static String notelp_ss;

    public static String getId_ss() {
        return id_ss;
    }

    public static void setId_ss(String id_ss) {
        Session.id_ss = id_ss;
    }

    public static String getNama_ss() {
        return nama_ss;
    }

    public static void setNama_ss(String nama_ss) {
        Session.nama_ss = nama_ss;
    }

    public static String getJenkel_ss() {
        return jenkel_ss;
    }

    public static void setJenkel_ss(String jenkel_ss) {
        Session.jenkel_ss = jenkel_ss;
    }

    public static String getNotelp_ss() {
        return notelp_ss;
    }

    public static void setNotelp_ss(String notelp_ss) {
        Session.notelp_ss = notelp_ss;
    }
}
