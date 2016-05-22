package family;

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

public class FindUncleOfPihu {

	    
		  static final String inputFileName = "/Users/siddharthgupta/Documents/workspace/FamilyModel/src/family/family.rdf";
		  public static void main (String args[]) {
		    // create an empty model
		    Model model = ModelFactory.createDefaultModel();
		    // use the FileManager to find the input file
		    InputStream in = FileManager.get().open(inputFileName);
		    if (in == null) {
		            throw new IllegalArgumentException( "File: " + inputFileName + " not found"); }
		    model.read( in, "");
		    String queryString = "PREFIX rela: <http://purl.org/vocab/relationship/> " +
					"SELECT ?Uncle_Of_Pihu " +
					"WHERE {" +
					"      <http://family/Pihu> rela:childOf ?parent . " +
					"      ?parent rela:siblingOf ?Uncle_Of_Pihu . " +
					"      }"+
					"GROUP BY ?Uncle_Of_Pihu";

		    Query query = QueryFactory.create(queryString);

		    // Execute the query and obtain results
		    QueryExecution qe = QueryExecutionFactory.create(query, model);
		    ResultSet results = qe.execSelect();

		    // Output query results	
		    ResultSetFormatter.out(System.out, results, query);

		    // Important - free up resources used running the query
		    qe.close();         
		    }
		}

