
/**
 * @author faisal
 *
 */
package sa.edu.cs.librarianrobot.gui.model;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import sa.edu.cs.librarianrobot.modeling.librarypackage.Book;
import sa.edu.cs.librarianrobot.modeling.librarypackage.Library;
import sa.edu.cs.librarianrobot.modeling.librarypackage.LibrarypackageFactory;
import sa.edu.cs.librarianrobot.modeling.librarypackage.LibrarypackagePackage;

public class BookGenerator {

	public static void main(String[] args) {

		try {
			new BookGenerator().generateLibrary(100);
			new BookGenerator().generateLibrary(500);
			new BookGenerator().generateLibrary(1000);
			new BookGenerator().generateLibrary(2500);
			new BookGenerator().generateLibrary(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void generateLibrary(int max) throws Exception {
		String model_path = "models" + File.separatorChar + "library_";
		LibrarypackagePackage.eINSTANCE.eClass();
		LibrarypackageFactory factory = LibrarypackageFactory.eINSTANCE;

		Library library = factory.createLibrary();
		library.setName("library");

		String file = BookGenerator.class.getResource("resources/book_10000.json").getPath();
		if (file == null)
			throw new IOException("Unable to locate the input random data as JSON file in resources package\n");

		JSONParser parser = new JSONParser();
		FileReader fr = new FileReader(file);

		JSONArray array = (JSONArray) parser.parse(fr);

		int counter = 0;

		for (Object obj : array) {
			if (counter == max)
				break;
			counter++;
			JSONObject JsonBook = (JSONObject) obj;
			Book book = factory.createBook();
			book.setTitle(JsonBook.get("title").toString());
			book.setAuthors(JsonBook.get("author_name").toString());
			book.setXCoordinate(Integer.parseInt(JsonBook.get("xcoordinate").toString()));
			book.setYCoordinate(Integer.parseInt(JsonBook.get("ycoordinate").toString()));
			book.setWeight(Integer.parseInt(JsonBook.get("weight").toString()));
			library.getResources().add(book);
		}

		// save library to model xmi
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("*", new XMIResourceFactoryImpl());
		ResourceSet rs = new ResourceSetImpl();

		Resource res = rs.createResource(URI.createURI(String.format("%s_%d.xmi", model_path, max)));
		res.getContents().add(library);

		res.save(Collections.EMPTY_MAP);
	}
}