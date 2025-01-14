/*
 * Copyright (c) 2021, salesforce.com, inc.
 * All rights reserved.
 * SPDX-License-Identifier: BSD-3-Clause
 * For full license text, see the LICENSE file in the repo root or https://opensource.org/licenses/BSD-3-Clause
 */

package utils

import scala.util.{Failure, Success, Try}

import com.typesafe.config.ConfigException
import com.typesafe.config.ConfigFactory

class DbConfig() {

  val config = ConfigFactory.load().getConfig("acdc.db")

  def ttl: Int = Try(config.getInt(s"ttl")) match {
    case Success(d) => d
    case Failure(e: ConfigException.Missing) => 90
    case Failure(e) => throw e
  }

}
