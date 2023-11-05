/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz52021004;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.DataOutputStream;
import java.io.DataInputStream;


/**
 *
 * @author kiyoshi
 */
public class IO_52021004 {
    int lulus=0, tidaklulus=0;
    public void SimpanData(String nim, String nama, String tugas, String quiz, String mid, String nilai_final, String nilai_total, String skor_akhir){
        try{
            FileOutputStream fout=new FileOutputStream("QUIZ52021004.dat",true);
            DataOutputStream out=new DataOutputStream(fout);
            out.writeUTF(nim);
            out.writeUTF(nama);
            out.writeUTF(tugas);
            out.writeUTF(quiz);
            out.writeUTF(mid);
            out.writeUTF(nilai_final);
            out.writeUTF(nilai_total);
            out.writeUTF(skor_akhir);
            out.close();
        }catch(IOException e){
            System.out.println(e.toString());
        }
        
        
    }   
    
     public String ReadData(){
        String nim,nama,tugas,quiz,mid,nilai_final,nilai_total,skor_akhir;
        String temp="",data="";
        try{
            FileInputStream fin=new FileInputStream("QUIZ52021004.dat");
            DataInputStream in=new DataInputStream(fin);
          
            while (in.available()>0){
                nim=in.readUTF();
                nama=in.readUTF();
                tugas=in.readUTF();
                quiz=in.readUTF();
                mid=in.readUTF();
                nilai_final=in.readUTF();
                nilai_total=in.readUTF();     //ambil Id sales
                skor_akhir=in.readUTF();  //ambil Point sales
                if (nilai_total.equals("E")){
                    tidaklulus++;
                }else {
                    lulus++;
                }
                temp="nim= "+nim+"\n nama= "+nama+"\n tugas= "+tugas+"\n quiz= "+quiz+"\n mid= "+mid+"\n nilai final= "+nilai_final+"\n nilai total= "+nilai_total+"\n nilai huruf="+skor_akhir+"\n ";  //bentuk string
                data+=temp; //masukkan setiap data ke string akhir
            }                              
            in.close();
        }catch(IOException e){
            System.out.println(e.toString());
        }
        return(data);
    }
    public int getlulus(){
        return lulus;
    }
     public int gettidaklulus(){
        return tidaklulus;
    }
}

