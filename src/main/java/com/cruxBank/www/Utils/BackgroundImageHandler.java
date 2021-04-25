package com.cruxBank.www.Utils;

import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.element.Image;

public class BackgroundImageHandler implements IEventHandler {
	
	private Image image;
	
	

	public BackgroundImageHandler(Image image) {
		super();
		this.image = image;
	}



	@Override
	public void handleEvent(Event event) {
		if(image==null)
			return;
		// TODO Auto-generated method stub
		PdfDocumentEvent docEvent = (PdfDocumentEvent)event;
		PdfDocument pdf_doc = docEvent.getDocument();
		PdfPage page = docEvent.getPage();
		PdfCanvas canvas = new PdfCanvas(page.newContentStreamBefore(),page.getResources(),pdf_doc);
		new Canvas(canvas, pdf_doc,page.getPageSize()).add(image);
		
	}

}
