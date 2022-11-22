package sa.edu.cs.librarianrobot.gui.io;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import sa.edu.cs.librarianrobot.modeling.librarypackage.Library;
import sa.edu.cs.librarianrobot.modeling.librarypackage.LibrarypackagePackage;

/**
 *
 * @author faisal
 */
public class LibraryReader {
	private String fileName = "library_X_.xmi";
	private final char SEPCHAR = File.separatorChar;
	private final String PATH = "." + SEPCHAR + "models" + SEPCHAR;

	private static LibraryReader INSTANCE;

	private LibraryReader() {
	}

	public static LibraryReader getInstance() {
		if (INSTANCE == null)
			INSTANCE = new LibraryReader();
		return INSTANCE;
	}

	public Library loadLibraryFromXMI(DataSet ds) throws IllegalArgumentException {
		String f = new String(PATH + SEPCHAR + fileName);

		if (ds == DataSet.DS_100)
		{
			f = f.replaceFirst("X_", "100");
			fileName = "library__100.xmi";
		}
		else if (ds == DataSet.DS_500)
		{
			f = f.replaceFirst("X_", "500");
			fileName = "library__500.xmi";
		}
		else if (ds == DataSet.DS_500)
		{
			f = f.replaceFirst("X_", "1000");
			fileName = "library__1000.xmi";
		}
		else if (ds == DataSet.DS_500)
		{
			f = f.replaceFirst("X_", "2500");
			fileName = "library__2500.xmi";
		}
		else if (ds == DataSet.DS_500)
		{
			f = f.replaceFirst("X_", "5000");
			fileName = "library__5000.xmi";
		}
		else
			throw new IllegalArgumentException(String.format("Unknown dataset is given"));

		LibrarypackagePackage.eINSTANCE.eClass();

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("*", new XMIResourceFactoryImpl());

		ResourceSet rs = new ResourceSetImpl();
		Resource res = rs.getResource(URI.createURI(PATH + SEPCHAR + fileName), true);

		Library library = (Library) res.getContents().get(0);
		return library;
	}

	public Library loadLibraryFromXMI(String filename) throws IllegalArgumentException, IOException {

		if (filename.endsWith(".xmi"))
			throw new IllegalArgumentException("The model file must ends with xmi");

		File f = new File(PATH + SEPCHAR + filename);
		if (!(f.exists() && f.canRead()))
			throw new IOException("The model file with path " + f.getPath()
					+ " cannot be read or doen't exist. Make sure the file is int models folder");

		LibrarypackagePackage.eINSTANCE.eClass();

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("*", new XMIResourceFactoryImpl());

		ResourceSet rs = new ResourceSetImpl();
		Resource res = rs.getResource(URI.createURI(f.getPath()), true);

		Library library = (Library) res.getContents().get(0);

		return library;
	}
}
