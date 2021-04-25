package com.cruxBank.www.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.cruxBank.www.Account.Controller.AccountController;
import com.cruxBank.www.Account.DAO.AccountDataRepository;
import com.cruxBank.www.Banking.Api.TransactionHistoryRequest;
import com.cruxBank.www.Banking.DAO.TransactionData;
import com.cruxBank.www.Registration.DAO.SignupInfo;
import com.cruxBank.www.Registration.DAO.SignupInfoDAO;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.*;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;

@Component
public class PdfUtils {
	
	@Autowired
	SignupInfoDAO profileDataDAO;
	
	@Autowired
	AccountDataRepository accountDataDAO;
	
	static String filePath = "/pdfs/";
	static String[] txn_hst_columnHeaders= {"TransactionTime","Txn_Description","ReferenceId","OperationType","PreviousBalance","Txn_Amount","CurrentBalance"};
	private static Resource  resource = new ClassPathResource("/static/homepage_bckgd.png");
	
	public String createTransactionHistoryDocument(String filename,List<TransactionData> txnData_list,TransactionHistoryRequest request) {
					
		try {
			String profileData = addCustomerInfo(request.getUserAccountId());
	        if(profileData==null) {
	        	System.out.println("No profile Data found for user Account Id "+request.getUserAccountId());
	        	return null;
	        }
	        String path = System.getProperty("user.dir");
	        File  absolutePath  = new File(path.concat(filePath));
	        if(absolutePath.mkdir()) {
	        	System.out.println("Directory created !!");
	        }else {
	        	System.out.println("Directory existed");
	        }
	        File file = new File(absolutePath.getAbsolutePath()+"/"+filename);
	        System.out.println(file.getPath());
	        PdfFont headerFont = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
			PdfDocument pdf_doc = new PdfDocument(new PdfWriter(new FileOutputStream(file)));			
	        Document doc = new Document(pdf_doc, PageSize.A4);
	        BackgroundImageHandler handler = new BackgroundImageHandler(addBackgroundImage());
	        pdf_doc.addEventHandler(PdfDocumentEvent.END_PAGE, handler);
	        doc.add(new Paragraph("ACCOUNT STATEMENT")
	        		.setHorizontalAlignment(HorizontalAlignment.CENTER)
	        		.setVerticalAlignment(VerticalAlignment.TOP)
	        		.setFont(PdfFontFactory.createFont(StandardFonts.TIMES_BOLD))
	        		.setFontSize(16)
	        		.setFontColor(ColorConstants.BLACK)
	        		.setTextAlignment(TextAlignment.CENTER)
	        		.setUnderline());
	        doc.add(new Paragraph(profileData)
	        		.setFontColor(ColorConstants.BLACK)
	        		.setFontSize(12)
	        		.setFont(headerFont)
	        		.setHorizontalAlignment(HorizontalAlignment.LEFT)
	        		.setVerticalAlignment(VerticalAlignment.MIDDLE));
	        doc.add(new Paragraph("Statement from "+request.getStartDate().toString()+" to "+request.getEndDate().toString())
	        		 .setFontColor(ColorConstants.BLACK)
	        		.setFontSize(10)
	        		.setFont(headerFont)
	        		.setHorizontalAlignment(HorizontalAlignment.LEFT)
	        		.setVerticalAlignment(VerticalAlignment.MIDDLE));
			Table table = new Table(txn_hst_columnHeaders.length);
			table.setAutoLayout();
			table.setFontSize(10);
			table.setFont(headerFont);
			table.setFontColor(ColorConstants.BLACK);
	        addHeader(table);
	        addRows(table,txnData_list);
	        doc.add(table);
	        doc.close();
	        pdf_doc.close();
	        return file.getAbsolutePath();
	        
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;		 	
	}
	
	public Image addBackgroundImage() {		
		try {
			Image image = new Image(ImageDataFactory.create(resource.getURL()));
			
			image.scaleToFit(PageSize.A4.getWidth(),PageSize.A4.getHeight());
			image.setFixedPosition((PageSize.A4.getWidth()-image.getImageScaledWidth())/2, (PageSize.A4.getHeight()-image.getImageScaledHeight())/2);			
			return image;		
			
		} catch(Exception e ) {
			System.out.println("Error while adding background image ");
			e.printStackTrace();
		}			
		return null;		
	}
	
	public void addHeader(Table table) {
		
			Stream.of(txn_hst_columnHeaders).forEach(headerElement ->{
				Cell header = new Cell();
				header.setBackgroundColor(ColorConstants.WHITE);
		        header.add(new Paragraph(headerElement));
		        header.setVerticalAlignment(VerticalAlignment.MIDDLE);
		        header.setHorizontalAlignment(HorizontalAlignment.CENTER);
		        table.addCell(header);		      
			});		
	}
	
	
	public void addRows(Table table,List<TransactionData> txnData_list) {
		
		if(txnData_list.size()<1) {
			table.addCell("No Transaction data found in the given period");
			return;
		}
		txnData_list.forEach(txnData ->{
			table.addCell(new Paragraph(txnData.getTransactionTime().toString()));
			table.addCell(new Paragraph(txnData.getTxnDescription()));
			table.addCell(new Paragraph(txnData.getReferenceId()));
			table.addCell(new Paragraph(txnData.getOperationType()));
			table.addCell(new Paragraph(txnData.getPreviousBalance().toString()));
			table.addCell(new Paragraph(txnData.getTransactionAmount().toString()));
			table.addCell(new Paragraph(txnData.getCurrentBalance().toString()));
		});
				
	}
	
	public String addCustomerInfo(Long accountId) {
		
		String emailId = accountDataDAO.findEmailByAccountId(accountId);
		//System.out.println("the email Id  "+ emailId +" of account id is  "+accountId);
		SignupInfo  profileData =  (emailId!=null) ? profileDataDAO.getProfileDatabyEmail(emailId):null;
		//System.out.println("the profile Data for  "+ emailId +"  is  "+profileData);
		if(profileData== null)
			return null;
		String data = "Customer Name : "+profileData.getFirstName().toUpperCase()+" "+profileData.getLastName().toUpperCase()+" \n"+
					   "Address : "+profileData.getAddress_1().toUpperCase()+", "+
					   ((profileData.getAddress_2()!=null && profileData.getAddress_2().length()>1) ? "\n"+profileData.getAddress_2().toUpperCase()+"," :"")+"\n"+
					   profileData.getCity().toUpperCase()+","+profileData.getState().toUpperCase()+"-"+profileData.getZip()+"."+"\n"+
					   "Email Id : "+emailId;
		//System.out.println("beautified profile Data" +data);
		return data;
	}

}
