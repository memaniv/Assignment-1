/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lockedme.businesslogic;

import com.lockedme.model.LockersInterface;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 *
 * @author MemaniV
 */
public class LockersManager implements LockersInterface {
    public LockersManager(){
    }
    
    @Override
    public void addFile(String fileName) throws IOException {
        //declare variabales
        File newFile = new File(fileName);
        
        //create file
        newFile.createNewFile();      
    }

    @Override
    public boolean isFileExisting(String fileName) throws IOException {
        //declare variables
        boolean isExisting = false;
        File newFile = new File(fileName);
        
        //check if file exists
        if(newFile.exists()){
            isExisting = true;
        }
        
        //return status
        return isExisting;
    }

    @Override
    public void deleteFile(String fileName) throws IOException {
        //create a file
        File newFile = new File(fileName);
        
        //delete the file.
        newFile.delete();
    }

    @Override
    public String[] getFileNames() throws IOException {
        //work with the current directory files
        File filePath = new File("./");
        
        //get all the files that ends with .txt
        String[] files = filePath.list(new FilenameFilter() {				
				@Override
				public boolean accept(File dir, String name) {
					boolean value;
					if(name.endsWith(".txt")){
						value=true;
					}
					else{
						value=false;
					}
					return value;
				}
			});       
        //return the files
        return files;
    }

    @Override
    public int fileSearch(String fileName) throws IOException {
        int index = -1;
        int i = 0;
        
        //get all the files
        String[] files = getFileNames();
        
        //iterate through the files
        while((i < files.length) && (files[i].compareTo(fileName) != 0)){
            i++;
        }
        
        if(i != files.length){
            index = i;
        }
        
        return index;
    }
    
}
