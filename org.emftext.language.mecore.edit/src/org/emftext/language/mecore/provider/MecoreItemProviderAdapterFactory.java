/**
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 * 
 */
package org.emftext.language.mecore.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.emftext.language.mecore.util.MecoreAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MecoreItemProviderAdapterFactory extends MecoreAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MecoreItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.emftext.language.mecore.MTypedElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected MecoreItemProviderAdapter mTypedElementItemProvider;

	/**
	 * This creates an adapter for a {@link org.emftext.language.mecore.MTypedElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Adapter createMTypedElementAdapter() {
		if (mTypedElementItemProvider == null) {
			mTypedElementItemProvider = new MecoreItemProviderAdapter(this);
		}

		return mTypedElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.emftext.language.mecore.MPackage} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected MecoreItemProviderAdapter mPackageItemProvider;

	/**
	 * This creates an adapter for a {@link org.emftext.language.mecore.MPackage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Adapter createMPackageAdapter() {
		if (mPackageItemProvider == null) {
			mPackageItemProvider = new MecoreItemProviderAdapter(this);
		}

		return mPackageItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.emftext.language.mecore.MImport} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected MecoreItemProviderAdapter mImportItemProvider;

	/**
	 * This creates an adapter for a {@link org.emftext.language.mecore.MImport}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Adapter createMImportAdapter() {
		if (mImportItemProvider == null) {
			mImportItemProvider = new MecoreItemProviderAdapter(this);
		}

		return mImportItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.emftext.language.mecore.MClass} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected MecoreItemProviderAdapter mClassItemProvider;

	/**
	 * This creates an adapter for a {@link org.emftext.language.mecore.MClass}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Adapter createMClassAdapter() {
		if (mClassItemProvider == null) {
			mClassItemProvider = new MecoreItemProviderAdapter(this);
		}

		return mClassItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.emftext.language.mecore.MEnum} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected MecoreItemProviderAdapter mEnumItemProvider;

	/**
	 * This creates an adapter for a {@link org.emftext.language.mecore.MEnum}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Adapter createMEnumAdapter() {
		if (mEnumItemProvider == null) {
			mEnumItemProvider = new MecoreItemProviderAdapter(this);
		}

		return mEnumItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.emftext.language.mecore.MEnumLiteral} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected MecoreItemProviderAdapter mEnumLiteralItemProvider;

	/**
	 * This creates an adapter for a {@link org.emftext.language.mecore.MEnumLiteral}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Adapter createMEnumLiteralAdapter() {
		if (mEnumLiteralItemProvider == null) {
			mEnumLiteralItemProvider = new MecoreItemProviderAdapter(this);
		}

		return mEnumLiteralItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.emftext.language.mecore.MFeature} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected MecoreItemProviderAdapter mFeatureItemProvider;

	/**
	 * This creates an adapter for a {@link org.emftext.language.mecore.MFeature}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Adapter createMFeatureAdapter() {
		if (mFeatureItemProvider == null) {
			mFeatureItemProvider = new MecoreItemProviderAdapter(this);
		}

		return mFeatureItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.emftext.language.mecore.MSimpleMultiplicity} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected MecoreItemProviderAdapter mSimpleMultiplicityItemProvider;

	/**
	 * This creates an adapter for a {@link org.emftext.language.mecore.MSimpleMultiplicity}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Adapter createMSimpleMultiplicityAdapter() {
		if (mSimpleMultiplicityItemProvider == null) {
			mSimpleMultiplicityItemProvider = new MecoreItemProviderAdapter(this);
		}

		return mSimpleMultiplicityItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.emftext.language.mecore.MComplexMultiplicity} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected MecoreItemProviderAdapter mComplexMultiplicityItemProvider;

	/**
	 * This creates an adapter for a {@link org.emftext.language.mecore.MComplexMultiplicity}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Adapter createMComplexMultiplicityAdapter() {
		if (mComplexMultiplicityItemProvider == null) {
			mComplexMultiplicityItemProvider = new MecoreItemProviderAdapter(this);
		}

		return mComplexMultiplicityItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.emftext.language.mecore.MDataType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected MecoreItemProviderAdapter mDataTypeItemProvider;

	/**
	 * This creates an adapter for a {@link org.emftext.language.mecore.MDataType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Adapter createMDataTypeAdapter() {
		if (mDataTypeItemProvider == null) {
			mDataTypeItemProvider = new MecoreItemProviderAdapter(this);
		}

		return mDataTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.emftext.language.mecore.MEcoreType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected MecoreItemProviderAdapter mEcoreTypeItemProvider;

	/**
	 * This creates an adapter for a {@link org.emftext.language.mecore.MEcoreType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Adapter createMEcoreTypeAdapter() {
		if (mEcoreTypeItemProvider == null) {
			mEcoreTypeItemProvider = new MecoreItemProviderAdapter(this);
		}

		return mEcoreTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.emftext.language.mecore.MOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected MecoreItemProviderAdapter mOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.emftext.language.mecore.MOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Adapter createMOperationAdapter() {
		if (mOperationItemProvider == null) {
			mOperationItemProvider = new MecoreItemProviderAdapter(this);
		}

		return mOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.emftext.language.mecore.MParameter} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected MecoreItemProviderAdapter mParameterItemProvider;

	/**
	 * This creates an adapter for a {@link org.emftext.language.mecore.MParameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Adapter createMParameterAdapter() {
		if (mParameterItemProvider == null) {
			mParameterItemProvider = new MecoreItemProviderAdapter(this);
		}

		return mParameterItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.emftext.language.mecore.MTypeParameter} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected MecoreItemProviderAdapter mTypeParameterItemProvider;

	/**
	 * This creates an adapter for a {@link org.emftext.language.mecore.MTypeParameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Adapter createMTypeParameterAdapter() {
		if (mTypeParameterItemProvider == null) {
			mTypeParameterItemProvider = new MecoreItemProviderAdapter(this);
		}

		return mTypeParameterItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.emftext.language.mecore.MTypeParametrizable} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected MecoreItemProviderAdapter mTypeParametrizableItemProvider;

	/**
	 * This creates an adapter for a {@link org.emftext.language.mecore.MTypeParametrizable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Adapter createMTypeParametrizableAdapter() {
		if (mTypeParametrizableItemProvider == null) {
			mTypeParametrizableItemProvider = new MecoreItemProviderAdapter(this);
		}

		return mTypeParametrizableItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.emftext.language.mecore.MTypeArgumentable} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected MecoreItemProviderAdapter mTypeArgumentableItemProvider;

	/**
	 * This creates an adapter for a {@link org.emftext.language.mecore.MTypeArgumentable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Adapter createMTypeArgumentableAdapter() {
		if (mTypeArgumentableItemProvider == null) {
			mTypeArgumentableItemProvider = new MecoreItemProviderAdapter(this);
		}

		return mTypeArgumentableItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (mTypedElementItemProvider != null) mTypedElementItemProvider.dispose();
		if (mPackageItemProvider != null) mPackageItemProvider.dispose();
		if (mImportItemProvider != null) mImportItemProvider.dispose();
		if (mClassItemProvider != null) mClassItemProvider.dispose();
		if (mEnumItemProvider != null) mEnumItemProvider.dispose();
		if (mEnumLiteralItemProvider != null) mEnumLiteralItemProvider.dispose();
		if (mFeatureItemProvider != null) mFeatureItemProvider.dispose();
		if (mSimpleMultiplicityItemProvider != null) mSimpleMultiplicityItemProvider.dispose();
		if (mComplexMultiplicityItemProvider != null) mComplexMultiplicityItemProvider.dispose();
		if (mDataTypeItemProvider != null) mDataTypeItemProvider.dispose();
		if (mEcoreTypeItemProvider != null) mEcoreTypeItemProvider.dispose();
		if (mOperationItemProvider != null) mOperationItemProvider.dispose();
		if (mParameterItemProvider != null) mParameterItemProvider.dispose();
		if (mTypeParameterItemProvider != null) mTypeParameterItemProvider.dispose();
		if (mTypeParametrizableItemProvider != null) mTypeParametrizableItemProvider.dispose();
		if (mTypeArgumentableItemProvider != null) mTypeArgumentableItemProvider.dispose();
	}

}
