/**
 */
package sa.edu.cs.librarianrobot.modeling.librarypackage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import sa.edu.cs.librarianrobot.modeling.librarypackage.Book;
import sa.edu.cs.librarianrobot.modeling.librarypackage.Library;
import sa.edu.cs.librarianrobot.modeling.librarypackage.LibrarypackageFactory;
import sa.edu.cs.librarianrobot.modeling.librarypackage.LibrarypackagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LibrarypackageFactoryImpl extends EFactoryImpl implements LibrarypackageFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LibrarypackageFactory init() {
		try {
			LibrarypackageFactory theLibrarypackageFactory = (LibrarypackageFactory)EPackage.Registry.INSTANCE.getEFactory(LibrarypackagePackage.eNS_URI);
			if (theLibrarypackageFactory != null) {
				return theLibrarypackageFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LibrarypackageFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibrarypackageFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case LibrarypackagePackage.LIBRARY: return createLibrary();
			case LibrarypackagePackage.BOOK: return createBook();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Library createLibrary() {
		LibraryImpl library = new LibraryImpl();
		return library;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Book createBook() {
		BookImpl book = new BookImpl();
		return book;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LibrarypackagePackage getLibrarypackagePackage() {
		return (LibrarypackagePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LibrarypackagePackage getPackage() {
		return LibrarypackagePackage.eINSTANCE;
	}

} //LibrarypackageFactoryImpl
