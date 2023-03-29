/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lockedme.model;

import java.io.IOException;

/**
 *
 * @author MemaniV
 */
public interface LockersInterface {
    public void addFile(String fileName) throws IOException;
    public boolean isFileExisting(String fileName) throws IOException;
    public int fileSearch(String fileName) throws IOException;
    public void deleteFile(String fileName) throws IOException;
    public String[] getFileNames() throws IOException;
}
