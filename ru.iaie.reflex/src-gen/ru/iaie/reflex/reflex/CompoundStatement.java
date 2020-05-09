/**
 * generated by Xtext 2.20.0
 */
package ru.iaie.reflex.reflex;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compound Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ru.iaie.reflex.reflex.CompoundStatement#getStatements <em>Statements</em>}</li>
 * </ul>
 *
 * @see ru.iaie.reflex.reflex.ReflexPackage#getCompoundStatement()
 * @model
 * @generated
 */
public interface CompoundStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Statements</b></em>' containment reference list.
   * The list contents are of type {@link ru.iaie.reflex.reflex.Statement}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statements</em>' containment reference list.
   * @see ru.iaie.reflex.reflex.ReflexPackage#getCompoundStatement_Statements()
   * @model containment="true"
   * @generated
   */
  EList<Statement> getStatements();

} // CompoundStatement
