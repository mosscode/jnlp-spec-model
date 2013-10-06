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
package com.moss.jnlp.specmodel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.moss.jnlp.specmodel.applet.AppletDescription;
import com.moss.jnlp.specmodel.application.ApplicationDescription;
import com.moss.jnlp.specmodel.common.Information;
import com.moss.jnlp.specmodel.common.Resources;
import com.moss.jnlp.specmodel.common.SecuritySpec;
import com.moss.jnlp.specmodel.common.UpdateSpec;
import com.moss.jnlp.specmodel.component.ComponentDescription;
import com.moss.jnlp.specmodel.installer.InstallerDescription;


@XmlRootElement(name="jnlp")
@XmlAccessorType(XmlAccessType.FIELD)
public final class JnlpDescriptor {
	
	@XmlAttribute(name="codebase")
	private String codeBase;
	
	@XmlAttribute(name="href")
	private String href;
	
	private Information information;
	private UpdateSpec update;
	
	private Resources resources;
	
	private SecuritySpec security;
	
	@XmlElement(name="component-desc")
	private ComponentDescription componentDescription;
	
	@XmlElement(name="applet-desc")
	private AppletDescription appletDescription;
	
	@XmlElement(name="application-desc")
	private ApplicationDescription applicationDescription;

	@XmlElement(name="installer-desc")
	private InstallerDescription installerDescription;
	
	public JnlpDescriptor() {}
	
	public JnlpDescriptor(String href, String codeBase, Information information, UpdateSpec update, Resources resources, SecuritySpec security, InstallerDescription installerDescription) {
		super();
		this.href = href;
		this.codeBase = codeBase;
		this.information = information;
		this.update = update;
		this.resources = resources;
		this.security = security;
		this.installerDescription = installerDescription;
	}
	
	public JnlpDescriptor(String href, String codeBase, Information information, UpdateSpec update, Resources resources, SecuritySpec security, ApplicationDescription applicationDescription) {
		super();
		this.href = href;
		this.codeBase = codeBase;
		this.information = information;
		this.update = update;
		this.resources = resources;
		this.security = security;
		this.applicationDescription = applicationDescription;
	}
	
	public JnlpDescriptor(String href, String codeBase, Information information, UpdateSpec update, Resources resources, SecuritySpec security, AppletDescription appletDescription) {
		super();
		this.href = href;
		this.codeBase = codeBase;
		this.information = information;
		this.update = update;
		this.resources = resources;
		this.security = security;
		this.appletDescription = appletDescription;
	}
	
	public JnlpDescriptor(String href, String codeBase, Information information, UpdateSpec update, Resources resources, SecuritySpec security, ComponentDescription componentDescription) {
		super();
		this.href = href;
		this.codeBase = codeBase;
		this.information = information;
		this.update = update;
		this.resources = resources;
		this.security = security;
		this.componentDescription = componentDescription;
	}
	
	
	
	
}