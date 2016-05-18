package com.healpal.encryptdecrypt

import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.DESedeKeySpec

class CryptographyUtil {
		
	public static String encrypt(String data) throws Exception {
		byte[] keyBytes = null;
		byte[] encrypted = null;
		byte[] text= null;
		String ciperText=null;
		try{
			if(data != null && !data.isEmpty()){		
				DESEncryption myEncryptor= new DESEncryption();
				ciperText=myEncryptor.encrypt(data);
				/*keyBytes = getKey();
				DESedeKeySpec keySpec = new DESedeKeySpec(keyBytes);
				SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
				SecretKey key = factory.generateSecret(keySpec);
				text = data.getBytes("ASCII");
				Cipher cipher = Cipher.getInstance("DESede");
				cipher.init(Cipher.ENCRYPT_MODE, key);
				encrypted = cipher.doFinal(text);		
				println("Encrypt Data-->"+new String(encrypted))*/
			}else{
				// do nothing
			}			
		}catch(Exception exception){
			throw exception;
		}
		//return new String(encrypted);
		//println("Encrypt Data-->"+ciperText)
		return  ciperText;
	}
	
	public static String decrypt(String cyperText) throws Exception {
		byte[] keyBytes = null;
		byte[] encrypted = null;
		//byte[] decrypted = null;
		String decrypted = null
		try{			
			if(cyperText != null && !cyperText.isEmpty()){	
				DESEncryption myEncryptor= new DESEncryption();
				decrypted=myEncryptor.decrypt(cyperText)						
			/*	keyBytes = getKey();
				DESedeKeySpec keySpec = new DESedeKeySpec(keyBytes);
				SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
				SecretKey key = factory.generateSecret(keySpec);
				Cipher cipher = Cipher.getInstance("DESede");
				println("***************************-->"+cyperText)
				encrypted = cyperText.getBytes("ASCII");
				cipher.init(Cipher.DECRYPT_MODE, key);
				decrypted = cipher.doFinal(encrypted);
				println("Decrypt Data-->"+new String(encrypted))*/				
			}else{
				// do nothing
			}
			
		}catch(Exception exception){
			throw exception;
		}
		
		//return new String(decrypted);
		//println("Decrypt Data-->"+decrypted)
		return decrypted;
	}
	
	private static byte[] getKey() throws Exception{
		StringBuilder output = new StringBuilder();
		String hex = null;
		byte [] keyValue=null;
		StringBuilder buffer = new StringBuilder()
		try{						
			for(int i=0;i<24;i++){				
				buffer.append(0x20+i);
			}
			hex = buffer.toString();		
			for (int i = 0; i < hex.length(); i+=2) {
				String str = hex.substring(i, i+2);
				output.append((char)Integer.parseInt(str, 16));
			}			
			//keyValue = output.toString().getBytes();
			
			keyValue="abcdefghijklmnopqrstuvwx".getBytes();
		}catch(Exception exception ){
			throw exception;
		}
		return keyValue;
	}
}
