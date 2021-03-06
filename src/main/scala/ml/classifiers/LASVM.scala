package ml.classifiers

import ml.Pattern
import ml.models.{LASVMModel, Model}

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
case class LASVM() extends Learner {
   override val toString = "LASVM"
   val boundaryType = "flexível"
   val attPref = "numérico"
   val id = -2
   val abr = toString

   def update(model: Model, fast_mutable: Boolean, semcrescer: Boolean = false)(pattern: Pattern) = ???

   def expected_change(model: Model)(pattern: Pattern) = ???

   def EMC(model: Model)(patterns: Seq[Pattern]) = ???

   def build(pool: Seq[Pattern]) = {
      //todo: preciso que jkernelmachines tenha suporte a "multiclass probability output" e que seja mais rapido que libsvm; caso não seja mais rápido ele pode ser descartado, já que diz o autor que ele já é realmente incremental.
      //build deve começar com |Y| exemplos e depois incrementar o resto por motivos de replicabilidade/resumable.
      ???
      LASVMModel()
   }
}
