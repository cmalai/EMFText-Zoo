/*******************************************************************************
 * Copyright (C) 2012
 * The Stanford Natural Language Processing Group 
 * http://nlp.stanford.edu/
 * This Eclipse plugin matches the Stanford CoreNLP version 1.3.3
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 ******************************************************************************/
package edu.stanford.nlp.trees;

import java.io.IOException;

/**
 * A <code>TreeReader</code> adds functionality to another <code>Reader</code>
 * by reading in Trees, or some descendant class.
 *
 * @author Christopher Manning
 * @author Roger Levy (mod. 2003/01)
 * @version 2003/01
 */
public interface TreeReader {

  /**
   * Reads a single tree.
   *
   * @return A single tree, or <code>null</code> at end of file.
   */
  public Tree readTree() throws IOException;


  /**
   * Close the Reader behind this <code>TreeReader</code>.
   */
  public void close() throws IOException;

}
