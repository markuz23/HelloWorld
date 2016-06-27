package Test;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;


@WebServlet("/AddDataServlet")
public class AddDataServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest request,HttpServletResponse
	 response) throws ServletException, IOException
	 {
		
		PrintWriter printer = new PrintWriter(response.getOutputStream());
		
		//Connect to host
		MongoClient mongoClient = new MongoClient( "localhost" );
		
		//Select DB
		MongoDatabase database = mongoClient.getDatabase("MiBase");
		
		//Select Collection
		MongoCollection<Document> collection = database.getCollection("MiColeccion");		
		
		//Get DateTime
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();	
	
		try
		{	
			//Checks if data is empty
			if(request.getParameter("data") == null || request.getParameter("data").equals(""))
			{			
				printer.println("<h1>Dato ingresado nulo o invalido</h1><br>");
			}else
			{
				//Creating Doc
				Document doc = new Document("Data", request.getParameter("data"))
			               .append("DateTime", dateFormat.format(cal.getTime()));
				
				//Inserting Doc
				collection.insertOne(doc);	
				printer.println("<h1>Dato "+request.getParameter("data")+" insertado</h1><br>");
			}	
		}
		catch(Exception ex)
		{
			printer.println(ex.getMessage());
		}
		
		//Printing Docs from Collection
		printer.println("<h1>Documentos en Colección</h1><br>");
		
		//Gets Objects
		MongoCursor<Document> cursor = collection.find().iterator();;
		
		//Prints Objects
		while (cursor.hasNext()) {
			
			printer.println(cursor.next()+"<br>");
		}
		
		//Closing connection
		mongoClient.close();
		
		printer.close();
	 }
}
