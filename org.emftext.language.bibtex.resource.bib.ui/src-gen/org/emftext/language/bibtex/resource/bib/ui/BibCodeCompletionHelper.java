/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib.ui;

/**
 * A CodeCompletionHelper can be used to derive completion proposals for partial
 * documents. It runs the parser generated by EMFText in a special mode (i.e., the
 * rememberExpectedElements mode). Based on the elements that are expected by the
 * parser for different regions in the document, valid proposals are computed.
 */
public class BibCodeCompletionHelper {
	
	private org.emftext.language.bibtex.resource.bib.mopp.BibAttributeValueProvider attributeValueProvider = new org.emftext.language.bibtex.resource.bib.mopp.BibAttributeValueProvider();
	
	/**
	 * Computes a set of proposals for the given document assuming the cursor is at
	 * 'cursorOffset'. The proposals are derived using the meta information, i.e., the
	 * generated language plug-in.
	 * 
	 * @param originalResource
	 * @param content the documents content
	 * @param cursorOffset
	 * 
	 * @return
	 */
	public org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal[] computeCompletionProposals(org.emftext.language.bibtex.resource.bib.IBibTextResource originalResource, String content, int cursorOffset) {
		org.eclipse.emf.ecore.resource.ResourceSet resourceSet = new org.eclipse.emf.ecore.resource.impl.ResourceSetImpl();
		// the shadow resource needs the same URI because reference resolvers may use the
		// URI to resolve external references
		org.emftext.language.bibtex.resource.bib.IBibTextResource resource = (org.emftext.language.bibtex.resource.bib.IBibTextResource) resourceSet.createResource(originalResource.getURI());
		java.io.ByteArrayInputStream inputStream = new java.io.ByteArrayInputStream(content.getBytes());
		org.emftext.language.bibtex.resource.bib.IBibMetaInformation metaInformation = resource.getMetaInformation();
		org.emftext.language.bibtex.resource.bib.IBibTextParser parser = metaInformation.createParser(inputStream, null);
		org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal[] expectedElements = parseToExpectedElements(parser, resource, cursorOffset);
		if (expectedElements == null) {
			return new org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal[0];
		}
		if (expectedElements.length == 0) {
			return new org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal[0];
		}
		java.util.List<org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal> expectedAfterCursor = java.util.Arrays.asList(getElementsExpectedAt(expectedElements, cursorOffset));
		java.util.List<org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal> expectedBeforeCursor = java.util.Arrays.asList(getElementsExpectedAt(expectedElements, cursorOffset - 1));
		setPrefixes(expectedAfterCursor, content, cursorOffset);
		setPrefixes(expectedBeforeCursor, content, cursorOffset);
		// First, we derive all possible proposals from the set of elements that are
		// expected at the cursor position.
		java.util.Collection<org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal> allProposals = new java.util.LinkedHashSet<org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal>();
		java.util.Collection<org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal> rightProposals = deriveProposals(expectedAfterCursor, content, resource, cursorOffset);
		java.util.Collection<org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal> leftProposals = deriveProposals(expectedBeforeCursor, content, resource, cursorOffset - 1);
		// Second, the set of left proposals (i.e., the ones before the cursor) is checked
		// for emptiness. If the set is empty, the right proposals (i.e., the ones after
		// the cursor) are also considered. If the set is not empty, the right proposal
		// are discarded, because it does not make sense to propose them until the element
		// before the cursor was completed.
		allProposals.addAll(leftProposals);
		if (leftProposals.isEmpty()) {
			allProposals.addAll(rightProposals);
		}
		// Third, the proposals are sorted according to their relevance. Proposals that
		// matched the prefix are preferred over ones that did not. Finally, proposals are
		// sorted alphabetically.
		final java.util.List<org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal> sortedProposals = new java.util.ArrayList<org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal>(allProposals);
		java.util.Collections.sort(sortedProposals);
		return sortedProposals.toArray(new org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal[sortedProposals.size()]);
	}
	
	public org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal[] parseToExpectedElements(org.emftext.language.bibtex.resource.bib.IBibTextParser parser, org.emftext.language.bibtex.resource.bib.IBibTextResource resource, int cursorOffset) {
		final java.util.List<org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal> expectedElements = parser.parseToExpectedElements(null, resource, cursorOffset);
		if (expectedElements == null) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal[0];
		}
		removeDuplicateEntries(expectedElements);
		removeInvalidEntriesAtEnd(expectedElements);
		return expectedElements.toArray(new org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal[expectedElements.size()]);
	}
	
	private void removeDuplicateEntries(java.util.List<org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal> expectedElements) {
		for (int i = 0; i < expectedElements.size() - 1; i++) {
			org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal elementAtIndex = expectedElements.get(i);
			for (int j = i + 1; j < expectedElements.size();) {
				org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal elementAtNext = expectedElements.get(j);
				if (elementAtIndex.equals(elementAtNext) && elementAtIndex.getStartExcludingHiddenTokens() == elementAtNext.getStartExcludingHiddenTokens()) {
					expectedElements.remove(j);
				} else {
					j++;
				}
			}
		}
	}
	
	private void removeInvalidEntriesAtEnd(java.util.List<org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal> expectedElements) {
		for (int i = 0; i < expectedElements.size() - 1;) {
			org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal elementAtIndex = expectedElements.get(i);
			org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal elementAtNext = expectedElements.get(i + 1);
			if (elementAtIndex.getStartExcludingHiddenTokens() == elementAtNext.getStartExcludingHiddenTokens() && shouldRemove(elementAtIndex.getFollowSetID(), elementAtNext.getFollowSetID())) {
				expectedElements.remove(i + 1);
			} else {
				i++;
			}
		}
	}
	
	public boolean shouldRemove(int followSetID1, int followSetID2) {
		return followSetID1 != followSetID2;
	}
	
	private String findPrefix(java.util.List<org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal> expectedElements, org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal expectedAtCursor, String content, int cursorOffset) {
		if (cursorOffset < 0) {
			return "";
		}
		int end = 0;
		for (org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal expectedElement : expectedElements) {
			if (expectedElement == expectedAtCursor) {
				final int start = expectedElement.getStartExcludingHiddenTokens();
				if (start >= 0  && start < Integer.MAX_VALUE) {
					end = start;
				}
				break;
			}
		}
		end = Math.min(end, cursorOffset);
		final String prefix = content.substring(end, Math.min(content.length(), cursorOffset));
		return prefix;
	}
	
	private java.util.Collection<org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal> deriveProposals(java.util.List<org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal> expectedElements, String content, org.emftext.language.bibtex.resource.bib.IBibTextResource resource, int cursorOffset) {
		java.util.Collection<org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal> resultSet = new java.util.LinkedHashSet<org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal>();
		for (org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal expectedElement : expectedElements) {
			resultSet.addAll(deriveProposals(expectedElement, content, resource, cursorOffset));
		}
		return resultSet;
	}
	
	private java.util.Collection<org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal> deriveProposals(org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal expectedTerminal, String content, org.emftext.language.bibtex.resource.bib.IBibTextResource resource, int cursorOffset) {
		org.emftext.language.bibtex.resource.bib.IBibMetaInformation metaInformation = resource.getMetaInformation();
		org.emftext.language.bibtex.resource.bib.IBibLocationMap locationMap = resource.getLocationMap();
		org.emftext.language.bibtex.resource.bib.IBibExpectedElement expectedElement = (org.emftext.language.bibtex.resource.bib.IBibExpectedElement) expectedTerminal.getTerminal();
		if (expectedElement instanceof org.emftext.language.bibtex.resource.bib.mopp.BibExpectedCsString) {
			org.emftext.language.bibtex.resource.bib.mopp.BibExpectedCsString csString = (org.emftext.language.bibtex.resource.bib.mopp.BibExpectedCsString) expectedElement;
			return handleKeyword(csString, expectedTerminal.getPrefix());
		} else if (expectedElement instanceof org.emftext.language.bibtex.resource.bib.mopp.BibExpectedBooleanTerminal) {
			org.emftext.language.bibtex.resource.bib.mopp.BibExpectedBooleanTerminal expectedBooleanTerminal = (org.emftext.language.bibtex.resource.bib.mopp.BibExpectedBooleanTerminal) expectedElement;
			return handleBooleanTerminal(expectedBooleanTerminal, expectedTerminal.getPrefix());
		} else if (expectedElement instanceof org.emftext.language.bibtex.resource.bib.mopp.BibExpectedEnumerationTerminal) {
			org.emftext.language.bibtex.resource.bib.mopp.BibExpectedEnumerationTerminal expectedEnumerationTerminal = (org.emftext.language.bibtex.resource.bib.mopp.BibExpectedEnumerationTerminal) expectedElement;
			return handleEnumerationTerminal(expectedEnumerationTerminal, expectedTerminal.getPrefix());
		} else if (expectedElement instanceof org.emftext.language.bibtex.resource.bib.mopp.BibExpectedStructuralFeature) {
			org.emftext.language.bibtex.resource.bib.mopp.BibExpectedStructuralFeature expectedFeature = (org.emftext.language.bibtex.resource.bib.mopp.BibExpectedStructuralFeature) expectedElement;
			org.eclipse.emf.ecore.EStructuralFeature feature = expectedFeature.getFeature();
			org.eclipse.emf.ecore.EClassifier featureType = feature.getEType();
			java.util.List<org.eclipse.emf.ecore.EObject> elementsAtCursor = locationMap.getElementsAt(cursorOffset);
			org.eclipse.emf.ecore.EObject container = null;
			// we need to skip the proxy elements at the cursor, because they are not the
			// container for the reference we try to complete
			for (int i = 0; i < elementsAtCursor.size(); i++) {
				container = elementsAtCursor.get(i);
				if (!container.eIsProxy()) {
					break;
				}
			}
			// if no container can be found, the cursor is probably at the end of the
			// document. we need to create artificial containers.
			if (container == null) {
				boolean attachedArtificialContainer = false;
				org.eclipse.emf.ecore.EClass containerClass = expectedTerminal.getTerminal().getRuleMetaclass();
				org.eclipse.emf.ecore.EStructuralFeature[] containmentTrace = expectedTerminal.getContainmentTrace();
				java.util.List<org.eclipse.emf.ecore.EObject> contentList = null;
				for (org.eclipse.emf.ecore.EStructuralFeature eStructuralFeature : containmentTrace) {
					if (attachedArtificialContainer) {
						break;
					}
					org.eclipse.emf.ecore.EClass neededClass = eStructuralFeature.getEContainingClass();
					// fill the content list during the first iteration of the loop
					if (contentList == null) {
						contentList = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
						java.util.Iterator<org.eclipse.emf.ecore.EObject> allContents = resource.getAllContents();
						while (allContents.hasNext()) {
							org.eclipse.emf.ecore.EObject next = allContents.next();
							contentList.add(next);
						}
					}
					// find object to attach artificial container to
					for (int i = contentList.size() - 1; i >= 0; i--) {
						org.eclipse.emf.ecore.EObject object = contentList.get(i);
						if (neededClass.isInstance(object)) {
							org.eclipse.emf.ecore.EObject newContainer = containerClass.getEPackage().getEFactoryInstance().create(containerClass);
							if (eStructuralFeature.getEType().isInstance(newContainer)) {
								org.emftext.language.bibtex.resource.bib.util.BibEObjectUtil.setFeature(object, eStructuralFeature, newContainer, false);
								container = newContainer;
								attachedArtificialContainer = true;
							}
						}
					}
				}
			}
			
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				org.eclipse.emf.ecore.EReference reference = (org.eclipse.emf.ecore.EReference) feature;
				if (featureType instanceof org.eclipse.emf.ecore.EClass) {
					if (reference.isContainment()) {
						// the FOLLOW set should contain only non-containment references
						assert false;
					} else {
						return handleNCReference(metaInformation, container, reference, expectedTerminal.getPrefix(), expectedFeature.getTokenName());
					}
				}
			} else if (feature instanceof org.eclipse.emf.ecore.EAttribute) {
				org.eclipse.emf.ecore.EAttribute attribute = (org.eclipse.emf.ecore.EAttribute) feature;
				if (featureType instanceof org.eclipse.emf.ecore.EEnum) {
					org.eclipse.emf.ecore.EEnum enumType = (org.eclipse.emf.ecore.EEnum) featureType;
					return handleEnumAttribute(metaInformation, expectedFeature, enumType, expectedTerminal.getPrefix(), container);
				} else {
					// handle EAttributes (derive default value depending on the type of the
					// attribute, figure out token resolver, and call deResolve())
					return handleAttribute(metaInformation, expectedFeature, container, attribute, expectedTerminal.getPrefix());
				}
			} else {
				// there should be no other subclass of EStructuralFeature
				assert false;
			}
		} else {
			// there should be no other class implementing IExpectedElement
			assert false;
		}
		return java.util.Collections.emptyList();
	}
	
	private java.util.Collection<org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal> handleEnumAttribute(org.emftext.language.bibtex.resource.bib.IBibMetaInformation metaInformation, org.emftext.language.bibtex.resource.bib.mopp.BibExpectedStructuralFeature expectedFeature, org.eclipse.emf.ecore.EEnum enumType, String prefix, org.eclipse.emf.ecore.EObject container) {
		java.util.Collection<org.eclipse.emf.ecore.EEnumLiteral> enumLiterals = enumType.getELiterals();
		java.util.Collection<org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal> result = new java.util.LinkedHashSet<org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal>();
		for (org.eclipse.emf.ecore.EEnumLiteral literal : enumLiterals) {
			String unResolvedLiteral = literal.getLiteral();
			// use token resolver to get de-resolved value of the literal
			org.emftext.language.bibtex.resource.bib.IBibTokenResolverFactory tokenResolverFactory = metaInformation.getTokenResolverFactory();
			org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(expectedFeature.getTokenName());
			String resolvedLiteral = tokenResolver.deResolve(unResolvedLiteral, expectedFeature.getFeature(), container);
			boolean matchesPrefix = matches(resolvedLiteral, prefix);
			result.add(new org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal(resolvedLiteral, prefix, matchesPrefix, expectedFeature.getFeature(), container));
		}
		return result;
	}
	
	private java.util.Collection<org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal> handleNCReference(org.emftext.language.bibtex.resource.bib.IBibMetaInformation metaInformation, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, String prefix, String tokenName) {
		// proposals for non-containment references are derived by calling the reference
		// resolver switch in fuzzy mode.
		org.emftext.language.bibtex.resource.bib.IBibReferenceResolverSwitch resolverSwitch = metaInformation.getReferenceResolverSwitch();
		org.emftext.language.bibtex.resource.bib.IBibTokenResolverFactory tokenResolverFactory = metaInformation.getTokenResolverFactory();
		org.emftext.language.bibtex.resource.bib.IBibReferenceResolveResult<org.eclipse.emf.ecore.EObject> result = new org.emftext.language.bibtex.resource.bib.mopp.BibReferenceResolveResult<org.eclipse.emf.ecore.EObject>(true);
		resolverSwitch.resolveFuzzy(prefix, container, reference, 0, result);
		java.util.Collection<org.emftext.language.bibtex.resource.bib.IBibReferenceMapping<org.eclipse.emf.ecore.EObject>> mappings = result.getMappings();
		if (mappings != null) {
			java.util.Collection<org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal> resultSet = new java.util.LinkedHashSet<org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal>();
			for (org.emftext.language.bibtex.resource.bib.IBibReferenceMapping<org.eclipse.emf.ecore.EObject> mapping : mappings) {
				org.eclipse.swt.graphics.Image image = null;
				if (mapping instanceof org.emftext.language.bibtex.resource.bib.mopp.BibElementMapping<?>) {
					org.emftext.language.bibtex.resource.bib.mopp.BibElementMapping<?> elementMapping = (org.emftext.language.bibtex.resource.bib.mopp.BibElementMapping<?>) mapping;
					Object target = elementMapping.getTargetElement();
					// de-resolve reference to obtain correct identifier
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);
					final String identifier = tokenResolver.deResolve(elementMapping.getIdentifier(), reference, container);
					if (target instanceof org.eclipse.emf.ecore.EObject) {
						image = getImage((org.eclipse.emf.ecore.EObject) target);
					}
					boolean matchesPrefix = matches(identifier, prefix);
					resultSet.add(new org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal(identifier, prefix, matchesPrefix, reference, container, image));
				}
			}
			return resultSet;
		}
		return java.util.Collections.emptyList();
	}
	
	private java.util.Collection<org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal> handleAttribute(org.emftext.language.bibtex.resource.bib.IBibMetaInformation metaInformation, org.emftext.language.bibtex.resource.bib.mopp.BibExpectedStructuralFeature expectedFeature, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EAttribute attribute, String prefix) {
		java.util.Collection<org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal> resultSet = new java.util.LinkedHashSet<org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal>();
		Object[] defaultValues = attributeValueProvider.getDefaultValues(attribute);
		if (defaultValues != null) {
			for (Object defaultValue : defaultValues) {
				if (defaultValue != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolverFactory tokenResolverFactory = metaInformation.getTokenResolverFactory();
					String tokenName = expectedFeature.getTokenName();
					if (tokenName != null) {
						org.emftext.language.bibtex.resource.bib.IBibTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);
						if (tokenResolver != null) {
							String defaultValueAsString = tokenResolver.deResolve(defaultValue, attribute, container);
							boolean matchesPrefix = matches(defaultValueAsString, prefix);
							resultSet.add(new org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal(defaultValueAsString, prefix, matchesPrefix, expectedFeature.getFeature(), container));
						}
					}
				}
			}
		}
		return resultSet;
	}
	
	private java.util.Collection<org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal> handleKeyword(org.emftext.language.bibtex.resource.bib.mopp.BibExpectedCsString csString, String prefix) {
		String proposal = csString.getValue();
		boolean matchesPrefix = matches(proposal, prefix);
		return java.util.Collections.singleton(new org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal(proposal, prefix, matchesPrefix, null, null));
	}
	
	private java.util.Collection<org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal> handleBooleanTerminal(org.emftext.language.bibtex.resource.bib.mopp.BibExpectedBooleanTerminal expectedBooleanTerminal, String prefix) {
		java.util.Collection<org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal> result = new java.util.LinkedHashSet<org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal>(2);
		org.emftext.language.bibtex.resource.bib.grammar.BibBooleanTerminal booleanTerminal = expectedBooleanTerminal.getBooleanTerminal();
		result.addAll(handleLiteral(booleanTerminal.getAttribute(), prefix, booleanTerminal.getTrueLiteral()));
		result.addAll(handleLiteral(booleanTerminal.getAttribute(), prefix, booleanTerminal.getFalseLiteral()));
		return result;
	}
	
	private java.util.Collection<org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal> handleEnumerationTerminal(org.emftext.language.bibtex.resource.bib.mopp.BibExpectedEnumerationTerminal expectedEnumerationTerminal, String prefix) {
		java.util.Collection<org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal> result = new java.util.LinkedHashSet<org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal>(2);
		org.emftext.language.bibtex.resource.bib.grammar.BibEnumerationTerminal enumerationTerminal = expectedEnumerationTerminal.getEnumerationTerminal();
		java.util.Map<String, String> literalMapping = enumerationTerminal.getLiteralMapping();
		for (String literalName : literalMapping.keySet()) {
			result.addAll(handleLiteral(enumerationTerminal.getAttribute(), prefix, literalMapping.get(literalName)));
		}
		return result;
	}
	
	private java.util.Collection<org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal> handleLiteral(org.eclipse.emf.ecore.EAttribute attribute, String prefix, String literal) {
		if ("".equals(literal)) {
			return java.util.Collections.emptySet();
		}
		boolean matchesPrefix = matches(literal, prefix);
		return java.util.Collections.singleton(new org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal(literal, prefix, matchesPrefix, null, null));
	}
	
	/**
	 * Calculates the prefix for each given expected element. The prefix depends on
	 * the current document content, the cursor position, and the position where the
	 * element is expected.
	 */
	private void setPrefixes(java.util.List<org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal> expectedElements, String content, int cursorOffset) {
		if (cursorOffset < 0) {
			return;
		}
		for (org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal expectedElement : expectedElements) {
			String prefix = findPrefix(expectedElements, expectedElement, content, cursorOffset);
			expectedElement.setPrefix(prefix);
		}
	}
	
	public org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal[] getElementsExpectedAt(org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal[] allExpectedElements, int cursorOffset) {
		java.util.List<org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal> expectedAtCursor = new java.util.ArrayList<org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal>();
		for (int i = 0; i < allExpectedElements.length; i++) {
			org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal expectedElement = allExpectedElements[i];
			int startIncludingHidden = expectedElement.getStartIncludingHiddenTokens();
			int end = getEnd(allExpectedElements, i);
			if (cursorOffset >= startIncludingHidden && cursorOffset <= end) {
				expectedAtCursor.add(expectedElement);
			}
		}
		return expectedAtCursor.toArray(new org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal[expectedAtCursor.size()]);
	}
	
	private int getEnd(org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal[] allExpectedElements, int indexInList) {
		org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal elementAtIndex = allExpectedElements[indexInList];
		int startIncludingHidden = elementAtIndex.getStartIncludingHiddenTokens();
		int startExcludingHidden = elementAtIndex.getStartExcludingHiddenTokens();
		for (int i = indexInList + 1; i < allExpectedElements.length; i++) {
			org.emftext.language.bibtex.resource.bib.mopp.BibExpectedTerminal elementAtI = allExpectedElements[i];
			int startIncludingHiddenForI = elementAtI.getStartIncludingHiddenTokens();
			int startExcludingHiddenForI = elementAtI.getStartExcludingHiddenTokens();
			if (startIncludingHidden != startIncludingHiddenForI || startExcludingHidden != startExcludingHiddenForI) {
				return startIncludingHiddenForI - 1;
			}
		}
		return Integer.MAX_VALUE;
	}
	
	private boolean matches(String proposal, String prefix) {
		return (proposal.toLowerCase().startsWith(prefix.toLowerCase()) || org.emftext.language.bibtex.resource.bib.util.BibStringUtil.matchCamelCase(prefix, proposal) != null) && !proposal.equals(prefix);
	}
	
	public org.eclipse.swt.graphics.Image getImage(org.eclipse.emf.ecore.EObject element) {
		if (!org.eclipse.core.runtime.Platform.isRunning()) {
			return null;
		}
		org.eclipse.emf.edit.provider.ComposedAdapterFactory adapterFactory = new org.eclipse.emf.edit.provider.ComposedAdapterFactory(org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory());
		org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider labelProvider = new org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider(adapterFactory);
		return labelProvider.getImage(element);
	}
}
