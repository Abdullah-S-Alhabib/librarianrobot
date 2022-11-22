/**
 */
package sa.edu.cs.librarianrobot.modeling.librarypackage;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link sa.edu.cs.librarianrobot.modeling.librarypackage.Library#getName <em>Name</em>}</li>
 *   <li>{@link sa.edu.cs.librarianrobot.modeling.librarypackage.Library#getResources <em>Resources</em>}</li>
 * </ul>
 *
 * @see sa.edu.cs.librarianrobot.modeling.librarypackage.LibrarypackagePackage#getLibrary()
 * @model
 * @generated
 */
public interface Library extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see sa.edu.cs.librarianrobot.modeling.librarypackage.LibrarypackagePackage#getLibrary_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link sa.edu.cs.librarianrobot.modeling.librarypackage.Library#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link sa.edu.cs.librarianrobot.modeling.librarypackage.Publication}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see sa.edu.cs.librarianrobot.modeling.librarypackage.LibrarypackagePackage#getLibrary_Resources()
	 * @model containment="true"
	 * @generated
	 */
	EList<Publication> getResources();

} // Library
