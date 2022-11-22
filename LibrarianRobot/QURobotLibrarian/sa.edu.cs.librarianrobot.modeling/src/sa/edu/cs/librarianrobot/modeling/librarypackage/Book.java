/**
 */
package sa.edu.cs.librarianrobot.modeling.librarypackage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Book</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link sa.edu.cs.librarianrobot.modeling.librarypackage.Book#getTitle <em>Title</em>}</li>
 *   <li>{@link sa.edu.cs.librarianrobot.modeling.librarypackage.Book#getAuthors <em>Authors</em>}</li>
 *   <li>{@link sa.edu.cs.librarianrobot.modeling.librarypackage.Book#getXCoordinate <em>XCoordinate</em>}</li>
 *   <li>{@link sa.edu.cs.librarianrobot.modeling.librarypackage.Book#getYCoordinate <em>YCoordinate</em>}</li>
 *   <li>{@link sa.edu.cs.librarianrobot.modeling.librarypackage.Book#getWeight <em>Weight</em>}</li>
 * </ul>
 *
 * @see sa.edu.cs.librarianrobot.modeling.librarypackage.LibrarypackagePackage#getBook()
 * @model
 * @generated
 */
public interface Book extends Publication {
	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see sa.edu.cs.librarianrobot.modeling.librarypackage.LibrarypackagePackage#getBook_Title()
	 * @model required="true"
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link sa.edu.cs.librarianrobot.modeling.librarypackage.Book#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Authors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Authors</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Authors</em>' attribute.
	 * @see #setAuthors(String)
	 * @see sa.edu.cs.librarianrobot.modeling.librarypackage.LibrarypackagePackage#getBook_Authors()
	 * @model required="true"
	 * @generated
	 */
	String getAuthors();

	/**
	 * Sets the value of the '{@link sa.edu.cs.librarianrobot.modeling.librarypackage.Book#getAuthors <em>Authors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Authors</em>' attribute.
	 * @see #getAuthors()
	 * @generated
	 */
	void setAuthors(String value);

	/**
	 * Returns the value of the '<em><b>XCoordinate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XCoordinate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XCoordinate</em>' attribute.
	 * @see #setXCoordinate(int)
	 * @see sa.edu.cs.librarianrobot.modeling.librarypackage.LibrarypackagePackage#getBook_XCoordinate()
	 * @model
	 * @generated
	 */
	int getXCoordinate();

	/**
	 * Sets the value of the '{@link sa.edu.cs.librarianrobot.modeling.librarypackage.Book#getXCoordinate <em>XCoordinate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XCoordinate</em>' attribute.
	 * @see #getXCoordinate()
	 * @generated
	 */
	void setXCoordinate(int value);

	/**
	 * Returns the value of the '<em><b>YCoordinate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>YCoordinate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>YCoordinate</em>' attribute.
	 * @see #setYCoordinate(int)
	 * @see sa.edu.cs.librarianrobot.modeling.librarypackage.LibrarypackagePackage#getBook_YCoordinate()
	 * @model
	 * @generated
	 */
	int getYCoordinate();

	/**
	 * Sets the value of the '{@link sa.edu.cs.librarianrobot.modeling.librarypackage.Book#getYCoordinate <em>YCoordinate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>YCoordinate</em>' attribute.
	 * @see #getYCoordinate()
	 * @generated
	 */
	void setYCoordinate(int value);

	/**
	 * Returns the value of the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight</em>' attribute.
	 * @see #setWeight(int)
	 * @see sa.edu.cs.librarianrobot.modeling.librarypackage.LibrarypackagePackage#getBook_Weight()
	 * @model
	 * @generated
	 */
	int getWeight();

	/**
	 * Sets the value of the '{@link sa.edu.cs.librarianrobot.modeling.librarypackage.Book#getWeight <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight</em>' attribute.
	 * @see #getWeight()
	 * @generated
	 */
	void setWeight(int value);

} // Book
