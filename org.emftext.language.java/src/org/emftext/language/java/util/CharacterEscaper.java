/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java.util;

/**
 * A CharacterEscaper can be used to escape and unescape special characters
 * in Java strings and character literals. Among these special characters are
 * tabs, single and double quotes, line breaks and backslashes.
 */
public class CharacterEscaper {

	private static final char BACKSLASH = '\\';
	
	/**
	   * Removes the escape symbol if the given String contains escaped characters.
	   * 
	   * @param source
	   *      string with escapes
	   * @return
	   *      string with characters un-escaped
	   */
	public static String unescapeEscapedCharacters(String source) {
	     /* could use regular expression, but not this time... */
	     final int srcLen = source.length();
	     char c;

	     StringBuffer buffer = new StringBuffer(srcLen);

	     int i = 0;
	     while (i < srcLen) {

	            c = source.charAt(i++);

	            if (c == BACKSLASH) {
	                char nc = source.charAt(i);
	                switch (nc) {
		        		// octal characters: \0 to \377
		                case '0': 
		                case '1': 
		                case '2': 
		                case '3': {
		                    // Now we found the '0' we need to find up to 3 octal digits
		                    // Note: shifting left by 3 is the same as multiplying by 8
		                    int v = 0; // Accumulator
		                    int j;
		                    boolean stop = false;
		                    for (j = 0; j < 3 && !stop; j++) {
		                    	if (i + j < source.length()) {
			                        nc = source.charAt(i + j);
			                        switch (nc)
			                        {
			                            case 48: // '0'
			                            case 49: // '1'
			                            case 50: // '2'
			                            case 51: // '3'
			                            case 52: // '4'
			                            case 53: // '5'
			                            case 54: // '6'
			                            case 55: // '7'
			                                v = ((v << 3) + nc) - 48;
			                                break;
			                            default:
			                            	// some other character
			                                // almost but no go
			                            	stop = true;
			                            	// we have to go back one character, because we've read to far
			                            	j--;
			                                break;
			                        }
		                    	}
		                    } // for each of the digits
	
		                    if (v >= 0) {      // We got a full conversion
		                        c = (char) v;  // Use the converted char
		                        i += j;       // skip the numeric values
		                    }
		                	break;
		                }    
		                case BACKSLASH: {
		                	// if the next character is a backslash we have an
		                	// escaped backslash
	                		// skip the second backslash
	                		i++;
	                		break;
		                }
		                case 'b': {
		                	c = '\b';
	                		i++;
	                		break;
		                }
		                case 't': {
		                	c = '\t';
	                		i++;
	                		break;
		                }
		                case 'n': {
		                	c = '\n';
	                		i++;
	                		break;
		                }
		                case 'f': {
		                	c = '\f';
	                		i++;
	                		break;
		                }
		                case 'r': {
		                	c = '\r';
	                		i++;
	                		break;
		                }
		                case '\"': {
		                	c = '\"';
	                		i++;
	                		break;
		                }
		                case '\'': {
		                	c = '\'';
	                		i++;
	                		break;
		                }
	                }
	            }
	            buffer.append(c);
	        }
			
		// Fill in the remaining characters from the buffer
		while (i < srcLen) {
			buffer.append(source.charAt(i++));
		}		
		return buffer.toString();
	}
	
	public static String escapeEscapedCharacters(String source) {
		
		source = source.replaceAll("\\\\", "\\\\\\\\");
		source = source.replaceAll("\\\b", "\\\\b");
		source = source.replaceAll("\\\t", "\\\\t");
		source = source.replaceAll("\\\n", "\\\\n");
		source = source.replaceAll("\\\f", "\\\\f");
		source = source.replaceAll("\\\r", "\\\\r");
		source = source.replaceAll("\"", "\\\\\"");
		source = source.replaceAll("\'", "\\\\\'");

		return source;
	}

}
