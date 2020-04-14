/**
 * generated by Xtext 2.20.0
 */
package ru.iaie.reflex.reflex.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import ru.iaie.reflex.reflex.Const;
import ru.iaie.reflex.reflex.Expression;
import ru.iaie.reflex.reflex.ReflexPackage;
import ru.iaie.reflex.reflex.ReflexType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Const</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ru.iaie.reflex.reflex.impl.ConstImpl#getType <em>Type</em>}</li>
 *   <li>{@link ru.iaie.reflex.reflex.impl.ConstImpl#getConstId <em>Const Id</em>}</li>
 *   <li>{@link ru.iaie.reflex.reflex.impl.ConstImpl#getConstValue <em>Const Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConstImpl extends MinimalEObjectImpl.Container implements Const
{
  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected ReflexType type;

  /**
   * The default value of the '{@link #getConstId() <em>Const Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstId()
   * @generated
   * @ordered
   */
  protected static final String CONST_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getConstId() <em>Const Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstId()
   * @generated
   * @ordered
   */
  protected String constId = CONST_ID_EDEFAULT;

  /**
   * The cached value of the '{@link #getConstValue() <em>Const Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstValue()
   * @generated
   * @ordered
   */
  protected Expression constValue;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConstImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ReflexPackage.Literals.CONST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ReflexType getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(ReflexType newType, NotificationChain msgs)
  {
    ReflexType oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReflexPackage.CONST__TYPE, oldType, newType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setType(ReflexType newType)
  {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReflexPackage.CONST__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReflexPackage.CONST__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReflexPackage.CONST__TYPE, newType, newType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getConstId()
  {
    return constId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setConstId(String newConstId)
  {
    String oldConstId = constId;
    constId = newConstId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReflexPackage.CONST__CONST_ID, oldConstId, constId));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getConstValue()
  {
    return constValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConstValue(Expression newConstValue, NotificationChain msgs)
  {
    Expression oldConstValue = constValue;
    constValue = newConstValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReflexPackage.CONST__CONST_VALUE, oldConstValue, newConstValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setConstValue(Expression newConstValue)
  {
    if (newConstValue != constValue)
    {
      NotificationChain msgs = null;
      if (constValue != null)
        msgs = ((InternalEObject)constValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReflexPackage.CONST__CONST_VALUE, null, msgs);
      if (newConstValue != null)
        msgs = ((InternalEObject)newConstValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReflexPackage.CONST__CONST_VALUE, null, msgs);
      msgs = basicSetConstValue(newConstValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReflexPackage.CONST__CONST_VALUE, newConstValue, newConstValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ReflexPackage.CONST__TYPE:
        return basicSetType(null, msgs);
      case ReflexPackage.CONST__CONST_VALUE:
        return basicSetConstValue(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ReflexPackage.CONST__TYPE:
        return getType();
      case ReflexPackage.CONST__CONST_ID:
        return getConstId();
      case ReflexPackage.CONST__CONST_VALUE:
        return getConstValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ReflexPackage.CONST__TYPE:
        setType((ReflexType)newValue);
        return;
      case ReflexPackage.CONST__CONST_ID:
        setConstId((String)newValue);
        return;
      case ReflexPackage.CONST__CONST_VALUE:
        setConstValue((Expression)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ReflexPackage.CONST__TYPE:
        setType((ReflexType)null);
        return;
      case ReflexPackage.CONST__CONST_ID:
        setConstId(CONST_ID_EDEFAULT);
        return;
      case ReflexPackage.CONST__CONST_VALUE:
        setConstValue((Expression)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ReflexPackage.CONST__TYPE:
        return type != null;
      case ReflexPackage.CONST__CONST_ID:
        return CONST_ID_EDEFAULT == null ? constId != null : !CONST_ID_EDEFAULT.equals(constId);
      case ReflexPackage.CONST__CONST_VALUE:
        return constValue != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (constId: ");
    result.append(constId);
    result.append(')');
    return result.toString();
  }

} //ConstImpl
