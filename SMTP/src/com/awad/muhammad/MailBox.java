package com.awad.muhammad;
import java.io.File;
import javax.swing.filechooser.FileSystemView;
import com.awad.muhammad.TransmissonChannel;

public class MailBox {
	private String mailPath;
	
	public MailBox(String mailAddress){
		File[] paths;
		FileSystemView fsv=FileSystemView.getFileSystemView();
		paths=File.listRoots();
		
		if(paths.length>0){
			File mailBox=new File(paths[0].toString()+"SMTPMailDir"+"\\"+mailAddress);
			if(!mailBox.exists()){
				mailBox.mkdirs();
			}else{
				System.out.println("MailBox "+mailAddress+" Already exists!");
			}
		}
		
		
		/*for(File path:paths){
			System.out.println("Drive Name: "+path);
			System.out.println("Description: "+ fsv.getSystemTypeDescription(path));
		}*/
		
		
	}
	
	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		MailBox mail=new MailBox("MohammadMail");
		TransmissonChannel t=new TransmissonChannel();
	}
}
