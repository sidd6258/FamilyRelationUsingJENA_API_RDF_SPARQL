package family;

import java.io.*;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;

public class FindChildOfMembers {
  static final String inputFileName = "/Users/siddharthgupta/Documents/workspace/FamilyModel/src/family/family.rdf";
  public static void main (String args[]) {
    // create an empty model
    Model model = ModelFactory.createDefaultModel();
    // use the FileManager to find the input file
    InputStream in = FileManager.get().open(inputFileName);
      if (in == null) {
         throw new IllegalArgumentException( "File: " + inputFileName + " not found"); }
    model.read( in, "");
    //query the statement:subject, property and object
    
    
    StmtIterator iter = model.listStatements(null, model.getProperty("http://purl.org/vocab/relationship/childOf"), (RDFNode) null);
        if (iter.hasNext()) {System.out.println("They are:");
            while (iter.hasNext()) {System.out.println("  " + iter.nextStatement());  }
        } else {System.out.println("They are not in the database");    }            
    }
}  
