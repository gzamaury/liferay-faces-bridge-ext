/**
 * Copyright (c) 2000-2019 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.liferay.faces.bridge.ext.renderkit.html_basic.internal;

import java.util.Collections;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;


/**
 * @author  Kyle Stiemann
 */
public class NodeImpl implements Node {

	// Private Data Members
	private short nodeType;
	private String textContent;
	private Node parentNode;
	private NodeListImpl childNodes;

	public NodeImpl(short nodeType, Node parentNode) {

		this.nodeType = nodeType;
		this.parentNode = parentNode;
		this.childNodes = new NodeListImpl();
	}

	public NodeImpl(short nodeType, String textContent, Node parentNode) {

		this(nodeType, parentNode);
		this.textContent = textContent;
	}

	@Override
	public Node appendChild(Node newChild) throws DOMException {

		childNodes.add(newChild);

		return newChild;
	}

	@Override
	public Node cloneNode(boolean deep) {
		throw new UnsupportedOperationException();
	}

	@Override
	public short compareDocumentPosition(Node other) throws DOMException {
		throw new UnsupportedOperationException();
	}

	@Override
	public NamedNodeMap getAttributes() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getBaseURI() {
		throw new UnsupportedOperationException();
	}

	@Override
	public NodeList getChildNodes() {
		return childNodes;
	}

	@Override
	public Object getFeature(String feature, String version) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Node getFirstChild() {
		return childNodes.item(0);
	}

	@Override
	public Node getLastChild() {

		int length = childNodes.getLength();

		return childNodes.item(length - 1);
	}

	@Override
	public String getLocalName() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getNamespaceURI() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Node getNextSibling() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getNodeName() {
		throw new UnsupportedOperationException();
	}

	@Override
	public short getNodeType() {
		return nodeType;
	}

	@Override
	public String getNodeValue() throws DOMException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Document getOwnerDocument() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Node getParentNode() {
		return parentNode;
	}

	@Override
	public String getPrefix() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Node getPreviousSibling() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getTextContent() throws DOMException {

		if (textContent == null) {

			textContent = "";

			int childNodeCount = childNodes.getLength();

			for (int i = 0; i < childNodeCount; i++) {

				Node childNode = childNodes.item(i);
				textContent += childNode.getTextContent();
			}
		}

		return textContent;
	}

	@Override
	public Object getUserData(String key) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasAttributes() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasChildNodes() {
		return !childNodes.isEmpty();
	}

	@Override
	public Node insertBefore(Node newChild, Node refChild) throws DOMException {

		int index = childNodes.indexOf(refChild);
		childNodes.add(index, newChild);

		return newChild;
	}

	@Override
	public boolean isDefaultNamespace(String namespaceURI) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isEqualNode(Node arg) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isSameNode(Node other) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isSupported(String feature, String version) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String lookupNamespaceURI(String prefix) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String lookupPrefix(String namespaceURI) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void normalize() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Node removeChild(Node oldChild) throws DOMException {

		childNodes.remove(oldChild);

		return oldChild;
	}

	@Override
	public Node replaceChild(Node newChild, Node oldChild) throws DOMException {

		Collections.replaceAll(childNodes, oldChild, newChild);

		return oldChild;
	}

	@Override
	public void setNodeValue(String nodeValue) throws DOMException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setPrefix(String prefix) throws DOMException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setTextContent(String textContent) throws DOMException {
		this.textContent = textContent;
	}

	@Override
	public Object setUserData(String key, Object data, UserDataHandler handler) {
		throw new UnsupportedOperationException();
	}
}
