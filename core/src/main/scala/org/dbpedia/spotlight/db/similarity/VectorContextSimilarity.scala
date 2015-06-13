package org.dbpedia.spotlight.db.similarity

import java.io.File

<<<<<<< HEAD
<<<<<<< HEAD
import breeze.linalg._

import org.dbpedia.spotlight.model.{DBpediaResource, TokenType}
import org.dbpedia.spotlight.util.MathUtil
=======

=======
>>>>>>> started vector model wrapper in contextsimilarity interface, added breeze 0.10 dependency
import breeze.linalg._

import org.dbpedia.spotlight.model.{DBpediaResource, TokenType}
>>>>>>> add dependencies for new breeze version

import scala.collection.mutable
import scala.io.Source

/**
<<<<<<< HEAD
 * Context similarity based on dense, continuous space vector models.
 * @author Philipp Dowling
 *
 * created on 12/06/15.
=======
 * Created by dowling on 12/06/15.
>>>>>>> add dependencies for new breeze version
 */
class VectorContextSimilarity(modelPath: String, dictPath: String) extends ContextSimilarity{
  var vectors: DenseMatrix[Double] = csvread(new File(modelPath))

  var dict: Map[String, Int] = Source.fromFile(dictPath).getLines().map { line =>
    val contents = line.split("\t")
    (contents(0), contents(1).toInt)
  }.toMap

  def get_similarity(first: String, second:String): Double = {
    val f = vectors(dict(first),0 to vectors.cols-1)
    val s = vectors(dict(second), 0 to vectors.cols-1)
    f * s.t
  }

  def get_similarity(first: Array[String], second: Array[String]): Double = {
    val f = first.map( s => {vectors(dict(s), 0 to vectors.cols - 1)}).reduceLeft(_ + _)
    val s = second.map( s => {vectors(dict(s), 0 to vectors.cols - 1)}).reduceLeft(_ + _)

    f * s.t
  }

  /**
   * Calculate the context score for all DBpedia resources in the given text. The text context is specified
   * as q query of tokens and their counts.
   *
   * @param query the text context of the document
   * @param candidates the set of DBpedia resource candidates
   * @return
   */
  override def score(query: Seq[TokenType], candidates: Set[DBpediaResource]): mutable.Map[DBpediaResource, Double] = null

  /**
   * Calculate the context score for the context alone, not assuming that there is any entity generating it.
   *
   * In the generative model, this is: \product_i P_LM(token_i)
   *
   * @param query the text context of the document
   * @return
   */
  override def nilScore(query: Seq[TokenType]): Double = 0.0
}
