package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main (String[] args) throws IOException {
        /**
         *   Using File Stream to copy a file
         */

        File source=new File("gt.mp4");
        File destination=new File("gt_copy.mp4");
        if(!source.exists()) {
            System.out.println("Source file does not exist!");
            return;
        }

        if(destination.exists())
        {
            System.out.println("Destination file already exist!");
            return;
        }
        FileInputStream fis=new FileInputStream(source);
        FileOutputStream fos= new FileOutputStream(destination);

        //10KB buffer
        byte[] data=new byte[1024*10];

        int len=0;
        //calculate time takes

        long startTime=System.currentTimeMillis();
        while((len=fis.read(data))!=-1)
        {
            fos.write(data,0,len);
        }
        long finishTime=System.currentTimeMillis();

        System.out.println("Copying file finished. Takes time in "+(finishTime-startTime)+" ms.");

        fis.close();
        fos.close();
    }
}

