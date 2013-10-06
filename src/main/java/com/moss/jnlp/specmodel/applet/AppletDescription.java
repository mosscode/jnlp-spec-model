/**
 * Copyright (C) 2013, Moss Computing Inc.
 *
 * This file is part of jnlp-spec-model.
 *
 * jnlp-spec-model is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * jnlp-spec-model is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with jnlp-spec-model; see the file COPYING.  If not, write to the
 * Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301 USA.
 *
 * Linking this library statically or dynamically with other modules is
 * making a combined work based on this library.  Thus, the terms and
 * conditions of the GNU General Public License cover the whole
 * combination.
 *
 * As a special exception, the copyright holders of this library give you
 * permission to link this library with independent modules to produce an
 * executable, regardless of the license terms of these independent
 * modules, and to copy and distribute the resulting executable under
 * terms of your choice, provided that you also meet, for each linked
 * independent module, the terms and conditions of the license of that
 * module.  An independent module is a module which is not derived from
 * or based on this library.  If you modify this library, you may extend
 * this exception to your version of the library, but you are not
 * obligated to do so.  If you do not wish to do so, delete this
 * exception statement from your version.
 */
package com.moss.jnlp.specmodel.applet;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @see <a href="https://jdk6.dev.java.net/plugin2/jnlp/"> Intro to JNLP support in the new (as of 6u10) java plug-in</a> 
 * @see <a href="http://java.sun.com/javase/6/docs/technotes/guides/javaws/developersguide/syntax.html#applet_desc"> Java6 Syntax Documentation for "applet-desc"</a>
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AppletDescription {
	/**
	 * Describes the name of the main applet class without the .class extension. 
	 */
	@XmlAttribute(name="main-class")
	private String mainClass;
	
	/**
	 * Describes the name of the applet. 
	 */
	@XmlAttribute(name="name")
	private String name;
	
	@XmlAttribute
	private Integer width;
	
	@XmlAttribute
	private Integer height;
	
	@XmlAttribute
	private String documentbase;
	
	/**
	 * Describes the documentbase for the applet as a URL. 
	 */
	@XmlElement(name="param")
	private List<AppletParam> params = new LinkedList<AppletParam>();
	
	public AppletDescription() {
	}
	
	public AppletDescription(String mainClass, String name, Integer width,
			Integer height, String documentbase, List<AppletParam> params) {
		super();
		this.mainClass = mainClass;
		this.name = name;
		this.width = width;
		this.height = height;
		this.documentbase = documentbase;
		this.params = params;
	}
	
	
	
}
