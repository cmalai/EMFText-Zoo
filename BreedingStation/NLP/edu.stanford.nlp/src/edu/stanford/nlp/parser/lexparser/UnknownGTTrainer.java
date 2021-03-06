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
package edu.stanford.nlp.parser.lexparser;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.stats.ClassicCounter;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.Pair;

/**
 * This class trains a Good-Turing model for unknown words from a
 * collection of trees.  It builds up a map of statistics which can be
 * used by any UnknownWordModel which wants to use the GT model.
 *
 * Authors:
 *
 * @author Roger Levy
 * @author Greg Donaker (corrections and modeling improvements)
 * @author Christopher Manning (generalized and improved what Greg did)
 * @author Anna Rafferty
 * @author John Bauer (refactored into a separate training class)
 */
public class UnknownGTTrainer {
  ClassicCounter<Pair<String,String>> wtCount = new ClassicCounter<Pair<String,String>>();
  ClassicCounter<String> tagCount = new ClassicCounter<String>();
  ClassicCounter<String> r1 = new ClassicCounter<String>(); // for each tag, # of words seen once
  ClassicCounter<String> r0 = new ClassicCounter<String>(); // for each tag, # of words not seen
  Set<String> seenWords = new HashSet<String>();
  
  double tokens = 0;
  
  HashMap<String,Float> unknownGT = new HashMap<String,Float>();
  
  public void train(Collection<Tree> trees) {
    train(trees, 1.0);
  }

  public void train(Collection<Tree> trees, double weight) {
    for (Tree t : trees) {
      train(t, weight);
    }
  }


  public void train(Tree tree, double weight) {
    /* get TaggedWord and total tag counts, and get set of all
     * words attested in training
     */
    for (TaggedWord word : tree.taggedYield()) {
      train(word, weight);
    }
  }

  public void train(TaggedWord tw, double weight) {
    tokens = tokens + weight;
    String word = tw.word();
    String tag = tw.tag();
          
    // TaggedWord has crummy equality conditions            
    Pair<String,String> wt = new Pair<String,String>(word, tag);
    wtCount.incrementCount(wt, weight);
          
    tagCount.incrementCount(tag, weight);
    seenWords.add(word);
  }
  
  public void finishTraining() {
    // testing: get some stats here
    System.err.println("Total tokens: " + tokens);
    System.err.println("Total WordTag types: " + wtCount.keySet().size());
    System.err.println("Total tag types: " + tagCount.keySet().size());
    System.err.println("Total word types: " + seenWords.size());
    
    /* find # of once-seen words for each tag */
    for (Pair<String,String> wt : wtCount.keySet()) {
      if (wtCount.getCount(wt) == 1) {
        r1.incrementCount(wt.second());
      }
    }
    
    /* find # of unseen words for each tag */
    for (String tag : tagCount.keySet()) {
      for (String word : seenWords) {
        Pair<String,String> wt = new Pair<String,String>(word, tag);
        if (!(wtCount.keySet().contains(wt))) {
          r0.incrementCount(tag);
        }
      }
    }
    
    /* set unseen word probability for each tag */
    for (String tag : tagCount.keySet()) {
      float logprob = (float) Math.log(r1.getCount(tag) / (tagCount.getCount(tag) * r0.getCount(tag)));
      unknownGT.put(tag, Float.valueOf(logprob));
    }
    
  }
  
}

