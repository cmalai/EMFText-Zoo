/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.java.closures.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.emftext.language.java.annotations.AnnotationsFactory;

import org.emftext.language.java.arrays.ArraysFactory;
import org.emftext.language.java.arrays.ArraysPackage;

import org.emftext.language.java.closures.Closure;
import org.emftext.language.java.closures.ClosuresFactory;
import org.emftext.language.java.closures.ClosuresPackage;

import org.emftext.language.java.expressions.ExpressionsFactory;

import org.emftext.language.java.instantiations.InstantiationsFactory;

import org.emftext.language.java.literals.LiteralsFactory;

import org.emftext.language.java.parameters.ParametersPackage;

import org.emftext.language.java.references.ReferencesFactory;
import org.emftext.language.java.references.ReferencesPackage;

import org.emftext.language.java.statements.StatementsPackage;

import org.emftext.language.java.types.TypesPackage;

/**
 * This is the item provider adapter for a {@link org.emftext.language.java.closures.Closure} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ClosureItemProvider
	extends AbstractClosureItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ClosureItemProvider(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

	/**
   * This returns the property descriptors for the adapted class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
    if (itemPropertyDescriptors == null)
    {
      super.getPropertyDescriptors(object);

      addMethodNamePropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

	/**
   * This adds a property descriptor for the Method Name feature.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected void addMethodNamePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_AbstractClosureCall_methodName_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_AbstractClosureCall_methodName_feature", "_UI_AbstractClosureCall_type"),
         ClosuresPackage.Literals.ABSTRACT_CLOSURE_CALL__METHOD_NAME,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

	/**
   * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
   * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
   * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
    if (childrenFeatures == null)
    {
      super.getChildrenFeatures(object);
      childrenFeatures.add(ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS);
    }
    return childrenFeatures;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
    // Check the type of the specified child object and return the proper feature to use for
    // adding (see {@link AddCommand}) it as a child.

    return super.getChildFeature(object, child);
  }

	/**
   * This returns Closure.gif.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/Closure"));
  }

	/**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public String getText(Object object) {
    String label = ((Closure)object).getName();
    return label == null || label.length() == 0 ?
      getString("_UI_Closure_type") :
      getString("_UI_Closure_type") + " " + label;
  }

	/**
   * This handles model notifications by calling {@link #updateChildren} to update any cached
   * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public void notifyChanged(Notification notification) {
    updateChildren(notification);

    switch (notification.getFeatureID(Closure.class))
    {
      case ClosuresPackage.CLOSURE__METHOD_NAME:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
      case ClosuresPackage.CLOSURE__ARGUMENTS:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
        return;
    }
    super.notifyChanged(notification);
  }

	/**
   * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
   * that can be created under this object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
    super.collectNewChildDescriptors(newChildDescriptors, object);

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         ClosuresFactory.eINSTANCE.createClosure()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         AnnotationsFactory.eINSTANCE.createAnnotationInstance()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         ArraysFactory.eINSTANCE.createArrayInstantiationBySize()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         ArraysFactory.eINSTANCE.createArrayInstantiationByValues()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         ExpressionsFactory.eINSTANCE.createAssignmentExpression()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         ExpressionsFactory.eINSTANCE.createConditionalExpression()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         ExpressionsFactory.eINSTANCE.createConditionalOrExpression()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         ExpressionsFactory.eINSTANCE.createConditionalAndExpression()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         ExpressionsFactory.eINSTANCE.createInclusiveOrExpression()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         ExpressionsFactory.eINSTANCE.createExclusiveOrExpression()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         ExpressionsFactory.eINSTANCE.createAndExpression()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         ExpressionsFactory.eINSTANCE.createEqualityExpression()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         ExpressionsFactory.eINSTANCE.createInstanceOfExpression()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         ExpressionsFactory.eINSTANCE.createRelationExpression()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         ExpressionsFactory.eINSTANCE.createShiftExpression()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         ExpressionsFactory.eINSTANCE.createAdditiveExpression()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         ExpressionsFactory.eINSTANCE.createMultiplicativeExpression()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         ExpressionsFactory.eINSTANCE.createUnaryExpression()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         ExpressionsFactory.eINSTANCE.createPrefixUnaryModificationExpression()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         ExpressionsFactory.eINSTANCE.createSuffixUnaryModificationExpression()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         ExpressionsFactory.eINSTANCE.createCastExpression()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         ExpressionsFactory.eINSTANCE.createNestedExpression()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         InstantiationsFactory.eINSTANCE.createNewConstructorCall()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         InstantiationsFactory.eINSTANCE.createExplicitConstructorCall()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         LiteralsFactory.eINSTANCE.createBooleanLiteral()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         LiteralsFactory.eINSTANCE.createCharacterLiteral()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         LiteralsFactory.eINSTANCE.createDecimalFloatLiteral()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         LiteralsFactory.eINSTANCE.createHexFloatLiteral()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         LiteralsFactory.eINSTANCE.createDecimalDoubleLiteral()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         LiteralsFactory.eINSTANCE.createHexDoubleLiteral()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         LiteralsFactory.eINSTANCE.createDecimalIntegerLiteral()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         LiteralsFactory.eINSTANCE.createHexIntegerLiteral()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         LiteralsFactory.eINSTANCE.createOctalIntegerLiteral()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         LiteralsFactory.eINSTANCE.createDecimalLongLiteral()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         LiteralsFactory.eINSTANCE.createHexLongLiteral()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         LiteralsFactory.eINSTANCE.createOctalLongLiteral()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         LiteralsFactory.eINSTANCE.createNullLiteral()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         ReferencesFactory.eINSTANCE.createIdentifierReference()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         ReferencesFactory.eINSTANCE.createMethodCall()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         ReferencesFactory.eINSTANCE.createReflectiveClassReference()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         ReferencesFactory.eINSTANCE.createPrimitiveTypeReference()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         ReferencesFactory.eINSTANCE.createStringReference()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS,
         ReferencesFactory.eINSTANCE.createSelfReference()));
  }

	/**
   * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
    Object childFeature = feature;
    Object childObject = child;

    boolean qualify =
      childFeature == TypesPackage.Literals.TYPED_ELEMENT__TYPE_REFERENCE ||
      childFeature == ClosuresPackage.Literals.ABSTRACT_CLOSURE__PARAMETER_TYPES ||
      childFeature == ClosuresPackage.Literals.ABSTRACT_CLOSURE__VALUE_TYPE ||
      childFeature == ArraysPackage.Literals.ARRAY_TYPEABLE__ARRAY_DIMENSIONS_BEFORE ||
      childFeature == ArraysPackage.Literals.ARRAY_TYPEABLE__ARRAY_DIMENSIONS_AFTER ||
      childFeature == StatementsPackage.Literals.STATEMENT_LIST_CONTAINER__STATEMENTS ||
      childFeature == ParametersPackage.Literals.PARAMETRIZABLE__PARAMETERS ||
      childFeature == ReferencesPackage.Literals.REFERENCE__NEXT ||
      childFeature == ReferencesPackage.Literals.ARGUMENTABLE__ARGUMENTS;

    if (qualify)
    {
      return getString
        ("_UI_CreateChild_text2",
         new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
    }
    return super.getCreateChildText(owner, feature, child, selection);
  }

}
