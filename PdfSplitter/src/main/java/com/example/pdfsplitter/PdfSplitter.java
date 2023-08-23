package com.example.pdfsplitter;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;


public class PdfSplitter {
    public static void main(String[] args){
     try{
         JFileChooser fileChooser=new JFileChooser();
         fileChooser.setDialogTitle("Select Pdf File");
         int res=fileChooser.showOpenDialog(null);
         if(res==JFileChooser.APPROVE_OPTION){
             File selectedFile=fileChooser.getSelectedFile();
             PDDocument document=Loader.loadPDF(selectedFile);
             int numPages=document.getNumberOfPages();
             String range=JOptionPane.showInputDialog(
                     "Enter the range of pages to split like (1-5)","1-"+numPages);
             int start=Integer.parseInt(range.split("-")[0].trim())-1;
             int end =Integer.parseInt(range.split("-")[1].trim())-1;

             for(int i=start;i<=end;i++){
                 PDDocument singlePageDoc=new PDDocument();
                 PDPage page=document.getPage(i);
                 singlePageDoc.addPage(page);
                 singlePageDoc.save("Output_"+(i+1)+".pdf");
                 singlePageDoc.close();
             }
             document.close();
             JOptionPane.showMessageDialog(null,"PDF Splitted Successfully!");
         }
     }
     catch(IOException e){
         e.printStackTrace();

     }

    }
    }
