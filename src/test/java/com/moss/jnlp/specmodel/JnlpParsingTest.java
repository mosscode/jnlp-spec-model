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
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import junit.framework.TestCase;
import bmsi.util.JavaDiff;

import com.moss.jaxbhelper.JAXBHelper;


public class JnlpParsingTest extends TestCase {
	public void testRun() throws Exception {
		String expected = read(getClass().getResourceAsStream("sample.jnlp")).toString();
		JAXBHelper h = new JAXBHelper(JnlpDescriptor.class);
		
		JnlpDescriptor in = h.readFromXmlString(expected);
		
		String actual = h.writeToXmlString(in);
		
		if(!expected.equals(actual)){
			String diff = new JavaDiff().unifiedDiff(expected, actual);
			System.out.println(diff);
			fail("Text differed:\n" + diff);
		}
	}
	
	private StringBuilder read(InputStream rawIn) throws Exception {
		final InputStream prettyBytes;
		{// NORMALIZE THE XML
			ByteArrayOutputStream prettyBytesSink = new ByteArrayOutputStream();
			JAXBHelper.beautify(rawIn, prettyBytesSink);
			prettyBytes = new ByteArrayInputStream(prettyBytesSink.toByteArray());
		}
		StringBuilder text = new StringBuilder();
		Reader r = new InputStreamReader(prettyBytes);
		char[] buf = new char[1024];
		for(int x= r.read(buf); x!=-1; x= r.read(buf)){
			text.append(buf, 0, x);
		}
		r.close();
		return text;
	}
}
