package family;

import java.util.*;
import java.io.*;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;

//A small family tree held in a Jena Model
public class CreateFamilyRelationshipModel {
  // Namespace declarations
  static final String familyUri = "http://family/";
  static final String relationshipUri = "http://purl.org/vocab/relationship/";
  
    public static void main(String args[]) {

// Create an empty Model
    Model model = ModelFactory.createDefaultModel(); 

//set namespace
    Resource NAMESPACE = model.createResource( relationshipUri );
       	model.setNsPrefix( "rela", relationshipUri);
    
// Create the types of Property we need to describe relationships in the model
    Property childOf = model.createProperty(relationshipUri,"childOf"); 
    Property siblingOf = model.createProperty(relationshipUri,"siblingOf");
    Property spouseOf = model.createProperty(relationshipUri,"spouseOf");
    Property parentOf = model.createProperty(relationshipUri,"parentOf"); 
    
    
// Create resources representing the people in our model
    Resource Siddharth = model.createResource(familyUri+"Siddharth");
    Resource Dhvanit = model.createResource(familyUri+"Dhvanit");
    Resource Rekha = model.createResource(familyUri+"Rekha");
    Resource Sandeep = model.createResource(familyUri+"Sandeep");
    Resource Kanchan = model.createResource(familyUri+"Kanchan");
    Resource Pihu = model.createResource(familyUri+"Pihu");
    Resource DwarkaPrasad = model.createResource(familyUri+"Dwarkesh");
    Resource Shakuntala = model.createResource(familyUri+"Shakuntala");
    Resource Santosh = model.createResource(familyUri+"Santosh");
    Resource Usha = model.createResource(familyUri+"Usha");
    Resource Priyadarshan = model.createResource(familyUri+"Priyadarshan");
    Resource Sudarshan = model.createResource(familyUri+"Sudarshan");
    Resource Pragya = model.createResource(familyUri+"Pragya");
    Resource Shailendra = model.createResource(familyUri+"Shailendra");
    Resource Rajni = model.createResource(familyUri+"Rajni");
    Resource Harsh = model.createResource(familyUri+"Harsh");
    Resource Satendra = model.createResource(familyUri+"Satendra");
    Resource Vandana = model.createResource(familyUri+"Vandana");
    Resource Priyam = model.createResource(familyUri+"Priyam");
    Resource Darshan = model.createResource(familyUri+"Darshan");
    Resource Vardhan = model.createResource(familyUri+"Vardhan");
       
    List<Statement> list = new ArrayList(); 
    list.add(model.createStatement(Dhvanit,spouseOf,Kanchan)); 
    list.add(model.createStatement(Sandeep,spouseOf,Rekha)); 
    list.add(model.createStatement(DwarkaPrasad,spouseOf,Shakuntala)); 
    list.add(model.createStatement(Santosh,spouseOf,Usha)); 
    list.add(model.createStatement(Shailendra,spouseOf,Rajni)); 
    list.add(model.createStatement(Satendra,spouseOf,Vandana)); 
    list.add(model.createStatement(Sandeep,childOf,DwarkaPrasad)); 
    list.add(model.createStatement(Sandeep,childOf,Shakuntala)); 
    list.add(model.createStatement(Santosh,childOf,DwarkaPrasad)); 
    list.add(model.createStatement(Santosh,childOf,Shakuntala)); 
    list.add(model.createStatement(Shailendra,childOf,DwarkaPrasad)); 
    list.add(model.createStatement(Shailendra,childOf,Shakuntala)); 
    list.add(model.createStatement(Satendra,childOf,DwarkaPrasad)); 
    list.add(model.createStatement(Satendra,childOf,Shakuntala)); 
    list.add(model.createStatement(DwarkaPrasad,parentOf,Sandeep)); 
    list.add(model.createStatement(DwarkaPrasad,parentOf,Santosh)); 
    list.add(model.createStatement(DwarkaPrasad,parentOf,Shailendra)); 
    list.add(model.createStatement(DwarkaPrasad,parentOf,Satendra)); 
    list.add(model.createStatement(Shakuntala,parentOf,Sandeep)); 
    list.add(model.createStatement(Shakuntala,parentOf,Santosh)); 
    list.add(model.createStatement(Shakuntala,parentOf,Shailendra)); 
    list.add(model.createStatement(Shakuntala,parentOf,Satendra)); 
    list.add(model.createStatement(Sandeep,parentOf,Siddharth)); 
    list.add(model.createStatement(Sandeep,parentOf,Dhvanit)); 
    list.add(model.createStatement(Rekha,parentOf,Siddharth)); 
    list.add(model.createStatement(Rekha,parentOf,Dhvanit)); 
    list.add(model.createStatement(Siddharth,childOf,Rekha)); 
    list.add(model.createStatement(Dhvanit,childOf,Rekha)); 
    list.add(model.createStatement(Siddharth,childOf,Sandeep)); 
    list.add(model.createStatement(Dhvanit,childOf,Sandeep)); 
    list.add(model.createStatement(Harsh,childOf,Shailendra)); 
    list.add(model.createStatement(Harsh,childOf,Rajni)); 
    list.add(model.createStatement(Shailendra,parentOf,Harsh)); 
    list.add(model.createStatement(Rajni,parentOf,Harsh)); 
    list.add(model.createStatement(Santosh,parentOf,Priyadarshan)); 
    list.add(model.createStatement(Santosh,parentOf,Sudarshan));
    list.add(model.createStatement(Santosh,parentOf,Pragya));
    list.add(model.createStatement(Usha,parentOf,Priyadarshan)); 
    list.add(model.createStatement(Usha,parentOf,Sudarshan));
    list.add(model.createStatement(Usha,parentOf,Pragya));
    list.add(model.createStatement(Priyadarshan,childOf,Santosh));
    list.add(model.createStatement(Pragya,childOf,Santosh));
    list.add(model.createStatement(Sudarshan,childOf,Santosh));
    list.add(model.createStatement(Priyadarshan,childOf,Usha));
    list.add(model.createStatement(Pragya,childOf,Usha));
    list.add(model.createStatement(Sudarshan,childOf,Usha));
    list.add(model.createStatement(Satendra,parentOf,Priyam)); 
    list.add(model.createStatement(Satendra,parentOf,Darshan));
    list.add(model.createStatement(Satendra,parentOf,Vardhan));
    list.add(model.createStatement(Vandana,parentOf,Priyam)); 
    list.add(model.createStatement(Vandana,parentOf,Darshan));
    list.add(model.createStatement(Vandana,parentOf,Vardhan));
    list.add(model.createStatement(Priyam,childOf,Satendra));
    list.add(model.createStatement(Darshan,childOf,Satendra));
    list.add(model.createStatement(Vardhan,childOf,Satendra));
    list.add(model.createStatement(Priyam,childOf,Vandana));
    list.add(model.createStatement(Darshan,childOf,Vandana));
    list.add(model.createStatement(Vardhan,childOf,Vandana));
    list.add(model.createStatement(Pihu,childOf,Dhvanit));
    list.add(model.createStatement(Pihu,childOf,Kanchan));
    list.add(model.createStatement(Dhvanit,parentOf,Pihu));
    list.add(model.createStatement(Kanchan,parentOf,Pihu));
    list.add(model.createStatement(Siddharth,siblingOf,Dhvanit));
    list.add(model.createStatement(Dhvanit,siblingOf,Siddharth));   
    list.add(model.createStatement(Priyadarshan,siblingOf,Sudarshan));
    list.add(model.createStatement(Priyadarshan,siblingOf,Pragya));
    list.add(model.createStatement(Sudarshan,siblingOf,Priyadarshan));
    list.add(model.createStatement(Sudarshan,siblingOf,Pragya));
    list.add(model.createStatement(Pragya,siblingOf,Priyadarshan));
    list.add(model.createStatement(Pragya,siblingOf,Sudarshan)); 
    list.add(model.createStatement(Priyam,siblingOf,Darshan));
    list.add(model.createStatement(Priyam,siblingOf,Vardhan));  
    list.add(model.createStatement(Darshan,siblingOf,Vardhan)); 
    list.add(model.createStatement(Darshan,siblingOf,Priyam));
    list.add(model.createStatement(Vardhan,siblingOf,Priyam));
    list.add(model.createStatement(Vardhan,siblingOf,Darshan));
    list.add(model.createStatement(Santosh,siblingOf,Sandeep));
    list.add(model.createStatement(Santosh,siblingOf,Shailendra));
    list.add(model.createStatement(Santosh,siblingOf,Satendra));
    list.add(model.createStatement(Sandeep,siblingOf,Santosh));
    list.add(model.createStatement(Sandeep,siblingOf,Shailendra));
    list.add(model.createStatement(Sandeep,siblingOf,Satendra));
    list.add(model.createStatement(Shailendra,siblingOf,Santosh));
    list.add(model.createStatement(Shailendra,siblingOf,Sandeep));
    list.add(model.createStatement(Shailendra,siblingOf,Satendra));
    list.add(model.createStatement(Satendra,siblingOf,Shailendra));
    list.add(model.createStatement(Satendra,siblingOf,Santosh));
    list.add(model.createStatement(Satendra,siblingOf,Sandeep));
    
    model.add(list);
    try{
    	  File file=new File("/Users/siddharthgupta/Documents/workspace/FamilyModel/src/family/family.rdf");
    	   	FileOutputStream f1=new FileOutputStream(file);
    	   	RDFWriter d = model.getWriter("RDF/XML-ABBREV");
    	   			d.write(model,f1,null);
    		}catch(Exception e) {}
    }
}