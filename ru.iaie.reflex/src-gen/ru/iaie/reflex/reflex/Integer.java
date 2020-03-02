/**
 * generated by Xtext 2.20.0
 */
package ru.iaie.reflex.reflex;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ru.iaie.reflex.reflex.Integer#getValue <em>Value</em>}</li>
 *   <li>{@link ru.iaie.reflex.reflex.Integer#isQualfier <em>Qualfier</em>}</li>
 * </ul>
 *
 * @see ru.iaie.reflex.reflex.ReflexPackage#getInteger()
 * @model
 * @generated
 */
public interface Integer extends EObject
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see ru.iaie.reflex.reflex.ReflexPackage#getInteger_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link ru.iaie.reflex.reflex.Integer#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

  /**
   * Returns the value of the '<em><b>Qualfier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Qualfier</em>' attribute.
   * @see #setQualfier(boolean)
   * @see ru.iaie.reflex.reflex.ReflexPackage#getInteger_Qualfier()
   * @model
   * @generated
   */
  boolean isQualfier();

  /**
   * Sets the value of the '{@link ru.iaie.reflex.reflex.Integer#isQualfier <em>Qualfier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Qualfier</em>' attribute.
   * @see #isQualfier()
   * @generated
   */
  void setQualfier(boolean value);

} // Integer
