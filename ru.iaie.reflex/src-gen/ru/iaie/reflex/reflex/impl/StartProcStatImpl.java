/**
 * generated by Xtext 2.20.0
 */
package ru.iaie.reflex.reflex.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import ru.iaie.reflex.reflex.ReflexPackage;
import ru.iaie.reflex.reflex.StartProcStat;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Start Proc Stat</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ru.iaie.reflex.reflex.impl.StartProcStatImpl#getProcId <em>Proc Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StartProcStatImpl extends MinimalEObjectImpl.Container implements StartProcStat
{
  /**
   * The default value of the '{@link #getProcId() <em>Proc Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProcId()
   * @generated
   * @ordered
   */
  protected static final String PROC_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getProcId() <em>Proc Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProcId()
   * @generated
   * @ordered
   */
  protected String procId = PROC_ID_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StartProcStatImpl()
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
    return ReflexPackage.Literals.START_PROC_STAT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getProcId()
  {
    return procId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setProcId(String newProcId)
  {
    String oldProcId = procId;
    procId = newProcId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReflexPackage.START_PROC_STAT__PROC_ID, oldProcId, procId));
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
      case ReflexPackage.START_PROC_STAT__PROC_ID:
        return getProcId();
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
      case ReflexPackage.START_PROC_STAT__PROC_ID:
        setProcId((String)newValue);
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
      case ReflexPackage.START_PROC_STAT__PROC_ID:
        setProcId(PROC_ID_EDEFAULT);
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
      case ReflexPackage.START_PROC_STAT__PROC_ID:
        return PROC_ID_EDEFAULT == null ? procId != null : !PROC_ID_EDEFAULT.equals(procId);
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
    result.append(" (procId: ");
    result.append(procId);
    result.append(')');
    return result.toString();
  }

} //StartProcStatImpl
