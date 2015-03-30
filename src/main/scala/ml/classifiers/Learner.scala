/*
mls: basic machine learning algorithms for Scala
Copyright (C) 2014 Davi Pereira dos Santos

  This program is free software: you can redistribute it and/or modify
  it under the terms of the GNU General Public License as published by
  the Free Software Foundation, either version 3 of the License, or
  (at your option) any later version.

  This program is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  GNU General Public License for more details.

  You should have received a copy of the GNU General Public License
  along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package ml.classifiers

import ml.Pattern
import ml.models.Model

trait Learner extends Limpa {
   val id: Int
   val abr: String
   val attPref: String
   val boundaryType: String

   lazy val querFiltro = qf(this)

   def qf(le: Learner) = le.id match {
      case 2651110 => true //rbf
      case 8001 => true //ci
      case 773 => false //rf
      case 2 => false //knn
      case 12 => false //nb
      case 666003 => false //c45
   }

   //  def diff(modelA: Model, modelB: Model): Double

   /**
    * Every call to build generates a model from scratch
    * (and reinstanciate all needed internal mutable objects, if any).
    * @param pool
    * @return
    */
   def build(pool: Seq[Pattern]): Model

   def update(model: Model, fast_mutable: Boolean = false, semcrescer: Boolean = false)(pattern: Pattern): Model

   //  def forget(model: Model, fast_mutable: Boolean = false)(pattern: Pattern): Model

   def expected_change(model: Model)(pattern: Pattern): Double
}

//trait IncrementalLearner extends Learner {
//  protected def cast2incmodel(model: Model) = model match {
//    case m: IncrementalModel => m
//    case _ => throw new Exception("IncrementalLearner requires IncrementalModel.")
//  }
//}

//trait BatchLearner extends Learner {
//  private def cast2batmodel(model: Model) = model match {
//    case m: BatchModel => m
//    case _ => throw new Exception("BatchLearner requires BatchModel.")
//  }
//
//  def update(model: Model)(pattern: Pattern) = build(pattern +: cast2batmodel(model).training_set)
//
//}