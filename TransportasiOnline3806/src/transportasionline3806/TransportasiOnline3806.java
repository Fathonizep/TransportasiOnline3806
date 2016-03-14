/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transportasionline3806;

/**
 *
 * @author eddomirsyad
 */
public class TransportasiOnline3806 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}

/**
 * 
 * FATHONI ZEPTIAN EKA PURNOMO 1301144286 :D
**/
 
 
 public abstract class Orang{
	private String nama;
	private String notelp;

	public Orang (String nama,String notelp){
		this.nama=nama;
		this.notelp=notelp;
	}

	public void setNama(String nama){
		this.nama=nama;
	}

	public String getNama(){
		return nama;
	}

	public void setNotelp(String notelp){
		this.notelp=notelp;
	}

	public String getNotelp(){
		return notelp;
	}

}


public class Pesanan{
	private String jenisPesanan;
	private String tujuan;
	private int tarif;
	private int jarak;

	public Pesanan (String jenisPesanan,String tujuan,int tarif,int jarak){
		this.jenisPesanan=jenisPesanan;
		this.tujuan=tujuan;
		this.tarif=tarif;
		this.jarak=jarak;
	}

	public void setJenisPesanan(String jenisPesanan){
		this.jenisPesanan=jenisPesanan;
	}

	public String getJenisPesanan(){
		return jenisPesanan;
	}

	public void setTujuan(String tujuan){
		this.tujuan=tujuan;
	}

	public String getTujuan(){
		return tujuan;
	}

	public void setTarif(int tarif){
		this.tarif=tarif;
	}

	public int getTarif(){
		return tarif;
	}

	public void setJarak(int jarak){
		this.jarak=jarak;
	}

	public int getJarak(){
		return jarak;
	}

}
  
 /**
  * TAMBAHAN BELUM ADA CREATEKURIR
  * ??
  * */
  
  public class Pelanggan extends Orang{
	private Pesanan[] pesanan;
	private long idPelanggan;
	private String alamat;
	private int list=0;
	private int y;

	public Pelanggan(String nama,String notelp,long idPelanggan,String alamat,int x){
		super(nama,notelp);
		this.alamat=alamat;
		this.idPelanggan=idPelanggan;
		y=x;
		pesanan = new Pesanan[x]; 
	} 

	public void createPesanan(Pesanan pesan){
		if (list<y){
			this.pesanan[list]=pesan;
			list++;
		}
		else
		{
			System.out.println("Pesanan Full");
		}
	}

	//public void createPesananKurir(Kurir kurir){
		
	//}
	public void setIdPelanggan(long idPelanggan){
		this.idPelanggan=idPelanggan;
	}

	public long getIdPelanggan(){
		return idPelanggan; 
	}

	public void setAlamat(String alamat){
		this.alamat=alamat;
	}

	public String getAlamat(){
		return alamat;
	}
}

